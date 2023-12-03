/*
Made by Joseph Novembre
For Linear Data Structures course
9/20/2023

Writing a program that stores and retrieves information related to universities, CRUD processees

*/

import java.util.Scanner;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
public class University {
    
    //collection the objects are stored into
    public static Collection<University> col = new ArrayList<University>();
   
    //all the variable for the class and objects
    private String uniName;
    private String nickName;
    private String uniCity;
    private String uniState;
    private int foundedYear;
    private int studentBodySize;


    //main method that introduces to program and grabs userinput so other methods can handle everything
    public static void main(String args[]) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Welcome to this University Collection program, please type 'help' for a list of commands.");
        while (true)
        {
                String userInput = myScanner.nextLine();
                programLoop(userInput);            
        }
        

        

    }
    
    //method associated with user inputting list into program
    public static void listCommand() {
        for (University u : col) {
            System.out.println(u.uniName);
        }
    }
    
    //method associated with user inputting help into program
    public static void helpCommand() {
        System.out.println("The commands are list, exit, add, delete, search, save, and help");
    }

    //method associated with user inputting the exit command into program, exits program
    public static void exitCommand() {
        System.exit(0);
    }

    //when called by user, allows user to add a new University object to collection
    public static void addCommand() {
        
        boolean duplicate = false;
        System.out.println("Enter the name of the University.");
        String userUniName = getInput();
        for (University u : col) //this loop checks to see if university being inputted is unique or not
        {
            if (u.uniName.toLowerCase().contains(userUniName.toLowerCase())) {
            System.out.println("Error, university already in list");
            duplicate = true;
            }
            else;
        }
        if (duplicate == false) {
        System.out.println("Enter the Universitys nickname.");
        String userNick = getInput();

        System.out.println("Enter the Universitys City.");
        String userCity = getInput();

        System.out.println("Enter the Universitys State.");
        String userState = getInput();

        System.out.println("Enter the year the University was founded.");
        int userYear = getInputInt();

        System.out.println("Enter the Universitys student body size.");
        int userBodySize = getInputInt();
        System.out.println("Inputs succesfully registered, please enter another command.");

        University u = new University(userUniName, userNick, userCity, userState, userYear,userBodySize);
        col.add(u);
        }
    }

    //method user can call to save info of all objects in collection to a .txt file
    public static void saveCommand() {
        try {
        FileWriter myFile = new FileWriter("dump.txt");
        for (University u : col) {
            myFile.write(u.uniName + "," + u.nickName + "," + u.uniCity + "," + u.uniState + "," + u.foundedYear
             + "," + u.studentBodySize + "\n");
        }
        myFile.close();
        System.out.println("Succesfully saved the Universities and their info to a file");
        } catch (IOException e ) {
            e.printStackTrace();
            
        }
        
    }
    
    //method user can call to delete a object from the collection
    public static void deleteCommand() {
        System.out.println("Enter the Universitys name or nickname you'd like to delete.");
        String userInput = getInput();
        
        
        List<University> removeList = new ArrayList<University>(); //2nd list so I can iterate and remove from array
        //without throwing exception
        
        for (University u : col) {
            if (u.uniName.toLowerCase().contains(userInput.toLowerCase())) {
                System.out.println("Matching University found, deleting " + userInput + " from collection.");

                removeList.add(u);
             }
             else;
             

        }
        if (removeList.size() == 0) {
            System.out.println("No matching University found, please input another command.");
        }
         col.removeAll(removeList);


    }

    //method user can call to search for specific university by name or nickname in collection
    public static void searchCommand() {
        String userInput = getInput();
        boolean isFound = false;
        for (University u : col) {
            if (u.uniName.toLowerCase().contains(userInput.toLowerCase()) ||
                u.nickName.toLowerCase().contains(userInput.toLowerCase())) {
                isFound = true;

             }
             else;
            }
        if (isFound == true)
        System.out.println("Matching University found.");
        else
        System.out.println("Matching University not found.");

    }

    //main program method that calls all other command methods.
    public static void programLoop(String userInput) {
        
        
        if (userInput.equals("help"))
        helpCommand();
        else if (userInput.equals("add"))
        addCommand();
        else if (userInput.equals("exit"))
        exitCommand();
        else if (userInput.equals("save"))
        saveCommand();
        else if (userInput.equals("delete"))
        deleteCommand();
        else if (userInput.equals("search"))
        searchCommand();
        else if (userInput.equals("list"))
        listCommand();
        else
        System.out.println("No valid input registered, please try again.");
    }

    //constructor that holds and sets everything.
    public University (String uniName, String nickName, 
    String uniCity, String uniState, int foundedYear, int studentBodySize) {
        setUniName(uniName);
        setNickName(nickName);
        setUniCity(uniCity);
        setUniState(uniState);
        setFoundedYear(foundedYear);
        setStudentSize(studentBodySize);
    }

    //everything below this point are the getters and setters, self explanatory 
    
    public static String getInput() {
        Scanner myScanner = new Scanner(System.in);
        return myScanner.nextLine();
    }

    public static int getInputInt() {
        int value = 0;
        boolean inputValid = true;
        
        // while loop that catches if user trying to throw a string into an int. will make
        //user keep trying until they input an integer
        while (inputValid == true) {
            try {
                    Scanner myScanner = new Scanner(System.in);
                    value = myScanner.nextInt();
                    inputValid = false;
        }
            catch (InputMismatchException e) {
                    System.out.println("Invalid input, please only enter numbers.");
        }
        }
        return value;

        
    }
    
    public String getUniName() {
        return uniName;
    }

    public void setUniName(String newUniName) {
        this.uniName = newUniName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String newNickName) {
        this.nickName = newNickName;
    }

    public String getUniCity() {
        return uniCity;
    }

    public void setUniCity(String newUniCity) {
        this.uniCity = newUniCity;
    }

    public String getUniState() {
        return uniState;
    }

    public void setUniState(String newUniState) {
        this.uniState = newUniState;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(int newFoundedYear) {
        this.foundedYear = newFoundedYear;
    }

    public int getStudentSize() {
        return studentBodySize;
    }

    public void setStudentSize(int newStudentSize) {
        this.studentBodySize = newStudentSize;
    }
}