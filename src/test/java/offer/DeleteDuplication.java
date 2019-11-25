package offer;

/**
 * Created by Ocean lin on 2019/11/25.
 *
 * @author Ocean lin
 */
public class DeleteDuplication {

    public static ListNode deleteDuplication(ListNode head) {
        // 可能删除头节点，增加虚拟节点

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        while (p.next != null) {
            ListNode q = p.next;
            // 一段内是否存在相同，如果存在q一直往后走
            while (q != null && p.next.val == q.val) {
                q = q.next;
            }
            // 判断下一段长度是否是1
            if (p.next.next == q) {
                p = p.next;
            } else {
                p.next = q;
            }
        }


        return dummy.next;
    }

    public static void main(String[] args) {
        // [1,2,3,3,4,4,5]
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        ListNode listNode = deleteDuplication(listNode1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

