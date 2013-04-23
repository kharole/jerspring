package org.home;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 23.04.13
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
public class HomeSecurityContext implements SecurityContext {

    private boolean secure;

    public HomeSecurityContext(boolean secure) {
        this.secure = secure;
    }

    @Override
    public Principal getUserPrincipal() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isUserInRole(String role) {
        return secure;
    }

    @Override
    public boolean isSecure() {
        return secure;
    }

    @Override
    public String getAuthenticationScheme() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
