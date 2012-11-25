package main.data;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern="dd.MM.yyyy")
    private Date open;
    @DateTimeFormat(pattern="dd.MM.yyyy")
    private Date close;
    
    @Size(min=2, max=50)
    private String location;
    
    @Size(min=2, max=50)
    private String description;
    
    @Min(1)
    private int involvedGuardCount;
    
    @Size(min=2, max=50)
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

    public void setInvolvedGuardCount(int involvedGuardCount) {
        this.involvedGuardCount = involvedGuardCount;
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
