import java.io.PrintWriter;
/**
 * Implementation of evaluate and store.
 * 
 * @author Joshua De La Rosa
 * @version 2 September 15th, 2023
 */

public class BFCalculator {

PrintWriter pen = new PrintWriter(System.out, true);
String runningTotal;
int base = (int) 'a';
int length = 26;
String[] fractions = new String[length];

// +---------+------------------------------------------------------
// | Methods |
// +---------+

  /*
   * Evaluate directs the majority of the arithmetic
   */
  public String evaluate(String exp){
    
    String[] expSplit = exp.split(" ");
    runningTotal = expSplit[0];
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
            if(expSplit[i].matches("[a-z]") && expSplit[i+1].matches("[a-z]")){
              BigFraction previousBF = new BigFraction(fractions[(expSplit[i].charAt(0) - base)]);
              BigFraction nextBF = new BigFraction(fractions[(expSplit[i+1].charAt(0) - base)]);

              result = evaluateHelper(expSplit, i, previousBF, nextBF);

            }
            else if(expSplit[i].matches("[a-z]")){
              BigFraction previousBF = new BigFraction(fractions[(expSplit[i].charAt(0) - base)]);
              BigFraction nextBF = new BigFraction(expSplit[i+1]);

              result = evaluateHelper(expSplit, i, previousBF, nextBF);
            } // else if
            else if(expSplit[i+1].matches("[a-z]")){
              BigFraction previousBF = new BigFraction(runningTotal);
              BigFraction nextBF = new BigFraction(fractions[(expSplit[i+1].charAt(0) - base)]);

              result = evaluateHelper(expSplit, i, previousBF, nextBF);
            } // else if
            else{
              BigFraction previousBF = new BigFraction(runningTotal);
              BigFraction nextBF = new BigFraction(expSplit[i+1]);

              result = evaluateHelper(expSplit, i, previousBF, nextBF);
            } // if...else

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
   * A helper for evaluate
   */
  public BigFraction evaluateHelper(String[] expSplit, int i, BigFraction previousBF, BigFraction nextBF){

    BigFraction result = new BigFraction("0");

    if(expSplit[i].equals("+")){
      return result = (previousBF.add(nextBF)).reduce();
    } // if
    else if(expSplit[i].equals("-")){
      return result = (previousBF.subtract(nextBF)).reduce();
    } // else if
    else if(expSplit[i].equals("/")){
      return result = (previousBF.divide(nextBF)).reduce();
    } // else if
    else if(expSplit[i].equals("*")){
      return result = (previousBF.multiply(nextBF)).reduce();
    } // else if

    return result;
  } // evaluateHelper(String[] expSplit, int i, BigFraction previousBF, BigFraction nextBF)

  /*
   * Tests if a string is an operation
   */
  public boolean isOperation(String val){
    if(val.equals("+") || val.equals("-")
      || val.equals("*") || val.equals("/")
      || val.equals("STORE"))
    return true;
    else
    return false; //if...else
  } // isOperation(String val)

  /*
   * function that stores previous computed value with an associated key
   */
  public void store(char register){
    
    if(!Character.isAlphabetic(register) || !Character.isLowerCase(register)){
      System.err.println("You may only store into alphabetic lowercase characters. Please try agian");
      System.exit(1);
    }
    else{
      fractions[register - base] = runningTotal;
    } // if...else
    
  }

} // class BFCalculator

// https://www.tutorialkart.com/java/how-to-check-if-string-contains-only-alphabets-in-java/#gsc.tab=0