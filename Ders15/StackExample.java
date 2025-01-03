class Stack {

    // array boyutları sabit bu yüzden en fazla miktar limiti belli olarak bir array
    // oluşturulur
    // stack en üstteki elementi belirlediğinden top elementi gösteren bir değişken
    // oluşturulur
    // matematiksel işlemlerde parantezler böyle hesaplanır

    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // stack boşken top -1 olur 0 olsa stackte bir eleman vardır
    }

    // push methodu ile ekleme yapılır
    // ++top sayesinde önce top değer artar sonra ekleme yapılır
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
        } else {
            stackArray[++top] = value; // Increment top and add element
        }
    }

    // Pop metodu en üstteki elemanı çıkartır
    // çıkartma işlemi aslında bir silme yapmaz en üst sırasını aşağı alır sadece
    // bir çok sistemde databaseden silme yapmak yerine de silindi olarak
    // işaretlenir
    // aynı cihaz hafızası yönetimi gibi
    // bu hem veri kurtarmayı mümkün kılar hem de mevcut veri yerine bir şey yazmak
    // ve
    // sonra onu silip yeni değeri yazmak gibi tekrarlı işlemi önler
    public int pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty. Cannot pop");
            return -1; // -1 genelde bir hata dönüşü olarak kullanılır eğer boş ise -1 döndürüyor
        } else {
            return stackArray[top--]; // burada önce elementi okur sonra ise döndürme sırasını düşürür
        }
    }

    // Peek method to see the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek");
            return -1; // Return -1 if the stack is empty
        } else {
            return stackArray[top];
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

// Main class to test the stack
public class StackExample {
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Create a stack of size 5

        // Pushing elements to the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peeking the top element
        System.out.println("Top element: " + stack.peek());

        // Popping elements from the stack
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        // Checking if stack is empty
        System.out.println("Is the stack empty? " + stack.isEmpty());
    }
}
