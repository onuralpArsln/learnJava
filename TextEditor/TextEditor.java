import java.util.Scanner;

public class TextEditor {

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter username");

        while (true) {
            String input = myObj.nextLine();
            if (input.equalsIgnoreCase("EXIT")) {
                break;
            } else if (-1 == input.indexOf(" ")) {
                System.out.println("Faulty Command ");
                continue;

            }
            String[] parts = input.split(" ", 2);

            System.out.println("Enter username " + input);

        }

    }

    private String handleCommand(String command, String input, String memory) {
        switch (command.toLowerCase()) {
            case "show":
                System.out.println(memory);
                return memory;

            case "type":
                return memory + input;

            case "undo":
                System.out.println(
                        "Available commands:\n  greet <name> - Greets the user.\n  add <num1> <num2> - Adds two numbers.\n  exit - Exits the program.");
                break;

            case "redo":
                System.out.println(
                        "Available commands:\n  greet <name> - Greets the user.\n  add <num1> <num2> - Adds two numbers.\n  exit - Exits the program.");
                break;

            default:
                System.out.println("Unknown command. Type 'help' for a list of commands.");
                return memory;
        }
        return memory;
    }
}

/*
 * In Java, the == operator checks for reference equality (whether both
 * variables refer to the same memory location) rather than content equality.
 * For comparing strings by content, use .equals() instead. Here’s the corrected
 * input.equalsIgnoreCase("EXIT") ignores case
 */

/*
 * string.indexOf('a');
 * 
 * String userName = myObj.nextLine(); // Read user input
 * String[] parts = userName.split(" ");
 * System.out.println("Username is: " + parts[0]); // Output user input
 * System.out.println("Username is: " + parts[1]); // Output user input
 * 
 */