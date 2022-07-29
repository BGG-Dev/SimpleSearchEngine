package org.griddynamics.search_engine.searcher;

import org.griddynamics.search_engine.Person;

import java.util.*;

/**
 * Abstract class to inherit searchers from
 */
public abstract class Searcher {

    // Private String -> List<Person> map to use in search
    private final Map<String, List<Person>> searchMap;

    /**
     * Searcher constructor with null search map
     * in case if child does not need its own search map.
     */
    Searcher() {
        // Initializing search map with null
        searchMap = null;
    }

    /**
     * Searcher constructor with search map initialization
     * @param people | Array of Person to search in
     */
    Searcher(Person[] people) {
        // Initializing search map
        searchMap = createSearchMap(people);
    }

    /**
     * Creates search map for given people
     * @param people Array of Person to create map for
     * @return Map String -> List<Person> to use for search
     */
    private Map<String, List<Person>> createSearchMap(Person[] people) {
        // Creating temporary map
        Map<String, List<Person>> tempMap = new HashMap<>();

        // Filling temp
        String[] currentPersonsInfo;
        List<Person> tempList;
        for (Person currentPerson : people) {
            // Taking current person's info
            currentPersonsInfo = Arrays.stream(currentPerson.getInfo())
                                       .map(String::toLowerCase)
                                       .toArray(String[]::new);

            // Iterating on info
            for (String currentInfoPart : currentPersonsInfo) {
                // Filling with current info
                if (!"".equals(currentInfoPart)) {
                    if (tempMap.containsKey(currentInfoPart)) {
                        tempMap.get(currentInfoPart).add(currentPerson);
                    } else {
                        tempList = new LinkedList<>();
                        tempList.add(currentPerson);
                        tempMap.put(currentInfoPart, tempList);
                    }
                }
            }
        }

        // Creating result
        Map<String, List<Person>> result = new HashMap<>();
        for (var current : tempMap.entrySet()) {
            result.put(current.getKey(), Collections.unmodifiableList(current.getValue()));
        }

        // Returning
        return result;
    }

    /**
     * search map getter
     * @return Map String -> List<Person> to use in search algorithms
     */
    Map<String, List<Person>> getSearchMap() {
        return this.searchMap;
    }

    /**
     * Splits given query in keywords
     * @param query | query to split as a String
     * @return low keywords as String array
     */
    String[] splitInLowKeywords(String query) {
        return query.toLowerCase().split(" ");
    }

    /**
     * Abstract method, searches people by given query.
     * Will be overridden in children.
     * @param query | Query as String to process
     * @return Query result as array of Person
     */
    public abstract Person[] searchByQuery(String query);
}
