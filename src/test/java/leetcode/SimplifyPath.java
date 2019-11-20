package leetcode;

import java.util.Stack;

/**
 * Created by Ocean lin on 2019/11/20.
 *
 * @author Ocean lin
 */
public class SimplifyPath {


    public static String simplifyPath(String path) {
        Stack stack = new Stack();
        String[] s = path.split("/");

        for (int i = 0; i < s.length; i++) {
            if (!stack.isEmpty() && s[i].equals("..")) {
                stack.pop();
            } else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals("..")) {
                stack.push(s[i]);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }


    public static void main(String[] args) {

        String path = "/home/";

        String ret = simplifyPath(path);

        String out = (ret);

        System.out.print(out);

    }

}
