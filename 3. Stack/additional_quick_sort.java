// Additional Quick Sort practice based on sudo code.
public class additional_quick_sort {
    public static void main(String[] args) {
        int[] array = {1, 8, 3, 9, 4, 5, 7};
        quick_sort(array, 0, array.length-1);
        StringBuilder sb = new StringBuilder();
        for(int i : array) {
            sb.append(i);
        }
        System.out.println(sb);
    }
    private static void quick_sort(int[] array, int low_index, int high_index) {
        if(low_index >= high_index) { return; }

        int pivot_index = (int) (Math.random() * (high_index-low_index))+low_index;
        swap(array, pivot_index, high_index);

        int pivot = array[high_index];
        System.err.println("Pivot: " +pivot);
        
        int left_pointer = low_index;
        int right_pointer = high_index;
        while (left_pointer != right_pointer) {
            while (array[left_pointer] <= pivot && left_pointer != right_pointer) {
                left_pointer++;
            }
            System.out.println("left pointer: " +left_pointer);
            while (array[right_pointer] >= pivot && left_pointer != right_pointer) {
                System.out.println("Right pointer: " +right_pointer);
                right_pointer--;
            }
            swap(array, left_pointer, right_pointer);
        }
        swap(array, left_pointer, high_index);

        String results = "[";
        for(int i : array) {
            results += i + ", ";
        }
        results += "]";
        System.out.println(results + " left pointer: "+left_pointer+", right pointer: " +right_pointer);
        // Quick sort the left array.
        System.out.println("LEFT: 0, left_pointer-1: " + (left_pointer - 1) + " left_pointer: "+left_pointer);
        quick_sort(array, low_index, left_pointer-1);
        // Quick sort the right array.
        System.out.println("Right: left_pointer+1:"+(left_pointer+1)+", array.length: " + array.length);
        quick_sort(array, left_pointer+1, high_index);
    }

    private static void swap(int[] array, int index1, int index2) {
        System.err.println("Trying to swap: "+index1+" with "+index2);
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
