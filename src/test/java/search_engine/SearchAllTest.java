package search_engine;

import org.griddynamics.search_engine.Person;
import org.griddynamics.search_engine.searcher.Searcher;
import org.griddynamics.search_engine.searcher.SearcherAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * SearcherAll class tests
 */
public class SearchAllTest {

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
        searcher = new SearcherAll(people);
    }

    @Test
    void harringtonErickAllTest() {
        // Searching
        Person[] result = searcher.searchByQuery("Harrington Erick");

        // Asserting
        assertEquals(1, result.length);
        assertEquals(Person.parsePerson("Erick Harrington harrington@gmail.com"),
                     result[0]);
    }

    @Test
    void erickAllTest() {
        // Searching by keyword
        Person[] result = searcher.searchByQuery("Erick");

        // Asserting
        assertEquals(2, result.length);
        assertEquals((new Person("Erick", "Harrington", "harrington@gmail.com")), result[0]);
        assertEquals((new Person("Erick", "Burgess", "")), result[1]);
    }

    @Test
    void noMatchAllTest() {
        // Searching by keyword
        Person[] result = searcher.searchByQuery("there is no me in there");

        // Asserting
        assertEquals(0, result.length);
    }
}
