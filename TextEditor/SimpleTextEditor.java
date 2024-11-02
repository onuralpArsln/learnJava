package TextEditor;

import java.util.Scanner;

public class SimpleTextEditor implements Runnable {
    String memory = "";
    SimpleStack undoStack = new SimpleStack(256);
    SimpleStack redoStack = new SimpleStack(256);

    public void run() {
        Scanner ScannerObj = new Scanner(System.in); // scanner reads input
        System.out.println("Welcome to STE SimpleTextEditor");

        while (true) {
            String command = ScannerObj.nextLine();
            if (command.equalsIgnoreCase("EXIT")) {
                break;
            }

            memory = handleCommand(command, memory);

        }
    }

    private String handleCommand(String command, String memory) {

        String input;

        if (-1 == command.indexOf(" ")) {
            input = "";
        } else {
            String[] parts = command.split(" ", 2);
            command = parts[0];
            input = parts[1];
        }

        switch (command.toLowerCase()) {
            case "show":
                System.out.println(memory);
                return memory; // ancak bir return vermeyeceksen sona break koymalısın

            case "type":
                undoStack.insert("type", input);
                return memory + input;

            case "delete":
                int n = memory.length();
                if (n > 0) {
                    String last = String.valueOf(memory.charAt(n - 1));
                    undoStack.insert("type", last);
                    memory = memory.substring(0, n - 1);
                } else {
                    System.out.print("Nothing to Delete");

                }
                break;

            case "undo":
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

    public void SelfTest() {
        System.out.println("Unknown command. Type 'help' for a list of commands.");

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