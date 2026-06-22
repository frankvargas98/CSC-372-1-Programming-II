import java.util.ArrayList;
import java.util.Comparator;

public class CustomSort {

    /**
     * Sorts an ArrayList of Students using the Selection Sort algorithm
     */
    public static void selectionSort(ArrayList<Student> list, Comparator<Student> comparator) {
        int n = list.size();

        // Moves the boundary of the unsorted subarray one by one
        for (int i = 0; i < n - 1; i++) {
            // Finds the minimum element in the remaining unsorted array
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                // We use the passed comparator to check if list(j) is "smaller" than list(minIdx)
                if (comparator.compare(list.get(j), list.get(minIdx)) < 0) {
                    minIdx = j;
                }
            }

            // Swaps the found minimum element with the first element of the unsorted boundary
            if (minIdx != i) {
                Student temp = list.get(minIdx);
                list.set(minIdx, list.get(i));
                list.set(i, temp);
            }
        }
    }
}