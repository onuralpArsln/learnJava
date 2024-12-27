public class AVLTree {

    // AVL ağacındaki düğüm yapısı
    class Node {
        int key;
        Node left, right;
        int height;

        public Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    private Node root;

    // Düğümün yüksekliğini hesaplamak
    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // Düğümün denge faktörünü hesaplamak
    private int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // Sol rotasyon
    private Node leftRotate(Node z) {
        Node y = z.right;
        Node T2 = y.left;

        // Rotasyon işlemi
        y.left = z;
        z.right = T2;

        // Yükseklik güncellemeleri
        z.height = Math.max(height(z.left), height(z.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Yeni kök düğüm
        return y;
    }

    // Sağ rotasyon
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Rotasyon işlemi
        x.right = y;
        y.left = T2;

        // Yükseklik güncellemeleri
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Yeni kök düğüm
        return x;
    }

    // Sol-Sağ rotasyonu (LR)
    private Node leftRightRotate(Node node) {
        node.left = rightRotate(node.left);
        return leftRotate(node);
    }

    // Sağ-Sol rotasyonu (RL)
    private Node rightLeftRotate(Node node) {
        node.right = leftRotate(node.right);
        return rightRotate(node);
    }

    // Yeni bir düğüm eklemek
    public void insert(int key) {
        root = insertNode(root, key);
    }

    // Düğüm ekleme işlemi
    private Node insertNode(Node node, int key) {
        // 1. Normal BST ekleme
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insertNode(node.left, key);
        } else if (key > node.key) {
            node.right = insertNode(node.right, key);
        } else {
            return node; // Aynı değeri tekrar eklememek için
        }

        // 2. Yükseklik güncelleme
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 3. Dengeyi kontrol et ve gerekirse rotasyon yap
        int balance = getBalance(node);

        // Eğer sol alt ağaç daha uzun ise:
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node); // LL
        }

        // Eğer sağ alt ağaç daha uzun ise:
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node); // RR
        }

        // Sol-sağ durumu:
        if (balance > 1 && key > node.left.key) {
            return leftRightRotate(node); // LR
        }

        // Sağ-sol durumu:
        if (balance < -1 && key < node.right.key) {
            return rightLeftRotate(node); // RL
        }

        return node; // Dengeyi sağla
    }

    // Ağacı ekrana yazdırmak (in-order traversal)
    public void inorder() {
        inorderTraversal(root);
        System.out.println();
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.key + " ");
            inorderTraversal(node.right);
        }
    }

    // Main metodu
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Elemanlar ekleniyor
        tree.insert(30);
        tree.insert(20);
        tree.insert(10); // Bu ekleme ile denge bozulur ve rotasyon yapılır
        tree.insert(25);
        tree.insert(40);
        tree.insert(50); // Bu ekleme ile başka bir rotasyon yapılır
        tree.insert(60);

        // Dengeyi kontrol etmek için in-order traversal
        System.out.println("In-order traversal of AVL tree:");
        tree.inorder(); // Çıktı: 10 20 25 30 40 50 60
    }
}
