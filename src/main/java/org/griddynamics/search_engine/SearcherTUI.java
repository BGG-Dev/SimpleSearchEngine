package org.griddynamics.search_engine;

import org.griddynamics.search_engine.searcher.Searcher;
import org.griddynamics.search_engine.searcher.SearcherAll;
import org.griddynamics.search_engine.searcher.SearcherAny;
import org.griddynamics.search_engine.searcher.SearcherNone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SearcherTUI {

    // Private static stdin scanner
    private static final Scanner scanIn = new Scanner(System.in);

    /**
     * Program menu
     */
    public static void menu(File data) {
        // Getting people
        Person[] people = readPeopleFromFile(data);

        // Menu cycle
        String userDecision;
        while(true) {
            // Printing
            System.out.println("\n=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");

            // Getting user decision
            userDecision = scanIn.nextLine();

            // Switching
            Searcher searcher;
            switch (userDecision) {
                case "1":
                    searcher = createSearcherBasedOnUserCommand(people);
                    searchByQuery(searcher);
                    break;
                case "2":
                    printPeople(people);
                    break;
                case "0":
                    System.out.println("\nBye!");
                    System.exit(0);
                default:
                    System.out.println("\nIncorrect option! Try again.");
            }
        }
    }

    /**
     * Reads people from given file
     * @param data | File instance to read from
     * @return Array of search.Person, loaded from file
     */
    private static Person[] readPeopleFromFile(File data) {
        // Linked list to store people
        List<Person> people = new LinkedList<>();

        // Scanner to read from file
        Scanner dataScan;
        try {
            dataScan = new Scanner(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Reading
        while(dataScan.hasNextLine()) {
            // Adding to list
            people.add(Person.parsePerson(dataScan.nextLine()));
        }

        // Returning
        return people.toArray(Person[]::new);
    }

    private static Searcher createSearcherBasedOnUserCommand(Person[] people) {
        while (true) {
            // Requesting command
            System.out.println("\nSelect a matching strategy: ALL, ANY, NONE");

            // Getting input
            String command = scanIn.nextLine();

            // Switching
            switch (command) {
                case "ALL":
                    return new SearcherAll(people);
                case "ANY":
                    return new SearcherAny(people);
                case "NONE":
                    return new SearcherNone(people);
                default:
                    System.out.println("\nIncorrect option! Try again.");
            }
        }
    }

    /**
     * TUI for searchByQuery method
     */
    private static void searchByQuery(Searcher searcher) {
        // Asking to enter a query
        System.out.println("\nEnter a name or email to search all suitable people.");

        // Reading query
        String query = scanIn.nextLine();

        // Processing query
        Person[] result = searcher.searchByQuery(query);

        // Printing result
        if (result == null) {
            System.out.println("No matching people found.");
        } else {
            System.out.printf("%d persons found:\n", result.length);
            for (Person current : result) {
                System.out.println(current);
            }
        }
    }

    /**
     * Prints persons in array
     * @param people | Array of search.Person to print
     */
    private static void printPeople(Person[] people) {
        System.out.println("\n=== List of people ===");
        for (Person current : people) {
            System.out.println(current.toString());
        }
    }
}
