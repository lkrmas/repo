package main.present;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalSplitPanel;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class EntityPanel extends CustomComponent {

    @Autowired private EntityTable entityTable;
    @Autowired private EntityForm entityForm;

    private HorizontalSplitPanel split;

    @PostConstruct
    public void init() {
        split = new HorizontalSplitPanel();
        split.setSplitPosition(50);

        split.setFirstComponent(entityForm);
        split.setSecondComponent(entityTable);

        setSizeFull();
        split.setSizeFull();
        setCompositionRoot(split);
    }

}
