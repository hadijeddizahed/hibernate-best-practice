package hibernatetutorial.org.sample.one2many;


import hibernatetutorial.org.sample.SampleApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class OneToManyTest {

    @Autowired
    private CartDao cartDao;

    @Test
    public void save_cart_test(){
        List<Item> items = new ArrayList<>();

        Cart cart = new Cart("Cart4");
        Item item = new Item("item4",1,100d);
        items.add(item);
        item.setCart(cart);
        cart.setItems(items);
        cartDao.save(cart);


    }
}
