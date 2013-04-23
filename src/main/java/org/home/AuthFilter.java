package org.home;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.jersey.spi.container.ResourceFilter;
import org.springframework.stereotype.Component;

import javax.ws.rs.ext.Provider;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 23.04.13
 * Time: 22:56
 * To change this template use File | Settings | File Templates.
 */

@Component   // let spring manage the lifecycle
@Provider    // register as jersey's provider
public class AuthFilter implements ResourceFilter, ContainerRequestFilter {

    @Override
    public ContainerRequest filter(ContainerRequest request) {
        // Get session id from request header
        final String secret = request.getQueryParameters().get("secret").get(0);

        if (secret != null && "secret".equals(secret)) {
            request.setSecurityContext(new HomeSecurityContext(true));
            return request;
        }

        // Set security context
        request.setSecurityContext(new HomeSecurityContext(false));
        return request;
    }

    @Override
    public ContainerRequestFilter getRequestFilter() {
        return this;
    }

    @Override
    public ContainerResponseFilter getResponseFilter() {
        return null;
    }
}
