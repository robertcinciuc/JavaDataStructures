package robertcinciuc.problems.leetcode.divideconquer;

public class SortList {

    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode it = head;
        int i = 1;
        while(it.next != null){
            it = it.next;
            i++;
        }

        recursiveDisect(head, it, i);

        return head;
    }

    public void recursiveDisect(ListNode start, ListNode end, int size){
        if(start == end){
            return;
        }

        ListNode slow = start;
        ListNode fast = start.next.next;
        if(size == 2){
            fast = slow.next;
        }
        int i = 1;
        while(fast != end && fast.next != end){
            slow = slow.next;
            fast = fast.next.next;
            ++i;
        }

        recursiveDisect(start, slow, i);
        recursiveDisect(slow.next, end, size - i);

        ListNode itNew = mergeHelper(start, end, slow);
        ListNode it = start;
        while(itNew != null){
            it.val = itNew.val;
            it = it.next;
            itNew = itNew.next;
        }
    }

    public ListNode mergeHelper(ListNode start, ListNode end, ListNode slow){
        ListNode n1 = start;
        ListNode n2 = slow.next;
        ListNode newHead = null;
        ListNode n3 = null;
        while(n1 != slow.next && n2 != end.next){
            ListNode newy = new ListNode();

            if(n2 != null){
                if(n1.val < n2.val){
                    newy.val = n1.val;
                    n1 = n1.next;
                }else{
                    newy.val = n2.val;
                    n2 = n2.next;
                }
            }

            if(newHead == null){
                newHead = newy;
            }else{
                n3.next = newy;
            }
            n3 = newy;
        }

        if(n1 != slow.next){
            ListNode newy = new ListNode();
            newy.val = n1.val;
            n3.next = newy;
        }else if(n2 != end.next){
            ListNode newy = new ListNode();
            newy.val = n2.val;
            n3.next = newy;
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

//        ListNode node5 = new ListNode();
//        node5.val = 5;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;

        ListNode listNode = v.sortList(node1);
        System.out.println();
    }
}
