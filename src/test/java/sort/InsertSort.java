package sort;

/**
 *
 * 关键点就是current和preIndex
 *
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
            // 记录当前节点与前一个节点
            int current = arr[i];
            int preIndex = i - 1;

            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex]; // 从后往前移动，直到当前值大于preIndex的值
                preIndex--;
            }
            arr[preIndex + 1] = current; // preIndex后的位置与current交换
        }
        return arr;
    }
}
