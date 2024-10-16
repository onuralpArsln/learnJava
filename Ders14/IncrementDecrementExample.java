public class IncrementDecrementExample {

    public static void main(String[] args) {
        int x = 5;
        int y = 5;

        // Example 1: Pre-Increment
        System.out.println("Example 1: Pre-Increment (++x)");
        System.out.println("Before: x = " + x);

        int a = ++x; // x is incremented first, then assigned to a
        System.out.println("After ++x: x = " + x + ", a = " + a);

        // Reset x
        x = 5;

        // Example 2: Post-Increment
        System.out.println("\nExample 2: Post-Increment (x++)");
        System.out.println("Before: x = " + x);
        int b = x++; // x is assigned to b first, then incremented
        System.out.println("After x++: x = " + x + ", b = " + b);

        // Example 3: Pre-Decrement
        System.out.println("\nExample 3: Pre-Decrement (--y)");
        System.out.println("Before: y = " + y);
        int c = --y; // y is decremented first, then assigned to c
        System.out.println("After --y: y = " + y + ", c = " + c);

        // Reset y
        y = 5;

        // Example 4: Post-Decrement
        System.out.println("\nExample 4: Post-Decrement (y--)");
        System.out.println("Before: y = " + y);
        int d = y--; // y is assigned to d first, then decremented
        System.out.println("After y--: y = " + y + ", d = " + d);

        x = 5;
        System.out.println(x);
        x++;
        System.out.println(x);

        x = 5;
        System.out.println(x);
        ++x;
        System.out.println(x);

    }
}
