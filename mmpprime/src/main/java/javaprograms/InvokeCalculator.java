package javaprograms;

public class InvokeCalculator {

	public static void main(String[] args) 
	{
		
		int actual = Calculator.add(10, 5);
		int expected =15;
		if(actual==expected)
		{
			System.out.println("Add functionality is working fine");
		}
		else
		{
			System.out.println("Add functionality is not working fine");
		}
		
		Calculator cal = new Calculator();
		actual = cal.divide(10, 5);
		expected=2;
		if(actual==expected)
		{
			System.out.println("Divide functionality is working fine");
		}
		else
		{
			System.out.println("Divide functionality is not working fine");
		}
	}
}
