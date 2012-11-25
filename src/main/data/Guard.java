package main.data;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

@NamedQueries({
    @NamedQuery(name="Guard.selectAll", query="SELECT g FROM Guard g")
})

@Entity
public class Guard implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@Size(min=2, max=50)
    private String name;
	
	@Min(15)
	@Max(110)
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
