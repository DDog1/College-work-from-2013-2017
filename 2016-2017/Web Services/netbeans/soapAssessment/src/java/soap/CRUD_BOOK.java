/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soap;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author darren
 */
@WebService(serviceName = "CRUD_BOOK")
@Stateless
public class CRUD_BOOK {
    ArrayList books = new ArrayList();
    
    /**
     * Web service operation add
     * @param bookName the name of the book
     * @param author the author of the book
     * @param publishDate the publish date of the book
     * @param isbn the isbn of the book
     * @param description the description of the book
     * @param price the price of the book
     * @return response message
     */
    @WebMethod(operationName = "addBook")
    public String addBook(@WebParam(name = "bookName") String bookName, 
            @WebParam(name = "author") String author, 
            @WebParam(name = "publishDate") String publishDate, 
            @WebParam(name = "isbn") String isbn, 
            @WebParam(name = "description") String description, 
            @WebParam(name = "price") double price) {
        
        books.add(bookName+":"+author+":"+publishDate+":"+isbn+":"+description+":"+price);
        System.out.println("ADD WAS CALLED");
        return "Book was added to list!!";
    }
    /**
     * Web service operation remove
     * @param index the index position in the list
     * @return response message
     */
    @WebMethod(operationName = "removeBook")
    public String removeBook(@WebParam(name = "index") int index) {
        if(index<books.size()){
            books.remove(index);
            System.out.println("REMOVE WAS CALLED");
            return "Book was removed from list!!";
        } else {
            return "There was nothing in this index!!";
        }
    }
    /**
     * Web service operation update
     * @param index the index position in the list
     * @param bookName the name of the book
     * @param author the author of the book
     * @param publishDate the publish date of the book
     * @param isbn the isbn of the book
     * @param description the description of the book
     * @param price the price of the book
     * @return response message
     */
    @WebMethod(operationName = "updateBook")
    public String updateBook(@WebParam(name = "index") int index,
            @WebParam(name = "bookName") String bookName, 
            @WebParam(name = "author") String author, 
            @WebParam(name = "publishDate") String publishDate, 
            @WebParam(name = "isbn") String isbn, 
            @WebParam(name = "description") String description, 
            @WebParam(name = "price") double price) {
        if(index<books.size()){
            books.add(index, bookName+":"+author+":"+publishDate+":"+isbn+":"+description+":"+price);
            books.remove(index+1);
            System.out.println("UPDATE WAS CALLED");
            return "Book was updated!!";
        } else {
            return "No such index in list!!";
        }
    }
    /**
     * Web service operation display
     * @return return all books in list
     */
    @WebMethod(operationName = "displayBook")
    public ArrayList<String> displayBook() {
        System.out.println("DISPLAY WAS CALLED");
        return books;
    }
}
