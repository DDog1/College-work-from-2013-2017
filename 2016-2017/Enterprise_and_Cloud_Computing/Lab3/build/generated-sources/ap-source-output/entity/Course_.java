package entity;

import entity.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-30T12:56:14")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile ListAttribute<Course, Student> students;
    public static volatile SingularAttribute<Course, String> id;
    public static volatile SingularAttribute<Course, String> department;
    public static volatile SingularAttribute<Course, String> courseDescription;

}