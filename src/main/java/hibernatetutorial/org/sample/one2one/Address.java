package hibernatetutorial.org.sample.one2one;


import hibernatetutorial.org.sample.newFeatures.Person;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    private Long id;
    private String title;
    private String postalCode;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private Person person;

    public Address() {
    }

    public Address(String title, String postalCode) {
        this.title = title;
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
