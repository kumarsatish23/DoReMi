package com.example.geektrust;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.example.geektrust.service.SubscriptionProcessor;

/**
 * The main class to read input from a file and process subscriptions.
 */
public class Main {

    /**
     * The main entry point of the application.
     *
     * @param args The command-line arguments. Expects a single argument: the input file path.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the input file path as a command-line argument.");
            return;
        }

        try {
            List<String> inputs = readInputsFromFile(args[0]);
            SubscriptionProcessor subscriptionProcessor = new SubscriptionProcessor();
            subscriptionProcessor.processSubscriptions(inputs);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the input file: " + e.getMessage());
        }
    }

    /**
     * Reads the inputs from the specified file.
     *
     * @param filePath The path to the input file.
     * @return A list of input lines read from the file.
     * @throws IOException If an error occurs while reading the file.
     */
    private static List<String> readInputsFromFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}
