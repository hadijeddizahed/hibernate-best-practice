package hibernatetutorial.org.sample.newFeatureTest;


import hibernatetutorial.org.sample.SampleApplication;
import hibernatetutorial.org.sample.newFeatures.PersonDao;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

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


}
