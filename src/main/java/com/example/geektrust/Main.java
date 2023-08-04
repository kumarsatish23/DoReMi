package com.example.geektrust;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.example.geektrust.service.Service;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the input file path as a command-line argument.");
            return;
        }

        try {
            List<String> inputs = readInputsFromFile(args[0]);
            if (inputs != null) {
                Service sub = new Service();
                sub.DoReMi(inputs);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the input file: " + e.getMessage());
        }
    }

    private static List<String> readInputsFromFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}
