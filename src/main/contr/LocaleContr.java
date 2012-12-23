package main.contr;

import java.util.Locale;

import main.Context;
import main.present.LocalePanel;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class LocaleContr implements ClickListener {

    private LocalePanel localePanel;

    public void setLocalePanel(LocalePanel localePanel) {
        this.localePanel = localePanel;
    }

    public void buttonClick(ClickEvent event) {
        Locale locale = (Locale) localePanel.getLangSel().getValue();
        if (locale != null) {
            Context.getApp().getLocality().setLocale(locale);
            Context.getApp().refreshLocale();
        }
    }

    public void refreshLocale() {
        localePanel.refreshLocale();
    }

}
