package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T22:23:51")
@StaticMetamodel(Game.class)
public class Game_ { 

    public static volatile SingularAttribute<Game, String> gamename;
    public static volatile SingularAttribute<Game, Integer> price;
    public static volatile SingularAttribute<Game, Integer> rating;
    public static volatile SingularAttribute<Game, String> description;
    public static volatile SingularAttribute<Game, Integer> id;

}