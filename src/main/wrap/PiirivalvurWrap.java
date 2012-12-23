package main.wrap;

import main.data.Piirivalvur;

import com.vaadin.data.util.BeanItemContainer;

@SuppressWarnings("serial")
public class PiirivalvurWrap extends BaseWrapper {

    public PiirivalvurWrap() {
        cls = Piirivalvur.class;
        container = new BeanItemContainer<Piirivalvur>(Piirivalvur.class);
        layoutCos = 3;
        layoutRos = 5;
        layout = new int[][] {{1,1,1,1},{1,2,1,1},{1,3,1,1},{1,4,1,1},{1,5,1,1},
                                        {2,1,1,1},{2,2,1,1},{2,3,1,1},{2,4,2,2}};
        refreshLocale();
    }

    public void refreshLocale() {
        name = localise();
        tblColOrdr = new String[] {"eesnimi", "perekonnanimi", "isikukood", "sodurikood"};
        tblColHead = localise(tblColOrdr);
        frmFldOrdr = new String[] {"sodurikood", "isikukood", "eesnimi", "perekonnanimi", "sugu", "email", "telefon", "aadress", "kommentaar"};
        frmFldHead = localise(frmFldOrdr);
    }

}
