package project_2;

import java.util.*;
import java.util.Scanner;

public class LSystems {
    static Queue<Character> queue = new LinkedList<Character>();
    static HashMap<Character, String> map = new HashMap<Character, String>();
    static Scanner scanner = new Scanner(System.in);

    


    public static void main(String[] args) {

        System.out.println("Enter the angle of the L-System: ");
        int degree = scanner.nextInt();
        
        System.out.println("Enter the starting pattern: ");
        String startPattern = scanner.next();
        queueBuilder(startPattern);

        
        System.out.println("Enter the number of rules: ");
        int rules = scanner.nextInt();
        String[] rulesArray = buildRules(rules);
        hashFiller(rulesArray);

        
        System.out.println("Enter the number of expansions: ");
        int expansions = scanner.nextInt();
        specialChar(expansions);

        

        while (expansions > 0) {

        }




        

    
    }

    
    
    public static String[] buildRules(int rules) {
        String[] rulesArray = new String[rules];
        for (int i = 0; i < rules; i++) {
            String rule = scanner.next();
            rulesArray[i] = rule;
        }
        return rulesArray;
    }

    public static void hashFiller(String[] rulesArray) {
        for (int i = 0; i < rulesArray.length; i++) {
            map.put(rulesArray[i].charAt(0), rulesArray[i]);
        }

    }

    public static void queueBuilder(String startPattern) {
       for (int i =0; i < startPattern.length(); i++) {
        char c = startPattern.charAt(i);
        queue.add(c);
       }
       
        

    }
    public static void specialChar(int expansions) {
        if (expansions > 0)
        queue.add('$');
        else;

    }
}
