/*
 * @author: Jessica Van Meter, CS 455
 * Rational class will perform arithmetic with fractions
 * 13 September 2015
*/

public class Rational{
	//instance variables with default to zero
	private int numerator; //any int
	private int denominator; // !=0
	
	//Constructors:
	
	//Rational default constructor: 
	public Rational(){
		this(0, 1); //invoke constructor with 2 args
	}
	//Rational constructor: numerator provided
	public Rational(int numerator){
		this(numerator, 1); //invoke constructor with 2 args
	}
	/*This constructor cannot be used in combination of the previous,
	 * as they have the same signature (one int):
	 * 
	 * //Rational constructor: denominator provided
		public Rational(int denominator){
		this(0, denominator); //invoke constructor with 2 args
		}
	 */ 
	//Rational constructor: both args provided
	public Rational(int numerator, int denominator){
		//validate the denominator
		if (denominator == 0)
			throw new IllegalArgumentException("Denominator cannot be zero.");
		this.numerator = numerator;
		this.denominator = denominator;
		reduce(this);
	}
	//Rational constructor: another Rational object provided
	public Rational(Rational rational){
		//invoke the constructor with 2 args:
		this(rational.getNumerator(), rational.getDenominator()); 
	}
	//end Constructors
	
	//get and set methods:
	
	//set numerator value:
	//(I don't think it needs validating
	//since it can be any int, please provide feedback if this is wrong)
	public void setNumerator(int numerator){
		this.numerator = numerator;
	}
	//set and validate the denominator value:
	public void setDenominator(int denominator){
		//validate that the denominator is not 0:
		if (denominator == 0)
			throw new IllegalArgumentException("Denominator cannot be zero.");
		this.denominator = denominator;
	}
	//get numerator value:
	public int getNumerator(){
		return numerator;
	}
	//get denominator value:
	public int getDenominator(){
		return denominator;
	}
	//end getters and setters
	
	//toString methods for Rational display:
	
	//method for displaying as fraction:
	public String toFracFormatString(){
		return String.format("%d/%d", getNumerator(), getDenominator());
	}	
	//method for displaying in decimal format:
	public String toDecFormatString(){
		double rational;
		int n = getNumerator();
		int d = getDenominator();
		
		rational = (double)n/d;
		
		return String.format("%5.2f", rational);
	}
	//end display methods
	
	//helper methods:
	private static int getGCD(int num, int denom){
		int num1 = Math.max(num, denom);
		int num2 = Math.min(num, denom);
		
		if(num2 == 0)
			return num1;
		else
			return getGCD(num2, num1%num2);
	}
	private static void reduce(Rational frac){
		int num = frac.getNumerator();
		int denom = frac.getDenominator();
		int gcd = getGCD(num, denom);
		frac.setNumerator(num /= gcd);
		frac.setDenominator(denom /= gcd);
	}
	//end helper methods
	
	//static arithmetic methods:
	
	//method to multiply two rationals:
	//Takes two rationals and returns their product in the form of another rational.
	public static Rational multiply(Rational frac1, Rational frac2){
		Rational answer = new Rational();
		
		answer.setNumerator(frac1.getNumerator() * frac2.getNumerator());
		answer.setDenominator(frac1.getDenominator() * frac2.getDenominator());
		reduce(answer);
		
		return answer;
	}
	//method to divide two rationals:
	//Takes two rationals and returns their quotient in the form of another rational.
	public static Rational divide(Rational frac1, Rational frac2){
		Rational answer = new Rational();
		//use reciprocal multiplication to arrive at quotient:
		answer.setNumerator(frac1.getNumerator() * frac2.getDenominator());
		answer.setDenominator(frac1.getDenominator() * frac2.getNumerator());
		reduce(answer);
		
		return answer;
	}
	//method to add two rationals:
	//Takes two rationals and returns their sum in the form of another rational.
	public static Rational add(Rational frac1, Rational frac2){
		Rational answer = new Rational();
		
		Rational fracOneCopy = new Rational(frac1);
		Rational fracTwoCopy = new Rational(frac2);
		
		//get a common denominator in each fraction:
		//multiply frac1 by 1 such that 1=frac2.denom/frac2.denom:
		fracOneCopy.setNumerator(fracOneCopy.getNumerator() * frac2.getDenominator());
		fracOneCopy.setDenominator(fracOneCopy.getDenominator() * frac2.getDenominator());
		//multiply frac2 by 1 such that 1=frac1.denom/frac1.denom:
		fracTwoCopy.setNumerator(fracTwoCopy.getNumerator() * frac1.getDenominator());
		fracTwoCopy.setDenominator(fracTwoCopy.getDenominator() * frac1.getDenominator());
		
		//add fractions now that they have same denominator:
		answer.setNumerator(fracOneCopy.getNumerator() + fracTwoCopy.getNumerator());
		answer.setDenominator(fracOneCopy.getDenominator());
		
		//reduce answer:
		reduce(answer);
		
		return answer;
	}
	//method to subtract two rationals:
	//Takes two rationals and returns their difference in the form of another rational.
	public static Rational subtract(Rational frac1, Rational frac2){
		Rational answer = new Rational();
		
		Rational fracOneCopy = new Rational(frac1);
		Rational fracTwoCopy = new Rational(frac2);
		
		//get a common denominator in each fraction:
		//multiply frac1 by 1 such that 1=frac2.denom/frac2.denom:
		fracOneCopy.setNumerator(fracOneCopy.getNumerator() * frac2.getDenominator());
		fracOneCopy.setDenominator(fracOneCopy.getDenominator() * frac2.getDenominator());
		//multiply frac2 by 1 such that 1=frac1.denom/frac1.denom:
		fracTwoCopy.setNumerator(fracTwoCopy.getNumerator() * frac1.getDenominator());
		fracTwoCopy.setDenominator(fracTwoCopy.getDenominator() * frac1.getDenominator());
		
		//add fractions now that they have same denominator:
		answer.setNumerator(fracOneCopy.getNumerator() - fracTwoCopy.getNumerator());
		answer.setDenominator(fracOneCopy.getDenominator());
		
		//reduce answer:
		reduce(answer);
		
		return answer;
	}
}