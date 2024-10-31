import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/** First we will create a method that finds out if a number
     is a perfect number or not.
    A perfect number is defined as a number which all of its
    divisors add up to that number.
    The second step will be to create a method to ask the user
    for input and handle any exceptions that may arrise, from
    this second method we will be calling the first method
    to see if number is perfect.
*/
public class Main {
    // The following method will check if number is perfect
    public static boolean checkIfNumberIsPerfect(long number){
        if(number <= 0){
            return false;
        }
        // total will be compared with number at the end
        long total = 0;
        // we know that no number is divisible by 0 so we start directly with 1
        for(long num=1; num < number; num++){
            // check if number is divisible by num and if so
            // we add that number to total
            if(number % num == 0){
                total += num;
            }
        }
        // if total is indeed equal to number that means
        // that number is a perfect number so we return true
        // otherwise it will return false
        return total == number;
    }
    // The following method will ask the user for input, handle
    // exceptions and call checkIfNumberIsPerfect to see if
    // number is perfect.
    public static void startAssignment(){
        boolean stop = false;
        String baseErrMsg = "sorry but program gave the following error:";
        while(!stop){
            try {
                Scanner scan = new Scanner(System.in);
                // scan user's input
                String msg = "Enter a number bigger than zero and less or equal than 9,223,372,036,854,775,807: ";
                System.out.println(msg);
                long userInput = scan.nextLong();
                // check if number is perfect or not
                boolean numberIsPerfect = Main.checkIfNumberIsPerfect(userInput);
                // tell the user the result
                if(numberIsPerfect){
                    System.out.println("The number was indeed a perfect number");
                }else{
                    System.out.println("The number was not a perfect number");
                }
                scan.close();
                stop = true;
            } catch (InputMismatchException err) {
                String errDisplayed = String.format("%s %s", baseErrMsg, err.toString());
                System.out.println(errDisplayed);
            }catch(NoSuchElementException err){
                String errDisplayed = String.format("%s %s", baseErrMsg, err.toString());
                System.out.println(errDisplayed);
            }
        }
    }
    public static void main(String[] args) {
        Main.startAssignment();
    }
}
