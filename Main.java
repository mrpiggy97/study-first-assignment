import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

final class Assignment{
    /** first we will create a method that finds out if a number
      is a perfect number or not.
      A perfect number is defined as a number which all of its
      divisors add up to that number
     */
    public static boolean checkIfNumberIsPerfect(long number){
        // total will be compared with number at the end
        long total = 0;
        // we know that no number is divisible by 0 so we start directly with 1
        for(long num=1; num <= number; num++){
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
    /**
     The following method will ask the user for input, check if input
     is valid and check if number is perfect
     */
    public static void startAssignment(){
        Scanner scanner = new Scanner(System.in);
        long userInput;
        boolean stop = false;
        while(!stop){
            try {
                String message = "Please enter a number that is bigger than 0 and less or equal than 9,223,372,036,854,775,807";
                System.out.println(message);
                userInput = scanner.nextLong();
                boolean numberIsPerfect = Assignment.checkIfNumberIsPerfect(userInput);
                if(numberIsPerfect){
                    System.out.println("The number provided was indeed a perfect number");
                    stop = true;
                }else{
                    System.out.println("Im Sorry but the number was not a perfect number");
                    stop = true;
                }
            } catch (InputMismatchException err) {
                String errMsg = String.format("Sorry, the program gave the following error: %s", err.toString());
                System.out.println(errMsg);
            } catch(NoSuchElementException err){
                String errMsg = String.format("Sorry, the program gave the following error %s", err.toString());
                System.out.println(errMsg);
            }
        }
        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        Assignment.startAssignment();
    }
}
