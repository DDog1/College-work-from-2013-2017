/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Bookings;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author darren
 */
@Stateless
public class BookingsFacade extends AbstractFacade<Bookings> {

    @PersistenceContext(unitName = "assessmentCodeTake2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookingsFacade() {
        super(Bookings.class);
    }
    
    public int maxBookings(){
        int result;
        Query query = em.createNativeQuery("SELECT max(booking_ID) FROM Bookings");
        result = (int)query.getSingleResult();
        return result;
    }
     
}
