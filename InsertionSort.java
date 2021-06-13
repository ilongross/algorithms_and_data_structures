package backend;

public class InsertionSort<T> {

    public static void sort(int[] array) {
        System.out.println("Insertion Sort: ");
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int in = i;
            while((in > 0) && (array[in - 1] >= tmp)) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = tmp;
        }
    }
}
