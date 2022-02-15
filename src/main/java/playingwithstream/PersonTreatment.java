package playingwithstream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

    public Map<String, Long> countOccurences(){
        var intermediateMap =  persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getFirstName,
                        Collectors.counting()
                ));
        return intermediateMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new
                ));
    }
}
