package org.griddynamics.search_engine.searcher;

import org.griddynamics.search_engine.Person;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Child of Searcher to implement "All" query
 * process strategy.
 */
public final class SearcherAll extends Searcher {

    // Private SearcherAny instance
    private final SearcherAny searcherAny;

    /**
     * Default SearcherAll constructor
     * @param people Person array to search on
     */
    public SearcherAll(Person[] people) {
        // Calling null search map Searcher constructor
        super();

        // Initializing inner SearcherAny instance
        searcherAny = new SearcherAny(people);
    }

    /**
     * Implementation of searchByQuery of Searcher class
     * @param query | Query as String to process
     * @return Query "All" strategy result as Person[]
     */
    @Override
    public Person[] searchByQuery(String query) {
        // Splitting and lowering query
        String[] keywords = splitInLowKeywords(query);

        // Running Any search for each keyword
        LinkedList<Person[]> resultForEachKeyword = new LinkedList<>();
        for (String currentKeyword : keywords) {
            resultForEachKeyword.add(searcherAny.searchByQuery(currentKeyword));
        }

        // Check for size
        if (resultForEachKeyword.size() == 0) {
            return new Person[0];
        }

        // Searching intersection
        HashSet<Person> intersection = new HashSet<>(Arrays.asList(resultForEachKeyword.pollFirst()));
        for (Person[] currentResult : resultForEachKeyword) {
            intersection.retainAll(new HashSet<>(Arrays.asList(currentResult)));
        }

        // Returning
        Person[] result = new Person[intersection.size()];
        intersection.toArray(result);
        return result;
    }
}
