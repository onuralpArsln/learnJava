package TextEditor;

import java.util.Arrays;

public class SimpleStackTest {

    private static void testAddOne(String command, String input) {
        SimpleStack testStack = new SimpleStack(10);
        testStack.insert(command, input);
        String[] testArray = { command, input };
        String[] resultArray = testStack.pop();
        System.out.println(testArray[0] + testArray[1]);
        System.out.println(resultArray[0] + resultArray[1]);

    }

    public static void main(String[] args) {
        testAddOne("delete", "b");
    }

}
