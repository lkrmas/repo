package main.present;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import javax.annotation.PostConstruct;

import main.Context;
import main.Locality;
import main.contr.SecurityContr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class SecurityPanel extends CustomComponent {

    @Autowired private SecurityContr securityContr;

    private Panel root;
    private Label name;
    private TextField username;
    private TextField password;
    private Button button;
    private Label message;

    @PostConstruct
    public void init() {
        securityContr.setSecurityPanel(this);
        root = new Panel();
        FormLayout formLayout = new FormLayout();
        root.setContent(formLayout);

        name = new Label();
        username = new TextField();
        password = new TextField();
        button = new Button();
        message = new Label();

        name.setSizeUndefined();
        username.setMaxLength(22);
        username.setWidth(22, Sizeable.UNITS_EM);
        password.setMaxLength(22);
        password.setWidth(22, Sizeable.UNITS_EM);
        message.setSizeUndefined();

        button.addListener(securityContr);

        showForm();

        root.addComponent(name);
        root.addComponent(username);
        root.addComponent(password);
        root.addComponent(button);
        root.addComponent(message);
        setCompositionRoot(root);
    }

    public void refreshLocale() {
        Locality loc = Context.getApp().getLocality();
        setCaption(loc.locMsg("layout.securitypanel.caption"));
        username.setCaption(loc.locMsg("layout.securitypanel.username"));
        password.setCaption(loc.locMsg("layout.securitypanel.password"));
        button.setCaption(loc.locMsg("layout.securitypanel.button"));
        message.setValue(loc.locMsg("layout.securitypanel.message"));
    }



    public void showForm() {
        name.setValue("");
        name.setVisible(false);
        username.setVisible(true);
        password.setVisible(true);
        message.setVisible(false);
    }

    public void showName(String str) {
        name.setValue(str);
        name.setVisible(true);
        username.setVisible(false);
        password.setVisible(false);
        message.setVisible(false);
    }

    public void showMessage() {
        message.setVisible(true);
    }



    public TextField getUsername() {
        return username;
    }

    public TextField getPassword() {
        return password;
    }

}
