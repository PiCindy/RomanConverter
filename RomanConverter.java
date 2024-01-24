// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;

class RomanConverter {
    
    static String converter(int number) {
        int[] nbOf = createTable(number);
        String roman = ""; 
        
        roman = addNTimes(roman, nbOf[6], "M");
        
        if (nbOf[4] >= 4) {
            if (nbOf[5] >= 1) {
                roman += "CM";
            }
            else {
                roman += "CD";
            }
        }
        else {
            roman = addNTimes(roman, nbOf[5], "D");
            roman = addNTimes(roman, nbOf[4], "C");
        }
        
        if (nbOf[2] >= 4) {
            if (nbOf[3] >= 1) {
                roman += "XC";
            }
            else {
                roman += "XL";
            }
        }
        else {
            roman = addNTimes(roman, nbOf[3], "L");
            roman = addNTimes(roman, nbOf[2], "X");
        }
        
        
        if (nbOf[0] >= 4) {
            if (nbOf[1] >= 1) {
                roman += "IX";
            }
            else {
                roman += "IV";
            }
        }
        else {
            roman = addNTimes(roman, nbOf[1], "V");
            roman = addNTimes(roman, nbOf[0], "I");
        }
        
        return roman;
    }
    
    static String addNTimes(String roman, int n, String letter) {
        for (int i=0; i<n; i++) {
            roman += letter;
        }
        return roman;
    }
    
    static int[] createTable(int number) {
        String[] letters = {"I", "V", "X", "L", "C", "D", "M"};
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
        while(true) {
            Scanner myObj = new Scanner(System.in);
            System.out.print("Enter number: ");
            int number = myObj.nextInt();
            if (number > 100000) {
		        System.out.println("Please enter a smaller number.");
		        continue;
	        }
            System.out.println(converter(number));
            System.out.println();
        }
    }
}