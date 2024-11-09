package ders17;

public class Main {
    public static void main(String[] args) {
        doublyLinked testlist = new doublyLinked();

        testlist.push(1);
        testlist.push(12);
        testlist.push(13);
        testlist.push(12);
        testlist.push(14);

        testlist.printNodeVals();
        testlist.deletebyVal(12);
        testlist.printNodeVals();

    }
}
