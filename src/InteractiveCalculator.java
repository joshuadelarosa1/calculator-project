import java.io.PrintWriter;
package mini- ;

/**
 * Main that reads multiple lines of operations
 * from the user, computes, and prints the answers.
 * 
 * @author Joshua De La Rosa
 * @version 1 September 13th, 2023
 */

public class InteractiveCalculator {
// +------+--------------------------------------------------------------
// | Main |
// +------+
  public static void main(String[] args){

    PrintWriter pen = new PrintWriter(System.out, true);

    String hey = "1/7 + 1/9 - 2/9";
    String[] heySplit = hey.split(" ");
    for(String split : heySplit){
      pen.println(split);
    }

    String str = evaluate("1/2 + 1/3 + 1/4");
    pen.println(str);

    //not yet implemented
  } // main(String[] args)
  
  
} // class InteractiveCalculator
