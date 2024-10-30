package TextEditor;

public class SimpleStack {
    private String[][] commandMem;

    private int stepPointer = -1;

    public SimpleStack(int Size) {
        commandMem = new String[Size][2];

    }

    public void insert(String command, String input) {
        String[] process = { command, input };
        commandMem[++stepPointer] = process;

    }

    public String[] pop() {

        return commandMem[stepPointer--];

    }

}
