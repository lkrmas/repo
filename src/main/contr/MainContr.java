package main.contr;

import main.Context;
import main.present.EntityPanel;
import main.present.MainMenu;
import main.present.MainPanel;
import main.present.UserPanel;
import main.wrap.AuasteWrap;
import main.wrap.PiirivalvurWrap;
import main.wrap.PiirivalvurauasteWrap;
import main.wrap.VahtkondWrap;
import main.wrap.VahtkonnaliigeWrap;

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
            if (source == mainMenu.getEntity1Btn()) {
                Context.getApp().setEntityWrap(new AuasteWrap());
            }
            else if (source == mainMenu.getEntity2Btn()) {
                Context.getApp().setEntityWrap(new PiirivalvurWrap());
            }
            else if (source == mainMenu.getEntity3Btn()) {
                Context.getApp().setEntityWrap(new PiirivalvurauasteWrap());
            }
            else if (source == mainMenu.getEntity4Btn()) {
                Context.getApp().setEntityWrap(new VahtkondWrap());
            }
            else if (source == mainMenu.getEntity5Btn()) {
                Context.getApp().setEntityWrap(new VahtkonnaliigeWrap());
            }
            Context.getApp().getEntityContr().refreshData();
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
