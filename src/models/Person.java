package models;

public abstract class Person {
    // Instance variables for name, surname, age, and gender
    private String name;
    private String surname;
    private int age;
    private boolean gender; // true = Male, false = Female

    // Constructor to initialize a Person object
    public Person(String name, String surname, int age, boolean gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    // Getter method for name
    public String getName() { return name; }

    // Getter method for surname
    public String getSurname() { return surname; }

    // Getter method for age
    public int getAge() { return age; }

    // Getter method for gender
    public boolean isMale() { return gender; }

    // Setter method for name
    public void setName(String name) { this.name = name; }

    // Setter method for surname
    public void setSurname(String surname) { this.surname = surname; }

    // Setter method for age
    public void setAge(int age) { this.age = age; }

    // Setter method for gender
    public void setGender(boolean gender) { this.gender = gender; }

    // Override the toString method to provide a string representation of the person
    @Override
    public String toString() {
        String genderString = gender ? "Male" : "Female";
        return "Hello, I am " + name + " " + surname + ", a " + age + " year old " + genderString + "!";
    }
}