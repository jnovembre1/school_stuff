//Made by Joseph Novembre
// 11/17/2023
//For EECS 2500. Project 2



package project_2;

import java.util.*;

public class LSystems {
   
   
    //our data structures
    static Queue<String> queue = new LinkedList<String>();
    static HashMap<String, String> map = new HashMap<String, String>();
    static Scanner scanner = new Scanner(System.in);

    

    //self explanatory, main method where we grab our inputs from user.
    public static void main(String[] args) {

            boolean error = false;
            while (error == false) {
                try {
                    System.out.println("Enter the angle of the L-System: ");
                    int degree = scanner.nextInt(); //useless
                
                    System.out.println("Enter the starting pattern: ");
                    String startPattern = scanner.next();
                    queueBuilder(startPattern);

                
                    System.out.println("Enter the number of rules: ");
                    int rules = scanner.nextInt();
                    String[] rulesArray = buildRules(rules);
                    hashFiller(rulesArray);

                
                    System.out.println("Enter the number of expansions: ");
                    int expansions = scanner.nextInt();
            
                    while (expansions > 0) {
                    
                        expansions = expander(expansions);
                        printOut();
                    }
                }
                catch (Exception e) {
                    error = true;
                    System.out.println("Input mismatch error:, make sure you're using the correct value types for each input. Try running the program again.");
                    
                }
            }
        }



        

    
    
    //prints out queue string by string
   public static void printOut() {
        for (String j : queue) {
            System.out.print(j);
        }
        System.out.print("\n");

   }
    //big method of this program. does all the heavy lifting and logic when it comes to expanding and the like.
    public static int expander(int expansions) {
        String[] queueArray = new String[queue.size()];
        int i = 0;
        for (String j : queue) {
            
            
            String s = map.get(j);
            
            if (s == "-" || s =="$" || s == null) {

            }
            else 
            map.put(s,s + s); //this is terrible for memory management but it works and saved me from having to play around with chars everywhere
            
            if (s != null) {
    
            queueArray[i] = s;
            i++;
            }
            else {
                queueArray[i] = j;
                i++;
            }
            

            
        }
        queue.clear();

        for (int k= 0; k < queueArray.length; k++) {
            queue.add(queueArray[k]);
            
        }
        return expansions -1;
    }

    

    //builds the rules array to be passed to hashFiller method
    public static String[] buildRules(int rules) {
        String[] rulesArray = new String[rules];
        scanner.nextLine();
        for (int i = 0; i < rules; i++) {
            String rule = scanner.nextLine();
            rule = rule.replaceAll("\\s", "");
            rulesArray[i] = rule;
        }
        return rulesArray;
    }
    //fills the hash map with rules
    public static void hashFiller(String[] rulesArray) {
        
        
        for (int i = 0; i < rulesArray.length; i++) {
            String a = Character.toString(rulesArray[i].charAt(0));
            String n = "";

            for (int j = 1; j < rulesArray[i].length(); j++) {
                String b = Character.toString(rulesArray[i].charAt(j));
                n = n += b;
                
                
            
            }
            map.put(a, n);
            
        }

    }
    // adds stuff to queue.
    public static void queueBuilder(String startPattern) {
       for (int i =0; i < startPattern.length(); i++) {
        String s = Character.toString(startPattern.charAt(i));
        queue.add(s);
       }
       
        

    }
    
}
