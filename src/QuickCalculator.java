/**
 * Main that computes multiple operations given on the same
 * command line and then prints that back out to the user.
 * 
 * @author Joshua De La Rosa
 * @version 1 September 13th, 2023
 */

import java.io.PrintWriter;

public class QuickCalculator {
// +------+--------------------------------------------------------------
// | Main |
// +------+
  public static void main(String[] args) throws Exception{

    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println("test");

    String hey = "1/7 + 1/9 - 2/9";
    String[] heySplit = hey.split(" ");
    for(String split : heySplit){
      pen.println(split);
    }

    //not yet implemented
  } // main(String[] args)
  
}
