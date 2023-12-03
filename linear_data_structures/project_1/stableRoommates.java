package project_1;
import java.io.*;
import java.util.ArrayList;
import java.util.Stack;



public class stableRoommates {
    
    static ArrayList<peopleFile> peopleList = new ArrayList<>();
    static Stack<roomFile> stack = new Stack<roomFile>();
    static ArrayList<roomFile> roomList = new ArrayList<>();
    
    public static void main (String args[]) {
    
        System.out.println("Enter the number of people. This value must be an even number.");
        int people = peopleFile.getNumberPeople();
        people = (peopleFile.oddCheck(people));

        System.out.println("Enter the roommate preferences for your people.");
        peopleList = peopleFile.generatePeople(people);

        
        
    }

    
}    


