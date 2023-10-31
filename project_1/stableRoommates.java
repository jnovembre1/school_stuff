package project_1;
import java.io.*;
import java.util.ArrayList;



public class stableRoommates {
    
    static ArrayList<peopleFile> peopleList = new ArrayList<>();

    
    public static void main (String args[]) {
    
        System.out.println("Enter the number of people. This value will be multiplied by 2 and must be an even number.");
        int people = peopleFile.getNumberPeople();
        people = 2*(peopleFile.oddCheck(people));

        
        peopleList = peopleFile.generatePeople(people);

        System.out.println(peopleList);
        
    }

}
    


