package search_engine;

import org.griddynamics.search_engine.Person;

import org.griddynamics.search_engine.searcher.Searcher;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for map creation
 */
public class SearchMapTest {

    //@Test
    //void createStringToPersonArrayMapTest() {
    //    // Creating people
    //    Person[] people = new Person[4];
    //    people[0] = Person.parsePerson("Katie Jacobs");
    //    people[1] = Person.parsePerson("Erick Harrington harrington@gmail.com");
    //    people[2] = Person.parsePerson("Myrtle Medina");
    //    people[3] = Person.parsePerson("Erick Burgess");

    //    // Creating map
    //    Map<String, Person[]> map = Searcher.createStringToPersonArrayMap(people);

    //    // Expected result
    //    Map<String, Person[]> expected = new HashMap<>();
    //    expected.put("katie", new Person[] { people[0] });
    //    expected.put("jacobs", new Person[] { people[0] });
    //    expected.put("erick", new Person[] { people[1], people[3] });
    //    expected.put("harrington", new Person[] { people[1] });
    //    expected.put("harrington@gmail.com", new Person[] { people[1] });
    //    expected.put("myrtle", new Person[] { people[2] });
    //    expected.put("medina", new Person[] { people[2] });
    //    expected.put("burgess", new Person[] { people[3] });

    //    // Asserting key sets
    //    var actualKeySet = map.keySet();
    //    var expectedKeySet = expected.keySet();
    //    assertEquals(expectedKeySet, actualKeySet);

    //    // Asserting value sets
    //    for (var currentKey : actualKeySet) {
    //        assertTrue(Arrays.equals(expected.get(currentKey), map.get(currentKey)));
    //    }
    //}
}
