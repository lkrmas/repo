package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.Application;

import main.contr.EntityContr;
import main.contr.LocaleContr;
import main.contr.MainContr;
import main.contr.SecurityContr;
import main.present.MainPanel;

import com.vaadin.ui.Window;

@SuppressWarnings("serial")
@Component(value = "vaadinApp")
@Scope(value = "session")
public class VaadinApp extends Application {

    @Autowired private MainPanel mainPanel;

    @Autowired private MainContr mainContr;
    @Autowired private SecurityContr securityContr;
    @Autowired private LocaleContr localeContr;
    @Autowired private EntityContr entityContr;

    private Security security;
    private boolean newEntityMode;
    private boolean mutableMode;

    @Override
    public void init() {
        setMainWindow(new Window());
        security = null;
        newEntityMode = false;
        makeLoggedOut();
        refreshLocale();
        getMainWindow().setContent(mainPanel);
    }

    public void refreshLocale() {
        getMainWindow().setCaption("Rakendus");
        mainContr.refreshLocale();
        securityContr.refreshLocale();
        localeContr.refreshLocale();
        entityContr.refreshLocale();
    }

    public void makeLoggedOut() {
        mainContr.makeLoggedOut();
    }

    public void makeLoggedIn() {
        mainContr.makeLoggedIn();
    }



    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public boolean getNewEntityMode() {
        return newEntityMode;
    }

    public void setNewEntityMode(boolean newEntityMode) {
        this.newEntityMode = newEntityMode;
    }

    public boolean getMutableMode() {
        return mutableMode;
    }

    public void setMutableMode(boolean mutableMode) {
        this.mutableMode = mutableMode;
    }



    public MainContr getMainContr() {
        return mainContr;
    }

    public SecurityContr getSecurityContr() {
        return securityContr;
    }

    public LocaleContr getLocaleContr() {
        return localeContr;
    }

    public EntityContr getEntityContr() {
        return entityContr;
    }

}
