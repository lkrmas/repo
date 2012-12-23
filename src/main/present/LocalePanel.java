package main.present;

import java.util.Locale;

import javax.annotation.PostConstruct;

import main.Context;
import main.Locality;
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

    private Locale localeUS;
    private Locale localeET;

    @PostConstruct
    public void init() {
        localeContr.setLocalePanel(this);
        root = new Panel();
        FormLayout formLayout = new FormLayout();
        root.setContent(formLayout);

        langSel = new NativeSelect();
        langBut = new Button();

        langSel.setSizeUndefined();

        Locale localeUS = Locale.US;
        langSel.addItem(localeUS);
        langSel.setItemCaption(localeUS, "English");
        Locale localeET = new Locale("et", "ET");
        langSel.addItem(localeET);
        langSel.setItemCaption(localeET, "Eesti");

        langSel.setNullSelectionAllowed(false);

        langBut.addListener(localeContr);

        root.addComponent(langSel);
        root.addComponent(langBut);
        setCompositionRoot(root);
    }

    public void refreshLocale() {
        Locality loc = Context.getApp().getLocality();
        setCaption(loc.locMsg("layout.localepanel.caption"));
        langSel.setCaption(loc.locMsg("layout.localepanel.selection"));
        langBut.setCaption(loc.locMsg("layout.localepanel.button"));
        if (loc.getLocale().equals(localeUS))
            langSel.setValue(localeUS);
        else if (loc.getLocale().equals(localeET))
            langSel.setValue(localeET);
        else
            langSel.setValue(null);
    }



    public NativeSelect getLangSel() {
        return langSel;
    }

    public Button getLangBut() {
        return langBut;
    }

}
