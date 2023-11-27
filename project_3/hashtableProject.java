package project_3;

import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;

public class hashtableProject {
    
    static File file = new File ("/Users/localadmin/school_code/project_3/gatsby.txt");
    static Hashtable<Integer, String>[] table = new Hashtable[1091];

    
    public static void main(String[] args) {
        populateTable();
        fileReader();
        tableData();
        
    }


    public static void populateTable() {
        for (int i = 0; i < table.length; i++) {
            table[i] = new Hashtable<>();
        }
    }

    public static void tableData() {
        int w = 0;
        for (int i = 0; i < table.length; i++) {
            w+= table[i].size();
        }

        for (Hashtable<Integer,String> a : table) {
            for (String s : a.values()) {
                System.out.println(s);
            }
        }
        System.out.println("Total words: " + w);

    }

    public static void fileReader () {
        try {
            Scanner scanner = new Scanner(
                new BufferedReader(
                    new FileReader(file)));
            while (scanner.hasNext()) {
                String s = scanner.next();
                s = s.toLowerCase();
                s = s.replaceAll("^[^a-zA-Z]+", "");
                s = s.replaceAll("[^a-zA-Z]+$", "");

                int index = Math.abs(s.hashCode()) % 1091;
                                    table[index].put(s.hashCode(),s);

                /*if (!table[index].containsKey(s.hashCode())) {
                    

                    table[index].put(s.hashCode(),s);
                }*/
                
            }
        }
        catch (FileNotFoundException e) {
        }
    }
}