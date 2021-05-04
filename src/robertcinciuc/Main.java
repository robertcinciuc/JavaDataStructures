package robertcinciuc;

import robertcinciuc.structures.linkedList.LinkedList;
import robertcinciuc.structures.linkedList.Node;

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

    public static void main(String[] args) {

//        testLinkedList();

    }
}
