package main;

import java.util.Locale;

import org.springframework.context.MessageSource;
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

    public static VaadinApp getApp() {
        return context.getBean(VaadinApp.class);
    }

    public static String getMessage(String code, Object[] args, Locale loc) {
        return context.getBean(MessageSource.class).getMessage(code, args, loc);
    }

}
