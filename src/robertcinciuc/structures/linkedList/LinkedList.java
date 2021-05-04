package robertcinciuc.structures.linkedList;

public class LinkedList {

    public Node head;

    public void insertAtStart(int data){
        Node newNode = new Node(data);

        newNode.next = head;

        head = newNode;
    }

    public void insertAfterGiven(Node prevNode, int data){
        if(prevNode == null){
            System.out.println("Prev node is null");
        }

        Node newNode = new Node(data);

        newNode.next = prevNode.next;

        prevNode.next = newNode;
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = null;

        Node last = head;
        while(last.next != null){
            last = last.next;
        }

        last.next = newNode;
        return;
    }

    public void deleteFirstFoundValue(int data){

        if(data == this.head.data){
            this.head = head.next;
            return;
        }

        if(head == null){
            System.out.println("Linked list head is null");
            return;
        }

        Node last = this.head;
        Node prevLast = null;
        while(last != null && last.data != data){
            prevLast = last;
            last = last.next;
        }

        if(last == null){
            System.out.println("No element with this data value");
            return;
        }

        prevLast.next = last.next;
    }

    public void deleteAtPos(int pos){

        if(pos == 0){
            this.head = head.next;
            return;
        }

        int count = 0;
        Node last = this.head;
        Node prevLast = null;
        while(count < pos && last != null){
            prevLast = last;
            last = last.next;
            count += 1;
        }

        if(last == null){
            System.out.println("Position too big for the list");
            return;
        }

        prevLast.next = last.next;

    }



}
