package offer;

/**
 * Created by Ocean lin on 2019/11/25.
 *
 * @author Ocean lin
 */
public class MaxProductAfterCutting {

    public static int maxProductAfterCutting(int length) {
        if (length <= 3) {
            return 1 * (length - 1);
        }
        int res = 1;
        if (length % 3 == 1) {
            res *= 4;
            length -= 4;
        }
        if (length % 3 == 2) {
            res *= 2;
            length -= 2;
        }

        while (length > 0) {
            res *= 3;
            length -= 3;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting(5));
    }

}
