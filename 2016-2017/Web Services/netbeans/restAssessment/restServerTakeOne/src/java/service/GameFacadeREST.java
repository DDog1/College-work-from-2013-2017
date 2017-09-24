/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Game;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author darren
 */
@Stateless
@Path("game")
public class GameFacadeREST extends AbstractFacade<Game> {

    @PersistenceContext(unitName = "restServerTakeOnePU")
    private EntityManager em;
    private int id;

    public GameFacadeREST() {
        super(Game.class);
    }

    @POST
    @Override
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Game entity) {
        id++;
        entity.setId(id);
        super.create(entity);
    }
    
    @DELETE
    @Path("remove/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String remove(@PathParam("id") Integer id) {
        try{
            super.remove(super.find(id));
            return "Game was deleted!!";
        } catch(Exception e){
            return "No such game with id "+id+" found!!";
        }
    }
    
    @PUT
    @Path("update/{id}")
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.TEXT_PLAIN)
    public void update(@PathParam("id") Integer id, Game entity) {
        try{
            Game game = super.find(id);
            game.setDescription(entity.getDescription());
            game.setGamename(entity.getGamename());
            game.setRating(entity.getRating());
            game.setPrice(entity.getPrice());
            super.edit(game);
            //return "Game was updated!!";
        } catch(Exception e){
            //return "No such game with id "+id+" found!!";
        }
    }

    @GET
    @Path("display")
    //@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Game> display() {
        return super.findAll();
    }

    @GET
    @Path("find/{id}")
    //@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Game find(@PathParam("id") Integer id) {
        return super.find(id);
    }


/*    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Game> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
*/
/*    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
*/
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
