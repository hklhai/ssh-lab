package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ocean lin on 2019/11/19.
 *
 * @author Ocean lin
 */
public class SpiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (null == matrix || matrix.length == 0) {
            return list;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        boolean[][] flag = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flag[i][j] = false;
            }
        }

        int x = 0, y = 0, d = 1;
        for (int i = 0; i < m * n; i++) {
            list.add(matrix[x][y]);
            flag[x][y] = true;

            int a = x + dx[d];
            int b = y + dy[d];
            if (a < 0 || a >= n || b < 0 || b >= m || flag[a][b]) {
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        List<Integer> ret = spiralOrder(matrix);

        System.out.print(ret);

    }

}
