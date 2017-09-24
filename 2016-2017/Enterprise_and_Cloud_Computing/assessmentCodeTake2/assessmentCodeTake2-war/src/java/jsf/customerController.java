/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import session.CustomersFacade;
import entity.*;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author darren
 */
@Named(value = "customerController")
@SessionScoped
public class customerController implements Serializable {
    private String username;
    private String password;
    private DataModel data = null;
    private List array=null;
    private String message;
    private boolean login;

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }
    
    @EJB
    private CustomersFacade customersFacade;

    private Customers customers = new Customers();

        public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }
    
    public customerController() {
    }
    /**
     * 
     * @return will return the home page if the user is on the database 
     * or will bring you back to the index if the user is not on the database
     */
    public String login(){   
        setUsername(customers.getUsername());
        setPassword(customers.getPassword());
        login = customersFacade.valLogin(username, password);
        
        if(login==true) {
            array = this.customersFacade.findRole(username);
            String role=array.get(0).toString();
            customers.setRole(role);
            
            display();
            message=null;
            return "home";
        } else {
            message="Username or password is not right";
            return "index";
        }
    }
    /**
     * 
     * @return This will log the user out and set the login boolean to false.
     */
    public String logout(){
        login = false;
        return "index";
    }
    /**
     * 
     * @return will get the max users and add one to the total as to auto increment,
     * also checks to see if username has been taken or not.
     */
    public String add(){
        int maxCustomers;
        maxCustomers = customersFacade.maxCustomers();
        maxCustomers++;
        boolean result = customersFacade.usernameTaken(customers.getUsername());
        if(result == true){
            message="Username is in the data base please pick a new one";
            return "register";
        } else{
            message=null;
            customers.setCustomerId(maxCustomers);
            if(customers.getRole()==null){
                customers.setRole("User");
            }
            this.customersFacade.create(this.customers);
            setUsername(customers.getUsername());
            display();
            return "/home";    
        }
    }
    public String update(){
        /*array = this.customersFacade.findUserData(username);
        StringTokenizer st = new StringTokenizer(array.get(0).toString(),"=");
        String temp="";
        while(st.hasMoreElements()){
            temp=st.nextToken();
            temp = String.valueOf(temp.charAt(0));
        }
        System.out.print("TEST : "+temp);
        System.out.println("Before : "+this.customers.getCustomerId());
        this.customers.setCustomerId(Integer.parseInt(temp)); 
        System.out.println("After : "+this.customers.getCustomerId());
        this.customersFacade.updateCustomers(this.customers);
        display();*/
        setMessage(null);
        boolean result;
        array = this.customersFacade.findId(username);
        setUsername(this.customers.getUsername());
        String id = array.get(0).toString();
        this.customers.setCustomerId(Integer.parseInt(id));
        result = this.customersFacade.updateCustomers(this.customers);
        if(result == true){
            setMessage("Username is taken, please pick a new one");
            return null;
        }
        return "userHome";
    }
    
    public String remove(){
        array = this.customersFacade.findId(username);
        if(array.size()>=1){
            String id=array.get(0).toString();
            System.out.println("TEST "+id);
            customers.setCustomerId(Integer.parseInt(id));
            customers.setAddress1(id);
            customers.setAddress2(id);
            customers.setCity(id);
            customers.setEmail(id);
            customers.setFirstname(username);
            customers.setLastname(username);
            customers.setPassword(username);
            customers.setPhone(id);
            customers.setRole(id);
            customers.setState(message);
            customers.setUsername(username);
            setMessage("Sorry to see you go :(");
            this.customersFacade.remove(customers);
        } else {
            setMessage("Error you are not a user anymore");
        }
        login=false;
        return "/index";
    }
    
    public String adminAdd(){
        return null;
    }
    
    public String cancel(){
        return "userHome";
    }
    /**
     * 
     * @return This method is used to get the user who is logged in data.
     * This will be displayed on the user display page
     */
    public String display(){
        data = new ListDataModel(this.customersFacade.findUserData(customers.getUsername()));
        return "user/display";
    }
}