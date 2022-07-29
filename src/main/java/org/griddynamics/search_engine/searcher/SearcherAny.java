package org.griddynamics.search_engine.searcher;

import org.griddynamics.search_engine.Person;

import java.util.LinkedList;
import java.util.List;

/**
 * Child of Searcher to implement "Any" query
 * process strategy.
 */
public final class SearcherAny extends Searcher {

    /**
     * Default SearcherAny constructor
     * @param people Person array to search on
     */
    public SearcherAny(Person[] people) {
        super(people);
    }

    /**
     * Implementation of searchByQuery of Searcher class
     * @param query | Query as String to process
     * @return Query "Any" strategy result as Person[]
     */
    @Override
    public Person[] searchByQuery(String query) {
        // Splitting and lowering query
        String[] keywords = splitInLowKeywords(query);

        // Searching
        List<Person> result = new LinkedList<>();
        List<Person> temp;
        for (String currentKeyword : keywords) {
            temp = getSearchMap().get(currentKeyword);
            if (temp != null) {
                result.addAll(temp);
            }
        }

        // Returning
        return result.toArray(Person[]::new);
    }
}
