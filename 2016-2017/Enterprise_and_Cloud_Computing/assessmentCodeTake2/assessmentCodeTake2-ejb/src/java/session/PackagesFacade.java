/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Packages;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author darren
 */
@Stateless
public class PackagesFacade extends AbstractFacade<Packages> {

    @PersistenceContext(unitName = "assessmentCodeTake2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public PackagesFacade() {
        super(Packages.class);
    }
    
    public int maxPackages(){
        int result;
        Query query = em.createNativeQuery("SELECT max(packages_ID) FROM packages");
        result = (int)query.getSingleResult();
        return result;
    }
    
    public void updatePackage(Packages p){
        edit(p);
    }
    
    public void removePackage(Packages p){
        remove(p);
    }
    
}
