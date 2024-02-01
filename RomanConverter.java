// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;

class RomanConverter {
    
    static String converter(int number) {
        // Create a table with the factorization of the number
        int[] nbOf = createTable(number);
        String roman = ""; 

        // As the number of M doesn't depend on anything else, just add all the needed "M" according to table
        roman = addNTimes(roman, nbOf[6], "M");

        // In a Roman number, we cannot have "CCCC" thus if there are more than 4 "C" we need to change it
        if (nbOf[4] >= 4) {
            // If there is a "D" after these 4 "C" (ex: 900), add the correct form "CM" (900) to the String
            if (nbOf[5] >= 1) {
                roman += "CM";
            }
            // If there is no "D" (ex: 400), add the correct form "CD" (400) to the String
            else {
                roman += "CD";
            }
        }
        // If there are less than 4 "C", the letters don't need to be changed
        // Just add the letters according to the table
        else {
            roman = addNTimes(roman, nbOf[5], "D");
            roman = addNTimes(roman, nbOf[4], "C");
        }

        // We cannot have "XXXX" thus if there are more than 4 "X" we need to change it
        if (nbOf[2] >= 4) {
            // If there is a "L" after these 4 "X" (ex: 90), add the correct form "XC" (900) to the String
            if (nbOf[3] >= 1) {
                roman += "XC";
            }
            // If there is no "L" (40), add the correct form "XL" (40) to the String
            else {
                roman += "XL";
            }
        }
        // If there are less than 4 "X", the letters don't need to be changed
        // Just add the letters according to the table
        else {
            roman = addNTimes(roman, nbOf[3], "L");
            roman = addNTimes(roman, nbOf[2], "X");
        }
        
        // We cannot have "IIII" thus if there are more than 4 "I" we need to change it
        if (nbOf[0] >= 4) {
            // If there is a "V" after these 4 "I" (ex: 9), add the correct form "IX" (9) to the String
            if (nbOf[1] >= 1) {
                roman += "IX";
            }
            // If there is no "V" (4), add the correct form "IV" (4) to the String
            else {
                roman += "IV";
            }
        }
        // If there are less than 4 "I", the letters don't need to be changed
        // Just add the letters according to the table
        else {
            roman = addNTimes(roman, nbOf[1], "V");
            roman = addNTimes(roman, nbOf[0], "I");
        }
        
        return roman;
    }
    
    static String addNTimes(String roman, int n, String letter) {
        // Add the letter n times to the String
        for (int i=0; i<n; i++) {
            roman += letter;
        }
        return roman;
    }
    
    static int[] createTable(int number) {
        // Decompose the number into I (1), V (5), X (10), L (50), C (100), D (500), M (1000)
        int[] nbOf = {0,0,0,0,0,0,0};
        nbOf[6] = number / 1000;
        number -= (number / 1000)*1000;
        nbOf[5] = number / 500; 
        number -= (number / 500)*500;
        nbOf[4] = number / 100;
        number -= (number / 100)*100;
        nbOf[3] = number / 50; 
        number -= (number / 50)*50;
        nbOf[2] = number / 10;
        number -= (number / 10)*10;
        nbOf[1] = number / 5; 
        number -= (number / 5)*5;
        nbOf[0] = number / 1; 
        number -= number / 1;
        return nbOf;
    }
    
    public static void main(String[] args) {
        // Create scanner, won't close it because tied to System.in
        // Won't be able to use System.in later if closed
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Enter number: ");
            try {
                // Read the entered number, check if not too large
                int number = sc.nextInt();
                if (number > 100000) {
                    System.out.println("Please enter a smaller number.");
                    continue;
	            }
	            // Convert the number and print the roman conversion
                System.out.println(converter(number));
                System.out.println();
            }
            // Catch the potential exceptions (ex: entered String instead of int)
            catch(Exception e) {
                System.out.println("Something went wrong, please try again.");
                sc.nextLine();
            }
        }
    }
}