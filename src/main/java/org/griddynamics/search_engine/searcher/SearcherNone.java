package org.griddynamics.search_engine.searcher;

import org.griddynamics.search_engine.Person;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Child of Searcher to implement "None" query
 * process strategy.
 */
public final class SearcherNone extends Searcher {

    // Private set of people
    private final Set<Person> personSet;

    // Private SearcherAny instance
    private final SearcherAny searcherAny;

    /**
     * Default SearcherNone constructor
     * @param people Person array to search on
     */
    public SearcherNone(Person[] people) {
        // Calling null search map Searcher constructor
        super();

        // Initializing set of people
        personSet = new LinkedHashSet<>(Arrays.asList(people));

        // Initializing inner SearcherAny instance
        searcherAny = new SearcherAny(people);
    }

    /**
     * Implementation of searchByQuery of Searcher class
     * @param query | Query as String to process
     * @return Query "None" strategy result as Person[]
     */
    @Override
    public Person[] searchByQuery(String query) {
        // Searching by "Any" strategy
        Set<Person> any = new LinkedHashSet<>(Arrays.asList(searcherAny.searchByQuery(query)));

        // None = ! Any = 1 - Any
        Set<Person> difference = new LinkedHashSet<>(personSet);
        difference.removeAll(any);

        // Returning
        Person[] result = new Person[difference.size()];
        difference.toArray(result);
        return result;
    }
}
