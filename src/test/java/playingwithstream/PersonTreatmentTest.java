package playingwithstream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PersonTreatmentTest {

    @Test
    void sort() {
        Person p1 = new Person("A", "D");
        Person p2 = new Person("A", "C");
        Person p3 = new Person("X", "Y");

        var persons = Arrays.asList(p1, p2, p3);

        PersonTreatment treatment = new PersonTreatment(persons);
        List<Person> result = treatment.sort();

        Assertions.assertThat(result).containsExactly(p2, p1, p3);
    }
}