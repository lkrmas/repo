package main.contr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import main.present.EntityForm;
import main.present.EntityTable;
import main.service.GeneralService;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class EntityContr implements ClickListener, ValueChangeListener {

    @Autowired private GeneralService genServ;

    private EntityTable table;
    private EntityForm form;

    public void setTable(EntityTable table) {
        this.table = table;
    }
    public void setForm(EntityForm form) {
        this.form = form;
    }

    public void buttonClick(ClickEvent event) {
        // TODO Auto-generated method stub
    }

    public void valueChange(ValueChangeEvent event) {
        // TODO Auto-generated method stub
    }

    public void refreshLocale() {
        form.refreshLocale();
    }

}
