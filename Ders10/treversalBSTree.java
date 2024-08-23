
public class treversalBSTree {

    public static void main(String[] args) {
        BST testTree = new BST();
        testTree.appendNewVal(10);
        testTree.appendNewVal(8);
        testTree.appendNewVal(9);
        testTree.appendNewVal(6);
        testTree.appendNewVal(12);

        System.out.println(testTree.root.val);
        System.out.println(testTree.root.nodeLeft.val);
        System.out.println(testTree.root.nodeLeft.nodeRight.val);
        System.out.println(testTree.root.nodeLeft.nodeLeft.val);
        System.out.println(testTree.root.nodeRight.val);

        String route = testTree.roadMap(6);
        System.out.println(route);

    }

}

class BST {
    TreeNode root = null;

    // ilk node boş mu boşsa ilk node ekle
    // ilk node dolu ise?
    // küçük sola büyük sağa

    public void appendNewVal(int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else if (root.val > val) {

            if (root.nodeLeft == null) {
                root.nodeLeft = new TreeNode(val);
            } else {
                TreeNode step = root.nodeLeft;
                this.appendNewValRec(val, step);
            }

        } else {
            if (root.nodeRight == null) {
                root.nodeRight = new TreeNode(val);
            } else {
                TreeNode step = root.nodeRight;
                this.appendNewValRec(val, step);

            }

        }

    }

    private void appendNewValRec(int val, TreeNode step) {
        if (step.val > val) {
            if (step.nodeLeft == null) {
                step.nodeLeft = new TreeNode(val);
            } else {
                TreeNode newStep = step.nodeLeft;
                this.appendNewValRec(val, newStep);
            }
        } else {
            if (step.nodeRight == null) {
                step.nodeRight = new TreeNode(val);
            } else {
                TreeNode newStep = step.nodeRight;
                this.appendNewValRec(val, newStep);
            }

        }

    }

    public String roadMap(int val) {
        String route = "";
        if (this.root == null) {
            route = route + " Null";
            return route;
        } else if (this.root.val == val) {
            return route;
        } else if (this.root.val > val) {
            route = route + " Left";
            TreeNode newStep = root.nodeLeft;
            route = route + this.roadMapRec(val, newStep);
            return route;
        } else {
            route = route + " Right";
            TreeNode newStep = root.nodeRight;
            route = route + this.roadMapRec(val, newStep);
            return route;
        }

    }

    private String roadMapRec(int val, TreeNode step) {
        String route = "";
        if (step == null) {
            route = route + " Null";
            return route;
        } else if (step.val == val) {
            return route;
        } else if (step.val > val) {
            route = route + " Left";
            TreeNode newStep = step.nodeLeft;
            route = route + this.roadMapRec(val, newStep);
            return route;

        } else {
            route = route + " Right";
            TreeNode newStep = step.nodeRight;
            route = route + this.roadMapRec(val, newStep);
            return route;

        }

    }
}

class TreeNode {
    TreeNode nodeLeft = null;
    TreeNode nodeRight = null;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }

}
