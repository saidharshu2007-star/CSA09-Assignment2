import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class PharmacyInventoryDemo {

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 5000};

        for (int size : sizes) {

            System.out.println("\n=== MEDICINE COUNT: " + size + " ===");

            Map<String, Integer> hashMap = new HashMap<>();
            Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
            Map<String, Integer> treeMap = new TreeMap<>();

            // Add medicines
            for (int i = 1; i <= size; i++) {
                String code = String.format("MED%05d", i);

                hashMap.put(code, i * 10);
                linkedHashMap.put(code, i * 10);
                treeMap.put(code, i * 10);
            }

            String searchCode = String.format("MED%05d", size / 2);

            // Test 100,000 lookups
            testLookup("HashMap", hashMap, searchCode);
            testLookup("LinkedHashMap", linkedHashMap, searchCode);
            testLookup("TreeMap", treeMap, searchCode);

            System.out.println("\nReport Order:");

            // Show insertion order
            System.out.println("LinkedHashMap (insertion order):");
            printFirstFive(linkedHashMap);

            // Show code order
            System.out.println("\nTreeMap (sorted code order):");
            printFirstFive(treeMap);

            System.out.println("\n----------------------------");
        }
    }

    public static void testLookup(String mapName,
                                  Map<String, Integer> inventory,
                                  String searchCode) {

        long start = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            inventory.get(searchCode);
        }

        long end = System.nanoTime();

        System.out.println(mapName
                + " - 100000 lookups: "
                + (end - start) + " ns");
    }

    public static void printFirstFive(Map<String, Integer> inventory) {

        int count = 0;

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey()
                    + " -> Stock: " + entry.getValue());

            count++;

            if (count == 5) {
                break;
            }
        }
    }
}