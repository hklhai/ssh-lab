package leetcode;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * Created by Ocean lin on 2020/3/26.
 *
 * @author Ocean lin
 */
public class MySqrt69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }

    public static int mySqrt(int x) {
        int l = 0, r = x;

        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (mid <= x / mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
