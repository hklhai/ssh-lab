package offer;

/**
 * Created by Ocean lin on 2019/12/1.
 *
 * @author Ocean lin
 */
public class BSTconvertLinkList {


    public static void main(String[] args) {

    }


    public static TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 返回当前子树最左侧节点和最右侧节点
        TreeNode[] res = dfs(root);
        return res[0];
    }


    public static TreeNode[] dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            // 既是最左侧也是最右侧
            return new TreeNode[]{root, root};
        }
        if (root.left != null && root.right != null) {
            TreeNode[] l = dfs(root.left);
            l[1].right = root;
            root.left = l[1];

            TreeNode[] r = dfs(root.right);
            root.right = r[0];
            r[0].left = root;
            // 返回左子树最左侧点和右子树最右侧的点
            return new TreeNode[]{l[0], r[1]};
        } else if (root.left != null) {
            TreeNode[] l = dfs(root.left);
            l[1].right = root;
            root.left = l[1];
            // 没有右子树，根节点就是最右点
            return new TreeNode[]{l[0], root};
        } else if (root.right != null) {
            TreeNode[] r = dfs(root.right);
            root.right = r[0];
            r[0].left = root;
            return new TreeNode[]{root, r[1]};
        }
        return null;
    }
}
