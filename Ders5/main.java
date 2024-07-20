import sourcePackage1.*;

public class main {
    public static void main(String[] args) {

        Paper testPaper = new Paper();
        testPaper.write("hello");

        System.out.println(testPaper.getContent());
        testPaper.eraseContent();
        System.out.println(testPaper.getContent());

        Printer testPrinter = new Printer();

        testPrinter.printPaper("cant erase me", testPaper);
        System.out.println(testPaper.getContent());

        Flyer testFlyer = testPrinter.printFlyer("flyer");
        System.out.println(testFlyer.note);

    }
}