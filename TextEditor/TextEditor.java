import java.util.Scanner;

public class TextEditor {

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter username");

        while (true) {
            String input = myObj.nextLine();
            if (input.equalsIgnoreCase("EXIT")) {

                break;
            }

            System.out.println("Enter username " + input);

        }
        /*
         * string.indexOf('a');
         * 
         * String userName = myObj.nextLine(); // Read user input
         * String[] parts = userName.split(" ");
         * System.out.println("Username is: " + parts[0]); // Output user input
         * System.out.println("Username is: " + parts[1]); // Output user input
         * 
         */

    }

}

/*
 * In Java, the == operator checks for reference equality (whether both
 * variables refer to the same memory location) rather than content equality.
 * For comparing strings by content, use .equals() instead. Here’s the corrected
 * input.equalsIgnoreCase("EXIT") ignores case
 */