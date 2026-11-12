import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Task07_RedesignDemo {

    public static void main(String[] args) {

        int size = 50000;
        int operations = 10000;

        System.out.println("=== TASK 7: ORIGINAL VS REDESIGNED SOLUTION ===");
        System.out.println("Initial Size: " + size);
        System.out.println("Front Operations: " + operations);

        // ORIGINAL: ArrayList
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }

        long start = System.nanoTime();

        for (int i = 0; i < operations; i++) {
            arrayList.add(0, i);
            arrayList.remove(0);
        }

        long end = System.nanoTime();

        System.out.println("\nOriginal Solution: ArrayList");
        System.out.println("Time for front operations: "
                + (end - start) + " ns");

        // REDESIGNED: ArrayDeque
        Deque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < size; i++) {
            arrayDeque.addLast(i);
        }

        start = System.nanoTime();

        for (int i = 0; i < operations; i++) {
            arrayDeque.addFirst(i);
            arrayDeque.removeFirst();
        }

        end = System.nanoTime();

        System.out.println("\nRedesigned Solution: ArrayDeque");
        System.out.println("Time for front operations: "
                + (end - start) + " ns");

        System.out.println("\nConclusion:");
        System.out.println("ArrayDeque is designed for efficient "
                + "operations at both ends.");
    }
}