import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCgpa() {
        return cgpa;
    }
}

public class Java_Sort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = in.nextInt();
            String name = in.next();
            double cgpa = in.nextDouble();
            studentList.add(new Student(id,name,cgpa));
        }

        insertionSort(studentList);
        for (Student student : studentList) {
            System.out.println(student.getName());
        }
    }

    static boolean comesBefore(Student a, Student b) {
        int c = Double.compare(a.getCgpa(), b.getCgpa());
        if (c != 0) {
            return c > 0;  // Better cgpa -> Stands before
        }
        int nameCmp = a.getName().compareTo(b.getName());
        if (nameCmp != 0) {
            return nameCmp < 0; // Smaller name -> Stands before
        }
        return a.getId() < b.getId(); // Smaller id -> Stands before
    }

    static void insertionSort(List<Student> list) {
        for (int i = 1; i < list.size(); i++) {
            Student temp = list.get(i);
            int j = i - 1;
            while (j >= 0 && comesBefore(temp, list.get(j))) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, temp);
        }
    }
}