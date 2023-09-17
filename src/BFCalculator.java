import java.io.PrintWriter;
import java.lang.String;
import java.lang.Character;

/**
 * Implementation of evaluate and store.
 * 
 * @author Joshua De La Rosa
 * @version 2 September 15th, 2023
 */

public class BFCalculator {

PrintWriter pen = new PrintWriter(System.out, true);

// +---------+------------------------------------------------------
// | Methods |
// +---------+

  /*
   * Evaluate directs the majority of the arithmetic
   */
  public String evaluate(String exp){
    
    String[] expSplit = exp.split(" ");
    for(int i = 0; i < expSplit.length; i++){
      pen.println(expSplit[i]);
    }
    String runningTotal = expSplit[0];
    BigFraction result = new BigFraction("0");

    for(int i = 0; i < expSplit.length; i++){

      if(!isOperation(expSplit[i])){
        continue;
      }
      else{
        if(expSplit[i].equals("STORE") && !expSplit[i+1].equals(" ")){
          char register = expSplit[i+1].charAt(0);
          store(register);
        }
          else{
          if(!expSplit[i+1].equals(" ")){
          BigFraction previousBF = new BigFraction(runningTotal);
          BigFraction nextBF = new BigFraction(expSplit[i+1]);

          if(expSplit[i].equals("+")){
            result = (previousBF.add(nextBF)).reduce();
          }
          else if(expSplit[i].equals("-")){
            result = (previousBF.subtract(nextBF)).reduce();
          }
          else if(expSplit[i].equals("/")){
            result = (previousBF.divide(nextBF)).reduce();
          }
          else if(expSplit[i].equals("*")){
            result = (previousBF.multiply(nextBF)).reduce();
          }

          String resultString = result.toString();
          runningTotal = resultString;
          }
          else
          return runningTotal; // if...else if...else
        } // if...else
      } // if...else

    } // for

    return runningTotal;

  } // evaluate(String exp)

  /*
   * Tests if a string is an operation
   */
  public boolean isOperation(String val){
    if(val.equals("+") || val.equals("-")
      || val.equals("*") || val.equals("/")
      || val.equals("STORE"))
    return true;
    else
    return false;
  } // isOperation(String val)

  /*
   * function that stores previous computed value with an associated key
   */
  public void store(char register){

    int base = (int) 'a';
    int length = 26;
    char[] letters = new char[length];
    BigFraction[] fractions = new BigFraction[length];

    for(int i = 0; i < letters.length; i++){
      letters[i] = (char) base;
      base++;
      pen.println(letters[i]);
    }
    
    if(!Character.isAlphabetic(register)){
      System.err.println("You may only store into alphabetic lowercase characters. Please try agian");
      System.exit(1);
    }
    else{
      
    }
    
  }

}
