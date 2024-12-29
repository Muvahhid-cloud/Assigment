import models.School;
import models.Student;
import models.Teacher;
import models.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new instance of the School class
        School school = new School();

        // Create a File object for the Students.txt file
        File studentFile = new File("src/models/Students.txt");

        // Create a Scanner object to read from the Students.txt file
        Scanner studentScanner = new Scanner(studentFile);

        // Read each line from the Students.txt file
        while (studentScanner.hasNextLine()) {
            // Split the line into an array of strings using space as the delimiter
            String[] data = studentScanner.nextLine().split(" ");
            String name = data[0];
            String surname = data[1];
            int age = Integer.parseInt(data[2]);
            boolean gender = data[3].equalsIgnoreCase("male");

            Student student = new Student(name, surname, age, gender);
            for (int i = 4; i < data.length; i++) {
                student.addGrade(Integer.parseInt(data[i]));
            }
            school.addMember(student);
        }
        studentScanner.close();

        File teachersFile = new File("src/models/Teachers.txt");
        Scanner teacherScanner = new Scanner(teachersFile);
        // Process each line in the teacher data file
        while (teacherScanner.hasNextLine()) {
            // Split the line into an array of strings
            String[] data = teacherScanner.nextLine().split(" ");

            // Extract teacher details from the array
            String name = data[0];
            String surname = data[1];
            int age = Integer.parseInt(data[2]);
            boolean gender = data[3].equalsIgnoreCase("male");
            String subject = data[4];
            int experience = Integer.parseInt(data[5]);
            int salary = Integer.parseInt(data[6]);

            // Create a new Teacher object with the extracted details
            Teacher teacher = new Teacher(name, surname, age, gender, subject, experience, salary);

            // Give a raise if the teacher has more than 10 years of experience
            if (experience > 10) {
                teacher.giveRaise(10);
            }

            // Add the teacher to the school
            school.addMember(teacher);
        }
        teacherScanner.close(); // Close the teacher scanner

// Print the details of the school
        System.out.println(school);
        System.out.println();

// Iterate through the members of the school and print their details
        for (Person member : school.getMembers()) {
            System.out.println(); // Add space between members

            if (member instanceof Student) {
                Student student = (Student) member;
                System.out.println(student.getName() + " GPA: " + student.calculateGPA());
            } else if (member instanceof Teacher) {
                Teacher teacher = (Teacher) member;
                System.out.println(teacher.getName() + " Salary after raise: " + teacher.getSalary());
            }
        }
    }
}