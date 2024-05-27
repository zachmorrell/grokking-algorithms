/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(binary_search(15));
    }

    /**
     * Returns the int value representing the index within the array. 
     */
    static int[] odd_array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41};
    private static int binary_search(int number) {
        int low = 0;
        int high = odd_array.length - 1;
        int mid = (low + high) / 2;
        while(odd_array[mid] != number) {
            if(odd_array[mid] < number) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return mid;
    }
}