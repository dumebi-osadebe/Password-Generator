
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main{
    
    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args){
           
        String[] requirements = getRequirements();
        String password = generator(requirements[0], requirements[1], requirements[2]);
        System.out.println("The generated password is:" + password);
        
    }

    public static String[] getRequirements() {
        
        String capitalization = "N";
        
        System.out.println("Length of password:");
        String passLength = scan.nextLine();
        
        System.out.println("\nChoose from options below (enter A, B or C):");
        System.out.println(" A. Only Letters \n B. Only Numbers \n C. Letters and Numbers");
        String alphNum = scan.nextLine();

        // ask users for capitalization only if they have specified that they want more than numbers in their password
        if(alphNum.equals("A")|| alphNum.equals("C")){

            System.out.println("\nChoose capitalization from options below (enter A, B or C):");
            System.out.println(" A. All Uppercase \n B. All Lowercase \n C. Uppercase and Lowercase");
            capitalization = scan.nextLine();

        }
        
        String[] arr = {passLength, alphNum, capitalization};
        return arr;

    }

    public static String generator(String passLength, String alphNum, String capitalization){

        int length = Integer.parseInt(passLength);
        ArrayList<Integer> randomNums = new ArrayList<>();
        ArrayList<Character> randomVars = new ArrayList<>();
        int upperbound = 9;
        String password = "none";

        for(int i = 0; i < length; i++){

            // generate only random numbers for the password as requested by user input
            if(alphNum.equals("B")){
                int int_random = random.nextInt(upperbound);
                randomNums.add(int_random);
                
            // generate only random characters (only uppercase or only lowercase) for the password as requested by user input
            } else if(alphNum.equals("A") && capitalization.equals("A")) {
                char alphabet = (char)(random.nextInt(26) + 'A');
                randomVars.add(alphabet);

            }   else if(alphNum.equals("A") && capitalization.equals("B")) {
                char alphabet = (char)(random.nextInt(26) + 'a');
                randomVars.add(alphabet);

            } 
        }


        if(alphNum.equals("C")){

            if(capitalization.equals("A")){
                return letterAndNumber(length).toUpperCase();
            } else if (capitalization.equals("B")) {
                return letterAndNumber(length).toLowerCase();
            } else {
                return letterAndNumber(length);
            }
            
        }

        return password;

    }

    public static String letterAndNumber(int length) {
        
        String lettNum = "0123456789" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(lettNum.charAt(random.nextInt(lettNum.length())));
        } 

        return password.toString();
    }
}
