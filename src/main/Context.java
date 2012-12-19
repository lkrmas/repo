package main;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.context.WebApplicationContext;

public class Context {

    private static WebApplicationContext context;

    public static void setContext(WebApplicationContext cont) {
        context = cont;
    }

    public static AuthenticationManager getManager() {
        return (AuthenticationManager) context.getBean("authManager");
    }

}
