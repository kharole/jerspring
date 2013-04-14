package org.home;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("/hello")
@Component
public class HelloResource {

    @GET
    @Path("/world")
    public Response helloWorld() {
        return Response.status(200).entity("hello").build();

    }

}
