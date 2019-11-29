package offer;

/**
 * Created by Ocean lin on 2019/11/29.
 *
 * @author Ocean lin
 */
public class VerifySequenceOfBST {


    public static void main(String[] args) {
        int[] sequence = {4, 8, 6, 12, 16, 14, 10};
        System.out.println(verifySequenceOfBST(sequence));
    }

    public static boolean verifySequenceOfBST(int[] sequence) {
        if (null == sequence) {
            return true;
        }

        int n = sequence.length;
        return dfs(0, n - 1, sequence);
    }

    public static boolean dfs(int l, int r, int[] sequence) {
        if (l >= r) {
            return true;
        }
        int root = sequence[r];
        int k = l;
        while (k < r && sequence[k] < root) {
            k++;
        }
        // 判断右子树是否合法
        for (int i = k; i < r; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        return dfs(l, k - 1, sequence) && dfs(k + 1, r - 1, sequence);
    }
}
