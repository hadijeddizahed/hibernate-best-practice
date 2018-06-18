package hibernatetutorial.org.sample.newFeatures;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persons")

@NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "born_date")
    private LocalDate bornDate;

    public Person() {
    }

    public Person(String name, Integer age, LocalDate bornDate) {
        this.name = name;
        this.age = age;
        this.bornDate = bornDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }
}
