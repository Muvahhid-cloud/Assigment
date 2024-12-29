package models;

import java.util.ArrayList;
import java.util.List;

public class School {
    // List to store members of the school
    private List<Person> members;

    // Constructor to initialize the members list
    public School() {
        members = new ArrayList<>();
    }

    // Method to add a member to the school
    public void addMember(Person person) {
        members.add(person);
    }

    // Method to get a member of the school by index
    public Person getSchool(int i) {
        return members.get(i);
    }

    // Method to get the list of all members in the school
    public List<Person> getMembers() {
        return members;
    }

    // Override the toString method to provide a string representation of the school
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person member : members) {
            sb.append(member.toString()).append("\n");
        }
        return sb.toString();
    }
}