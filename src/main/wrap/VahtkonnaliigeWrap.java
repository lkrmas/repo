package main.wrap;

import main.data.Vahtkonnaliige;

import com.vaadin.data.util.BeanItemContainer;

@SuppressWarnings("serial")
public class VahtkonnaliigeWrap extends BaseWrapper {

    public VahtkonnaliigeWrap() {
        cls = Vahtkonnaliige.class;
        container = new BeanItemContainer<Vahtkonnaliige>(Vahtkonnaliige.class);
        layoutCos = 2;
        layoutRos = 4;
        layout = new int[][] {{1,1,1,1},{1,2,1,1},{1,3,2,2},
                                        {2,1,1,1},{2,2,1,1}};
        refreshLocale();
    }

    public void refreshLocale() {
        name = localise();
        tblColOrdr = new String[] {"kommentaar", "alates", "kuni"};
        tblColHead = localise(tblColOrdr);
        frmFldOrdr = new String[] {"piirivalvur", "vahtkond", "kommentaar", "alates", "kuni"};
        frmFldHead = localise(frmFldOrdr);
    }

}
