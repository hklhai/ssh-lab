package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ocean lin on 2019/12/2.
 *
 * @author Ocean lin
 */
public class GetLeastNumbers {


    public static List<Integer> getLeastNumbers_Solution(int[] input, int k) {
        List<Integer> arr = new ArrayList<>();
        int len = input.length;
        if (k > len)
            return arr;
        for (int i = 0; i < k; i++) {
            heapsort(input, i, len);
            arr.add(input[i]);
        }
        return arr;
    }

    static void heapsort(int[] input, int i, int len) {
        for (int j = len - 1; j >= i; j--) {
            // 最后一个节点的parent节点
            int p = (j + i - 1) / 2;
            if (input[p] > input[j]) {
                int temp = input[p];
                input[p] = input[j];
                input[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 8, 4, 5, 6, 7, 3};
        int k = 7;
        List<Integer> integerList = getLeastNumbers_Solution(input, k);
        integerList.forEach(e -> System.out.println(e));
    }
}
