/*
Made by Joseph Novembre
For Linear Data Structures course
9/11/2023

Writing a program that stores and retrieves information related to universities, CRUD processees

*/

import java.util.Scanner;
import java.util.*;

public class University {
    
    
    public static Collection<University> col = new ArrayList<University>();
   
    private String uniName;
    private String nickName;
    private String uniCity;
    private String uniState;
    private int foundedYear;
    private int studentBodySize;


    public static void main(String args[]) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Welcome to this University Collection program, please type 'help' for a list of commands.");
        while (true)
        {
                String userInput = myScanner.nextLine();
                programLoop(userInput);            
                System.out.println(col);
        }
        

        

    }
    
    public static void helpCommand() {
        System.out.println("The commands are, list, exit, add, delete, search, save, and help");
    }

    public static void exitCommand() {
        System.exit(0);
    }

    public static void addCommand() {
        
        boolean duplicate = false;
        System.out.println("Enter the name of the University.");
        String userUniName = getInput();
        for (University u : col)
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
        System.out.println("Inputs succesfully registered");

        University u = new University(userUniName, userNick, userCity, userState, userYear,userBodySize);
        col.add(u);
        }
    }

    public static void programLoop(String userInput) {
        
        
        if (userInput.equals("help"))
        helpCommand();
        else if (userInput.equals("add"))
        addCommand();
        else if (userInput.equals("exit"))
        exitCommand();
    }

    public University (String uniName, String nickName, 
    String uniCity, String uniState, int foundedYear, int studentBodySize) {
        setUniName(uniName);
        setNickName(nickName);
        setUniCity(uniCity);
        setUniState(uniState);
        setFoundedYear(foundedYear);
        setStudentSize(studentBodySize);
    }

    public static String getInput() {
        Scanner myScanner = new Scanner(System.in);
        return myScanner.nextLine();
    }

    public static int getInputInt() {
        Scanner myScanner = new Scanner(System.in);
        return myScanner.nextInt();
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