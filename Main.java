
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main{
    
    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args){
           
        String[] requirements = getRequirements();
        String password = generator(requirements[0], requirements[1], requirements[2]);
        
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
            System.out.println("Username is: " + capitalization);

        }
        
        String[] arr = {passLength, alphNum, capitalization};
        return arr;

    }

    public static String generator(String passLength, String alphNum, String capitalization){

        int length = Integer.parseInt(passLength);
        ArrayList<Integer> randomNums = new ArrayList<>();
        ArrayList<Character> randomVars = new ArrayList<>();
        int upperbound = 9;
        String password = "no";

        //char data[] = {'a', 'b', 'c'};
        //String str = new String(data);

        for(int i = 0; i < length; i++){

            // generate only e=random numbers for the password as requested by user input
            if(alphNum.equals("B")){
                int int_random = random.nextInt(upperbound);
                randomNums.add(int_random);

            } else if(alphNum.equals("A") && capitalization.equals("A")) {
                char alphabet = (char)(random.nextInt(26) + 'A');
                randomVars.add(alphabet);
                System.out.println(randomVars.get(0));

            }   else if(alphNum.equals("A") && capitalization.equals("B")) {
                char alphabet = (char)(random.nextInt(26) + 'a');
                randomVars.add(alphabet);
                System.out.println(randomVars.get(0));

            }

    
        }

        return password;

    }

}
