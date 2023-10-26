import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Main that reads multiple lines of operations from the user, computes, and prints the answers.
 * 
 * @author Joshua De La Rosa
 * @version 1 September 13th, 2023
 */

public class InteractiveCalculator {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+
  public static void main(String[] args) throws Exception {

    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner scan = new Scanner(System.in);
    BFCalculator calc = new BFCalculator();
    String input;

    pen.println("Hello! This program will do basic math arithmatic using Big Fractions.");
    pen.println("You can use STORE to store the previous value & QUIT will exit the program");

    do {
      input = scan.nextLine();

      if(input.length() <= 1) {
        System.err.println("You did not enter a correct number of inputs");
        System.err.println("Here is what you entered: " + input);
        System.exit(1);
      }

      String result = calc.evaluate(input);

      if (!result.equals("STORE COMPLETE") && !input.equals("QUIT"))
        pen.println(result);

    } while (!input.equals("QUIT")); // do...while

    scan.close();

  } // main(String[] args)

} // class InteractiveCalculator
