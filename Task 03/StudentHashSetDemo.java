import java.util.HashSet;
import java.util.Set;

class Student {

    private final String regNo;
    private final String name;

    Student(String regNo, String name) {
        this.regNo = regNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) {
            return false;
        }

        Student other = (Student) o;
        return regNo.equals(other.regNo);
    }

    @Override
    public int hashCode() {
        return regNo.hashCode();
    }
}

public class StudentHashSetDemo {

    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();

        students.add(new Student("192424258", "Dharshini"));
        students.add(new Student("192424259", "Student Two"));
        students.add(new Student("192424258", "Dharshini Duplicate"));

        System.out.println("Unique students: " + students.size());
    }
}