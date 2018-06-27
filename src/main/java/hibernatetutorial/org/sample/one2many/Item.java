package hibernatetutorial.org.sample.one2many;

import javax.persistence.*;

@Entity
@Table
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private int count;
    private Double cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Item() {
    }

    public Item(String title, int count, Double cost) {
        this.title = title;
        this.count = count;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
