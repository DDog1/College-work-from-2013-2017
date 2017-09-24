package entity;

import entity.Customers;
import entity.Packages;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-30T12:39:49")
@StaticMetamodel(Bookings.class)
public class Bookings_ { 

    public static volatile SingularAttribute<Bookings, String> timeDay;
    public static volatile SingularAttribute<Bookings, Customers> customerFk;
    public static volatile SingularAttribute<Bookings, Packages> packageFk;
    public static volatile SingularAttribute<Bookings, String> dateDay;
    public static volatile SingularAttribute<Bookings, Integer> bookingId;

}