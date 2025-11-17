package services;

import models.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Course> courses;
    private ArrayList<Enrollment> enrollments;

    public StudentManager() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        courses = new ArrayList<>();
        enrollments = new ArrayList<>();
    }

    // ==================== Students ====================
    public void addStudent(Scanner scanner) {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        Student student = new Student(name, age, id);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("=== Students List ===");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // ==================== Courses ====================
    public void addCourse(Scanner scanner) {
        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Course ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Credit Hours: ");
        int ch = Integer.parseInt(scanner.nextLine());

        Course course = new Course(id, name, ch);
        courses.add(course);
        System.out.println("Course added successfully!");
    }

    // ==================== Enrollment ====================
    public void enrollStudent(Scanner scanner) {
        if (students.isEmpty() || courses.isEmpty()) {
            System.out.println("Add students and courses first!");
            return;
        }

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        Course course = findCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found!");
            return;
        }

        Enrollment enrollment = new Enrollment(student, course);
        enrollments.add(enrollment);
        System.out.println("Enrollment successful!");
    }

    public void listEnrollments() {
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments available.");
        } else {
            System.out.println("=== Enrollments ===");
            for (Enrollment e : enrollments) {
                System.out.println(e);
            }
        }
    }

    // ==================== Helper Methods ====================
    private Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getStudentId().equals(id)) return s;
        }
        return null;
    }

    private Course findCourseById(String id) {
        for (Course c : courses) {
            if (c.getCourseId().equals(id)) return c;
        }
        return null;
    }
}
