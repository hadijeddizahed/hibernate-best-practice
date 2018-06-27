package hibernatetutorial.org.sample.one2many;

public interface CartDao {

    void save(Cart cart);
    Cart find(Long id);
}
