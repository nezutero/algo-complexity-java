public class Main {
    public static void main(String args[]) {
        int[] arr1 = new int[] { 4, 5, 12 };
        int[] arr2 = new int[] { 4, 5, 5, 10, 12 };

        System.out.println(linearSearch(5, arr1)); // 1
        System.out.println(linearSearch(2, arr1)); // -1

        System.out.println(searchSortedArray(5, arr1)); // -1
        System.out.println(searchSortedArray(2, arr1)); // -1
        System.out.println(searchSortedArray(14, arr1)); // -1

        System.out.println(binarySearch(2, arr2)); // -1
        System.out.println(binarySearch(2, arr2)); // -1
    }

    // 4.1. target = 7, array = {0,1,3,4,5,2,7}
    // Since the array is unsorted, we must check each element sequentially.
    // Time Complexity: O(n) where n = array length

    // (A) Linear search algorithm in an unsorted array
    public static int linearSearch(int target, int[] array) { // 5.1. done
        // int index = -1;
        for (int i = 0; i < array.length; i++) { // 5.2. done
            if (array[i] == target) {
                // index = i;
                return i;
            }
        }
        // return index;
        return -1;
    }

    public static int linearSearchOccurrences(int target, int[] array) { // 5.2. done
        int counter = 0;
        for (int i = 0; i < array.length; i++) { // 5.2. done
            if (array[i] == target) {
                counter++;
            }
        }
        return counter;
    }

    // 5.4. done
    public static int linearSearchMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // 5.5. done
    public static boolean checkForSeveralOccurencies(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    // 4.2. target = 7, array = {1,2,3,4,5,6,7}
    // Since the array is sorted, we don't have to check each element sequentially.
    // However, if the target is the last element, we still have to check previous
    // elements,
    // so the time complexity is O(n), where n = array length; and we need to check
    // all of them.

    // (B) Search algorithm in a sorted array in ascending order
    public static int searchSortedArray(int target, int[] array) {
        int index = -1;
        boolean found = false;
        int i = 0;
        while (!found && i < array.length && array[i] <= target) {
            if (array[i] == target) {
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }

    public static int searchSortedArrayOccurrences(int target, int[] array) { // 5.3. done
        int counter = 0;
        int index = -1;
        int i = 0;
        while (i < array.length && array[i] <= target) {
            if (array[i] == target) {
                counter++;
                index = counter;
            }
            i++;
        }
        return index;
    }

    // 4.3. target = 7 or 1, array = {1,2,3,4,5,6,7}
    // Binary search runs in logarithmic time in the worst case,
    // making O(log n) comparisons, where n is the number of elements in the array.
    // However, if the target is the last or the first element in a sorted list, we
    // still have to
    // check every element smaller or bigger than the middle.

    // (C) Binary search algorithm in a sorted array in ascending order
    public static int binarySearch(int target, int[] array) {
        int start = 0;
        int end = array.length - 1;
        boolean found = false;
        int middle = (start + end) / 2;
        while (!found && start <= end) {
            middle = (start + end) / 2;
            if (array[middle] == target) {
                found = true;
            } else if (array[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        if (found) {
            return middle;
        } else {
            return -1;
        }
    }
}
