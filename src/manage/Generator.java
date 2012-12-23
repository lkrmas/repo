package manage;

import java.util.Date;

import main.dao.GeneralDAO;
import main.data.Auaste;
import main.data.Piirivalvur;
import main.data.Piirivalvurauaste;
import main.data.Vahtkond;
import main.data.Vahtkonnaliige;

public class Generator {

    public static void generate()
    {
        int count = 5;
        for (int k = 0; k < count; k ++) {
            GeneralDAO dao = new GeneralDAO();
            Auaste e = new Auaste();
            e.setKood("kood " + k);
            e.setNimetus("Auaste nimetus " + k);
            e.setTyyp("tyyp " + k);
            e.setVersion(k + 1);
            e.setAvaja("gen");
            dao.insert(e);
            dao.terminate();
        }
        for (int k = 0; k < count; k ++) {
            GeneralDAO dao = new GeneralDAO();
            Piirivalvur e = new Piirivalvur();
            e.setAadress("aadress " + k);
            e.setEesnimi("Eesnimi " + k);
            e.setEmail("email" + k + "@mail.com");
            e.setIsikukood("3771122333" + k);
            e.setKommentaar("kommentaar " + k);
            e.setPerekonnanimi("Perekonnanimi " + k);
            e.setSodurikood("sodurikood " + k);
            e.setSugu(k % 2);
            e.setTelefon("123450" + k);
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
        for (int k = 0; k < count; k ++) {
            GeneralDAO dao = new GeneralDAO();
            Vahtkond e = new Vahtkond();
            e.setKommentaar("kommentaar " + k);
            e.setKood("kood " + k);
            e.setNimetus("Vahtkond nimetus " + k);
            e.setPiiripunkt("piiripunkt " + k);
            e.setVaeosa("vaeosa " + k);
            e.setVersion(k + 1);
            e.setAvaja("gen");
            dao.insert(e);
            dao.terminate();
        }
        for (int k = 0; k < count; k ++) {
            GeneralDAO dao = new GeneralDAO();
            Vahtkonnaliige e = new Vahtkonnaliige();
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
