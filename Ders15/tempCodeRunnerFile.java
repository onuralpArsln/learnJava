import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class QuickSortVisualizer extends JPanel {
    private int[] array;
    private int delay = 100; // milliseconds

    public QuickSortVisualizer(int size) {
        array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(500); // Random heights for bars
        }
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
    }

    // Method to perform QuickSort and visualize it
    public void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    // Partition function for QuickSort
    private int partition(int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(i, j);
                repaint(); // Visualize swap
                sleep();
            }
        }
        swap(i + 1, high);
        repaint(); // Visualize final swap with pivot
        sleep();
        return i + 1;
    }

    // Method to swap two elements
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Method to make the thread sleep for visualization
    private void sleep() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Paint method to draw the array
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < array.length; i++) {
            g.setColor(Color.GREEN);
            g.fillRect(i * (800 / array.length), 600 - array[i], (800 / array.length) - 1, array[i]);
        }
    }

    // Main method to create the GUI and start the sorting
    public static void main(String[] args) {
        JFrame frame = new JFrame("QuickSort Visualization");
        QuickSortVisualizer visualizer = new QuickSortVisualizer(50); // Size of the array
        frame.add(visualizer);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        visualizer.quickSort(0, visualizer.array.length - 1); // Start sorting
    }
}
