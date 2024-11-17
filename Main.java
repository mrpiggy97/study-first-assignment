import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/** First we will create a nested loop to find out how many
    perfect numbers are between 1 and 200.
    Then we will create a method that finds out if a number
    is a perfect number or not.
    A perfect number is defined as a number which all of its
    divisors add up to that number.
    The second step will be to create a method to ask the user
    for input and handle any exceptions that may arrise, from
    this second method we will be calling the first method
    to see if number is perfect and loop from 1 up to the given number
    and print all the perfect numbers found.
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
            // if before ending the loop we have a total bigger than the number given
            // then we don't need to perform any more calculations just return false
            if(total > number){
                return false;
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
                ArrayList<Long> perfectNumbers = new ArrayList<>();
                Scanner scan = new Scanner(System.in);
                // scan user's input
                String msg = "Enter a number bigger than zero and less or equal than 9,223,372,036,854,775,807: ";
                System.out.println(msg);
                long userInput = scan.nextLong();
                // check how many perfect numbers are between 1 and the upper limit given by the user
                for(long i=1; i <= userInput; i++){
                    boolean numberIsPerfect = Main.checkIfNumberIsPerfect(i);
                    if(numberIsPerfect){
                        perfectNumbers.add(i);
                    }
                }
                // show user all the perfect numbers found
                System.out.println(perfectNumbers.toString());
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
        // perfect numbers will store all numbers considered perfect and will
        // be printed at the end of the nested loop
        ArrayList<Integer> perfectNumbers = new ArrayList<>();
        for (int currentNumber = 1; currentNumber <= 200; currentNumber++) {
            // now determine if currentNumber is perfect or not
            int total = 0;
            // start from 1 all the way to the number before currentNumber,
            // check if the number is a divisor of currentNumber and if so
            // increase the total
            for(int i=1; i < currentNumber; i++){
                if(currentNumber%i == 0){
                    total += i;
                }
            }
            if(total == currentNumber){
                perfectNumbers.add(currentNumber);
            }
        }
        // now display all perfect numbers between 1 and 200
        System.out.println("the following are the perfect numbers between 1 and 200");
        System.out.println(perfectNumbers.toString());
        Main.startAssignment();
    }
}
