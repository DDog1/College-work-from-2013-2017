package smallNumbers;

import javax.jws.WebService;

@WebService
public class SmallestNumber {

	public int getSmallestNumber(int input1, int input2, int input3){
		int small = input1;
		
		if(small>input2){
			small = input2;
			if(small>input3){
				small = input3;
			}
		}
		System.out.println(small);
		return small;
	}	
}
