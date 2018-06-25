package hibernatetutorial.org.sample.newFeatures;


import java.util.List;
import java.util.stream.Stream;

public interface PersonDao {

    void save(Person person);

    Person findBy(Long id);

    Stream<Person> getAll();

    List<Person> getMultipleById(List<Long> ids);

    List<Person> findByName(String name);
}
