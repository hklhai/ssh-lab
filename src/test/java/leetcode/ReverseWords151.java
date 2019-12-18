package leetcode;

/**
 * Created by Ocean lin on 2019/12/18.
 *
 * @author Ocean lin
 */
public class ReverseWords151 {

    public static void main(String[] args) {
        String str = "the  sky   is     blue ";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            String str = split[i];
            if (str.equals("")) {
                continue;
            } else {
                sb.append(str).append(" ");
            }
        }

        String res = sb.toString();
        if (res.length() > 1) {
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }

}
