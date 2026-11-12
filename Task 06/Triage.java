import java.util.Comparator;
import java.util.PriorityQueue;

class Patient {

    final String name;
    final int severity;
    final long arrival;

    Patient(String name, int severity, long arrival) {
        this.name = name;
        this.severity = severity;
        this.arrival = arrival;
    }

    @Override
    public String toString() {
        return name + " (Severity " + severity + ")";
    }
}

public class Triage {

    private long counter = 0;

    // Severity 1 comes first.
    // For equal severity, earlier arrival comes first.
    private final PriorityQueue<Patient> queue =
            new PriorityQueue<>(
                    Comparator.comparingInt((Patient p) -> p.severity)
                            .thenComparingLong(p -> p.arrival)
            );

    void admit(String name, int severity) {
        queue.add(new Patient(name, severity, counter++));
    }

    Patient next() {
        return queue.poll();
    }

    public static void main(String[] args) {

        Triage triage = new Triage();

        // Add 8 patients
        triage.admit("Arun", 3);
        triage.admit("Bala", 1);
        triage.admit("Chitra", 4);
        triage.admit("Divya", 2);
        triage.admit("Eshan", 1);
        triage.admit("Farah", 5);
        triage.admit("Gokul", 2);
        triage.admit("Hari", 3);

        System.out.println("=== HOSPITAL TRIAGE ORDER ===");

        int number = 1;
        Patient patient;

        while ((patient = triage.next()) != null) {
            System.out.println(number + ". " + patient);
            number++;
        }
    }
}