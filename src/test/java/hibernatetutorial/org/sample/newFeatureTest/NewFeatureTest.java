package hibernatetutorial.org.sample.newFeatureTest;


import hibernatetutorial.org.sample.SampleApplication;
import hibernatetutorial.org.sample.newFeatures.Person;
import hibernatetutorial.org.sample.newFeatures.PersonDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class NewFeatureTest {


    @Resource
    private PersonDao personDao;

    @org.springframework.context.annotation.Configuration
    public static class ContextConfiguration {
    }


    @Test
    public void save_test() {
        Person person = new Person("Hadi", 32, LocalDate.of(1986, 10, 21));
        personDao.save(person);
    }

    @Test
    public void findMultipleById_test() {
        List<Person> personList = personDao.getMultipleById(Arrays.asList(1l, 2l, 3l));
        assertEquals(personList.size(), 3);
    }

}
