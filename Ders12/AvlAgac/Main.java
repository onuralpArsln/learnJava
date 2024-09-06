/*
 AVL Ağacı
______________________
Dengeleme Mekanizması: Her düğüm için, sol ve sağ alt ağaçların yükseklik farkı en fazla 1 olabilir. 
Bu farkı koruyabilmek için her ekleme ve silme işleminde ağaç dengelemeleri yapılır.
Rotasyonlar: Dengeyi sağlamak için dört farklı rotasyon kullanılır: 
Tekli Sağ, Tekli Sol, Çift Sağ-Sol, Çift Sol-Sağ.
Ancak AVL ağaçları, Red-Black ağaçlarına göre daha sık rotasyon yapma ihtiyacı duyar.
Uygulama Alanı: Sık veri ekleme ve silme işlemlerinin olmadığı durumlarda 
(örneğin, veri tabanları ve diğer sabit veri yapılandırmalarında) AVL ağaçları tercih edilir.
  
Tekli Sağ (Right Rotation)
___________________
     x
    /
   y
  /
 z


    y
   / \
  z   x

Tekli Sol (Left Rotation)
____________________________
   x
    \
     y
      \
       z

    y
   / \
  x   z

Çift Sağ-Sol (Right-Left Rotation)
________________________________
     x
    /
   y
    \
     z

    x
   /
  z
 /
y

    y
   / \
  x   z

Çift Sol-Sağ (Left-Right Rotation)
__________________________________
   x
    \
     y
    /
   z

    x
    \
     z
      \
       y

    y
   / \
  x   z


 */
public class Main {

    public static void main(String[] Args) {

        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 10);
        System.out.println("Mevcut Root:" + tree.root.value);
        tree.root = tree.insert(tree.root, 20);
        System.out.println("Mevcut Root:" + tree.root.value);
        tree.root = tree.insert(tree.root, 30);
        System.out.println("Mevcut Root:" + tree.root.value);
        tree.root = tree.insert(tree.root, 40);
        System.out.println("Mevcut Root:" + tree.root.value);
        tree.root = tree.insert(tree.root, 50);
        System.out.println("Mevcut Root:" + tree.root.value);
        tree.root = tree.insert(tree.root, 25);
        System.out.println("Mevcut Root:" + tree.root.value);

        System.out.println("In-order dolaşma sonrası AVL ağacı:");
        tree.inOrder(tree.root);
    }
}

class Node {
    // node bir değer ve yüksekliğini içerecek
    // yükseklik sol yada sağ alt ağacının maksimum uzunluğudur
    int value, height;
    Node left, right;

    Node(int value) {
        this.value = value;
        height = 1;
    }
}

class AVLTree {
    Node root;

    // Yükseklik alma
    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // Maksimum değeri bul
    int max(int a, int b) {
        // tek satırda yazılmış bir if ifadesi
        // ternary operator (üçlü operatör)
        return (a > b) ? a : b;
    }

    // Sağ dönüş işlemi : Sağa dönerken left alt node yukarı çıkacak
    Node rightRotate(Node y) {
        // left alt nodeu al kafaya at
        Node x = y.left;
        // T2 orijinal nodeun left alt nodeunun right subtreesi
        Node T2 = x.right;

        // Döndürme işlemi
        // x in alt sağına y node u tak
        x.right = y;
        // eskiden x in alt sağında olan sub treeyi ynin soluna tak
        y.left = T2;

        // Yükseklikleri güncelle
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Yeni kök düğümü döndür
        return x;
    }

    // Sol dönüş işlemi
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Döndürme işlemi
        y.left = x;
        x.right = T2;

        // Yükseklikleri güncelle
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Yeni kök düğümü döndür
        return y;
    }

    // Düğümün denge faktörünü hesapla
    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // AVL ağacına eleman ekleme
    Node insert(Node node, int value) {
        // Eğer ağaç kökü boş ise buraya alcak
        if (node == null)
            return (new Node(value));

        // value büyük küçük olmasında göre doğru yere gitsin diye recursive bir ekleme
        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else
            return node; // Aynı değere sahip düğümler kabul edilmez
        // bu değerleri id olarak düşün ve her node un ayrık idsi olması gerek
        // aynı TCKN gibi

        // Artık yeni bir yüksekli parametremiz
        // var sağ ve sol nodelardan en büyük olan yükseklik değerini alcaz
        // ve bir ekleyip bu nodeun yüksekliğini bulacağız
        node.height = 1 + max(height(node.left), height(node.right));

        // Yükseklikleri bildiğimize göre denge faktörünü hesaplayacağız
        int balance = getBalance(node);

        // Dengesiz durumlar için döndürmeler

        // Sol Sol Durumu
        if (balance > 1 && value < node.left.value)
            return rightRotate(node);

        // Sağ Sağ Durumu
        if (balance < -1 && value > node.right.value)
            return leftRotate(node);

        // Sol Sağ Durumu
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Sağ Sol Durumu
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Düğümü döndür
        return node;
    }

    // Ağaçta dolaşma (In-order)
    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

}
