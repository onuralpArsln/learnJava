public class basicTreeNode {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(4);

        root.left = left;
        root.right = right;
        root.left.left = leftLeft;
        root.left.right = leftRight;

    }
}

class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }

}