package main.present;

import javax.annotation.PostConstruct;

import main.contr.MainContr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class MainPanel extends CustomComponent {

    @Autowired private MainMenu mainMenu;
    @Autowired private UserPanel userPanel;
    @Autowired private EntityPanel entityPanel;

    @Autowired private MainContr mainContr;

    private VerticalLayout root;
    private HorizontalSplitPanel split;

    @PostConstruct
    public void init() {
        mainContr.setMainPanel(this);
        mainContr.setMainMenu(mainMenu);
        mainContr.setUserPanel(userPanel);
        mainContr.setEntityPanel(entityPanel);
        root = new VerticalLayout();

        split = new HorizontalSplitPanel();
        split.setSplitPosition(11, Sizeable.UNITS_PERCENTAGE);

        makeUserMode();

        setSizeFull();
        root.setSizeFull();
        split.setSizeFull();

        root.addComponent(split);
        root.setExpandRatio(split, 1);
        setCompositionRoot(root);
    }

    public void makeUserMode() {
        split.setFirstComponent(mainMenu);
        split.setSecondComponent(userPanel);
    }

    public void makeEntityMode() {
        split.setFirstComponent(mainMenu);
        split.setSecondComponent(entityPanel);
    }

}
