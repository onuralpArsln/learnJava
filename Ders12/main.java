
public class main {

    public static void main(String[] args) {

        Tree test = new Tree();
        test.root = new Node("A");
        test.root.left = new Node("T1");
        test.root.right = new Node("B");
        test.root.right.left = new Node("T2");
        test.root.right.right = new Node("T3");

        test.root = test.leftRotate(test.root);

        System.out.println(test.root.value);
        System.out.println(test.root.right.value);
        System.out.println(test.root.left.value);
        System.out.println(test.root.left.right.value);
    }

}

class Tree {
    Node root = null;

    Node leftRotate(Node node) {

        Node root = node;
        Node newRoot = node.right;
        node.right = newRoot.left;

        newRoot.left = node;
        return newRoot;
    }

}

class Node {

    String value;
    Node left, right;

    Node(String value) {
        this.value = value;

    }
}
