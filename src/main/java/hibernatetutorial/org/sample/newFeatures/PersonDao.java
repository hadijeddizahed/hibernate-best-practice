package hibernatetutorial.org.sample.newFeatures;


import java.util.List;
import java.util.stream.Stream;

public interface PersonDao {

    void save(Person person);

    Stream<Person> getAll();

    List<Person> getMultipleById(List<Long> ids);

    List<Person> findByName(String name);
}
