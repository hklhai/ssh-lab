package cn.edu.ncut.test;

import org.eclipse.jetty.continuation.ContinuationSupport;

/**
 * Created by Ocean lin on 2019/12/18.
 *
 * @author Ocean lin
 */
public class SplitTest {

    public static void main(String[] args) {
        String str = "the  sky   is     blue ";
        String[] split = str.split(" ");
        for (int i = 0; i < split.length; i++) {
            System.out.println("=" + split[i] + "=");

        }
    }
}
