package org.iitwforce.mmp.mmpprime;

/**
 * Hello world!
*
*/
public class StringUse 
{
	String drName;
	String s =" Hello $drName$";
	
   public static void main( String[] args )
   {
	   StringUse a1 = new StringUse();
        a1.display("James");
   }
   public void display(String drName)
   {
   	this.drName = drName;
   	System.out.println(this.drName);
   	System.out.println("Display the value stored in s" + s.replace("$drName$",drName));
   }
}