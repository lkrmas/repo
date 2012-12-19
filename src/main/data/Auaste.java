package main.data;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;

import java.util.List;

@NamedQueries({
    @NamedQuery(name="Auaste.selectAll", query="SELECT e FROM Auaste e"),
    @NamedQuery(name="Auaste.selectActive", query="SELECT e FROM Auaste e WHERE e.sulgeja is null OR e.sulgeja = ''")
})

@Entity
public class Auaste extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String kood;
	private String nimetus;
	private String tyyp;
	@OneToMany(mappedBy="auaste", fetch=FetchType.EAGER)
	@IndexColumn(name="id")
	private List<Piirivalvurauaste> piirivalvurauastes;

	public Auaste() {
	}

	public String getKood() {
		return this.kood;
	}

	public void setKood(String kood) {
		this.kood = kood;
	}

	public String getNimetus() {
		return this.nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}

	public String getTyyp() {
		return this.tyyp;
	}

	public void setTyyp(String tyyp) {
		this.tyyp = tyyp;
	}

	public List<Piirivalvurauaste> getPiirivalvurauastes() {
		return this.piirivalvurauastes;
	}

	public void setPiirivalvurauastes(List<Piirivalvurauaste> piirivalvurauastes) {
		this.piirivalvurauastes = piirivalvurauastes;
	}

}