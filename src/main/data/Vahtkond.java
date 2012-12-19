package main.data;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;

import java.util.List;

@NamedQueries({
    @NamedQuery(name="Vahtkond.selectAll", query="SELECT e FROM Vahtkond e"),
    @NamedQuery(name="Vahtkond.selectActive", query="SELECT e FROM Vahtkond e WHERE e.sulgeja is null OR e.sulgeja = ''")
})

@Entity
public class Vahtkond extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String kommentaar;
	private String kood;
	private String nimetus;
	private String piiripunkt;
	private String vaeosa;
	@OneToMany(mappedBy="vahtkond", fetch=FetchType.EAGER)
    @IndexColumn(name="id")
	private List<Vahtkonnaliige> vahtkonnaliiges;

	public Vahtkond() {
	}

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
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

	public String getPiiripunkt() {
		return this.piiripunkt;
	}

	public void setPiiripunkt(String piiripunkt) {
		this.piiripunkt = piiripunkt;
	}

	public String getVaeosa() {
		return this.vaeosa;
	}

	public void setVaeosa(String vaeosa) {
		this.vaeosa = vaeosa;
	}

	public List<Vahtkonnaliige> getVahtkonnaliiges() {
		return this.vahtkonnaliiges;
	}

	public void setVahtkonnaliiges(List<Vahtkonnaliige> vahtkonnaliiges) {
		this.vahtkonnaliiges = vahtkonnaliiges;
	}

}