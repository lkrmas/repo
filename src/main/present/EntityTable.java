package main.present;

import javax.annotation.PostConstruct;

import main.Context;
import main.contr.EntityContr;
import main.data.BaseEntity;
import main.wrap.BaseWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class EntityTable extends CustomComponent {

    @Autowired private EntityContr entityContr;

    private VerticalLayout root;
    private Table table;

    @PostConstruct
    public void init() {
        entityContr.setTable(this);
        root = new VerticalLayout();
        table = new Table();

        table.setColumnReorderingAllowed(true);
        table.setColumnCollapsingAllowed(true);
        table.setSelectable(true);
        table.setNullSelectionAllowed(false);
        table.setImmediate(true);

        table.addListener(entityContr);

        setSizeFull();
        root.setSizeFull();
        table.setSizeFull();

        root.addComponent(table);
        root.setExpandRatio(table, 1);
        setCompositionRoot(root);
    }



    public void setContainer(BeanItemContainer<? extends BaseEntity> container) {
        BaseWrapper wrap = Context.getApp().getEntityWrap();
        table.setContainerDataSource(container);
        table.setVisibleColumns(wrap.getTblColOrdr());
        table.setColumnHeaders(wrap.getTblColHead());
    }

    private BaseEntity getValue() {
        return (BaseEntity) table.getValue();
    }

    @SuppressWarnings("unchecked")
    public BeanItem<? extends BaseEntity> getItem(Object itemId) {
        return (BeanItem<? extends BaseEntity>) table.getItem(itemId);
    }

    @SuppressWarnings("unchecked")
    public BeanItem<? extends BaseEntity> getItem() {
        if (table.getValue() != null) {
            return (BeanItem<? extends BaseEntity>) table.getItem(getValue());
        }
        else {
            return null;
        }
    }

}
