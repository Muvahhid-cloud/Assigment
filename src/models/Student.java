package models;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    // Static variable to keep track of the next student ID
    private static int idCounter = 1;

    // Instance variables for student ID and grades
    private int studentID;
    private List<Integer> grades;

    // Constructor to initialize a Student object
    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = idCounter++;
        this.grades = new ArrayList<>();
    }

    // Method to add a grade to the student's grade list
    public void addGrade(int grade) {
        grades.add(grade);
    }

    // Method to calculate the GPA of the student
    public double calculateGPA() {
        // List to store GPA values corresponding to numerical grades
        ArrayList<Double> gradesGpa = new ArrayList<>();

        // Convert numerical grades to GPA scale
        for (int i = 0; i < grades.size(); i++) {
            // Convert each grade to GPA and add to the list
            gradesGpa.add((grades.get(i) >= 60) ? Math.max(0, Math.min(4.0, 4.0 - 3.0 * (100 - grades.get(i)) / 40.0)) : 0.0);
        }

        // Return 0.0 if there are no grades
        if (gradesGpa.isEmpty()) return 0.0;

        // Calculate the total GPA
        double total = 0;
        for (double grade : gradesGpa) {
            total += grade;
        }

        // Return the average GPA
        return total / grades.size();
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ".";
    }
}
