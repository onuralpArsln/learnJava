
public class loopCounter {
    public static void main(String[] args) {

        algoToLoop(5);
        algoToLoop(10);
        algoToLoop(20);
        algoToLoop(40);
        algoToLoop(80);
        algoToLoop(160);
        algoToLoop(161);
        algoToLoop(162);
        algoToLoop(163);
        algoToLoop(164);

    }

    public static void algoToLoop(int n) {
        int loopCount = 0;
        int x = 0;
        while (x < n) {
            x = x * 2 + 1;
            loopCount++;
        }
        System.out.println(n + "  icin " + loopCount + "  loop atildi");
    }
}
