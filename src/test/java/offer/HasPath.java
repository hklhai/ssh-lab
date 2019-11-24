package offer;

/**
 * Created by Ocean lin on 2019/11/24.
 *
 * @author Ocean lin
 */
public class HasPath {

    public static boolean hasPath(char[][] matrix, String str) {

        if (null == matrix || 0 == matrix.length) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        if (row == 1 && col == 1 & str.length() == 1 && matrix[0][0] == str.charAt(0)) {
            return true;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(matrix, str, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // len 表示str字符串的长度
    public static boolean dfs(char[][] matrix, String str, int len, int x, int y) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (str.length() == len) {
            return true;
        }
        if (matrix[x][y] != str.charAt(len)) {
            return false;
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        char t = matrix[x][y];
        matrix[x][y] = '*';
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < row && b >= 0 && b < col) {
                if (dfs(matrix, str, len + 1, a, b)) {
                    return true;
                }
            }
        }
        matrix[x][y] = t;
        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a'}};
        String str = "a";
        System.out.println(hasPath(matrix, str));

    }
}
