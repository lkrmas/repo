package main;

import java.io.Serializable;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@SuppressWarnings("serial")
public class Security implements Serializable {

    private transient Authentication security;
    private String name;
    private R role;

    public Security(Authentication sec) {
        security = sec;
        String r = sec.getName();
        if (r.equals("valvur"))
            role = R.USER;
        else if (r.equals("ylem"))
            role = R.POWER;
        else if (r.equals("admin"))
            role = R.ADMIN;
        else
            role = R.NONE;
        name = r;
    }

    public void secure() {
        SecurityContextHolder.getContext().setAuthentication(security);
    }

    public R getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

}
