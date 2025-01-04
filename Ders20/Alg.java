class Alg {
    public static void main(String[] args) {
        alg2(10);

    }

    static int alg2(int n) {
        if (n <= 1) {
            return 0;
        } else {
            n = n - 2;
            System.out.println("n şuan: " + n);
            return 1 + alg2(n);
        }
    }
}