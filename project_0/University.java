/*
Made by Joseph Novembre
For Linear Data Structures course
9/11/2023

Writing a program that stores and retrieves information related to universities, CRUD processees

*/

import java.util.Scanner;


public class University {
    
    
    private String uniName;
    private String nickName;
    private String uniCity;
    private String uniState;
    private int foundedYear;
    private int studentBodySize;


    public static void main(String args[]) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Welcome to this University Collection program, please type 'help' for a list of commands.");
        String userInput = myScanner.nextLine();

        if (userInput.equals("help")) 
        System.out.println("The commands are, list, exit, add, delete, search, save, and help");
        else;

        
        University u1 = new University();
        String userUniName = myScanner.nextLine();
        u1.setUniName(userUniName);
        System.out.print(u1.uniName);


    }


    

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String newUniName) {
        this.uniName = newUniName;
    }
}