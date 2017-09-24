

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("Hypto")
public class HyptoProj {
    @Context
    private UriInfo context;

    public HyptoProj() {
        // TODO Auto-generated constructor stub
    }
    @GET
    @Path("result/{input1}/{input2}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public double getHypotenuse(@PathParam("input1")double a, @PathParam("input2")double b){
		double Hypotenuse = Math.hypot(a, b);
		return Hypotenuse;
	}
}