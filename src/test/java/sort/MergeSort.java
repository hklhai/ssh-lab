package sort;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ocean lin on 2019/11/27.
 *
 * @author Ocean lin
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 7, 1};
        int[] res = mergeSort(arr, 0, arr.length - 1);
    }

    private static int[] mergeSort(int[] arr, int l, int r) {
        int len = arr.length;
        if (l >= r) {
            return arr;
        }
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        List<Integer> list = new LinkedList<>();
        int i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                list.add(arr[i]);
                i++;
            }
            if (arr[i] > arr[j]) {
                list.add(arr[j]);
                j++;
            }
        }

        // 把剩余未循环的指针循环
        while (i <= mid) {
            list.add(arr[i]);
            i++;
        }
        while (j <= r) {
            list.add(arr[j]);
            j++;
        }
        for (int x = l, y = 0; y < list.size(); x++, y++) {
            arr[x] = list.get(y);
        }
        return arr;
    }
}
