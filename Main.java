
import java.util.Scanner;

public class Main{
    
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
           
        String[] requirements = getRequirements();
        
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
}
