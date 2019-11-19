package leetcode;

import java.util.Arrays;

/**
 * Created by Ocean lin on 2019/11/19.
 *
 * @author Ocean lin
 */
public class SortTest {

    public static void main(String[] args) {

        int[][] a = new int[][]{{1, 2}, {3, 1}, {4, 6}, {6, 9}, {8, 10}};
        Arrays.sort(a, (a1, a2) -> (a2[1] - a1[1]));
        for (int[] e : a) {
            System.out.println(e[0] + ":" + e[1]);
        }
    }

}
