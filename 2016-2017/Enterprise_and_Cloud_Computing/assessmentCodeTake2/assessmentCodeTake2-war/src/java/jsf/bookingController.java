/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entity.Bookings;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import session.BookingsFacade;

/**
 *
 * @author darren
 */
@Named(value = "bookingController")
@SessionScoped
public class bookingController implements Serializable {

    @EJB
    private BookingsFacade bookingsFacade;
    
    private Bookings bookings = new Bookings();

    private DataModel items = null;

    public DataModel getItems() {
        return items;
    }

    public void setItems(DataModel items) {
        this.items = items;
    }
    
    public Bookings getBookings() {
        return bookings;
    }

    public void setBookings(Bookings bookings) {
        this.bookings = bookings;
    }
    
    public bookingController() {
    }
    /**
     * lets the user make a booking on the database
     * @return 
     */
    public String add(){
        int maxBookings;
        maxBookings = bookingsFacade.maxBookings();
        maxBookings++;
        this.bookings.setBookingId(maxBookings);
        this.bookingsFacade.create(this.bookings);
        return "bookingHome";
    }
    
    /**
     * 
     * @return lets the user update there packages if they change their mind
     */
    public String update(){
        return "packageHome";
    }
    /**
     * lets the user see their booking
     */
    public void display(){
        items = new ListDataModel (this.bookingsFacade.findAll());
    }
}