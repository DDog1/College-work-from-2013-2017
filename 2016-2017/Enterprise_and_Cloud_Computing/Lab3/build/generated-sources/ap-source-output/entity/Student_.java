package entity;

import entity.Course;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-30T12:56:14")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> firstName;
    public static volatile SingularAttribute<Student, String> lastName;
    public static volatile SingularAttribute<Student, Course> course;
    public static volatile SingularAttribute<Student, String> id;
    public static volatile SingularAttribute<Student, Integer> age;
    public static volatile SingularAttribute<Student, String> email;

}