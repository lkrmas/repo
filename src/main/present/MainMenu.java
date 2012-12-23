package main.present;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;
import javax.annotation.PostConstruct;

import main.Context;
import main.Locality;
import main.contr.MainContr;
import main.wrap.AuasteWrap;
import main.wrap.PiirivalvurWrap;
import main.wrap.PiirivalvurauasteWrap;
import main.wrap.VahtkondWrap;
import main.wrap.VahtkonnaliigeWrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class MainMenu extends CustomComponent {

    @Autowired private MainContr mainContr;

    private VerticalLayout root;

    private VerticalLayout menu;
    private Button userBtn;
    private Button entity1Btn;
    private Button entity2Btn;
    private Button entity3Btn;
    private Button entity4Btn;
    private Button entity5Btn;

    @PostConstruct
    public void init() {
        root = new VerticalLayout();
        menu = new VerticalLayout();
        userBtn = new Button();

        entity1Btn = new Button();
        entity2Btn = new Button();
        entity3Btn = new Button();
        entity4Btn = new Button();
        entity5Btn = new Button();
        entity1Btn.addListener(mainContr);
        entity2Btn.addListener(mainContr);
        entity3Btn.addListener(mainContr);
        entity4Btn.addListener(mainContr);
        entity5Btn.addListener(mainContr);
        entity1Btn.setWidth(100, Sizeable.UNITS_PERCENTAGE);
        entity2Btn.setWidth(100, Sizeable.UNITS_PERCENTAGE);
        entity3Btn.setWidth(100, Sizeable.UNITS_PERCENTAGE);
        entity4Btn.setWidth(100, Sizeable.UNITS_PERCENTAGE);
        entity5Btn.setWidth(100, Sizeable.UNITS_PERCENTAGE);
        menu.addComponent(entity1Btn);
        menu.addComponent(entity2Btn);
        menu.addComponent(entity3Btn);
        menu.addComponent(entity4Btn);
        menu.addComponent(entity5Btn);

        root.setMargin(true);
        menu.setSpacing(true);
        userBtn.addListener(mainContr);
        userBtn.setWidth(100, Sizeable.UNITS_PERCENTAGE);

        setSizeFull();
        root.setSizeFull();
        menu.setWidth("100%");

        root.addComponent(menu);
        root.addComponent(userBtn);
        root.setExpandRatio(menu, 1);
        setCompositionRoot(root);
    }

    public void refreshLocale() {
        Locality loc = Context.getApp().getLocality();
        userBtn.setCaption(loc.locMsg("layout.mainmenu.userbutton"));
        entity1Btn.setCaption(new AuasteWrap().getName());
        entity2Btn.setCaption(new PiirivalvurWrap().getName());
        entity3Btn.setCaption(new PiirivalvurauasteWrap().getName());
        entity4Btn.setCaption(new VahtkondWrap().getName());
        entity5Btn.setCaption(new VahtkonnaliigeWrap().getName());
    }

    public void makeLoggedOutMode() {
        menu.setVisible(false);
    }

    public void makeLoggedInMode() {
        menu.setVisible(true);
    }



    public Button getUserBtn() {
        return userBtn;
    }

    public Button getEntity1Btn() {
        return entity1Btn;
    }

    public Button getEntity2Btn() {
        return entity2Btn;
    }

    public Button getEntity3Btn() {
        return entity3Btn;
    }

    public Button getEntity4Btn() {
        return entity4Btn;
    }

    public Button getEntity5Btn() {
        return entity5Btn;
    }

}
