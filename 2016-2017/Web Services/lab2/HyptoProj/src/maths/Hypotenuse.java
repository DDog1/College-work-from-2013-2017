package maths;

import javax.jws.WebService;

@WebService
public class Hypotenuse {

	int squareA = (int) Math.pow(2, 3);
	
	public double getHypotenuse(double a, double b){
		double Hypotenuse = Math.hypot(a, b);
		return Hypotenuse;
	}
}
