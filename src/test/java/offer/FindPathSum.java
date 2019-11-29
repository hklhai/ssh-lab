package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ocean lin on 2019/11/29.
 *
 * @author Ocean lin
 */
public class FindPathSum {

    private static List<List<Integer>> res = new LinkedList<>();
    private static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(2);
        t1.left = null;
        t1.right = t2;
        t2.left = t3;
        t2.right = t4;
        t3.left = t5;
        t3.right = null;
        t5.left = null;
        t5.right = null;
        t4.left = null;
        t4.right = null;
        int sum = 13;
        List<List<Integer>> path = findPath(t1, sum);
        System.out.println(path);

    }

    public static List<List<Integer>> findPath(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    public static void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            //引用调用，需要复制path内容，不然存在ans中的为引用
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(list);
            res.add(tmp);
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        System.out.println(list);
        list.remove(list.size() - 1);
        // list.clear();

    }
}
