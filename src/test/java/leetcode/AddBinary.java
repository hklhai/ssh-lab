package leetcode;

/**
 * Created by Ocean lin on 2019/11/19.
 *
 * @author Ocean lin
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        String a1 = new StringBuilder(a).reverse().toString();
        String b1 = new StringBuilder(b).reverse().toString();

        int carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < a.length() || i < b.length(); i++) {
            int va = i >= a.length() ? 0 : a1.charAt(i) - '0';
            int vb = i >= b.length() ? 0 : b1.charAt(i) - '0';
            int s = va + vb + carry;
            carry = s / 2;
            s %= 2;
            res.append(s);
        }

        if (carry == 1) {
            res.append("1");
        }
        return res.reverse().toString();


    }

    public static void main(String[] args) {

        String a = "11";
        String b = "1";

        String ret = addBinary(a, b);

        String out = (ret);

        System.out.print(out);
    }
}


