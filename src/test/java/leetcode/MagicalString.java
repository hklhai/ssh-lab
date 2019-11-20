package leetcode;

/**
 * Created by Ocean lin on 2019/11/19.
 *
 * @author Ocean lin
 */
public class MagicalString {

    public static void main(String[] args) {

        int ret = magicalString(89999);

        String out = String.valueOf(ret);

        System.out.print(out);

    }

    public static int magicalString(int n) {
        String s = "122";
        int i = 1;
        int count = 1;
        int size = 3;
        while (size < n) {
            if (i == 100) {
                s = s.substring(100);
                i = 0;
                size = s.length();
                n -= 100;
            }
            int x = Integer.parseInt(s.charAt(++i) + "");
            if (x == 1) {
                if (s.charAt(size - 1) == '1') {
                    s += "2";
                } else {
                    s += "1";
                    count += 1;
                }
            } else {
                if (s.charAt(size - 1) == '1') {
                    s += "22";
                } else {
                    s += "11";
                    count += 2;
                    if (s.length() > n)
                        count -= 1;
                }
            }
            size = s.length();
        }

        return n > 0 ? count : 0;
    }
}
