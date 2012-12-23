package main.present;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class UserPanel extends CustomComponent {

    @Autowired private SecurityPanel securityPanel;
    @Autowired private LocalePanel localePanel;

    private VerticalLayout root;

    @PostConstruct
    public void init() {
        root = new VerticalLayout();
        root.setMargin(true);

        setSizeFull();
        root.setSizeFull();

        root.addComponent(securityPanel);
        root.addComponent(localePanel);
        setCompositionRoot(root);
    }

}
