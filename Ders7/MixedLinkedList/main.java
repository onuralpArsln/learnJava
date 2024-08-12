
public class main {

    public static void main(String[] args) {

        LinkList test = new LinkList();

        test.append(5);
        System.out.println(test.lastNode);

        test.append("5");
        System.out.println(test.lastNode);

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

}

class Node {
    Node nextNode = null;

}

class IntNode extends Node {
    int val;

    public IntNode(int val) {
        this.val = val;
    }

}

class StringNode extends Node {
    String val;

    public StringNode(String val) {
        this.val = val;
    }

}
