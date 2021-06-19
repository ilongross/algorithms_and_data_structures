package backend;

public class QuickSort {

    private static int[] array;

    public static void sort(int[] arr) {
        array = arr;
        recQuickSort(0, arr.length - 1);
    }

    private static void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if(size < 10)
            insertionSort(left, right);
        else {
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    private static void insertionSort(int left, int right) {
        int in, out;
        for(out = left + 1; out <= right; out++) {
            int tmp = array[out];
            in = out;

            while((in > left) && (array[in - 1] >= tmp)) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = tmp;
        }
    }

    private static long medianOf3(int left, int right) {
        int center = (left + right) / 2;
        if(array[left] > array[center])
            swap(left, center);
        if(array[left] > array[right])
            swap(left, right);
        if(array[center] > array[right])
            swap(center, right);
        swap(center, right - 1);
        return array[right - 1];
    }

    private static int partitionIt(int left, int right, long pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;
        while(true) {
            while(array[++leftPtr] < pivot)
                ;
            while(array[--rightPtr] > pivot)
                ;
            if(leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right - 1);
        return leftPtr;
    }

    private static void swap(int dex1, int dex2) {
        int temp = array[dex1];
        array[dex1] = array[dex2];
        array[dex2] = temp;
    }
}
