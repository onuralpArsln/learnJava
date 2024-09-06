/*

Red-Black Ağacı
____________________
Also known as symmetric binary B-tree.
Dengeleme Mekanizması: Kırmızı-siyah ağaçlar, düğümlere kırmızı veya siyah renk atayarak dengeyi sağlar.
Kırmızı düğümler arka arkaya gelmez ve her yapraktan köke kadar olan yol üzerinde siyah düğüm sayısı aynıdır.
Rotasyonlar: Dengelemeyi sağlamak için rotasyon ve yeniden renklendirme yapılır. 
Ancak AVL ağaçlarına kıyasla daha az rotasyon yapılır.
Ancak daha az sık rotasyon yaptıkları için özellikle sık ekleme 
ve silme işlemlerinde daha verimli olabilir.
Uygulama Alanı: Red-Black ağaçları genellikle sık veri 
ekleme ve silme işlemlerinin yapıldığı sistemlerde 
(örneğin, işletim sistemleri, harici veri yapıları) kullanılır.
 * 
 * 
 Red-Black Ağaçlarının Özellikleri
Red-Black ağaçları, aşağıdaki özellikleri sağlar:

Her düğüm ya kırmızı ya da siyah.
Kök düğüm her zaman siyah.
Her yaprak (veya boş düğüm) siyah.
Bir kırmızı düğümün çocukları her zaman siyah olmalıdır (yani, iki kırmızı düğüm yan yana olamaz).
Her düğümden yapraklara kadar olan yollar, aynı sayıda siyah düğüm içerir (bu sayıya “black-height” denir).

 * 
 */

public class Main {
    public static void main(String[] args) {
        RedBlackTree rbTree = new RedBlackTree();

        rbTree.insert(55);
        rbTree.insert(40);
        rbTree.insert(65);
        rbTree.insert(60);
        rbTree.insert(70);
        rbTree.insert(63);
        rbTree.insert(67);

        rbTree.printTree();
    }
}

class Node {
    int data;
    Node parent;
    Node left;
    Node right;
    boolean isRed; // Kırmızı mı, siyah mı

    public Node(int data) {
        this.data = data;
        this.isRed = true; // Yeni düğümler genellikle kırmızı olarak eklenir
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

class RedBlackTree {
    private Node root;
    private Node TNULL;

    // Ağacı başlatan constructor
    public RedBlackTree() {
        TNULL = new Node(0);
        TNULL.isRed = false;
        root = TNULL;
    }

    // Ağaca düğüm ekleyen metot
    public void insert(int key) {
        Node node = new Node(key);
        node.left = TNULL;
        node.right = TNULL;

        Node y = null;
        Node x = this.root;

        while (x != TNULL) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null) {
            node.isRed = false;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        fixInsert(node);
    }

    // Ağacın kurallarını koruyarak eklemeyi düzeltir
    private void fixInsert(Node k) {
        Node u;
        while (k.parent.isRed) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                if (u.isRed) {
                    k.parent.isRed = false;
                    u.isRed = false;
                    k.parent.parent.isRed = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;
                if (u.isRed) {
                    k.parent.isRed = false;
                    u.isRed = false;
                    k.parent.parent.isRed = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.isRed = false;
    }

    // Sağ rotasyon
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Sol rotasyon
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Ağacı yazdırma metodu (in-order traversal)
    public void printTree() {
        printTreeHelper(this.root, "", true);
    }

    private void printTreeHelper(Node root, String indent, boolean last) {
        if (root != TNULL) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            String sColor = root.isRed ? "RED" : "BLACK";
            System.out.println(root.data + "(" + sColor + ")");
            printTreeHelper(root.left, indent, false);
            printTreeHelper(root.right, indent, true);
        }
    }
}
