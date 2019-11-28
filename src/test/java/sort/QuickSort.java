package sort;

/**
 * Created by Ocean lin on 2019/11/28.
 *
 * @author Ocean lin
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 7, 1};
        int[] res = quickSort(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return arr;
        }
        // 为下面计算方便
        int i = l - 1, j = r + 1;
        int mid = arr[l + r >> 1];
        while (i < j) {
            do i++; while (arr[i] < mid);
            do j--; while (arr[j] > mid);
            if (i < j) {
                // 放错位置交换
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            } else {
                // 所有大于、小于mid的已经放置完毕
                quickSort(arr, l, j);
                quickSort(arr, j + 1, r);
            }
        }
        return arr;
    }

}
