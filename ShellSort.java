package backend;

public class ShellSort {
    public static void sort(int[] arr) {
        int inner, outer;
        int tmp;
        int h = 1;

        while(h <= arr.length / 3)
            h = h * 3 + 1;

        while(h > 0) {
            for (outer = h; outer < arr.length; outer++) {
                tmp = arr[outer];
                inner = outer;

                while((inner > h - 1) && arr[inner - h] >= tmp) {
                    arr[inner] = arr[inner - h];
                    inner -= h;
                }
                arr[inner] = tmp;
            }
            h = (h - 1) /3;
        }
    }
}
