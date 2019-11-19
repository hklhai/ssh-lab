package leetcode;

/**
 * Created by Ocean lin on 2019/11/19.
 *
 * @author Ocean lin
 */
public class RemoveKdigits {

    public static String removeKdigits(String num, int k) {
        String res = new String();

        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && res.length() > 0 && ((char) res.charAt(res.length() - 1) - '0') > (num.charAt(i) - '0')) {
                k--;
                res = res.substring(0, res.length() - 1);
            }
            res += num.charAt(i);
        }

        while (k > 0) {
            res = res.substring(0, res.length() - 1);
            k--;
        }

        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') {
            i++;
        }
        if (i == res.length()) {
            return "0";
        }
        res = res.substring(i, res.length());
        return res;

    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        String ret = removeKdigits(num, k);

        String out = (ret);

        System.out.print(out);
    }
}






