/*
 * GEE
 * This is free and unencumbered software released into the public domain.
 */
package gee_lab1;

import java.util.Random;
import java.util.Scanner;

/**
 *This Java program demonstrates how to create and manipulate a two-dimensional
 * array. The program creates a square 2D array from user input, populates it
 * with random integers, then prints the sums of rows, columns, and diagonals.
 *
 * @author Gee
 * @version 1.0
 */
public class TwoDimArray {

    /**
     * This is the entry of the program
     * It prompts the user to enter the size of a 2D array, generates and
     * fills the array using a random number. Then prints the array with sums of
     * the rows, the columns and the major and minor diagonals.
     * @param args A string array containing the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        //Repeats the block until the user chooses to exit
        do {
            //Gets the size of the 2D array from the user
            int size = getArraySize(keyboard);

            //Creates and fills the 2D array of the specified size with random
            //integers
            int[][] numbers = createAndFillArray(size);

            //Print the array and the sums of the rows, columns and diagonals
            printArrayWithSums(numbers);

            //Ask the user if they want to repeat the process
            System.out.println("Go Again? (y/n) ");
        } while (keyboard.next().equalsIgnoreCase("Y"));

        //Display the message after user exits
        System.out.println("Thanks for playing TwoDimArray!");
    }

    /**
     * This method prompts user to enter the size of the 2D array.
     * A limit between 1 and 10 is used to ensure a valid size.
     * @param keyboard The scanner object for the user input
     * @return The size of the 2D array specified by user
     */
    private static int getArraySize(Scanner keyboard) {
        System.out.print("How many rows (something between 1 and 10)? ");
        int size = keyboard.nextInt();

        // Validate the input size to be between 1 and 10
        while (size <= 0 || size > 10) {
            System.out.print("How many rows (something between 1 and 10)? ");
            size = keyboard.nextInt();
        }

        return size;
    }

    /**
     *This method creates and fills a 2D array of the specified size with
     * random integers.
     *
     * @param size The size of the 2D array
     * @return The created and filled 2D array
     */
    private static int [][] createAndFillArray(int size){
        int [][] numbers = new int [size][size];
        Random random = new Random();

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                numbers[i][j] = random.nextInt(100);
            }
        }

        return numbers;
    }

    /**
     * This method prints the 2D array along with the sums of each row, column,
     * and diagonals.
     *
     * @param number The 2D array to be printed
     */
    private static void printArrayWithSums(int [][] number) {
        int size = number.length;

        // Print the array contents and row sums
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size; j++) {
                System.out.printf("%3d", number[i][j]);
            }

            // Calculate and print the sum of the current row
            int rowSum = calculateRowSum(number, i);
            System.out.printf("| Row Sum = %3d\n", rowSum);
        }

        // Print a horizontal line to separate rows from column sums
        printHorizontalLine(size);

        // Print column sums
        for (int j = 0; j < size; j++) {
            int columnSum = calculateColumnSum(number, j);
            System.out.printf("| Column Sum = %3d\n ", columnSum);
        }

        // Print a label for the column sums
        System.out.println("| Column Sums = ");

        // Print the sums of the major and minor diagonals
        printDiagonalSums(number);
    }


    /**
     * The method calculayes the sum of a specific row in the 2D array
     *
     * @param numbers The 2D array
     * @param row The index of the row which sum is calculated
     * @return The sum of the specified row
     */
    private static int calculateRowSum(int[][] numbers, int row) {
        int sum = 0;

        // Calculate the sum of the elements in the specified row
        for (int j = 0; j < numbers.length; j++){
            sum += numbers[row][j];
        }

        return sum;
    }

    /**
     * This method prints a horizontal line to separate rows from column sums
     *
     * @param size The size of the 2D array
     */
    private static void printHorizontalLine(int size ) {
        for (int i = 0; i < size; i++) {
            System.out.println(" - " );
        }
        System.out.println();
    }


    /**
     * This method calculates the sum of the specified column in the 2D array.
     *
     * @param numbers The 2D array
     * @param column The index of the column which the sum is to be calculated
     * @return The sum of the specified column
     */
    private static int calculateColumnSum(int[][] numbers, int column) {
        int sum = 0;

        // Calculate the sum of the elements in the specified column
        for (int i = 0; i < numbers.length; i++){
            sum += numbers[i][column];
        }
        return sum;
    }


    /**
     * This method prints the sum of the major and minor diagonals in the 2D
     * array
     * @param numbers The 2D array
     */
    private static void printDiagonalSums(int[][]  numbers ) {
       int size = numbers.length;

        int majorDiagonalSum = 0;
        int minorDiagonalSum = 0;

        // Calculate the sums of the major and minor diagonals
        for (int i = 0; i < size; i++) {
            majorDiagonalSum += numbers[i][i];              //major diagonals
            minorDiagonalSum += numbers[i][size - 1 - i];   //minor diagonals
        }

        // Print the sums of the major and minor diagonals
        System.out.printf("Major Diagonal Sum: %3d\n", majorDiagonalSum);
        System.out.printf("Minor Diagonal Sum: %3d\n", minorDiagonalSum);
    }


}
