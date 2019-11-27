package sort;

/**
 * Created by Ocean lin on 2019/11/27.
 *
 * @author Ocean lin
 */
public class InsertSort {


    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 7, 1};
        int[] res = insertSort(arr);
    }

    private static int[] insertSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int current = arr[i];
            int preIndex = i - 1;

            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }
}
