package misc_stuff;


import java.util.Scanner;

public class FirstGUI {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int stepSize = scan.nextInt();
        
        
        if (stepSize < 1) {
            while (stepSize < 1) {
                System.out.println("Step size must be greater than or equal to one.");
                stepSize = scan.nextInt();
            }
        }
        
        int upperLimit = scan.nextInt();
        if (upperLimit < 1) {
            while (upperLimit < 1) {
                System.out.println("Upper limit value must be greather than 0");
                upperLimit = scan.nextInt();
            }
        }
        
        
        
        int num = 0;
        
        while (num < upperLimit) {
            System.out.println(num = stepSize + num);
        
        }

    }
    
}