package search_engine;

import org.griddynamics.search_engine.Person;
import org.griddynamics.search_engine.searcher.Searcher;
import org.griddynamics.search_engine.searcher.SearcherAny;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * SearcherAny class tests
 */
public class SearcherAnyTest {

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
        searcher = new SearcherAny(people);
    }

    @Test
    void erickAnyTest() {
        // Searching by keyword
        Person[] result = searcher.searchByQuery("Erick");

        // Asserting
        assertEquals(2, result.length);
        assertEquals((new Person("Erick", "Harrington", "harrington@gmail.com")), result[0]);
        assertEquals((new Person("Erick", "Burgess", "")), result[1]);
    }

    @Test
    void noMatchAnyTest() {
        // Searching by keyword
        Person[] result = searcher.searchByQuery("there is no me in there");

        // Asserting
        assertEquals(0, result.length);
    }

    @Test
    void webbAnyTest() {
        // Searching by keyword
        Person[] result = searcher.searchByQuery("webb@gmail.com");

        // Asserting
        assertEquals(1, result.length);
        assertEquals((new Person("Rene", "Webb", "webb@gmail.com")), result[0]);
    }
}
