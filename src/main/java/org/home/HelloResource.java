package org.home;

import com.sun.jersey.api.core.ResourceContext;
import com.sun.jersey.spi.resource.PerRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;


@Path("/hello")
@PerRequest
@Component
@Scope("prototype")
public class HelloResource {

    @Context
    private ResourceContext resourceContext;

    public HelloResource() {
        System.out.println("new HelloResource()");
    }

    @Path("/{hello}")
    public WorldResource helloWorld(@PathParam("hello") String hello) {
        WorldResource worldResource = resourceContext.getResource(WorldResource.class);
        worldResource.setHello(new Hello(hello));
        return worldResource;
    }

}
