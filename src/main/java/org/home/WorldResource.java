package org.home;

import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static java.util.Arrays.asList;

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
    @RolesAllowed("bear")
    public List<World> helloWorld(@PathParam("world") String world) {
        World w = new World();
        w.setHello(hello);
        w.setWorld(world);
        if("error".equals(world)) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).
                    entity(w).type(MediaType.APPLICATION_JSON_TYPE).build());
        }
        return asList(w,w);
    }


    public Hello getHello() {
        return hello;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }
}
