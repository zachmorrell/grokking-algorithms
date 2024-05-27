import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(selection_sort(new int[]{9,4,6,2,8,3,7,1}).toString());
    }

    private static ArrayList<Integer> selection_sort(int[] orig_array) {
        ArrayList<Integer> array_copy = new ArrayList<>();
        ArrayList<Integer> sorted_array = new ArrayList<>();
        for(int i = 0; i < orig_array.length; i++) { array_copy.add(orig_array[i]); }

        while (array_copy.size() > 0) {
            int largest_number = -1;
            int index = -1;
            for(int i=0; i<array_copy.size(); i++) {
                if(array_copy.get(i) > ((index > -1) ? array_copy.get(index) : largest_number)) {
                    largest_number = array_copy.get(i);
                    index = i;
                }
            }
            sorted_array.add(array_copy.get(index));
            array_copy.remove(index);
        }

        return sorted_array;
    }
}
