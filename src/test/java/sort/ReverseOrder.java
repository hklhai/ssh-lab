package sort;

/**
 * 逆序对个数
 *
 * Created by Ocean lin on 2019/11/28.
 *
 * @author Ocean lin
 */
public class ReverseOrder {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int res = reverseOrder(arr);
        System.out.println(res);
    }

    private static int reverseOrder(int[] arr) {
        int count = 0;
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    count++;
                }
            }
        }
        return count;
    }
}
