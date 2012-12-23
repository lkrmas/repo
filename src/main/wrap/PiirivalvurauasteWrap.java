package main.wrap;

import main.data.Piirivalvurauaste;

import com.vaadin.data.util.BeanItemContainer;

@SuppressWarnings("serial")
public class PiirivalvurauasteWrap extends BaseWrapper {

    public PiirivalvurauasteWrap() {
        cls = Piirivalvurauaste.class;
        container = new BeanItemContainer<Piirivalvurauaste>(Piirivalvurauaste.class);
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
        frmFldOrdr = new String[] {"piirivalvur", "auaste", "kommentaar", "alates", "kuni"};
        frmFldHead = localise(frmFldOrdr);
    }

}
