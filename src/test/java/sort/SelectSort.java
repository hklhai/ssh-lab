package sort;

/**
 * Created by Ocean lin on 2019/11/27.
 *
 * @author Ocean lin
 */
public class SelectSort {


    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 7, 1};
        int[] res = selectSort(arr);
    }

    private static int[] selectSort(int[] arr) {
        int length = arr.length;
        int minIndex = 0;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            for (int j = i; j < length ; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int t = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = t;
        }
        return arr;
    }
}
