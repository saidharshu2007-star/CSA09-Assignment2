import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceDemo {

    public static void testList(String name, List<Integer> list, int size) {

        // Add elements
        long start = System.nanoTime();

        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        long end = System.nanoTime();
        System.out.println(name + " - Add at end: "
                + (end - start) + " ns");

        // Access middle element
        start = System.nanoTime();

        int middle = list.get(size / 2);

        end = System.nanoTime();
        System.out.println(name + " - Access middle element: "
                + (end - start) + " ns");

        // Insert at front
        start = System.nanoTime();

        list.add(0, -1);

        end = System.nanoTime();
        System.out.println(name + " - Insert at front: "
                + (end - start) + " ns");

        // Remove from front
        start = System.nanoTime();

        list.remove(0);

        end = System.nanoTime();
        System.out.println(name + " - Remove from front: "
                + (end - start) + " ns");

        // Iterate through the list
        start = System.nanoTime();

        long sum = 0;
        for (int value : list) {
            sum += value;
        }

        end = System.nanoTime();
        System.out.println(name + " - Iterate through list: "
                + (end - start) + " ns");

        System.out.println();
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 50000};

        System.out.println("=== ARRAYLIST VS LINKEDLIST ===\n");

        for (int size : sizes) {

            System.out.println("Playlist Size: " + size);

            testList("ArrayList", new ArrayList<>(), size);
            testList("LinkedList", new LinkedList<>(), size);

            System.out.println("-----------------------------");
        }
    }
}