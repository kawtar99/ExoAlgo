package playingwithstream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonTreatment {

    private List<Person> persons;

    public PersonTreatment(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> sort(){
        return persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName))
                .collect(Collectors.toList());
    }
}
