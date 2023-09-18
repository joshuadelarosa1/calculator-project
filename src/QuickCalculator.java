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
    BFCalculator calc = new BFCalculator();
    String runningTotal = "0";
    
    for(int i = 0; i < args.length; i++){
      String result = calc.evaluate(args[i]);

      if(!result.equals("STORE COMPLETE"))
      runningTotal = result;
    }
   
    pen.println(runningTotal);
  } // main(String[] args)
  
}
