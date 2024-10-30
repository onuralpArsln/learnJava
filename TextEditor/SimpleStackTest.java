package TextEditor;

import java.util.Arrays;

public class SimpleStackTest {

    private static void testAddOne(String command, String input) {
        SimpleStack testStack = new SimpleStack(10);
        testStack.insert(command, input);
        String[] testArray = { command, input };
        String[] resultArray = testStack.pop();
        if (Arrays.equals(testArray, resultArray)) {
            System.out.println("test Passed");
        } else {
            System.out.println("test Failed");

        }

    }

    public static void main(String[] args) {
        testAddOne("delete", "b");
    }

}
