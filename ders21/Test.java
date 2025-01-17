interface run {
    public void start();
}

interface runAgain {
    public void start();
}

public class Test implements run, runAgain {

    public static void main(String[] args) {
        Test pubTest = new Test();
        pubTest.start();
    }

    @Override
    public void start() {
        return;
    };
}