package main.data;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;

@NamedQueries({
    @NamedQuery(name="Vahtkonnaliige.selectAll", query="SELECT e FROM Vahtkonnaliige e"),
    @NamedQuery(name="Vahtkonnaliige.selectActive", query="SELECT e FROM Vahtkonnaliige e WHERE e.sulgeja is null OR e.sulgeja = ''")
})

@Entity
public class Vahtkonnaliige extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date alates;
	private String kommentaar;
	private Date kuni;
	@ManyToOne
	private Piirivalvur piirivalvur;
	@ManyToOne
	private Vahtkond vahtkond;

	public Vahtkonnaliige() {
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

	public Piirivalvur getPiirivalvur() {
		return this.piirivalvur;
	}

	public void setPiirivalvur(Piirivalvur piirivalvur) {
		this.piirivalvur = piirivalvur;
	}

	public Vahtkond getVahtkond() {
		return this.vahtkond;
	}

	public void setVahtkond(Vahtkond vahtkond) {
		this.vahtkond = vahtkond;
	}

}