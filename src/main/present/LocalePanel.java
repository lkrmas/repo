package main.present;

import javax.annotation.PostConstruct;

import main.contr.LocaleContr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class LocalePanel extends CustomComponent {

    @Autowired private LocaleContr localeContr;

    private Panel root;
    private NativeSelect langSel;
    private Button langBut;

    @PostConstruct
    public void init() {
        localeContr.setLocalePanel(this);
        root = new Panel();
        FormLayout formLayout = new FormLayout();
        root.setContent(formLayout);

        langSel = new NativeSelect();
        langBut = new Button();

        langSel.setSizeUndefined();

        langSel.setNullSelectionAllowed(false);

        langBut.addListener(localeContr);

        root.addComponent(langSel);
        root.addComponent(langBut);
        setCompositionRoot(root);
    }

    public void refreshLocale() {
        setCaption("Keel");
        langSel.setCaption("Keel");
        langBut.setCaption("Vali");
    }



    public NativeSelect getLangSel() {
        return langSel;
    }

    public Button getLangBut() {
        return langBut;
    }

}
