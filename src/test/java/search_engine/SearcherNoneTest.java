package search_engine;

import org.griddynamics.search_engine.Person;
import org.griddynamics.search_engine.searcher.Searcher;
import org.griddynamics.search_engine.searcher.SearcherNone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * SearcherNone class tests
 */
public class SearcherNoneTest {

    // Searcher reference
    private Searcher searcher;

    /**
     * Initializes searcher
     */
    @BeforeEach
    private void initializePeople() {
        // Initializing array
        Person[] people = new Person[6];

        // Initializing instances
        people[0] = new Person("Dwight", "Joseph", "djo@gmail.com");
        people[1] = new Person("Rene", "Webb", "webb@gmail.com");
        people[2] = new Person("Katie", "Jacobs", "");
        people[3] = new Person("Erick", "Harrington", "harrington@gmail.com");
        people[4] = new Person("Myrtle", "Medina", "");
        people[5] = new Person("Erick", "Burgess", "");

        // Creating map based on people
        searcher = new SearcherNone(people);
    }

    @Test
    void djoErickNoneTest() {
        // Searching
        Person[] result = searcher.searchByQuery("djo@gmail.com ERICK");

        // Asserting
        assertEquals(3, result.length);
        assertEquals(Person.parsePerson("Rene Webb webb@gmail.com"), result[0]);
        assertEquals(Person.parsePerson("Katie Jacobs"), result[1]);
        assertEquals(Person.parsePerson("Myrtle Medina"), result[2]);
    }
}
