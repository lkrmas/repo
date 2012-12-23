package main.contr;

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
        // TODO Auto-generated method stub
    }

    public void refreshLocale() {
        localePanel.refreshLocale();
    }

}
