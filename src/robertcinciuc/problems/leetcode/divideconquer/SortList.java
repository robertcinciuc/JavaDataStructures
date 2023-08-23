package robertcinciuc.problems.leetcode.divideconquer;

public class SortList {

    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return mergeHelper(l1, l2);
    }

    public ListNode mergeHelper(ListNode start, ListNode slow){
        ListNode newHead = null;
        ListNode n3 = null;
        while(start != null && slow != null){
            ListNode newy = new ListNode();

            if(start.val < slow.val){
                newy.val = start.val;
                start = start.next;
            }else{
                newy.val = slow.val;
                slow = slow.next;
            }

            if(newHead == null){
                newHead = newy;
            }else{
                n3.next = newy;
            }
            n3 = newy;
        }

        if(start != null){
            if (newHead == null) {
                newHead = start;
            }else{
                n3.next = start;
            }
        }

        if(slow != null){
            if (newHead == null) {
                newHead = slow;
            }else{
                n3.next = slow;
            }
        }

        return newHead;
    }

    public static void main(String[] args) {
        var v = new SortList();
        ListNode node1 = new ListNode();
        node1.val = 4;

        ListNode node2 = new ListNode();
        node2.val = 2;

        ListNode node3 = new ListNode();
        node3.val = 7;

        ListNode node4 = new ListNode();
        node4.val = 1;

        ListNode node5 = new ListNode();
        node5.val = 5;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = v.sortList(node1);
        System.out.println();
    }
}
