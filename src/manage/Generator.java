package manage;

import java.util.Date;

import main.dao.GeneralDAO;
import main.data.Auaste;
import main.data.Piirivalvurauaste;

public class Generator {

    public static void generate()
    {
        int count = 5;
        for (int k = 0; k < count; k ++) {
            GeneralDAO dao = new GeneralDAO();
            Auaste e = new Auaste();
            e.setKood("kood " + k);
            e.setNimetus("nimetus " + k);
            e.setTyyp("tyyp " + k);
            e.setVersion(k + 1);
            e.setAvaja("gen");
            dao.insert(e);
            dao.terminate();
        }
        for (int k = 0; k < count; k ++) {
            GeneralDAO dao = new GeneralDAO();
            Piirivalvurauaste e = new Piirivalvurauaste();
            e.setAlates(new Date());
            e.setKuni(new Date());
            e.setKommentaar("kommentaar " + k);
            e.setVersion(k + 1);
            e.setAvaja("gen");
            dao.insert(e);
            dao.terminate();
        }
    }

}
