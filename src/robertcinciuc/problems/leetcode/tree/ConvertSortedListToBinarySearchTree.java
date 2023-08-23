package robertcinciuc.problems.leetcode.tree;

public class ConvertSortedListToBinarySearchTree {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }

        if(head.next==null)
            return new TreeNode(head.val);

        ListNode n1 = head;
        ListNode n2 = head.next.next;
        while(n2 != null && n2.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }

        TreeNode root = new TreeNode(n1.next.val);

        ListNode toSearchRight = n1.next.next;
        n1.next = null;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(toSearchRight);

        return root;
    }

    public static void main(String[] args) {
        var v = new ConvertSortedListToBinarySearchTree();
        ListNode node1 = new ListNode();
        node1.val = -10;

        ListNode node2 = new ListNode();
        node2.val = -3;

        ListNode node3 = new ListNode();
        node3.val = 0;

        ListNode node4 = new ListNode();
        node4.val = 5;

        ListNode node5 = new ListNode();
        node5.val = 9;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(v.sortedListToBST(node1));
    }

}
