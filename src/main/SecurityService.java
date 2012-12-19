package main;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@SuppressWarnings("serial")
@Service
@Scope("session")
public class SecurityService implements Serializable {

    public boolean loginUser(String username, String password) {
        AuthenticationManager am = Context.getManager();
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(username, password);
            Authentication result = am.authenticate(request);
            if (result != null) {
                SecurityContextHolder.getContext().setAuthentication(result);
            }
            else {
                System.out.println("Authentication failed: Response was null");
                return false;
            }
        }
        catch(AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
            return false;
        }
        System.out.println("Successfully authenticated. Security context contains: " +
          SecurityContextHolder.getContext().getAuthentication());
        return true;
    }

    public boolean logoutUser() {
        System.out.println("Cleared security context for user: " + getUsername());
        SecurityContextHolder.clearContext();
        SecurityContextHolder.getContext().setAuthentication(null);
        return true;
    }

    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (authentication == null) ? false : authentication.isAuthenticated();
    }

    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (authentication == null) ? "" : authentication.getName();
    }

    public Authentication getSecurity() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public void setSecurity(Authentication sec) {
        SecurityContextHolder.getContext().setAuthentication(sec);
    }

}
