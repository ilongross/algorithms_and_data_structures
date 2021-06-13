package backend;

public class BubbleSort {

    public static void sort(int[] array) {
        int size = array.length;
        System.out.println("Bubble Sort: ");
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j > i; j--) {
                if(array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
