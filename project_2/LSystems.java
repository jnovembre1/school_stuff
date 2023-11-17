package project_2;

import java.util.*;

public class LSystems {
    static Queue<String> queue = new LinkedList<String>();
    static HashMap<String, String> map = new HashMap<String, String>();
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
       
        while (expansions > 0) {
            
            expansions = expander(expansions);
            printOut();
            
        }
        



        

    
    }

   public static void printOut() {
        for (String j : queue) {
            System.out.print(j);
        }
        System.out.print("\n");

   }
   
    public static int expander(int expansions) {
        String[] queueArray = new String[queue.size()];
        int i = 0;
        for (String j : queue) {
            
            
            String s = map.get(j);
            
            if (s == "-" || s =="$" || s == null) {

            }
            else 
            map.put(s,s + s);
            
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

    public static void hashFiller(String[] rulesArray) {
        
        
        for (int i = 0; i < rulesArray.length; i++) {
            String a = Character.toString(rulesArray[i].charAt(0));
            String n = "";

            for (int j = 1; j < rulesArray[i].length(); j++) {
                String b = Character.toString(rulesArray[i].charAt(j));
                n = n += b;
                
                
            
            }
            map.put(a, n);
            map.put("-","-");
        }

    }

    public static void queueBuilder(String startPattern) {
       for (int i =0; i < startPattern.length(); i++) {
        String s = Character.toString(startPattern.charAt(i));
        queue.add(s);
       }
       
        

    }
    
}
