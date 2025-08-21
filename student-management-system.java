package com.StudentManagement;
import java.util.*;

// 🔹 Abstraction
abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method (must be implemented by subclasses)
    public abstract void displayInfo();
}

// 🔹 Inheritance + Encapsulation
class Student extends Person {
    private int rollNo;
    private String grade;
    private List<String> subjects;

    public Student(int rollNo, String name, String grade, List<String> subjects) {
        super(name); // Person constructor
        this.rollNo = rollNo;
        this.grade = grade;
        this.subjects = subjects;
    }

    // Getters & Setters (Encapsulation)
    public int getRollNo() { return rollNo; }
    public String getGrade() { return grade; }
    public List<String> getSubjects() { return subjects; }

    public void setGrade(String grade) { this.grade = grade; }
    public void setSubjects(List<String> subjects) { this.subjects = subjects; }

    // 🔹 Polymorphism (method overriding)
    @Override
    public void displayInfo() {
        System.out.println("Roll No: " + rollNo +
                ", Name: " + getName() +
                ", Grade: " + grade +
                ", Subjects: " + subjects);
    }
}

// 🔹 Another type of Person (for Inheritance demo)
class Teacher extends Person {
    private String subject;

    public Teacher(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    @Override
    public void displayInfo() {
        System.out.println("Teacher Name: " + getName() + ", Subject: " + subject);
    }
}

// 🔹 Main Management System
public class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // Add student
    public void addStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        sc.nextLine();
        List<String> subjects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter subject " + (i + 1) + ": ");
            subjects.add(sc.nextLine());
        }

        students.add(new Student(roll, name, grade, subjects));
        System.out.println("✅ Student added successfully!\n");
    }

    // Add teacher
    public void addTeacher() {
        System.out.print("Enter Teacher Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Subject: ");
        String subject = sc.nextLine();

        teachers.add(new Teacher(name, subject));
        System.out.println("✅ Teacher added successfully!\n");
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠ No student records found.");
        } else {
            for (Student s : students) {
                s.displayInfo(); // Polymorphism
            }
        }
    }

    // Display all teachers
    public void displayTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("⚠ No teacher records found.");
        } else {
            for (Teacher t : teachers) {
                t.displayInfo(); // Polymorphism
            }
        }
    }

    // Menu-driven application (Loops + Control Structures)
    public void start() {
        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Display Students");
            System.out.println("4. Display Teachers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addTeacher();
                case 3 -> displayStudents();
                case 4 -> displayTeachers();
                case 5 -> {
                    System.out.println("👋 Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.start();
    }
}
