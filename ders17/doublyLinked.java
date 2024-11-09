package ders17;

public class doublyLinked {

    public Node head = null;
    public Node lastNode = null;

    public void push(int val) {
        if (this.head == null) {
            this.head = new Node(val);
            this.lastNode = this.head;
        } else {
            Node temp = new Node(val);
            temp.prev = this.lastNode;
            this.lastNode.next = temp;
            this.lastNode = temp;
        }
    }

    public void printNodeVals() {
        Node temp = this.head;

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;

        }
    }

    public void printFromLast() {
        Node temp = this.lastNode;

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.prev;

        }

    }

    public void deletebyVal(int val) {
        Node temp = this.head;

        while (temp != null) {
            if (temp.val == val) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;

            }
            temp = temp.next;
        }
    }

}

class Node {
    public Node next = null;
    public Node prev = null;
    public int val;

    public Node(int val) {
        this.val = val;
    }

}