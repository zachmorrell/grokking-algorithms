import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println(factorial(6));
        ArrayList<Integer> sum_list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        int[] number_list = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,
            27,28,29,30,31,32,33,34,35,36,37,38,39,40};
        int[] sort_me = {1,20,300,4,5000,6,70,800,9,100};
        ArrayList<Integer> sum_list2 = new ArrayList<>(Arrays.asList(1,20,300,4,5000,6,70,800,9,100));
        System.out.println("Sum of list: " + sum(new ArrayList<>(sum_list)) + ", the list has a length of: " + count(new ArrayList<>(sum_list)));
        System.err.println("Largest number: " + max(sum_list2));
        System.err.println("Binary Search: " + binary_search(number_list, 8));
        quick_sort(sort_me);
        String result = "";
        for(int i : sort_me) {
            result += i + ", ";
        }
        System.err.println(result);
        System.out.println(euclid(1680,640));
    }

    private static int factorial(int target) {
        return ((target == 1) ? 1 : target * factorial(target-1));
    }

    private static int sum(ArrayList<Integer> sum_list) {
        if(sum_list.size() == 1) {
            return sum_list.get(0);
        }
        int current_sum = sum_list.get(0);
        sum_list.remove(0);
        return current_sum + sum(sum_list);
    }

    private static int count(ArrayList<Integer> sum_list) {
        if(sum_list.size() == 1) {
            return 1;
        }
        sum_list.remove(0);
        return 1 + count(sum_list);
    }

    private static int max(ArrayList<Integer> sum_list) {
        if(sum_list.size() == 1) { return sum_list.get(0); }
        if (sum_list.get(0) > sum_list.get(1)) {
            sum_list.remove(1);
        } else {
            sum_list.remove(0);
        }
        return max(sum_list);
    }

    private static int binary_search(int[] array, int target) {
        int guess = (array.length - 1) / 2;
        if(array[guess] == target) {
            return guess;
        }
        if(array[guess] > target) {
            return binary_search(Arrays.copyOfRange(array, 0, guess), target);
        }
        return guess + 1 + binary_search(Arrays.copyOfRange(array, guess + 1, array.length), target);
    }

    // Finds the largest, shared, dimensions between the two ints in dimensions.
    private static int euclid(int a, int b) {
        int greater = Math.max(a, b);
        int smaller = Math.min(a, b);
        if(greater%smaller==0) {
            return smaller;
        }
        return euclid(greater%smaller, smaller);
    }

    // Overload quick_sort method so user doesn't have to enter start and end length of array.
    private static void quick_sort(int[] array) {
        quick_sort(array, 0, array.length-1);
    }

    // Fastest sorting algorithm, utilizes divide and conquer.
    private static void quick_sort(int[] array, int low, int high) {

        // To prevent a never ending loop, escape with return call if left is 1.
        if(low >= high) { return; }

        // Fastest sort involves a random pivot.
        int pivotIndex = new Random().nextInt(high - low) + low;

        // Declares pivot int as the value of the random array item at pivotIndex.
        int pivot = array[pivotIndex];

        // Move pivot index to the end of the array.
        swap(array, pivotIndex, high);

        // The correct index location for the selected integer pivot.
        int left_pointer = partition(array, low, high, pivot);

        // All items to the left of pivot, perform quick_sort.
        quick_sort(array, low, left_pointer-1);

        // All items to the right of pivot, perform quick_sort.
        quick_sort(array, left_pointer+1, high);
    }

    public static int partition(int[] array, int low, int high, int pivot) {

        // Left pointer index in the array.
        int left_pointer = low;

        // Right pointer index in the array.
        int right_pointer = high;
        
        // Loops through the list.
        while (left_pointer < right_pointer) {

            // while pivot is greater than or equal to left_pointer, increment left_pointer.
            while(array[left_pointer] <= pivot && left_pointer < right_pointer) {
                left_pointer++;
            }

            // While pivot is less than or equal to right_pointer, decrement right pointer.
            while (array[right_pointer] >= pivot && left_pointer < right_pointer) {
                right_pointer--;
            }

            // Swap the item at left_pointer with the item at right_pointer in array.
            swap(array, left_pointer, right_pointer);
        }

        // Swap left_pointer with the last index.
        swap(array, left_pointer, high);

        // Return left_pointer.
        return left_pointer;
    }

    // Swap item at index 1 with item at index 2 in array.
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}