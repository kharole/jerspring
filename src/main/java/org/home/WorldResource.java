package org.home;

import org.springframework.stereotype.Component;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 16.04.13
 * Time: 23:02
 * To change this template use File | Settings | File Templates.
 */
public class WorldResource {

    private Hello hello;

    public WorldResource() {
        System.out.println("new WorldResource()");
    }

    @GET
    @Path("/{world}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloWorld(@PathParam("world") String world) {
        World w = new World();
        w.setHello(hello);
        w.setWorld(world);
        return Response.status(200).entity(w).build();
    }


    public Hello getHello() {
        return hello;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }
}
