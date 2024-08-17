
public class myBst {

    public static void main(String[] args) {
        BST test = new BST();
        test.count(15);
        System.out.println("best " + test.bstVal);
        System.out.println("ikinci count");
        test.count(13);
    }
}

class TreeNode {

    int val;
    TreeNode leftNode = null;
    TreeNode rightNode = null;

    public TreeNode(int value) {
        this.val = value;

    }

}

class BST {
    TreeNode root = null;

    int bstVal = 7;

    public void append(int val) {
        TreeNode temp = new TreeNode(val);

        if (this.root == null) {

            this.root = temp;

        } else {
            if (val > this.root.val) {

                this.root.rightNode = temp;
            } else {

                this.root.leftNode = temp;
            }
        }

    }

    public void count(int limit) {
        int currentStep = this.bstVal;
        if (currentStep >= limit) {
            System.out.println("limite eriştim");
        } else {
            currentStep = currentStep + 1;
            System.out.println(currentStep);
            this.count(limit, currentStep);
        }
    }

    private void count(int limit, int currentStep) {
        if (currentStep >= limit) {
            System.out.println("limite eriştim");
        } else {
            currentStep = currentStep + 1;
            System.out.println(currentStep);
            this.count(limit, currentStep);
        }

    }
}
