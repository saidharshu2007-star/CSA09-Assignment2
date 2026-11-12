public class StringPerformanceDemo {

    public static String buildWithString(int fields) {
        String ticket = "";

        for (int i = 1; i <= fields; i++) {
            ticket = ticket + "Field" + i + ": Value" + i + "\n";
        }

        return ticket;
    }

    public static String buildWithStringBuilder(int fields) {
        StringBuilder ticket = new StringBuilder();

        for (int i = 1; i <= fields; i++) {
            ticket.append("Field")
                  .append(i)
                  .append(": Value")
                  .append(i)
                  .append("\n");
        }

        return ticket.toString();
    }

    public static String buildWithStringBuffer(int fields) {
        StringBuffer ticket = new StringBuffer();

        for (int i = 1; i <= fields; i++) {
            ticket.append("Field")
                  .append(i)
                  .append(": Value")
                  .append(i)
                  .append("\n");
        }

        return ticket.toString();
    }

    public static void runTest(String method, int fields) {

        long startTime = System.nanoTime();

        if (method.equals("String")) {
            buildWithString(fields);
        } else if (method.equals("StringBuilder")) {
            buildWithStringBuilder(fields);
        } else if (method.equals("StringBuffer")) {
            buildWithStringBuffer(fields);
        }

        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;

        System.out.println(method + " - Fields: " + fields
                + " - Time: " + timeTaken + " ns");
    }

    public static void main(String[] args) {

        System.out.println("=== STRING PERFORMANCE COMPARISON ===");

        // Workload 1: Short ticket
        System.out.println("\nWorkload 1: Short Ticket (10 fields)");
        runTest("String", 10);
        runTest("StringBuilder", 10);
        runTest("StringBuffer", 10);

        // Workload 2: Large ticket
        System.out.println("\nWorkload 2: Large Ticket (10000 fields)");
        runTest("String", 10000);
        runTest("StringBuilder", 10000);
        runTest("StringBuffer", 10000);

        // Workload 3: Medium ticket
        System.out.println("\nWorkload 3: Medium Ticket (1000 fields)");
        runTest("String", 1000);
        runTest("StringBuilder", 1000);
        runTest("StringBuffer", 1000);

        System.out.println("\nConclusion:");
        System.out.println("StringBuilder is generally efficient for repeated text building.");
        System.out.println("StringBuffer is useful when thread safety is required.");
    }
}