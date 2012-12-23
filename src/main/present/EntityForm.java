package main.present;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import main.contr.EntityContr;
import main.data.BaseEntity;

import com.vaadin.data.Buffered.SourceException;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class EntityForm extends CustomComponent {

    @Autowired private EntityContr entityContr;

    private VerticalLayout root;
    private Form form;
    private Button add;
    private Button edit;
    private Button cancel;
    private Button delete;

    @PostConstruct
    public void init() {
        entityContr.setForm(this);
        root = new VerticalLayout();
        form = new Form();
        root.setMargin(true);

        add = new Button("", entityContr);
        edit = new Button("", entityContr);
        cancel = new Button("", entityContr);
        delete = new Button("", entityContr);

        HorizontalLayout footer = new HorizontalLayout();
        footer.addComponent(edit);
        footer.addComponent(cancel);
        footer.addComponent(delete);
        footer.setSpacing(true);
        form.setFooter(footer);
        form.setWriteThrough(false);
        form.setItemDataSource(null);
        form.getFooter().setVisible(false);

        setSizeFull();
        root.setSizeFull();
        form.setSizeFull();

        root.addComponent(add);
        root.addComponent(form);
        root.setExpandRatio(form, 1);
        setCompositionRoot(root);
    }

    public void refreshLocale() {
        add.setCaption("Lisa");
        edit.setCaption("Salvesta");
        cancel.setCaption("Katkesta");
        delete.setCaption("Kustuta");
    }



    public void makeImmutable() {
        form.setReadOnly(true);
        cancel.setEnabled(false);
        delete.setEnabled(false);
    }

    public void makeMutable() {
        form.setReadOnly(false);
        cancel.setEnabled(true);
        delete.setEnabled(true);
    }

    public BaseEntity getValue() {
        return (BaseEntity) getItem().getBean();
    }

    @SuppressWarnings("unchecked")
    public BeanItem<? extends BaseEntity> getItem() {
        return (BeanItem<? extends BaseEntity>) form.getItemDataSource();
    }



    public Button getAdd() {
        return add;
    }

    public Button getEdit() {
        return edit;
    }

    public Button getCancel() {
        return cancel;
    }

    public Button getDelete() {
        return delete;
    }

    public void commit() throws SourceException, InvalidValueException {
        form.commit();
    }

    public void discard() throws SourceException {
        form.discard();
    }

    public boolean isValid() {
        return form.isValid();
    }

}
