package main.present;

import java.util.Arrays;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import main.Context;
import main.Locality;
import main.contr.EntityContr;
import main.data.BaseEntity;
import main.util.FldFct;
import main.util.WrapGridLayout;
import main.wrap.BaseWrapper;

import com.vaadin.data.Buffered.SourceException;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.Sizeable;
import com.vaadin.terminal.UserError;
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
    private WrapGridLayout layout;

    @PostConstruct
    public void init() {
        entityContr.setForm(this);
        root = new VerticalLayout();
        form = new Form();

        add = new Button("", entityContr);
        edit = new Button("", entityContr);
        cancel = new Button("", entityContr);
        delete = new Button("", entityContr);

        HorizontalLayout footer = new HorizontalLayout();
        footer.addComponent(edit);
        footer.addComponent(cancel);
        footer.addComponent(delete);
        footer.setMargin(true);
        footer.setSpacing(true);
        form.setFooter(footer);
        form.setWriteThrough(false);
        form.setItemDataSource(null);
        form.getFooter().setVisible(false);

        layout = new WrapGridLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        form.setLayout(layout);

        setSizeFull();
        root.setSizeFull();
        layout.setWidth(100, Sizeable.UNITS_PERCENTAGE);
        form.setSizeFull();

        root.addComponent(add);
        root.addComponent(form);
        root.setExpandRatio(form, 1);
        setCompositionRoot(root);
    }

    public void refreshLocale() {
        Locality loc = Context.getApp().getLocality();
        add.setCaption(loc.locMsg("layout.entityform.add"));
        edit.setCaption(loc.locMsg("layout.entityform.edit"));
        cancel.setCaption(loc.locMsg("layout.entityform.cancel"));
        delete.setCaption(loc.locMsg("layout.entityform.delete"));
    }



    public void makeClearMutable() {
        makeMutable();
        setItem(null);
        form.setComponentError(null);
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

    public boolean checkValidity() {
        Locality loc = Context.getApp().getLocality();
        boolean valid = form.isValid();
        if (! valid)
            form.setComponentError(new UserError(loc.locMsg("layout.entityform.message")));
        else
            form.setComponentError(null);
        return valid;
    }

    public BaseEntity getValue() {
        return (BaseEntity) getItem().getBean();
    }

    public void setItem(BeanItem<? extends BaseEntity> item) {
        if (item != null) {
            BaseWrapper wrap = Context.getApp().getEntityWrap();
            layout.prepare(wrap.getLayoutCos(), wrap.getLayoutRos(), wrap.getLayout());
            form.setFormFieldFactory(new FldFct());
            form.setItemDataSource(item, Arrays.asList(wrap.getFrmColOrdr()));
            form.getFooter().setVisible(true);
        }
        else {
            form.setItemDataSource(null);
            form.getFooter().setVisible(false);
        }
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

}
