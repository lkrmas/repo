package main.wrap;

import main.data.Vahtkond;

import com.vaadin.data.util.BeanItemContainer;

@SuppressWarnings("serial")
public class VahtkondWrap extends BaseWrapper {

    public VahtkondWrap() {
        cls = Vahtkond.class;
        container = new BeanItemContainer<Vahtkond>(Vahtkond.class);
        layoutCos = 2;
        layoutRos = 4;
        layout = new int[][] {{1,1,1,1},{1,2,1,1},{1,3,2,2},
                                        {2,1,1,1},{2,2,1,1}};
        refreshLocale();
    }

    public void refreshLocale() {
        name = localise();
        tblColOrdr = new String[] {"nimetus", "kood", "piiripunkt", "vaeosa"};
        tblColHead = localise(tblColOrdr);
        frmFldOrdr = new String[] {"kood", "piiripunkt", "kommentaar", "nimetus", "vaeosa"};
        frmFldHead = localise(frmFldOrdr);
    }

}
