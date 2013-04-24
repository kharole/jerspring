package org.home;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 24.04.13
 * Time: 22:44
 * To change this template use File | Settings | File Templates.
 */
@Provider
public class HomeExceptionMapper implements ExceptionMapper<WebApplicationException> {

    public Response toResponse(WebApplicationException webApplicationException) {
        Object error = webApplicationException.getResponse().getEntity() != null ?
                webApplicationException.getResponse().getEntity() : new HomeError(webApplicationException.getMessage());

        return Response.status(webApplicationException.getResponse().getStatus()).
                entity(error).type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
