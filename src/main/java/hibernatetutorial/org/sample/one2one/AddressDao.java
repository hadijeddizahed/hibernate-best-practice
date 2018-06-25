package hibernatetutorial.org.sample.one2one;


public interface AddressDao {

    void save(Address address);

    Address find(Long id);
}
