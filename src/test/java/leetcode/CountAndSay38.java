package leetcode;

/**
 * Created by Ocean lin on 2019/12/16.
 *
 * @author Ocean lin
 */
public class CountAndSay38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }

    public static String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int k = j;
                while (k < s.length() && s.charAt(k) == s.charAt(j)) {
                    k++;
                }
                int t = k - j;
                sb.append(t);
                sb.append(s.charAt(j));
                j  = k -1 ;
            }
            s = sb.toString();
        }
        return s;
    }
}
