package main.data;

import java.io.Serializable;
import javax.persistence.*;

@NamedQueries({
    @NamedQuery(name="Guard.selectAll", query="SELECT g FROM Guard g")
})

@Entity
public class Guard implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	private int age;

    public Guard() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
