package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ocean lin on 2019/11/23.
 *
 * @author Ocean lin
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BuildTree {


    private static Map<Integer, Integer> order = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int iSize = inorder.length;
        for (int i = 0; i < iSize; i++) {
            order.put(inorder[i], i);
        }

        return dfs(0, iSize - 1, 0, iSize - 1, preorder);
    }

    public static TreeNode dfs(int pl, int pr, int il, int ir, int[] preorder) {
        if (pl > pr) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int k = order.get(root.val);
        TreeNode left = dfs(pl + 1, pl + k - il, il, k - 1, preorder);
        TreeNode right = dfs(pl + k - il + 1, pr, k + 1, ir, preorder);
        root.left = left;
        root.right = right;
        return root;
    }


    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }


}
