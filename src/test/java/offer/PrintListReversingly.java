package offer;

import java.util.Stack;

/**
 * Created by Ocean lin on 2019/11/22.
 *
 * @author Ocean lin
 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class PrintListReversingly {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(5);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(-4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        int[] ints = printListReversingly(a1);
        System.out.println(ints);
    }

    public static int[] printListReversingly(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        if (head == null) {
            return new int[0];
        }

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
