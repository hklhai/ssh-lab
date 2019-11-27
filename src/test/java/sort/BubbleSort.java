package sort;

/**
 * Created by Ocean lin on 2019/11/27.
 *
 * @author Ocean lin
 */
public class BubbleSort {


    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 7, 1};
        int[] res = bubbleSort(arr);

        int[] arr2 = {1, 2, 5, 6, 7};
        int[] res2 = bubbleSortAdvance(arr2);

    }

    private static int[] bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        return arr;
    }


    private static int[] bubbleSortAdvance(int[] arr) {
        int len = arr.length;
        boolean flag = false;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    flag = true;
                }
            }
            // 如果没有经过交换就表示已经有序
            if (!flag) {
                break;
            }
        }
        return arr;
    }
}
