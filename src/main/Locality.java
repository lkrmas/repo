package main;

import java.io.Serializable;
import java.util.Locale;

@SuppressWarnings("serial")
public class Locality implements Serializable {

    private Locale locale;

    public Locality(Locale locale) {
        this.locale = locale;
    }

    public String locMsg(String code) {
        return Context.getMessage(code, null, locale);
    }

    public String locMsg(String code, Object[] args) {
        return Context.getMessage(code, args, locale);
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
