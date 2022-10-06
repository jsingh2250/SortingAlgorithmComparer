package sort;

import java.util.Arrays;

/**
 * This class contains sorting methods.
 * 
 * @author Jaskaran Singh
 */
public class Sort {
    /**
     * Sort the inputted array in-place with bubble sort. The array is sorted in ascending order.
     * 
     * @param arrayToSort The array to sort.
     */
    public static void bubbleSort(int[] arrayToSort) {
        for (int i = (arrayToSort.length - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                // If the element in the array with the larger index is smaller than the element in the array with the larger index, swap the elements.
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    int valueToSwap = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = valueToSwap;
                }
            }
        }
    }

    /**
     * Sort a copy of the inputted array with merge sort. The returned array is sorted in ascending order.
     * 
     * @param arrayToSort The array to sort.
     */
    public static int[] mergeSort(int[] arrayToSort) {
        // If the array has one element in it, it does not need to be sorted because it is already sorted. Return the single element array.
        if (arrayToSort.length <= 1) {
            // Return the single element array.
            return arrayToSort;
        } else {
            // Store copies of halves of the inputted array in separate arrays.
            int arraySplitIndex = arrayToSort.length / 2;
            int[] firstHalfOfArrayToSort = Arrays.copyOfRange(arrayToSort, 0, arraySplitIndex);
            int[] secondHalfOfArrayToSort = Arrays.copyOfRange(arrayToSort, arraySplitIndex, arrayToSort.length);

            // Recursively store copies of the halves of the inputted array in separate arrays. When an array half returns from the recursive call, it is in a sorted order. Merge that sorted array half with the other sorted array half when the second array half is returned from its recursive call. The array halves should be merged into an array in a way such that the merged array is a sorted array. After merging the two sorted array halves into a sorted array, return the sorted array.
            firstHalfOfArrayToSort = mergeSort(firstHalfOfArrayToSort);
            secondHalfOfArrayToSort = mergeSort(secondHalfOfArrayToSort);
            // Both of the array halves are sorted.

            // Create an array that can store all of the elements from the array halves.
            int[] sortedArray = new int[firstHalfOfArrayToSort.length + secondHalfOfArrayToSort.length];

            // Declare indices that can aid in merging the array halves into an array in a way such that the merged array is a sorted array.
            int indexOfFirstHalfOfArrayToSort = 0;
            int indexOfSecondHalfOfArrayToSort = 0;
            int indexOfSortedArray = 0;

            // While there are elements in both of the array halves that haven't been inserted into the merged array, insert the elements from the array halves into an array in a way such that the merged array is a sorted array.
            while ((indexOfFirstHalfOfArrayToSort < firstHalfOfArrayToSort.length)
                    && (indexOfSecondHalfOfArrayToSort < secondHalfOfArrayToSort.length)) {
                if (firstHalfOfArrayToSort[indexOfFirstHalfOfArrayToSort] < secondHalfOfArrayToSort[indexOfSecondHalfOfArrayToSort]) {
                    sortedArray[indexOfSortedArray++] = firstHalfOfArrayToSort[indexOfFirstHalfOfArrayToSort++];
                } else {
                    sortedArray[indexOfSortedArray++] = secondHalfOfArrayToSort[indexOfSecondHalfOfArrayToSort++];
                }
            }

            // Insert any remaining elements into the sorted array from the array half that had more elements in it than the other array half.
            while (indexOfFirstHalfOfArrayToSort < firstHalfOfArrayToSort.length) {
                sortedArray[indexOfSortedArray++] = firstHalfOfArrayToSort[indexOfFirstHalfOfArrayToSort++];
            }
            while (indexOfSecondHalfOfArrayToSort < secondHalfOfArrayToSort.length) {
                sortedArray[indexOfSortedArray++] = secondHalfOfArrayToSort[indexOfSecondHalfOfArrayToSort++];
            }

            // Return the sorted array.
            return sortedArray;
        }
    }
}
