import java.util.Scanner;

public class stringequlity {

    public static void main(String[] args) {

        Scanner ScannerObj = new Scanner(System.in);
        String command = ScannerObj.nextLine();
        String a = "selam";
        String b = "selam";

        if (a == command) {
            System.err.println("naber");
        } else {
            System.err.println("bu adamı hayatımda görmedim");
        }

        if (a.equals(command)) {
            System.err.println("naber commanmd");
        } else {
            System.err.println("bu adamı hayatımda görmedim");
        }
    }
}
