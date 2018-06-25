package hibernatetutorial.org.sample.one2one;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AddressDaoImpl implements AddressDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Address address) {
        entityManager.merge(address);
    }

    @Override
    public Address find(Long id) {
        return null;
    }
}
