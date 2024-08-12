
package src;

public class LinkList {

    Node intialNode = null;

    public void append(int val) {
        Node tempNode = new Node(val);

        if (this.intialNode == null) {
            this.intialNode = tempNode;
        } else {
            Node searchNode = this.intialNode;
            while (searchNode.nextNode != null) {
                searchNode = searchNode.nextNode;
            }
            searchNode.nextNode = tempNode;

        }

    }

    public int getInitialVal() {
        return this.intialNode.getVal();
    }

    public void printVals() {
        Node searchNode = this.intialNode;
        while (searchNode != null) {
            System.out.println(searchNode.value);
            searchNode = searchNode.nextNode;
        }
    }

}

class Node {

    int value;
    Node nextNode = null;

    public Node(int val) {
        this.value = val;
    }

    public int getVal() {
        return this.value;
    }

    public int getValTimes(int i) {
        return i * this.value;
    }

    public static int getFiveTimes(int i) {
        return i * 5;
    }

}
