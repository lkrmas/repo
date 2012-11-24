package main.data;

import java.io.Serializable;
import javax.persistence.*;

@NamedQueries({
    @NamedQuery(name="Station.selectAll", query="SELECT s FROM Station s")
})

@Entity
public class Station implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String address;
    private int guardCount;

    public Station() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGuardCount() {
        return this.guardCount;
    }

    public void setGuardCount(int guardCount) {
        this.guardCount = guardCount;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
