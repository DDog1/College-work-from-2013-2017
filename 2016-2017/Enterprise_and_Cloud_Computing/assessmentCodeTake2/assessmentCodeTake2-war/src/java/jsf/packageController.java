package jsf;

import entity.Packages;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import session.PackagesFacade;

/**
 *
 * @author darren
 */
@Named(value = "packageController")
@SessionScoped
public class packageController implements Serializable {

    @EJB
    private PackagesFacade packagesFacade;
    
    private Packages packages = new Packages();
    private DataModel items = null;
    
    public DataModel getItems() {
        return items;
    }

    public void setItems(DataModel items) {
        this.items = items;
    }
    public packageController() {
    }

    public PackagesFacade getPackagesFacade() {
        return packagesFacade;
    }

    public void setPackagesFacade(PackagesFacade packagesFacade) {
        this.packagesFacade = packagesFacade;
    }

    public Packages getPackages() {
        return packages;
    }

    public void setPackages(Packages packages) {
        this.packages = packages;
    }
    /**
     * 
     * @return gets the max packages on the database as to auto increment the id.
     * Add new package
     */
    public String add(){
        int maxPackages;
        maxPackages = packagesFacade.maxPackages();
        maxPackages++;
        packages.setPackagesId(maxPackages);
        this.packagesFacade.create(this.packages);
        return "packageHome";
    }
    
    /**
     * gets all the available packages on the database and displays it to the user.
     */
    public void display(){
        items = new ListDataModel (this.packagesFacade.findAll());
    }
    
    /**
     * 
     * @return lets the admin update a package
     */
    public String update(){
        this.packagesFacade.updatePackage(this.packages);
        return "packageHome";
    }
    
    /**
     * 
     * @return lets the admin remove a package
     */
    public String remove(){
        //this.packagesFacade.removePackage(this.packages);
        this.packages.setPrice(0);
        //this.packages.setPackagesId(3);
        this.packages.setName("Darren");
        this.packages.setDuration("");
        this.packages.setDescription("");
        this.packagesFacade.remove(this.packages);
        return "display";
    }
}
