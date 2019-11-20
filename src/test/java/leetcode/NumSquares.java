package leetcode;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ocean lin on 2019/11/19.
 *
 * @author Ocean lin
 */
public class NumSquares {

    public static int numSquares(int n) {
        Queue queue = new LinkedList();
        int[] dist = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        queue.offer(0);
        dist[0] = 0;
        while (queue.size() > 0) {
            int t = (int) queue.poll();
            if (t == n) {
                return dist[t];
            }
            for (int i = 1; i * i + t <= n; i++) {
                int j = t + i * i;
                // System.out.println("t:" + t + " j:" + j + "--- " + "dist[j]:" + dist[j] + " - dist[t]:" + dist[t]);
                if (dist[j] > dist[t] + 1) {
                    if (j == 12 || j == 8 || j == 4) {
                        System.out.println("000");
                    }
                    dist[j] = dist[t] + 1;
                    queue.offer(j);
                }
            }
            System.out.println();
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        int ret = numSquares(12);
        String out = String.valueOf(ret);
        System.out.print(out);

    }

}
