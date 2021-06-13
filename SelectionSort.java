package backend;


public class SelectionSort{

    public static void sort(int[] array) {
        int min;
        int size = array.length;
        System.out.println("Selection Sort: ");
        for (int i = 0; i < size - 1; i++) {
            min = i;
            for (int j = i + 1; j < size; j++) {
                if(array[min] > array[j]) {
                    int tmp = array[min];
                    array[min] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
