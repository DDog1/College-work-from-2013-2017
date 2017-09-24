/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;
import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entity.Customers;
/**
 *
 * @author darren
 */
@Stateless
public class CustomersFacade extends AbstractFacade<Customers> {
    @PersistenceContext(unitName = "assessmentCodeTake2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomersFacade() {
        super(Customers.class);
    }
    
    /**
    * Used to see if the user is on the database
    * @param username
    * @param password
    * @return returns true if the user is on the database
    */
    public Boolean valLogin(String username, String password) {
        boolean result = false;
        
        Query query = em.createNamedQuery("Customers.isOnDatabase");
        DataModel items = new ListDataModel(query.setParameter("username", username).setParameter("password", password).getResultList());

        if(items.getRowCount()>=1){//User is in the database
            result = true;
        } else if(items.getRowCount()==0){//User is not in the database
            result = false;
        }
        return result;
    }
    
    /**
     * 
     * @return returns the max id in the database
     */
    public int maxCustomers(){
        int result;
        Query query = em.createNativeQuery("SELECT max(customer_ID) FROM Customers ");
        result = (int)query.getSingleResult();
        return result;
    }
   
   /**
    * 
    * @param username
    * @return returns the selected username data back;
    */
    public List<entity.Customers> findUserData(String username) {
        Query query = em.createNamedQuery("Customers.findByUsername");
        query.setParameter("username", username);
        return query.getResultList();
    }
    
    public List findRole(String username){
        Query query = em.createNamedQuery("Customers.findRole");
        query.setParameter("username", username);
        return query.getResultList();
    }
    public List findId(String username){
        Query query = em.createNamedQuery("Customers.findId");
        query.setParameter("username", username);
        return query.getResultList();
    }
        
   public boolean usernameTaken(String username){
       boolean result = false;
       Query query = em.createNamedQuery("Customers.findByUsername");
       DataModel items = new ListDataModel(query.setParameter("username", username).getResultList());

        if(items.getRowCount()>=1){//User is in the database
            result = true;
        } else if(items.getRowCount()==0){//User is not in the database
            result = false;
        }
        return result;
   }
   
    public boolean updateCustomers(Customers c){
        boolean result;
        result = usernameTaken(c.getUsername());
        if(result == true){
            System.out.println("Username is taken");
        }else{//If username is free
            edit(c);
        }
        return result;
    }
}
