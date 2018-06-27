package hibernatetutorial.org.sample.one2many;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(Cart cart) {
        entityManager.persist(cart);
    }

    @Override
    public Cart find(Long id) {
        return entityManager.find(Cart.class, id);
    }
}
