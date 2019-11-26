package offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Ocean lin on 2019/11/26.
 *
 * @author Ocean lin
 */
public class PrrintFromTopToBottom {
    static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> printFromTopToBottom(TreeNode root) {

        if (null == root) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        List<Integer> level = new LinkedList<>();
        while (q.size() > 0) {
            TreeNode t = q.peek();
            q.poll();
            // 表示遍历完一整行
            if (t == null) {
                if (level.isEmpty()) {
                    break;
                }
                List<Integer> tmp = new LinkedList<>(level);
                res.add(tmp);
                level.clear();
                q.offer(null);
                continue;
            }
            level.add(t.val);
            if (t.left != null) {
                q.offer(t.left);
            }
            if (t.right != null) {
                q.offer(t.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = null;
        System.out.println(printFromTopToBottom(root));

    }

}
