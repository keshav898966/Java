package task2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters for the fields
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    // Setter for updating marks (useful for an update function)
    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Setter for updating name
    public void setName(String name) {
        this.name = name;
    }

    // Overriding toString() for easy printing of student details
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + String.format("%.2f", marks);
    }
}

/**
 * Main class for the Student Record Management System.
 * Handles the CLI, student list, and CRUD operations.
 */
public class StudentList {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        while (true) {
            displayMenu();
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewAllStudents();
                        break;
                    case 3:
                        updateStudent();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        System.out.println("Exiting the application. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        }
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("\n--- Student Record Management System ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student Record");
        System.out.println("4. Delete Student Record");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Adds a new student record to the list.
     */
    private static void addStudent() {
        try {
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Check if student ID already exists
            if (findStudentById(id) != null) {
                System.out.println("Error: A student with this ID already exists. Please use a unique ID.");
                return;
            }

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            studentList.add(new Student(id, name, marks));
            System.out.println("Student added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data for ID and marks.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    /**
     * Prints all student records currently in the list.
     */
    private static void viewAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n--- All Student Records ---");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    /**
     * Updates an existing student's name and/or marks by their ID.
     */
    private static void updateStudent() {
        try {
            System.out.print("Enter the ID of the student to update: ");
            int idToUpdate = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Student studentToUpdate = findStudentById(idToUpdate);

            if (studentToUpdate == null) {
                System.out.println("Student with ID " + idToUpdate + " not found.");
                return;
            }

            System.out.println("Student found: " + studentToUpdate);
            System.out.print("Enter new name (leave blank to keep current): ");
            String newName = scanner.nextLine();
            if (!newName.isBlank()) {
                studentToUpdate.setName(newName);
            }

            System.out.print("Enter new marks (-1 to keep current): ");
            double newMarks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            if (newMarks >= 0) {
                studentToUpdate.setMarks(newMarks);
            }

            System.out.println("Student record updated successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number for the ID and marks.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    /**
     * Deletes a student record by their ID.
     */
    private static void deleteStudent() {
        try {
            System.out.print("Enter the ID of the student to delete: ");
            int idToDelete = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Student studentToDelete = findStudentById(idToDelete);

            if (studentToDelete != null) {
                studentList.remove(studentToDelete);
                System.out.println("Student with ID " + idToDelete + " deleted successfully.");
            } else {
                System.out.println("Student with ID " + idToDelete + " not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number for the ID.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    /**
     * Helper method to find a student by their ID.
     * @param id The ID to search for.
     * @return The Student object if found, otherwise null.
     */
    private static Student findStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
