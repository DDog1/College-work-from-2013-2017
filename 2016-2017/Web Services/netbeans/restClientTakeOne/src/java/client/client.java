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
import javax.ws.rs.ClientErrorException;

/**
 *
 * @author darren
 */
@WebServlet(name = "client", urlPatterns = {"/client"})
public class client extends HttpServlet {
Game game = new Game();
NewJerseyClient client = new NewJerseyClient();
List<Game> games;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
@SuppressWarnings("ConvertToStringSwitch")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action;
            try{
            //games = client.display(Game.class);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet client</title>");            
            out.println("<link rel='stylesheet' type='text/css' href='style.css'>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<nav>");
            out.print("<a href='/restClientTakeOne/client?action=add'>Add</a>");
            out.print("<a href='/restClientTakeOne/client?action=remove'>Remove</a>");
            out.print("<a href='/restClientTakeOne/client?action=update'>Update</a>");
            out.print("<a href='/restClientTakeOne/client?action=display'>Display</a>");
            out.println("</nav>");
            
            if(request.getParameter("action")!=null){
                action=request.getParameter("action");
                    
                /************************************************************/
                // <editor-fold defaultstate="collapsed" desc="Add method">
                if("add".equals(action)){
                    out.println(
                        "<form action=\"client\" method=\"get\">\n" +
                            "<h2>Add Game</h2>"+
                            "Game Name<input type = \"text\" name=\"gameName\" required><br>" +
                            "Rating<input type = \"number\" name=\"rating\" required><br>" +
                            "Description<input type = \"text\" name=\"description\" required><br>" +
                            "Price<input type = \"number\" name=\"price\" required><br>" +
                            "<div style=\"visibility: hidden;\">"+
                                "Action<input type = \"text\" name=\"action\" value=\"addResult\" required><br>" +
                            "</div>" +
                            "<input type=\"submit\" value=\"Submit\"><input type=\"reset\" value=\"Reset\">" +
                        "</form>"
                    );
                } else if ("addResult".equals(action)){
                    String gameName = request.getParameter("gameName"), 
                    description = request.getParameter("description");

                    int price = Integer.valueOf(request.getParameter("price"));
                    int rating = Integer.parseInt(request.getParameter("rating"));
                    
                    //game.setId(2);
                    game.setGamename(gameName);
                    game.setRating(rating);
                    game.setDescription(description);
                    game.setPrice(price);
                    client.create(game);
                    out.println("<br><span>Add result: Game Added</span>");
                    try{
                        Thread.sleep(2000);
                    } catch(Exception e){
                        
                    }
                    List t = client.display(List.class);
                    games = t;
                    String line;
                    String[] lineItems;
                    
                    out.println("<table>");
                        out.println("<tr>");
                            out.println("<th>id</th><th>gamename</th><th>description</th><th>rating</th><th>price</th><th>Options</th>");
                        out.println("</tr>");
                        
                    for(int i = 0;i<games.size();i++)
                    {
                        line = t.get(i).toString();
                        String substring = line.substring(1, line.length()-1);
                        lineItems = substring.split(",");
                        lineItems[0] = lineItems[0].substring(3);
                        lineItems[1] = lineItems[1].substring(10);
                        lineItems[2] = lineItems[2].substring(13);
                        lineItems[3] = lineItems[3].substring(8);
                        lineItems[4] = lineItems[4].substring(7);
                        
                        out.println("<tr>");                        
                        out.println("<th>"+lineItems[0]+"</th><th>"+lineItems[1]+"</th><th>"+lineItems[2]+"</th><th>"+lineItems[3]+"</th><th>"+lineItems[4]+"</th><th><a href='/restClientTakeOne/client?action=RemoveResult&index="+lineItems[0]+"'>Remove <a href='/restClientTakeOne/client?action=update&index="+lineItems[0]+"'>Update</a></th>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                } 
                // </editor-fold>

                /************************************************************/
                // <editor-fold defaultstate="collapsed" desc="Romove method">
                else if("remove".equals(action)){
                    out.println(
                        "<form action=\"client\" method=\"get\">\n" +
                            "<h2>Remove Game</h2>"+
                            "ID<input type = \"text\" name=\"index\" required><br>" +
                            "<div style=\"visibility: hidden;\">"+
                                "Action<input type = \"text\" name=\"action\" value=\"RemoveResult\" required><br>" +
                            "</div>" +
                            "<input type=\"submit\" value=\"Submit\"><input type=\"reset\" value=\"Reset\">" +
                        "</form>"
                    );        
                } else if ("RemoveResult".equals(action)){
                    String index = request.getParameter("index");
                    client.remove(index);
                    out.println("<br><span>Remove result: Game Removed!!</span>");
                    
                    
                    List t = client.display(List.class);
                    games = t;
                    String line;
                    String[] lineItems;
                    
                    out.println("<table>");
                        out.println("<tr>");
                            out.println("<th>id</th><th>gamename</th><th>description</th><th>rating</th><th>price</th><th>Options</th>");
                        out.println("</tr>");
                        
                    for(int i = 0;i<games.size();i++)
                    {
                        line = t.get(i).toString();
                        String substring = line.substring(1, line.length()-1);
                        lineItems = substring.split(",");
                        lineItems[0] = lineItems[0].substring(3);
                        lineItems[1] = lineItems[1].substring(10);
                        lineItems[2] = lineItems[2].substring(13);
                        lineItems[3] = lineItems[3].substring(8);
                        lineItems[4] = lineItems[4].substring(7);
                        
                        out.println("<tr>");                        
                        out.println("<th>"+lineItems[0]+"</th><th>"+lineItems[1]+"</th><th>"+lineItems[2]+"</th><th>"+lineItems[3]+"</th><th>"+lineItems[4]+"</th><th><a href='/restClientTakeOne/client?action=RemoveResult&index="+lineItems[0]+"'>Remove <a href='/restClientTakeOne/client?action=update&index="+lineItems[0]+"'>Update</a></th>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    
                }
                // </editor-fold>
                
                /************************************************************/
                // <editor-fold defaultstate="collapsed" desc="Update method">
                else if("update".equals(action)){
                    if(request.getParameter("index")!=null){
                        String index = request.getParameter("index");
                        game = client.find(Game.class, index);
                        out.println(
                            "<form action=\"client\" method=\"get\">\n" +
                                "<h2>Update Game</h2>"+
                                "ID<input type = \"text\" name=\"index\" value="+index+" required><br>" +
                                "Game Name<input type = \"text\" name=\"gameName\" value="+game.getGamename()+" required><br>" +
                                "Rating<input type = \"number\" name=\"rating\" value="+game.getRating()+" required><br>" +
                                "Description<input type = \"text\" name=\"description\" value="+game.getDescription()+" required><br>" +
                                "Price<input type = \"number\" name=\"price\" value="+game.getPrice()+" required><br>" +
                                "<div style=\"visibility: hidden;\">"+
                                    "Action<input type = \"text\" name=\"action\" value=\"updateResult\" required><br>" +
                                "</div>" +
                                "<input type=\"submit\" value=\"Submit\"><input type=\"reset\" value=\"Reset\">" +
                            "</form>"
                        );                    
                    } else {
                        game=null;
                        out.println(
                            "<form action=\"client\" method=\"get\">\n" +
                                "<h2>Update Game</h2>"+
                                "ID<input type = \"text\" name=\"index\" required><br>" +
                                "Game Name<input type = \"text\" name=\"gameName\" required><br>" +
                                "Rating<input type = \"number\" name=\"rating\" required><br>" +
                                "Description<input type = \"text\" name=\"description\" required><br>" +
                                "Price<input type = \"number\" name=\"price\" required><br>" +
                                "<div style=\"visibility: hidden;\">"+
                                    "Action<input type = \"text\" name=\"action\" value=\"updateResult\" required><br>" +
                                "</div>" +
                                "<input type=\"submit\" value=\"Submit\"><input type=\"reset\" value=\"Reset\">" +
                            "</form>"
                        );                    
                    }
                        
                } else if ("updateResult".equals(action)){
                    String index = request.getParameter("index");
                    String gameName = request.getParameter("gameName"), 
                    description = request.getParameter("description");

                    int price = Integer.valueOf(request.getParameter("price"));
                    int rating = Integer.parseInt(request.getParameter("rating"));
                    int id = Integer.valueOf(index);
                    game.setId(id);
                    game.setGamename(gameName);
                    game.setRating(rating);
                    game.setDescription(description);
                    game.setPrice(price);
                    client.update(game,index);

                    out.println("<br><span>Update result: Game Updated</span>");
                    
                    List t = client.display(List.class);
                    games = t;
                    String line;
                    String[] lineItems;
                    
                    out.println("<table>");
                        out.println("<tr>");
                            out.println("<th>id</th><th>gamename</th><th>description</th><th>rating</th><th>price</th><th>Options</th>");
                        out.println("</tr>");
                        
                    for(int i = 0;i<games.size();i++)
                    {
                        line = t.get(i).toString();
                        String substring = line.substring(1, line.length()-1);
                        lineItems = substring.split(",");
                        lineItems[0] = lineItems[0].substring(3);
                        lineItems[1] = lineItems[1].substring(10);
                        lineItems[2] = lineItems[2].substring(13);
                        lineItems[3] = lineItems[3].substring(8);
                        lineItems[4] = lineItems[4].substring(7);
                        
                        out.println("<tr>");                        
                        out.println("<th>"+lineItems[0]+"</th><th>"+lineItems[1]+"</th><th>"+lineItems[2]+"</th><th>"+lineItems[3]+"</th><th>"+lineItems[4]+"</th><th><a href='/restClientTakeOne/client?action=RemoveResult&index="+lineItems[0]+"'>Remove <a href='/restClientTakeOne/client?action=update&index="+lineItems[0]+"'>Update</a></th>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                } 
                // </editor-fold>
                
                /************************************************************/
                // <editor-fold defaultstate="collapsed" desc="Display method">
                else if("display".equals(action)){
                    List t = client.display(List.class);
                    games = t;
                    String line;
                    String[] lineItems;
                    
                    out.println("<table>");
                        out.println("<tr>");
                            out.println("<th>id</th><th>gamename</th><th>description</th><th>rating</th><th>price</th><th>Options</th>");
                        out.println("</tr>");
                        
                    for(int i = 0;i<games.size();i++)
                    {
                        line = t.get(i).toString();
                        String substring = line.substring(1, line.length()-1);
                        lineItems = substring.split(",");
                        lineItems[0] = lineItems[0].substring(3);
                        lineItems[1] = lineItems[1].substring(10);
                        lineItems[2] = lineItems[2].substring(13);
                        lineItems[3] = lineItems[3].substring(8);
                        lineItems[4] = lineItems[4].substring(7);
                        
                        out.println("<tr>");                        
                        out.println("<th>"+lineItems[0]+"</th><th>"+lineItems[1]+"</th><th>"+lineItems[2]+"</th><th>"+lineItems[3]+"</th><th>"+lineItems[4]+"</th><th><a href='/restClientTakeOne/client?action=RemoveResult&index="+lineItems[0]+"'>Remove <a href='/restClientTakeOne/client?action=update&index="+lineItems[0]+"'>Update</a></th>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                }
                // </editor-fold>
                    
            } else{
                out.println("Please pick an action to do :D<br>");
            }
            out.println("</body>");
            out.println("<h1></h1>");
            out.println("</html>");
            } catch(NumberFormatException | ClientErrorException e){
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

}
