/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallNumber;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author darren
 */
@Path("lab4")
public class Lab4 {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MinProj
     */
    public Lab4() {
    }

    /**
     * Retrieves representation of an instance of smallNumber.MinProj
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("result/{input1}/{input2}/{input3}")
    @Produces(MediaType.APPLICATION_JSON)
    public int getSmallestNumber(@PathParam("input1")int input1, @PathParam("input2")int input2, @PathParam("input3")int input3){
        int small = input1;

        if(small>input2){
            small = input2;
            if(small>input3){
                    small = input3;
            }
        }
        System.out.println(small);
        return small;
    }
    @GET
    @Path("result/{input1}/{input2}")
    @Produces(MediaType.APPLICATION_JSON)
    public double getHypotenuse(@PathParam("input1")double a, @PathParam("input2")double b){
        double Hypotenuse = Math.hypot(a, b);
        return Hypotenuse;
    }
    
}
