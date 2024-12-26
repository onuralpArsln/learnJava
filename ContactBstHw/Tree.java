package ContactBstHw;

public class Tree {
    Node root = null;

    public void add(String name, String phone) {
        Node tempNode = new Node(name, phone);
        if (this.root == null) {
            this.root = tempNode;

        } else {
            Node cNode = this.root;
            while (cNode != null) {
                if (cNode.name.compareTo(tempNode.name) < 0) {
                    if (cNode.left == null) {
                        cNode.left = tempNode;
                        return;
                    }
                    cNode = cNode.left;

                } else if (cNode.name.compareTo(tempNode.name) > 0) {
                    if (cNode.right == null) {
                        cNode.right = tempNode;
                        return;
                    }
                    cNode = cNode.right;

                } else {
                    cNode.phone = tempNode.phone;
                    return;
                }
            }
            cNode = tempNode;
        }
    }

    public String search(String name) {
        Node cNode = this.root;
        while (cNode != null) {
            if (cNode.name.compareTo(name) < 0) {

                cNode = cNode.left;

            } else if (cNode.name.compareTo(name) > 0) {

                cNode = cNode.right;

            } else {
                return cNode.phone;
            }
        }
        return "Bu isim yok.";

    }

    public void inOrder(Node cnode) {
        if (cnode != null) {
            inOrder(cnode.left);
            System.out.println(cnode.name + " " + cnode.phone);
            inOrder(cnode.right);
        }

    }

    public void show(Node cnode) {
        inOrder(cnode);
    }

    public void delete(String name) {

        // silinecek nodeu ve silinecek node un parentini bul

        Node pNode = null; // parent node ( nul başlıyor çünkü bura null ise roottayız demek aşağıda onu
                           // kontrol ediyoruz )
        Node cNode = this.root;
        while (cNode != null) {
            if (cNode.name.compareTo(name) < 0) {

                pNode = cNode;
                cNode = cNode.left;

            } else if (cNode.name.compareTo(name) > 0) {

                pNode = cNode;
                cNode = cNode.right;

            } else {
                break; // eğer silinecek node bulunduysa while döngüsünü erken bitir
            }
        }
        if (cNode == null) {
            return; // eğere cNode null olduysa demekki isim listede yok o zaman delete methodunu
                    // erken bitir
        }

        // Hiç çocuğu yok (yaprak düğüm)
        if (cNode.left == null && cNode.right == null) {
            if (pNode == null) {
                this.root = null; // Eğer root düğümse
            } else if (pNode.left == cNode) {
                pNode.left = null;
            } else {
                pNode.right = null;
            }
        }
        // Tek çocuğu varsa
        else if (cNode.left == null || cNode.right == null) {
            Node child = (cNode.left != null) ? cNode.left : cNode.right;
            if (pNode == null) {
                this.root = child; // Eğer root düğümse
            } else if (pNode.left == cNode) {
                pNode.left = child;
            } else {
                pNode.right = child;
            }
        } // iki çocuklu ise
        else {
            // Burası biraz karışık
            // Silinecek nodeun sağındaki en küçük değeri alacağız mesela node değer 10 ise
            // sağdaki bulunabilecek en küçük değer 11 olacak çünkü sağ tarafa hep 10 dan
            // büyük olmalı
            // şimdi 11 ile 10 un yerini değişebiliriz çünkü sağdaki en küçük değer 11 ve
            // diğerleri büyük
            // yer değişiminden sonra eskiden 11in olduğu yeri sileriz çünkü en küçü değer
            // uçta ve silmesi kolay

            // Sağ alt ağaçtaki en küçük düğümü bul (inorder successor)
            Node successorParent = cNode; // Ardılın parent düğümü
            Node successor = cNode.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Ardıl düğümün değerlerini silinecek düğüme kopyala
            cNode.name = successor.name;

            // Ardıl düğümü sil
            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }

        }

    }

    public static void main(String[] args) {
        Tree testTree = new Tree();
        testTree.add("Mahmet", "123");
        testTree.add("Ahmet", "127");
        testTree.add("Zahmet", "124");

        System.out.println(testTree.root.name);
        System.out.println(testTree.root.left.name);
        System.out.println(testTree.root.right.name);

        System.out.println(testTree.search("Zahmet"));
        System.out.println(testTree.search("Cahmet"));

        testTree.add("Kahmet", "321");
        System.out.println(testTree.root.phone);

        testTree.show(testTree.root);

        testTree.delete("Mahmet");

        System.out.println(testTree.search("Mahmet"));

    }

}

class Node {
    String name;
    String phone;
    Node left;
    Node right;

    Node(String name, String phone) {
        this.phone = phone;
        this.name = name;
        this.left = null;
        this.right = null;
    }

}