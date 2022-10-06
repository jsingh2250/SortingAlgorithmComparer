import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import sort.Sort;

/** This class compares sorting algorithms.
 * 
 * @author Jaskaran Singh
 */
public class SortingAlgorithmComparer {
    // Store the text input cursor that will be used in this program.
    private static final String TEXT_INPUT_CURSOR = ">";

    /**
     * Print the text with a new line before and after the text.
     * @param text The text to print.
     */
    private static void printLnTextLn(String text) {
        System.out.println();
        System.out.println(text);
    }

    /**
     * Print a formatted version of the text input cursor to show the user where to type their input.
     * @param textInputCursor The text input cursor to print.
     */
    private static void printTextInputCursor(String textInputCursor) {
        System.out.println();
        System.out.print(textInputCursor + " ");
    }

    /**
    * Print information about the specified exception and exit out of the program.
    * 
    * @param exception The exception to print information about.
    */
    public static void printExceptionInformationAndExit(Exception exception) {
        // Print information about the exception.
        System.out.println();
        exception.printStackTrace();
        System.out.println();

        // Exit out of the program.
        System.exit(0);
    }

    /**
     * Print a message to the user to let them know that their input was invalid.
     * 
     */
    private static void printInvalidInputMessage() {
        printLnTextLn("Your input was invalid. Please try again.");
    }

    /**
     * Print a message to the user to ask them to specify an array length. Read and return the user-specified array length.
     * 
     * @param scanner The scanner object used to get user-input.
     * @return The user-specified array length.
     */
    public static int getArrayLengthFromUser(Scanner scanner) {
        // Declare a variable that will store the user-specified array length.
        // Initialize the variable to zero to indicate that the user hasn't specified a valid array length yet.
        int arrayLength = 0;

        // Try to get the user-specified array length until they specify a positive integer for the array length.
        while (arrayLength <= 0) {
            try {
                // Print a message to the user to ask them to specify an array length.
                printLnTextLn("Please enter an array length. The array length should be a positive integer.");
                printTextInputCursor(TEXT_INPUT_CURSOR);

                // Store the user-specified array length.
                arrayLength = Integer.parseInt(scanner.next());

                // If the user didn't enter a positive integer, throw an exception.
                if (arrayLength <= 0) {
                    throw new Exception();
                }

            } catch (Exception exception) {
                // Print a message to the user to let them know that their input was invalid.
                printInvalidInputMessage();
            }
        }

        // Return the user-specified array length.
        return arrayLength;
    }

    /**
     * Create an int array of the specified length and fill it with random integers between 0 (inclusive) and 100 (exclusive). Return the array.
     * 
     * @param arrayLength The array length of the array that is created and filled with random integers.
     * @return The array that is created and filled with random integers.
     */
    public static int[] createArrayOfRandomIntegers(int arrayLength) {
        // Create the array.
        int[] array = new int[arrayLength];

        // Create a random object.
        Random random = new Random();

        // Fill the array with random integers.
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        // Return the array.
        return array;
    }

    /**
     * Print the elements in the specified array with spaces between the elements.
     * 
     * @param array The array that contains the elements to print.
     */
    public static void printArray(int[] array) {
        System.out.println();
        for (int element : array) {
            System.out.print(element + " ");
        }
    }

    /**
    * Determine whether the specified array is sorted in ascending order. Return true if the array is sorted in ascending order. Return false otherwise.
    * 
    * @param array The array that needs to be checked to determine whether it is sorted.
    * @return Return true if the array is sorted in ascending order. Return false otherwise.
    */
    public static boolean isArraySorted(int[] array) {
        // Return false if an element with a lower index is greater than an element with a higher index.
        for (int i = 0; i < (array.length - 1); i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        // The array is sorted in ascending order. Return true.
        return true;
    }

    /**
    * Determine whether an array is sorted and print a message to the user to state the result.
    * 
    * @param array The array that needs to be checked to determine whether it is sorted.
    */
    public static void printIsArraySorted(int[] array) {
        System.out.println("The array is sorted: " + isArraySorted(array));
    }

    /**
    * Calculate how many seconds have passed between the specified start and end times. The specified start and end times should be in milliseconds. Return the amount of seconds that have passed between the specified start and end times.
    * 
    * @param startTimeInMilliseconds The start time in milliseconds.
    * @param endTimeInMilliseconds The end time in milliseconds.
    * @return The amount of seconds that have passed between the specified start and end times.
    */
    public static double calculateTimePassedInSeconds(long startTimeInMilliseconds, long endTimeInMilliseconds) {
        return ((endTimeInMilliseconds - startTimeInMilliseconds) / 1000.0);
    }

    /**
     * Main method of this class.
     * 
     * @param args Unused input argument.
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Store the name of this program as a string.
        final String PROGRAM_NAME = "Sorting Algorithm Comparer";

        // Store the valid commands the user can input as strings.
        final String RESTART_COMMAND = "restart";

        // Print a welcome message.
        System.out.println();
        System.out.println("Welcome to the " + PROGRAM_NAME + " program!\n" +
                "This program compares sorting algorithms.");

        // Create a scanner object to read user input.
        Scanner scanner = new Scanner(System.in);

        // Declare a variable to store user input.
        String userInput;

        do {
            // Get an array length from the user.
            int arrayLength = getArrayLengthFromUser(scanner);

            // Declare variables to store the start and end times of tasks.
            long startTimeInMilliseconds;
            long endTimeInMilliseconds;

            // Store the current time in milliseconds.
            startTimeInMilliseconds = System.currentTimeMillis();
            // Create an array with the user-specified array length and fill it with random integers.
            int[] array = createArrayOfRandomIntegers(arrayLength);
            // Store the current time in milliseconds.
            endTimeInMilliseconds = System.currentTimeMillis();
            // Calculate how much time has passed in seconds.
            double timePassedInSecondsDuringArrayCreation = calculateTimePassedInSeconds(startTimeInMilliseconds,
                    endTimeInMilliseconds);
            // Tell the user that the array has been created and filled with random integers. Also tell the user how long it took to do that.
            System.out.println();
            System.out.printf("Created an array of array length %d and filled it with random integers in %f seconds.",
                    array.length, timePassedInSecondsDuringArrayCreation);
            System.out.println();
            // Check whether the array is sorted and print a message to indicate whether the array is sorted.
            printIsArraySorted(array);

            // Store the current time in milliseconds.
            startTimeInMilliseconds = System.currentTimeMillis();
            // Create a copy of the unsorted array and sort it. Store the sorted array.
            int[] arraySortedWithMergeSort = Sort.mergeSort(array);
            // Store the current time in milliseconds.
            endTimeInMilliseconds = System.currentTimeMillis();
            // Calculate how much time has passed in seconds.
            double timePassedInSecondsDuringMergeSort = calculateTimePassedInSeconds(startTimeInMilliseconds,
                    endTimeInMilliseconds);
            // Tell the user that a copy of the array was sorted. Also tell the user how long it took to do that.
            System.out.println();
            System.out.printf("Used merge sort to sort a copy of the array in %f seconds.",
                    timePassedInSecondsDuringMergeSort);
            System.out.println();
            // Check whether the array is sorted and print a message to indicate whether the array is sorted.
            printIsArraySorted(arraySortedWithMergeSort);

            // Create a copy of the unsorted array to sort in-place with bubble sort.
            int[] arraySortedWithBubbleSort = Arrays.copyOf(array, array.length);
            // Store the current time in milliseconds.
            startTimeInMilliseconds = System.currentTimeMillis();
            // Sort the copied array.
            Sort.bubbleSort(arraySortedWithBubbleSort);
            // Store the current time in milliseconds.
            endTimeInMilliseconds = System.currentTimeMillis();
            // Calculate how much time has passed in seconds.
            double timePassedInSecondsDuringBubbleSort = calculateTimePassedInSeconds(startTimeInMilliseconds,
                    endTimeInMilliseconds);
            // Tell the user that a copy of the array was sorted. Also tell the user how long it took to do that.
            System.out.println();
            System.out.printf("Used bubble sort to sort a copy of the array in %f seconds.",
                    timePassedInSecondsDuringBubbleSort);
            System.out.println();
            // Check whether the array is sorted and print a message to indicate whether the array is sorted.
            printIsArraySorted(arraySortedWithBubbleSort);

            // Ask the user if they want to use the program again.
            printLnTextLn("Would you like to use the program again?\n" + "Enter \"" + RESTART_COMMAND
                    + "\" to use the program again. Enter anything else to quit.");
            printTextInputCursor(TEXT_INPUT_CURSOR);
            userInput = scanner.next();
        } while (userInput.equals(RESTART_COMMAND));

        // Close the scanner.
        scanner.close();

        // Print a farewell message.
        System.out.println();
        System.out.println("Thank you for using the " + PROGRAM_NAME + " program!\n" + "Goodbye.");
    }
}
