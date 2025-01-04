public class BstPrint {

    public static void main(String[] args) {

        Tree tesTree = new Tree();
        tesTree.root = new Node(8);
        tesTree.root.left = new Node(5);
        tesTree.root.right = new Node(12);
        tesTree.root.right.left = new Node(9);
        tesTree.root.left.left = new Node(4);
        tesTree.root.left.left.left = new Node(3);
        tesTree.root.left.right = new Node(6);

        tesTree.inOrder();
        tesTree.heightCalc(tesTree.root);

    }

}

class Tree {
    public Node root;

    void inOrder() {

        if (this.root == null) {
            return;
        }
        inOrderRunner(this.root);
    }

    void inOrderRunner(Node node) {
        if (node == null) {
            return;
        }
        inOrderRunner(node.left);
        System.out.println(node.data);
        inOrderRunner(node.right);
    }

    int heightCalc(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = heightCalc(node.left);
        int rightHeight = heightCalc(node.right);

        int currentHeight = Math.max(leftHeight, rightHeight) + 1;

        System.out.println("For node " + node.data + "   Height: " + currentHeight);

        return currentHeight;
    }

}

class Node {
    public int data;
    public Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }

}