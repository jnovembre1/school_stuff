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
        boolean exit = true;
        
        while (exit == true)
        {
                String userInput = myScanner.nextLine();

            if (userInput.equals("help")) 
                System.out.println("The commands are, list, exit, add, delete, search, save, and help");
            else if (userInput.equals("add")) {
            
                String userUniName = getInput();
                String userNick = myScanner.nextLine();
                String userCity = myScanner.nextLine();
                String userState = myScanner.nextLine();
                int userYear = myScanner.nextInt();
                int userBodySize = myScanner.nextInt();
                System.out.println("Inputs succesfully registered");
            
                University u = new University(userUniName, userNick, userCity, userState, userYear,userBodySize);
                System.out.println(u.getUniName());
                System.out.println(u.getNickName());

            
        } 
            else if (userInput.equals("exit")) {

                System.out.println("Thanks for using this program.");
                exit = false;
            }
            else;
        }
        

        
        


    }

    public University (String uniName, String nickName, 
    String uniCity, String uniState, int foundedYear, int studentBodySize) {
        setUniName(uniName);
        setNickName(nickName);
        uniCity = getUniCity();
        uniState = getUniState();
        foundedYear = getFoundedYear();
        studentBodySize = getStudentSize();
    }

    public static String getInput() {
        Scanner myScanner = new Scanner(System.in);
        return myScanner.nextLine();
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