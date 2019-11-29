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
        int minIndex;
        for (int i = 0; i < length - 1; i++) { // 依次插入0 到 n-1 位置的值
            // 当前值暂时作为最小索引
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 将第i小的值放到第i的位置上
            int t = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = t;
        }
        return arr;
    }
}
