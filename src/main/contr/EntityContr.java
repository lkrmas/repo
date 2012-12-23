package main.contr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import main.Context;
import main.data.BaseEntity;
import main.present.EntityForm;
import main.present.EntityTable;
import main.service.GeneralService;
import main.wrap.BaseWrapper;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
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
        Button source = event.getButton();

        if (source == form.getAdd()) {
            if (form.getItem() == null) {
                makeNewEntity();
            }
            else {
                makeMutable();
                makeNewEntity();
            }
        }
        else if (source == form.getEdit()) {
            if (! Context.getApp().getMutableMode())
                makeMutable();
            else if (form.checkValidity())
                saveEntity();
        }
        else if (source == form.getCancel()) {
            if (! Context.getApp().getNewEntityMode())
                form.discard();
            else
                dropNewEntity();
            makeImmutable();
        }
        else if (source == form.getDelete()) {
            deleteEntity();
        }
    }

    public void valueChange(ValueChangeEvent event) {
        BeanItem<? extends BaseEntity> item = table.getItem();
        if (item != null) {
            if (item != form.getItem()) {
                form.setItem(item);
                makeImmutable();
                Context.getApp().setNewEntityMode(false);
            }
        }
    }

    public void refreshData() {
        BaseWrapper wrap = Context.getApp().getEntityWrap();
        List<BaseEntity> entities = genServ.retrieveActive(wrap.getCls());
        for (BaseEntity entity : entities)
            wrap.getContainer().addItem(entity);
        clearForm();
        table.setContainer(wrap.getContainer());
    }

    private void makeNewEntity() {
        form.setItem(Context.getApp().getEntityWrap().newItem());
        Context.getApp().setNewEntityMode(true);
    }

    private void dropNewEntity() {
        Context.getApp().setNewEntityMode(false);
        clearForm();
    }

    private void saveEntity() {
        form.commit();
        BaseEntity entity = form.getValue();
        if (! Context.getApp().getNewEntityMode()) {
            entity = genServ.update(entity, Context.getApp().getSecurity().getName());
        }
        else {
            entity = genServ.insert(entity, Context.getApp().getSecurity().getName());
            BaseWrapper wrap = Context.getApp().getEntityWrap();
            BeanItem<? extends BaseEntity> addedItem = wrap.getContainer().addItem(entity); // We need to add the new item to the container.
            form.setItem(addedItem); // We must update the form to use the Item from our datasource as we are now in edit mode (no longer in add mode).
        }
        Context.getApp().setNewEntityMode(false);
        makeImmutable();
    }

    private void deleteEntity() {
        if (! Context.getApp().getNewEntityMode()) {
            BaseEntity entity = form.getValue();
            genServ.delete(entity, Context.getApp().getSecurity().getName());
            Context.getApp().setNewEntityMode(false);
            clearForm();
            BaseWrapper wrap = Context.getApp().getEntityWrap();
            wrap.getContainer().removeItem(entity);
        }
        else {
            dropNewEntity();
        }
    }

    private void clearForm() {
        form.makeClearMutable();
        Context.getApp().setMutableMode(true);
        switch (Context.getApp().getSecurity().getRole()) {
            case USER:
                form.getAdd().setVisible(false);
                form.getEdit().setVisible(false);
                form.getCancel().setVisible(false);
                form.getDelete().setVisible(false);
                break;
            case POWER:
                form.getAdd().setVisible(false);
                form.getEdit().setVisible(true);
                form.getCancel().setVisible(true);
                form.getDelete().setVisible(false);
                break;
            case ADMIN:
                form.getAdd().setVisible(true);
                form.getEdit().setVisible(true);
                form.getCancel().setVisible(true);
                form.getDelete().setVisible(true);
                break;
            default: break; }
    }

    private void makeMutable() {
        form.makeMutable();
        Context.getApp().setMutableMode(true);
    }

    private void makeImmutable() {
        Context.getApp().setMutableMode(false);
        form.makeImmutable();
    }

    public void refreshLocale() {
        form.refreshLocale();
    }

}
