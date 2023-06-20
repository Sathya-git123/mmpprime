package javaprograms;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
//http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php
public class RandomEx {

	public static void main(String[] args) throws InterruptedException {

		//for(int i=0;i<20;i++)
		//{
			Calendar cal = Calendar.getInstance();
			System.out.println(cal.getTimeInMillis());
			System.out.println(cal.getTimeInMillis()% 1000000000);
			
			//DateFunctionality
			cal.add(Calendar.DAY_OF_MONTH, 10);
			Date d = cal.getTime();
			System.out.println(d);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
			System.out.println(sdf.format(d));
			
			
			
//			
////			Thread.sleep(50);
//		   int r=0,a=1145,b=100;
//		   
//		   r = a/b;
//		   System.out.println(r );// 5
//		   
//		   r = a%b;
//		   System.out.println(r);
//		   

		//}
//		
//		String s = 1234567+"";
//		System.out.println(s);
		 
		
		
//		 	Random rand = new Random();
//		//		
//			//for(int i=0;i<20;i++)
//			//{
//				//Generate random int value with a boundary of 100 - range [0..99]
//				int value = rand.nextInt(100);
//				//System.out.println(value);
//			//}
//
//				//Generate Random Upper Case character
//				int upperCaseValue = 65 + rand.nextInt(26);
//				char upperCaseChar = (char)upperCaseValue;
//				System.out.println(upperCaseChar);
//				
//				//Generate Random lower case Character
//				int lowerCaseValue = 97+ rand.nextInt(26);
//				char lowerCaseChar = (char)lowerCaseValue;
//				System.out.println(lowerCaseChar);
//				
//				String randomEmailID="autoprime"+upperCaseChar+lowerCaseChar+upperCaseChar+lowerCaseChar+value+"@gmail.com";
//				System.out.println(randomEmailID);



	}
}
/*
byte
short
int 
long
float
double
char
boolean
 */





