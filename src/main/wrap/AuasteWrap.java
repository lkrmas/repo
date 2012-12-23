package main.wrap;

import main.data.Auaste;

import com.vaadin.data.util.BeanItemContainer;

@SuppressWarnings("serial")
public class AuasteWrap extends BaseWrapper {

    public AuasteWrap() {
        cls = Auaste.class;
        container = new BeanItemContainer<Auaste>(Auaste.class);
        layoutCos = 3;
        layoutRos = 3;
        layout = new int[][] {{1,1,1,1},{1,2,1,1},{1,3,2,1}};
        refreshLocale();
    }

    public void refreshLocale() {
        name = localise();
        tblColOrdr = new String[] {"nimetus", "tyyp", "kood"};
        tblColHead = localise(tblColOrdr);
        frmFldOrdr = new String[] {"kood", "nimetus", "tyyp"};
        frmFldHead = localise(frmFldOrdr);
    }

}
