///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           M11.12 Zylabs FileHandler Program
// Course:          CS 200, Spring, 2023
//
// Author:          Max Liss-'s-Gravemade
// Email:           lisssgravema@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html;
//
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Opens a specified file, reads its content, and then prints out the contents of the file.
 */
public class FileHandler {
    /**
     * Takes user input for a file name, attempts to open the file, and then prints out its contents.
     * Displays an error message if the file is invalid.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean isFileOpened = false;
        String fileName;
        BufferedReader reader = null;

        while (!isFileOpened) {
            System.out.println("What is the name of the file you want to open?");
            fileName = scnr.nextLine();

            try {
                reader = openFile(fileName);
                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line); // Print each line of the file
                }
                isFileOpened = true;
            } catch (FileNotFoundException e) {
                System.out.println("That file name is invalid");
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file.");
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred while closing the file.");
                    }
                }
            }
        }
    }

    /**
     * Opens the file with the specified name and reads it. Throws an IOException if the file is not
     * found.
     *
     * @param fileName The name of the file to be opened for reading.
     * @return A BufferedReader object for reading the specified file.
     * @throws IOException If the file is not found or if an error occurs during file operations.
     */
    private static BufferedReader openFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        return reader;
    }
}
