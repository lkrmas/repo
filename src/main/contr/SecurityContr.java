package main.contr;

import main.Context;
import main.Security;
import main.SecurityService;
import main.present.SecurityPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class SecurityContr implements ClickListener {

    @Autowired private SecurityService secServ;

    private SecurityPanel securityPanel;

    public void setSecurityPanel(SecurityPanel securityPanel) {
        this.securityPanel = securityPanel;
    }

    public void buttonClick(ClickEvent event) {
        if (Context.getApp().getSecurity() == null) {
            loginUser();
        }
        else {
            logoutUser();
        }
    }

    private void loginUser() {
        String name = (String) securityPanel.getUsername().getValue();
        String pass = (String) securityPanel.getPassword().getValue();
        if (name == null || name.equals("") || pass == null || pass.equals("")) {
            securityPanel.showMessage();
            return;
        }
        else {
            if (! secServ.loginUser(name, pass)) {
                securityPanel.showMessage(); }
            else {
                securityPanel.getUsername().setValue("");
                securityPanel.getPassword().setValue("");
                securityPanel.showName(secServ.getUsername());
                Context.getApp().setSecurity(new Security(secServ.getSecurity()));
                Context.getApp().makeLoggedIn(); }
        }
    }

    private void logoutUser() {
        System.out.println("Logged out user: " + Context.getApp().getSecurity().getName());
        Context.getApp().makeLoggedOut();
        Context.getApp().setSecurity(null);
        securityPanel.showForm();
    }

    public void refreshLocale() {
        securityPanel.refreshLocale();
    }

}
