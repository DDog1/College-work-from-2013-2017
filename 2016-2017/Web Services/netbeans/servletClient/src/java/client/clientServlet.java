/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import soap.CRUDBOOK_Service;

/**
 *
 * @author darren
 */
@WebServlet(name = "clientServlet", urlPatterns = {"/clientServlet"})
public class clientServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CRUD_BOOK/CRUD_BOOK.wsdl")
    private CRUDBOOK_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action;
            try{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet clientServlet</title>");            
                out.println("<link rel='stylesheet' type='text/css' href='style.css'>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Soap Assessment</h1>");

                if(request.getParameter("action")!=null){
                    action=request.getParameter("action");
                    
                    /************************************************************/
                    // <editor-fold defaultstate="collapsed" desc="Add method">
                    if("add".equals(action)){
                        out.println(
                            "<form action=\"clientServlet\" method=\"get\">\n" +
                                "<h2>Add Book</h2>"+
                                "Book Name<input type = \"text\" name=\"bookName\" required><br>" +
                                "Author<input type = \"text\" name=\"author\" required><br>" +
                                "Publish Date<input type = \"text\" name=\"publishDate\" required><br>" +
                                "ISBN<input type = \"text\" name=\"isbn\" required><br>" +
                                "Description<input type = \"text\" name=\"description\" required><br>" +
                                "Price<input type = \"number\" name=\"price\" required><br>" +
                                "<div style=\"visibility: hidden;\">"+
                                    "Action<input type = \"text\" name=\"action\" value=\"addResult\" required><br>" +
                                "</div>" +
                                "<input type=\"submit\" value=\"Submit\"><input type=\"reset\" value=\"Reset\">" +
                            "</form>"
                        );
                    } else if ("addResult".equals(action)){
                        String bookName = request.getParameter("bookName"), 
                                author = request.getParameter("author"), 
                                publishDate = request.getParameter("publishDate"), 
                                isbn = request.getParameter("isbn"), 
                                description = request.getParameter("description");

                        double price = Double.valueOf(request.getParameter("price"));

                        String add = addBook(bookName,author,publishDate,isbn,description,price);
                        out.println("<span>Add result: "+add+"</span>");
                        
                        List booksList = displayBook();
                        out.println("<table>");
                            out.println("<tr>");
                                out.println("<th>bookName</th><th>author</th><th>publishDate</th><th>isbn</th><th>description</th><th>price</th><th>Options</th>");
                            out.println("</tr>");
                            int index = 0;
                            String[] splitArray;
                        for( Object temp : booksList) {
                            String test = String.valueOf(temp);
                            splitArray = test.split(":");
                            out.println("<tr>");
                                out.println("<td>"+splitArray[0]+"</td><td>"+splitArray[1]+"</td><td>"+splitArray[2]+"</td><td>"+splitArray[3]+"</td><td>"+splitArray[4]+"</td><td>"+splitArray[5]+"</td>");
                                out.print("<td><a href='/servletClient/clientServlet?action=remove&index="+index+"'>Remove</a> ");
                                out.print("<a href='/servletClient/clientServlet?action=update&index="+index+"'>Update</a></td>");
                            out.println("</tr>");
                            index++;
                        }
                        out.println("</table>");

                    } 
                    // </editor-fold>
                    
                    /************************************************************/
                    // <editor-fold defaultstate="collapsed" desc="Romove method">
                    else if("remove".equals(action)){
                        int index = Integer.valueOf(request.getParameter("index"));
                        String remove = removeBook(index);
                        out.println("<span>Remove result: "+remove+"</span>");
                        
                        List booksList = displayBook();
                        out.println("<table>");
                            out.println("<tr>");
                                out.println("<th>bookName</th><th>author</th><th>publishDate</th><th>isbn</th><th>description</th><th>price</th><th>Options</th>");
                            out.println("</tr>");
                            int i = 0;
                            String[] splitArray;
                        for( Object temp : booksList) {
                            String test = String.valueOf(temp);
                            splitArray = test.split(":");
                            out.println("<tr>");
                                out.println("<td>"+splitArray[0]+"</td><td>"+splitArray[1]+"</td><td>"+splitArray[2]+"</td><td>"+splitArray[3]+"</td><td>"+splitArray[4]+"</td><td>"+splitArray[5]+"</td>");
                                out.print("<td><a href='/servletClient/clientServlet?action=remove&index="+i+"'>Remove</a> ");
                                out.print("<a href='/servletClient/clientServlet?action=update&index="+i+"'>Update</a></td>");
                            out.println("</tr>");
                            i++;
                        }
                        out.println("</table>");
                        
                    } 
                    // </editor-fold>
                    
                    /************************************************************/
                    // <editor-fold defaultstate="collapsed" desc="Update method">
                    else if("update".equals(action)){
                        int index = Integer.valueOf(request.getParameter("index"));
                        List booksList = displayBook();
                        if(index<booksList.size()){
                            String temp = booksList.get(index).toString();
                            String[] splitArray = temp.split(":");
                            out.println(
                                "<form action=\"clientServlet\" method=\"get\">" +
                                    "<h2>Update Book</h2>"+
                                    "Index<input type = \"text\" name=\"index\" value="+index+" required><br>" +
                                    "Book Name<input type = \"text\" name=\"bookName\" value="+splitArray[0]+" required><br>" +
                                    "Author<input type = \"text\" name=\"author\" value="+splitArray[1]+" required><br>" +
                                    "Publish Date<input type = \"text\" name=\"publishDate\" value="+splitArray[2]+" required><br>" +
                                    "ISBN<input type = \"text\" name=\"isbn\" value="+splitArray[3]+" required><br>" +
                                    "Description<input type = \"text\" name=\"description\" value="+splitArray[4]+" required><br>" +
                                    "Price<input type = \"number\" name=\"price\" value="+splitArray[5]+" required><br>" +
                                    "<div style=\"visibility: hidden;\">"+
                                        "Action<input type = \"text\" name=\"action\" value=\"updateResult\" required><br>" +
                                    "</div>" +
                                    "<input type=\"submit\" value=\"Submit\"><input type=\"reset\" value=\"Reset\">" +
                                "</form>"
                            );
                        } else {
                            out.println("<span>No such item in list!!</span><br>");
                        }
                        
                    } else if ("updateResult".equals(action)){
                        int index = Integer.valueOf(request.getParameter("index"));
                        String bookName = request.getParameter("bookName"), 
                        author = request.getParameter("author"), 
                        publishDate = request.getParameter("publishDate"), 
                        isbn = request.getParameter("isbn"), 
                        description = request.getParameter("description");

                        double price = Double.valueOf(request.getParameter("price"));
                        String update = updateBook(index,bookName,author,publishDate,isbn,description,price);
                        out.println("<span>Update result: "+update+"</span>");
                        
                        List booksList = displayBook();
                        out.println("<table>");
                            out.println("<tr>");
                                out.println("<th>bookName</th><th>author</th><th>publishDate</th><th>isbn</th><th>description</th><th>price</th><th>Options</th>");
                            out.println("</tr>");
                        int i = 0;
                        String[] splitArray;
                            
                        for( Object temp : booksList) {
                            String test = String.valueOf(temp);
                            splitArray = test.split(":");
                            out.println("<tr>");
                                out.println("<td>"+splitArray[0]+"</td><td>"+splitArray[1]+"</td><td>"+splitArray[2]+"</td><td>"+splitArray[3]+"</td><td>"+splitArray[4]+"</td><td>"+splitArray[5]+"</td>");
                                out.print("<td><a href='/servletClient/clientServlet?action=remove&index="+i+"'>Remove</a> ");
                                out.print("<a href='/servletClient/clientServlet?action=update&index="+i+"'>Update</a></td>");
                            out.println("</tr>");
                            i++;
                        }
                        out.println("</table>");

                    } 
                    // </editor-fold>
                    
                    /************************************************************/
                    // <editor-fold defaultstate="collapsed" desc="Display method">
                    else if("display".equals(action)){
                        out.println("<h1>Display</h1>");
                        List booksList = displayBook();
                        out.println("<table>");
                            out.println("<tr>");
                                out.println("<th>bookName</th><th>author</th><th>publishDate</th><th>isbn</th><th>description</th><th>price</th><th>Options</th>");
                            out.println("</tr>");
                            int index = 0;
                            String[] splitArray;
                        for( Object temp : booksList) {
                            String test = String.valueOf(temp);
                            splitArray = test.split(":");
                            out.println("<tr>");
                                out.println("<td>"+splitArray[0]+"</td><td>"+splitArray[1]+"</td><td>"+splitArray[2]+"</td><td>"+splitArray[3]+"</td><td>"+splitArray[4]+"</td><td>"+splitArray[5]+"</td>");
                                out.print("<td><a href='/servletClient/clientServlet?action=remove&index="+index+"'>Remove</a> ");
                                out.print("<a href='/servletClient/clientServlet?action=update&index="+index+"'>Update</a></td>");
                            out.println("</tr>");
                            index++;
                        }
                        out.println("</table>");
                    }
                    // </editor-fold>
                } else{
                    out.println("Please pick an action to do :D<br>");
                }
                out.print("<a href='/servletClient/clientServlet?action=add' style ='margin-left: 50px;'>Add</a>");
                out.print("<a href='/servletClient/clientServlet?action=display'>Display</a>");
                out.println("</body>");
                out.println("</html>");
            } catch(Exception e){
                System.out.println("Error: "+e);
                out.println("Error: "+e);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String addBook(java.lang.String bookName, java.lang.String author, java.lang.String publishDate, java.lang.String isbn, java.lang.String description, double price) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        soap.CRUDBOOK port = service.getCRUDBOOKPort();
        return port.addBook(bookName, author, publishDate, isbn, description, price);
    }

    private java.util.List<java.lang.String> displayBook() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        soap.CRUDBOOK port = service.getCRUDBOOKPort();
        return port.displayBook();
    }

    private String removeBook(int index) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        soap.CRUDBOOK port = service.getCRUDBOOKPort();
        return port.removeBook(index);
    }

    private String updateBook(int index, java.lang.String bookName, java.lang.String author, java.lang.String publishDate, java.lang.String isbn, java.lang.String description, double price) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        soap.CRUDBOOK port = service.getCRUDBOOKPort();
        return port.updateBook(index, bookName, author, publishDate, isbn, description, price);
    }
    
}
