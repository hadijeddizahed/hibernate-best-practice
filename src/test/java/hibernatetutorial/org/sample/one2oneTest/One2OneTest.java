package hibernatetutorial.org.sample.one2oneTest;


import hibernatetutorial.org.sample.SampleApplication;
import hibernatetutorial.org.sample.newFeatures.Person;
import hibernatetutorial.org.sample.newFeatures.PersonDao;
import hibernatetutorial.org.sample.one2one.Address;
import hibernatetutorial.org.sample.one2one.AddressDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class One2OneTest {

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private PersonDao personDao;


    @Test
    public void save_address_test() {
        Person person = personDao.findBy(1l);
        Address address = new Address("Tehran", "2545888555");
        address.setPerson(person);

        addressDao.save(address);

    }

    private void test(List<String> list){
        System.out.println("size:   >>>>>"+ list.size());
    }
}
