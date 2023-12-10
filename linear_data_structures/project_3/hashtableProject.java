//made by Joseph Novembre
//Project 3 for EECS2500 
//12/02/2023

package project_3;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class hashtableProject {

    static File file = new File("/Users/localadmin/school_code/linear_data_structures/project_3/gatsby.txt");
    static LinkedList<Entry>[] table = new LinkedList[1091];

    public static void main(String[] args) {
        populateTable();
        fileReader();
        tableData();
    }

    public static void populateTable() {   //populates table
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public static void tableData() {    //prints info from table
        int w = 0;
        for (int i = 0; i < table.length; i++) {
            w += table[i].size();
        }

        for (LinkedList<Entry> bucket : table) {
            for (Entry entry : bucket) {
                System.out.println(entry.value);
            }
        }
        System.out.println("Total words: " + w);
    }

    public static void fileReader() {   //reads in from txt file
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)));
            while (scanner.hasNext()) {
                String s = scanner.next();
                s = s.toLowerCase();
                s = s.replaceAll("^[^a-zA-Z]+", "");
                s = s.replaceAll("[^a-zA-Z]+$", "");

                int index = Math.abs(s.hashCode()) % 1091;
                Entry entry = new Entry(s);

                LinkedList<Entry> collisionList = table[index]; //collision handling with linkedlist
                boolean found = false;

                for (Entry existingEntry : collisionList) { //checks if already in list
                    if (existingEntry.equals(entry)) {
                        found = true;
                        break;
                    }
                }

                if (!found) {                       //self explanatory
                    collisionList.add(entry);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class Entry {   //class to handle words as Entry objects
        String value;

        Entry(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Entry entry = (Entry) obj;
            return value.equals(entry.value);
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }
    }
}

