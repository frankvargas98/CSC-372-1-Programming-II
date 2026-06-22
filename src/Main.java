import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // Storing 10 custom student objects
        students.add(new Student(105, "Zachary", "123 Aspen St"));
        students.add(new Student(101, "Alice", "789 Maple Ave"));
        students.add(new Student(110, "Oliver", "456 Oak Rd"));
        students.add(new Student(103, "Charlie", "321 Pine Ln"));
        students.add(new Student(102, "Bob", "654 Birch Dr"));
        students.add(new Student(107, "Fiona", "987 Cedar Ct"));
        students.add(new Student(104, "Diana", "159 Elm St"));
        students.add(new Student(109, "Hannah", "753 Willow Way"));
        students.add(new Student(106, "Evan", "852 Spruce Rd"));
        students.add(new Student(108, "George", "246 Cherry Dr"));

        System.out.println("================ ORIGINAL UNORDERED LIST ================");
        printList(students);

        // Sorts by Name
        System.out.println("\n================ SORTED BY NAME (A-Z) ================");
        CustomSort.selectionSort(students, new NameComparator());
        printList(students);

        // Sorts by Roll Number
        System.out.println("\n================ SORTED BY ROLL NUMBER ================");
        CustomSort.selectionSort(students, new RollNoComparator());
        printList(students);
    }

    // Helper method
    private static void printList(ArrayList<Student> list) {
        for (Student s : list) {
            System.out.println(s);
        }
    }
}