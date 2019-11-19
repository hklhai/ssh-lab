package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ocean lin on 2019/11/14.
 *
 * @author Ocean lin
 */
public class Bfs {

    static class Solution {
        public int numSquares(int n) {
            Queue queue = new LinkedList();
            int[] dist = new int[n+1];
            for(int i = 0 ;i < n+1; i++){
                dist[i] = Integer.MAX_VALUE;
            }

            queue.offer(0);
            dist[0]=0;
            while(queue.size()>0){
                int t = (int)queue.poll();
                if(t == n) {
                    return dist[t];
                }
                for(int i = 1 ; i*i + t <= n ; i++){
                    int j = t + i*i;
                    if(dist[j] > dist[t] + 1){
                        dist[j] = dist[t] + 1;
                        queue.offer(j);
                    }
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().numSquares(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

}
