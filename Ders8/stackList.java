
public class stackList {

    public static void main(String[] args) {

        Stack test = new Stack();
        test.append(1);
        test.append(2);
        test.append(3);
        test.append(4);

        StackNode result = test.pop();
        System.out.println(result.val);
        result = test.pop();
        System.out.println(result.val);

        test.append(17);
        result = test.pop();
        System.out.println(result.val);

    }

}

class Linklist {
    Node initialNode = null;
    Node lastNode = null;

    public void append(int val) {
        Node temp = new Node(val);

        if (this.initialNode == null) {
            this.initialNode = temp;
            this.lastNode = temp;
        } else {
            this.lastNode.nextNode = temp;
            this.lastNode = temp;
        }
    }

}

class Node {
    int val;
    Node nextNode;

    public Node(int val) {
        this.val = val;
    }
}

class Stack {
    StackNode initialNode = null;
    StackNode lastNode = null;

    public void append(int val) {
        StackNode temp = new StackNode(val);

        if (this.initialNode == null) {
            this.initialNode = temp;
            this.lastNode = temp;
        } else {
            this.lastNode.append(temp);
            this.lastNode = temp;

        }
    }

    public StackNode pop() {
        StackNode temp = this.lastNode;
        this.lastNode = this.lastNode.prevNode;
        return temp;
    }
}

class StackNode {
    StackNode nextNode;
    StackNode prevNode;
    int val;

    public StackNode(int val) {
        this.val = val;
    }

    public void append(StackNode node) {
        this.nextNode = node;
        node.prevNode = this;
    }

}
