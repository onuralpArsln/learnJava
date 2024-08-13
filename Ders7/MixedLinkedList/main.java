
public class main {

    public static void main(String[] args) {

        LinkList test = new LinkList();

        test.append(5);
        test.append("five");
        test.printVals();

    }

}

class LinkList {
    Node intialNode = null;
    Node lastNode = null;

    public void append(int val) {
        IntNode tempNode = new IntNode(val);

        if (this.intialNode == null) {
            this.intialNode = tempNode;
            this.lastNode = tempNode;
        } else {
            Node searchNode = this.intialNode;
            while (searchNode.nextNode != null) {
                searchNode = searchNode.nextNode;
            }
            searchNode.nextNode = tempNode;
            this.lastNode = tempNode;

        }

    }

    public void append(String val) {
        StringNode tempNode = new StringNode(val);

        if (this.intialNode == null) {
            this.intialNode = tempNode;
            this.lastNode = tempNode;

        } else {
            Node searchNode = this.intialNode;
            while (searchNode.nextNode != null) {
                searchNode = searchNode.nextNode;
            }
            searchNode.nextNode = tempNode;
            this.lastNode = tempNode;

        }

    }

    public void printVals() {
        Node searchNode = this.intialNode;
        while (searchNode != null) {
            System.out.println(searchNode.getData());
            searchNode = searchNode.nextNode;
        }
    }

}

abstract class Node {
    Node nextNode = null;

    public abstract Object getData();

}

class IntNode extends Node {
    int val;

    public IntNode(int val) {
        this.val = val;
    }

    @Override
    public Integer getData() {
        return this.val;
    }

}

class StringNode extends Node {
    String val;

    public StringNode(String val) {
        this.val = val;
    }

    @Override
    public String getData() {
        return this.val;
    }

}
