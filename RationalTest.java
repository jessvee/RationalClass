/*
 * @author: Jessica Van Meter
 * CS 455
 * RationalTest class will perform arithmetic with fractions
 * 13 September 2015
*/
public class RationalTest{
	public static  void main(String[] args){
		//test all overloaded Constructors:
	
		Rational frac1 = new Rational();//test empty 
		Rational frac2 = new Rational(2);//test 1 arg 
		Rational frac3 = new Rational(1,2);//test 2 arg 
		Rational frac4 = new Rational(2,4);//test 2 arg and simplify()
		Rational frac5 = new Rational(frac3);//test reference 

		displayFrac("Fraction1: ", frac1);
		displayFrac("Fraction2: ", frac2);
		displayFrac("Fraction3: ", frac3);
		displayFrac("Fraction4: ", frac4);
		displayFrac("Fraction5: ", frac5);
		
		//test arithmetic methods:
		Rational frac6 = Rational.add(frac1, frac2);//should equal 2/1
		Rational frac7 = Rational.subtract(frac2, frac3);//should equal 3/2
		Rational frac8 = Rational.multiply(frac3, frac4);//should equal 1/4
		Rational frac9 = Rational.divide(frac4, frac5);//should equal 1/1
		
		displayFrac("The sum of Fraction1 and Fraction 2: ", frac6);
		displayFrac("The difference of Fraction2 and Fraction3: ", frac7);
		displayFrac("The product of Fraction3 and Fraction4: ", frac8);
		displayFrac("The quotient of Fraction4 and Fraction5: ", frac9);
	}
	//method for displaying Rational, using its toString methods:
	private static void displayFrac(String header, Rational frac){
		//, frac.toDecFormatString);
			System.out.printf("%s%n %s = %s%n", header,
					frac.toFracFormatString(), frac.toDecFormatString() ); 
	} 
}