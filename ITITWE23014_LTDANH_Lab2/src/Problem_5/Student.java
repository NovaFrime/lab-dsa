package Problem_5;

import java.util.Random;

public class Student {
    private String fname, lname;
    private int grade;

    public Student(String fname, String lname, int grade) {
        this.fname = fname;
        this.lname = lname;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return fname + " " + lname + "\t" + grade;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getGrade() {
        return grade;
    }

    public static void bubbleSortByFirstName(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getFname().compareTo(students[j + 1].getFname()) > 0) {

                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortByLastName(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getLname().compareTo(students[j + 1].getLname()) > 0) {

                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortByGrade(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getGrade() > students[j + 1].getGrade()) {

                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        String[] firstNames = {"John", "Jane", "Bob", "Alice", "Charlie", "Diana", "Eve", "Frank", "Grace", "Hank"};
        String[] lastNames = {"Smith", "Doe", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Wilson", "Moore"};
        Student[] students = new Student[10];

        for (int i = 0; i < students.length; i++) {
            String fname = firstNames[rand.nextInt(firstNames.length)];
            String lname = lastNames[rand.nextInt(lastNames.length)];
            int grade = rand.nextInt(101);
            students[i] = new Student(fname, lname, grade);
        }

        System.out.println("Before sorting:");
        for (Student student : students) {
            System.out.println(student);
        }

        bubbleSortByFirstName(students);
        System.out.println("\nSorted by first name:");
        for (Student student : students) {
            System.out.println(student);
        }

        bubbleSortByLastName(students);
        System.out.println("\nSorted by last name:");
        for (Student student : students) {
            System.out.println(student);
        }

        bubbleSortByGrade(students);
        System.out.println("\nSorted by grade:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}