package main.data;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;

@NamedQueries({
    @NamedQuery(name="Piirivalvurauaste.selectAll", query="SELECT e FROM Piirivalvurauaste e"),
    @NamedQuery(name="Piirivalvurauaste.selectActive", query="SELECT e FROM Piirivalvurauaste e WHERE e.sulgeja is null OR e.sulgeja = ''")
})

@Entity
public class Piirivalvurauaste extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date alates;
	private String kommentaar;
	private Date kuni;
	@ManyToOne
	private Auaste auaste;
	@ManyToOne
	private Piirivalvur piirivalvur;

	public Piirivalvurauaste() {
	}

	public Date getAlates() {
		return this.alates;
	}

	public void setAlates(Date alates) {
		this.alates = alates;
	}

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public Date getKuni() {
		return this.kuni;
	}

	public void setKuni(Date kuni) {
		this.kuni = kuni;
	}

	public Auaste getAuaste() {
		return this.auaste;
	}

	public void setAuaste(Auaste auaste) {
		this.auaste = auaste;
	}

	public Piirivalvur getPiirivalvur() {
		return this.piirivalvur;
	}

	public void setPiirivalvur(Piirivalvur piirivalvur) {
		this.piirivalvur = piirivalvur;
	}

}