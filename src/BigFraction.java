import java.math.BigInteger;

/**
 * A simple implementation of BigFractions.
 * 
 * @author Samuel A. Rebelsky
 * @author Jinny Eo, Joshua Delarosa
 * @version 1.2 of August 2023
 */
public class BigFraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are represented 
   * with a negative numerator. Similarly, if a fraction has a negative numerator, it 
   * is negative.
   * 
   * (2) BigFractions are not necessarily stored in simplified form. To obtain a fraction 
   * in simplified form, one must call the `simplify` method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   */
  public BigFraction(BigInteger num, BigInteger denom) {
    this.num = num;
    this.denom = denom;
  } // BigFraction(BigInteger num, BigInteger denom)

  /**
   * Build a new fraction with numerator num and denominator denom.
   *
   */
  public BigFraction(int num, int denom) {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  } // BigFraction(int num, int denom)

  /**
   * Build a new fraction by parsing a string.
   *
   */
  public BigFraction(String str) {
    if(str.equals("0")){
      this.num = BigInteger.valueOf(0);
      this.denom = BigInteger.valueOf(0);
    }
    else{
    int i = str.indexOf("/");
    String numStr = str.substring(0, i);
    int num = Integer.parseInt(numStr);
    String denomStr = str.substring(i+1, str.length());
    int denom = Integer.parseInt(denomStr);

    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
    }
  } // BigFraction (String str) */

  

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the fraction `addMe` to this fraction.
   */
  public BigFraction add(BigFraction addMe) {
    BigInteger resultNumerator, resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  }// add(BigFraction addMe)

  /**
   * Get the denominator of this BigFraction.
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()

  /**
   * Divides Big Fractions.
   */
  public BigFraction divide(BigFraction divideMe){
    BigInteger resultNum, resultDenom;

    resultNum = this.num.divide(divideMe.num);
    resultDenom = this.denom.divide(divideMe.denom);

    return new BigFraction(resultNum, resultDenom);
  } // divide(BigFraction divideMe)

  /**
   * Returns values as a fraction.
   */
  public BigFraction fractional(){
    BigInteger resultNum, resultDenom;

    resultNum = this.num.mod(this.denom);
    resultDenom = this.denom;

    return new BigFraction(resultNum, resultDenom);
  } // fractional()

  /**
   * Multiplies two BigFraction
   */
  public BigFraction multiply(BigFraction multiplyMe){
    BigInteger resultNum, resultDenom;

    resultNum = this.num.multiply(multiplyMe.num);
    resultDenom = this.denom.multiply(multiplyMe.denom);

    return new BigFraction(resultNum, resultDenom);
  } // multiply(BigFraction multiplyMe)
  
  /**
   * Get the numerator of this BigFraction.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()

  /**
   * 
   * reduces a fraction to the simplest form
   */
  public BigFraction reduce(){
    BigInteger resultNum, resultDenom;
    BigInteger BCD = BigInteger.valueOf(1);

    for(BigInteger i = BigInteger.valueOf(1); (i.compareTo(this.num.min(this.denom))) <= 0; 
        i = i.add(BigInteger.valueOf(1))){
          if(((this.num.mod(i)) == BigInteger.valueOf(0)) && 
            ((this.denom.mod(i)) == BigInteger.valueOf(0))){
              BCD = i;
            }
          }

    resultNum = this.num.divide(BCD);
    resultDenom = this.denom.divide(BCD);
    return new BigFraction(resultNum, resultDenom);
  } // reduce()

  /**
   * Subtracts two BigFractions.
   */
  public BigFraction subtract(BigFraction subtractMe){
    BigInteger resultNum, resultDenom;

    if(this.denom == subtractMe.denom){
      resultNum = this.num.subtract(subtractMe.num);
      resultDenom = this.denom;
      return new BigFraction(resultNum, resultDenom);
    }
    else{
      resultNum = (this.num.multiply(subtractMe.denom)).subtract(subtractMe.num.multiply(this.denom));
      resultDenom = this.denom.multiply(subtractMe.denom);
      return new BigFraction(resultNum, resultDenom);

    } // if...else
  } // subtract(BigFraction subtractMe)
  
  /**
   * Convert this Bigfraction to a string for ease of printing.
   */
  public String toString() {
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()

} // class BigFraction