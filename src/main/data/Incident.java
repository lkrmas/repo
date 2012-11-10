package main.data;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;

@NamedQueries({
    @NamedQuery(name="Incident.selectAll", query="SELECT i FROM Incident i")
})

@Entity
public class Incident implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date open;
    private Date close;
    private String location;
    private String description;
    private int involvedGuardCount;
    private String status;

    public Incident() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getClose() {
        return this.close;
    }

    public void setClose(Date close) {
        this.close = close;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInvolvedGuardCount() {
        return this.involvedGuardCount;
    }

    public void setInvolvedGuardCount(int involvedguardcount) {
        this.involvedGuardCount = involvedguardcount;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getOpen() {
        return this.open;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}