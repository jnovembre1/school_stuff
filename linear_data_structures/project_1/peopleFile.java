package project_1;
import java.util.Scanner;
import java.util.ArrayList;

public class peopleFile {
    private int pref1;
    private int pref2;
    private int pref3;
    
    
    static Scanner peopleScanner = new Scanner(System.in);

    public peopleFile (int pref1, int pref2, int pref3) {
        this.pref1 = pref1;
        this.pref2 = pref2;
        this.pref3 = pref3;
    }
    
    public static int getNumberPeople() {
        
        int people = peopleScanner.nextInt();
        return people;

    }


    public static int oddCheck(int people) {
        boolean run = true;
        while (run == true) {
            if (people % 2 != 0) {
                System.out.println("You entered an odd number, try again.");
                people = getNumberPeople();
            }
            else
                run = false;

        }
        return people;
    }

    public static ArrayList generatePeople(int people) {
        ArrayList<peopleFile> peopleList = new ArrayList<>();

        for (int i = 0; i < people; i++) {
            
            int pref1 = peopleScanner.nextInt();
            int pref2 = peopleScanner.nextInt();
            int pref3 = peopleScanner.nextInt();
            
            peopleFile p1 = new peopleFile (pref1, pref2, pref3);
            peopleList.add(p1);
        }
        return peopleList;
    }

    public int getPref1() {
        return pref1;
    }

    public int getPref2() {
        return pref2;
    }

    public int getPref3() {
        return pref3;
    }
}


