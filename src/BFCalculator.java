import java.io.PrintWriter;
package mini project 2.src;

/**
 * Implementation of evaluate and store.
 * 
 * @author Joshua De La Rosa
 * @version 1 September 13th, 2023
 */

public class BFCalculator {

  PrintWriter pen = new PrintWriter(System.out, true);

// +---------+------------------------------------------------------
// | Methods |
// +---------+

  public String evaluate(String exp){
    
    String[] expSplit = exp.split(" ");
    String runningTotal = expSplit[0];
    BigFraction result = new BigFraction("0");

    for(int i = 0; i < expSplit.length; i++){

      if(!isOperation(expSplit[i])){
        continue;
      }
      else{
        if(!expSplit[i+1].equals(" ")){
        BigFraction previousBF = new BigFraction(runningTotal);
        BigFraction nextBF = new BigFraction(expSplit[i+1]);

        if(expSplit[i].equals("+")){
          result = previousBF.add(nextBF);
        }
        else if(expSplit[i].equals("-")){
          result = previousBF.subtract(nextBF);
        }
        else if(expSplit[i].equals("/")){
          result = previousBF.divide(nextBF);
        }
        else if(expSplit[i].equals("*")){
          result = previousBF.multiply(nextBF);
        }

        String resultString = result.toString();
        runningTotal = resultString;
        }
        else
        return runningTotal;
      }

    } // for

    return runningTotal;

  } // evaluate(String exp)

  public boolean isOperation(String val){
    if(val.equals("+") || val.equals("-")
      || val.equals("*") || val.equals("/")
      || val.equals("STORE"))
    return true;
    else
    return false;
  }

  public void store(char register){
    //not yet implemented
  }

}

/*
 *
 * test code:
 *      int i = 0;
    BigFraction[] fractions = new BigFraction[exp.length()];
    String[] expSplit = exp.split(" ");
    String[] operations;

    for(String split : expSplit){
      if(isOperation(split)){
        operations[i] = split;
      }
      else{
        fractions[i] = new BigFraction(split); 
      } // if... else
      i++;
    } // for

    for(BigFraction fraction : fractions){
      if(operations[j].equals("+")){
        fractions[j] = fractions[j].add(fractions[j+1]);
      }
    }

    return ;
 */
