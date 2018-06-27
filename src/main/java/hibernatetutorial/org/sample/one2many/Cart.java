package hibernatetutorial.org.sample.one2many;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "cart")
    private List<Item> items;

    public Cart() {
    }

    public Cart(String title) {
        this.title = title;
    }

    public Cart(String title, List<Item> items) {
        this.title = title;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
