package sort;

/**
 * Created by Ocean lin on 2019/12/2.
 *
 * @author Ocean lin
 */
public class HeapSort {

    public static void main(String[] args) {
        // 对根节点做heapify
//        int[] a = {4, 10, 3, 5, 1, 2};
//        heapify(a, a.length, 0);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }


        /**
         *  所有节点混乱的情况下构成堆，对最后非叶节点
         *  *******（最后一个节点的Parent节点） *******
         */
//        int[] a = {2, 5, 3, 1, 10, 4};
//        buildHeap(a, a.length);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }


        /**
         *
         * 1. 堆排序，把根节点和最后节点交换；
         * 2. 把最后节点去除；
         * 3. 对根节点做heapify，最大值又交换至根节点
         * 4. 重复让面的步骤
         */
        int[] a = {2, 5, 3, 1, 10, 4};
        heapSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void buildHeap(int[] a) {
        int lastNode = a.length - 1;
        int lastNodeParent = lastNode - 1 >> 1;
        for (int i = lastNodeParent; i >= 0; i--) {
            heapify(a, a.length, i);
        }
    }

    private static void heapSort(int[] a, int n) {
        buildHeap(a);
        // 最后一个节点触发
        for (int i = n - 1; i >= 0; i--) {
            int t = a[0];
            a[0] = a[i];
            a[i] = t;
            // 会做砍断，树的长度会减少，heapify的长度就是i的值
            heapify(a, i, 0);
        }
    }


    /**
     * @param a 树
     * @param n 树的节点总数
     * @param i 对哪个节点做heapify操作
     */
    private static void heapify(int[] a, int n, int i) {
        if (i >= n) {
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;

        if (c1 < n && a[max] < a[c1]) {
            max = c1;
        }
        if (c2 < n && a[max] < a[c2]) {
            max = c2;
        }
        // 如果i是最大值不需要交换
        if (max != i) {
            int t = a[max];
            a[max] = a[i];
            a[i] = t;
            // 是c1或c2的下标
            heapify(a, n, max);
        }
    }
}
