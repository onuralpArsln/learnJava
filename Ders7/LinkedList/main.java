import src.*;

public class main {

    public int m = 7;

    public static void main(String[] args) {

        LinkList test = new LinkList();

        test.append(0);
        test.append(1);
        test.append(2);
        test.append(3);
        test.append("string 4");

        test.printVals();

    }
}
