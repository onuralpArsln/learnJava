
import java.util.Random;


class  Node {
    // attributes 
    int data;
    Node next;

    // Create a Random object
    // private static amde it in class accessible
    

    // construtor 
    public Node(int data) {
        this.data= data;
        this.next=null;

    }
}





public class linkedList {

    //  created nul head as start
    private Node head;

    // constructor
    public linkedList() {
        this.head = null;
    }

    // creates a append method to add new data to list 
    public void append(int data) {

        // temproray new node 
        Node newNode = new Node(data);

        // eğer ilk node ise 
        if (head == null) {
            head = newNode;
            return;
        }

        // değilse return yemez ve devam eder 
        // son node u ara 
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        // son node ucuna yenisini ekle 
        last.next = newNode;
    }

    // prints your data 
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    // when run JVM looks for here 
    public static void main(String[] args) {
        linkedList myList = new linkedList();
        Random random = new Random();
        
        int val= random.nextInt();
        myList.append(val);

        val= random.nextInt();
        myList.append(val);

        val= random.nextInt();
        myList.append(val);

        System.out.println("Linked List:");
        myList.display();
    }
}