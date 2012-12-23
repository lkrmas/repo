package main.contr;

import main.present.EntityPanel;
import main.present.MainMenu;
import main.present.MainPanel;
import main.present.UserPanel;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class MainContr implements ClickListener {

    private MainPanel mainPanel;
    private MainMenu mainMenu;
    private UserPanel userPanel;
    private EntityPanel entityPanel;

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }
    public void setUserPanel(UserPanel userPanel) {
        this.userPanel = userPanel;
    }
    public void setEntityPanel(EntityPanel entityPanel) {
        this.entityPanel = entityPanel;
    }

    public void buttonClick(ClickEvent event) {
        Button source = event.getButton();

        if (source == mainMenu.getUserBtn()) {
            mainPanel.makeUserMode();
        }
        else {
            mainPanel.makeEntityMode();
        }
    }

    public void refreshLocale() {
        mainMenu.refreshLocale();
    }

    public void makeLoggedOut() {
        mainMenu.makeLoggedOutMode();
    }

    public void makeLoggedIn() {
        mainMenu.makeLoggedInMode();
    }

}
