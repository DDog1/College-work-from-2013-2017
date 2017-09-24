

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("smallNumber")
public class MinProj {
    @Context
    private UriInfo context;
    public MinProj() {
        // TODO Auto-generated constructor stub
    }
    @GET
    @Path("result/{input1}/{input2}/{input3}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
}