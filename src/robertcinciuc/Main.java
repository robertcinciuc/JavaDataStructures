package robertcinciuc;

import robertcinciuc.structures.heap.Heap;
import robertcinciuc.structures.linkedList.LinkedList;
import robertcinciuc.structures.linkedList.Node;
import robertcinciuc.structures.tree.BinaryTree;
import robertcinciuc.structures.tree.BinaryTreeNode;
import robertcinciuc.structures.trie.TrieNode;
import robertcinciuc.structures.trie.Trie;

import java.util.List;

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

    public static void testingBinaryTrees() throws Exception {

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

//        Find element 60
        BinaryTreeNode resultNode = binaryTree.findNode(binaryTree.getHead(), 60);
        System.out.println("Result=" + resultNode.getData());

    }

    public static void testingHeap(){

        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(24);
        heap.insert(30);
        heap.insert(14);
        heap.insert(8);
        heap.insert(50);
        heap.insert(12);
        heap.insert(64);
        heap.insert(23);
        heap.insert(50);
        heap.insert(34);
        heap.printOnLevels();

//        Printing and deleting top of heap = HEAP SORT
        System.out.println();
        List<Integer> sortedList = heap.getSorted();
        for(Integer elem: sortedList){
            System.out.print(elem + " ");
        }

    }

    public static void testingTries(){

        Trie trie = new Trie();
        trie.insert("abe", trie.getRoot());
        trie.insert("ada", trie.getRoot());
        trie.insert("bec", trie.getRoot());
        trie.insert("bad", trie.getRoot());
//        System.out.println(trie.toString());
//        trie.printOnLevels();
        trie.printWords("", trie.getRoot(), -1);
    }

    public static void main(String[] args) throws Exception {

//        testLinkedList();

//        testingBinaryTrees();

//        testingHeap();

        testingTries();
    }
}
