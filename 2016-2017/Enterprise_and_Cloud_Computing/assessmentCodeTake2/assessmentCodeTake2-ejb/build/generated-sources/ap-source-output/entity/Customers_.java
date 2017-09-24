package entity;

import entity.Bookings;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-30T12:39:49")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SingularAttribute<Customers, String> firstname;
    public static volatile SingularAttribute<Customers, String> role;
    public static volatile SingularAttribute<Customers, String> address2;
    public static volatile SingularAttribute<Customers, String> city;
    public static volatile SingularAttribute<Customers, String> address1;
    public static volatile CollectionAttribute<Customers, Bookings> bookingsCollection;
    public static volatile SingularAttribute<Customers, String> lastname;
    public static volatile SingularAttribute<Customers, String> password;
    public static volatile SingularAttribute<Customers, String> phone;
    public static volatile SingularAttribute<Customers, Integer> customerId;
    public static volatile SingularAttribute<Customers, String> state;
    public static volatile SingularAttribute<Customers, String> email;
    public static volatile SingularAttribute<Customers, String> username;

}