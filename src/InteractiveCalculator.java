import java.io.PrintWriter;
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
  public static void main(String[] args) throws Exception{

    PrintWriter pen = new PrintWriter(System.out, true);
    BFCalculator calc = new BFCalculator();

    String str = calc.evaluate("1 + 5/6 / 2 STORE a a + a STORE b b - b");
    pen.println(str);

    //not yet implemented
  } // main(String[] args)
  
} // class InteractiveCalculator
