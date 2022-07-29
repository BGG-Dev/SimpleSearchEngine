package org.griddynamics;

import org.griddynamics.search_engine.SearcherTUI;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Checking if correct number of arguments
        if (args.length != 2) {
            System.out.println("Wrong count of arguments!");
            System.exit(1);
        }

        // Checking if correct argument
        if (!args[0].equals("--data")) {
            System.out.println("Wrong argument! You should enter --data");
            System.exit(1);
        }

        // Opening file
        File data = new File(args[1]);

        // Calling menu
        SearcherTUI.menu(data);
    }
}