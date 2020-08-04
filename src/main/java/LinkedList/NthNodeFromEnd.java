package LinkedList;

public class NthNodeFromEnd {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    public static void reverseLinkList( Node head )
    {
        Node prev,current,forward;
        prev = forward = null;
        current = head;
        while ( current != null )
        {
            forward = current.next;
            current.next = prev;
            prev = current;
            current = forward;
        }
        head = prev;
        printLinkedList(head);
    }

    public static void printLastToNthNode(Node head, int index)
    {
        Node fastPointer = null;
        Node currentPointer = head;
        // move fast pointer ahead
        for (int i=0;i<index;i++)
        {
            fastPointer = head.next;
            head =head.next;
        }
        while (fastPointer != null)
        {
            fastPointer = fastPointer.next;
            currentPointer = currentPointer.next;
        }
        System.out.println(currentPointer.data);
    }

    public static int printLinkedList(Node Head) {
        int count = 0;
        while (Head != null) {
            System.out.println(Head.data);
            Head = Head.next;
            count++;

        }
        return count;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        reverseLinkList(head);
      //  printLastToNthNode(head, 2);
    }

}
