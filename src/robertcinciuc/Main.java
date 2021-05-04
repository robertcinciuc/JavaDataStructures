package robertcinciuc;

import robertcinciuc.structures.linkedList.LinkedList;
import robertcinciuc.structures.linkedList.Node;
import robertcinciuc.structures.tree.BinaryTree;

public class Main {

    public static void testLinkedList(){
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(12);

        linkedList.insertAtStart(11);
        linkedList.insertAtEnd(13);
        linkedList.insertAtEnd(69);
        linkedList.insertAtEnd(61);

        linkedList.insertAfterGiven(linkedList.head, 20);

        Node last = linkedList.head;
        while(last != null){
            System.out.println(last.data);
            last = last.next;
        }
        System.out.println();

        linkedList.deleteFirstFoundValue(69);

        last = linkedList.head;
        while(last != null){
            System.out.println(last.data);
            last = last.next;
        }
        System.out.println();

        linkedList.deleteAtPos(1);

        last = linkedList.head;
        while(last != null){
            System.out.println(last.data);
            last = last.next;
        }
    }

    public static void testingBinaryTrees(){

//        Create & insert into binary tree
        BinaryTree binaryTree = new BinaryTree(10);
        binaryTree.insert(13, binaryTree.getHead());
        binaryTree.insert(8, binaryTree.getHead());
        binaryTree.insert(5, binaryTree.getHead());
        binaryTree.insert(12, binaryTree.getHead());
        binaryTree.insert(45, binaryTree.getHead());
        binaryTree.insert(16, binaryTree.getHead());
        binaryTree.insert(21, binaryTree.getHead());
        binaryTree.insert(60, binaryTree.getHead());
        binaryTree.insert(14, binaryTree.getHead());

//        Print binary tree in preorder (left, data, right)
        binaryTree.printPreorder(binaryTree.getHead());

    }
    public static void main(String[] args) {

//        testLinkedList();

        testingBinaryTrees();

    }
}
