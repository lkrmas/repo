package main.data;

import java.io.Serializable;
import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String avaja;
    private String muutja;
    private String sulgeja;
    private int version;

    public BaseEntity() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvaja() {
        return avaja;
    }

    public void setAvaja(String avaja) {
        this.avaja = avaja;
    }

    public String getMuutja() {
        return muutja;
    }

    public void setMuutja(String muutja) {
        this.muutja = muutja;
    }

    public String getSulgeja() {
        return sulgeja;
    }

    public void setSulgeja(String sulgeja) {
        this.sulgeja = sulgeja;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
