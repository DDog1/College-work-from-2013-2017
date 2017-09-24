package entity;

import entity.Bookings;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-30T12:39:49")
@StaticMetamodel(Packages.class)
public class Packages_ { 

    public static volatile SingularAttribute<Packages, String> duration;
    public static volatile SingularAttribute<Packages, Double> price;
    public static volatile SingularAttribute<Packages, Integer> packagesId;
    public static volatile SingularAttribute<Packages, String> name;
    public static volatile SingularAttribute<Packages, String> description;
    public static volatile CollectionAttribute<Packages, Bookings> bookingsCollection;

}