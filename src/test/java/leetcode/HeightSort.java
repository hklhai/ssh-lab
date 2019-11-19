package leetcode;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Ocean lin on 2019/11/18.
 *
 * @author Ocean lin
 */


public class HeightSort {


    public static void main(String[] args) {

        String a = new String();

        for (int i = 0; i < 4; i++) {
            a = a + i;
        }


        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        int[][] ret = reconstructQueue(people);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i][0] + ":" + ret[i][1]);
        }

    }


    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
//            System.out.println(i[1]);
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][2]);
    }
}