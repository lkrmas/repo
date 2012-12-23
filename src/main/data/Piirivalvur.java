package main.data;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;

import java.util.List;

@NamedQueries({
    @NamedQuery(name="Piirivalvur.selectAll", query="SELECT e FROM Piirivalvur e"),
    @NamedQuery(name="Piirivalvur.selectActive", query="SELECT e FROM Piirivalvur e WHERE e.sulgeja is null OR e.sulgeja = ''")
})

@Entity
public class Piirivalvur extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String aadress;
	private String eesnimi;
	private String email;
	private String isikukood;
	private String kommentaar;
	private String perekonnanimi;
	private String sodurikood;
	private int sugu;
	private String telefon;
	@OneToMany(mappedBy="piirivalvur", fetch=FetchType.EAGER)
    @IndexColumn(name="id")
	private List<Piirivalvurauaste> piirivalvurauastes;
	@OneToMany(mappedBy="piirivalvur", fetch=FetchType.EAGER)
    @IndexColumn(name="id")
	private List<Vahtkonnaliige> vahtkonnaliiges;

	public Piirivalvur() {
	}

	public String getAadress() {
		return this.aadress;
	}

	public void setAadress(String aadress) {
		this.aadress = aadress;
	}

	public String getEesnimi() {
		return this.eesnimi;
	}

	public void setEesnimi(String eesnimi) {
		this.eesnimi = eesnimi;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsikukood() {
		return this.isikukood;
	}

	public void setIsikukood(String isikukood) {
		this.isikukood = isikukood;
	}

	public String getKommentaar() {
		return this.kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public String getPerekonnanimi() {
		return this.perekonnanimi;
	}

	public void setPerekonnanimi(String perekonnanimi) {
		this.perekonnanimi = perekonnanimi;
	}

	public String getSodurikood() {
		return this.sodurikood;
	}

	public void setSodurikood(String sodurikood) {
		this.sodurikood = sodurikood;
	}

	public int getSugu() {
		return this.sugu;
	}

	public void setSugu(int sugu) {
		this.sugu = sugu;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<Piirivalvurauaste> getPiirivalvurauastes() {
		return this.piirivalvurauastes;
	}

	public void setPiirivalvurauastes(List<Piirivalvurauaste> piirivalvurauastes) {
		this.piirivalvurauastes = piirivalvurauastes;
	}

	public List<Vahtkonnaliige> getVahtkonnaliiges() {
		return this.vahtkonnaliiges;
	}

	public void setVahtkonnaliiges(List<Vahtkonnaliige> vahtkonnaliiges) {
		this.vahtkonnaliiges = vahtkonnaliiges;
	}

}