package offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ocean lin on 2019/11/26.
 *
 * @author Ocean lin
 */
public class PrintMatrix {
    public static int[] printMatrix(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return new int[]{};
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] stat = new boolean[m][n];
        List<Integer> res = new LinkedList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, d = 1;

        for (int i = 0; i < m * n; i++) {
            res.add(matrix[x][y]);
            stat[x][y] = true;
            int a = x + dx[d];
            int b = y + dy[d];
            if (a < 0 || a >= m || b < 0 || b >= n || stat[a][b] == true) {
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] ints = printMatrix(matrix);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
