import java.util.* ;
import java.io.*;
import java.math.BigInteger; 
public class BigStringToInt {
	public static String findSum(String num1 , String num2)  {
		BigInteger n1=new BigInteger(num1);
		BigInteger n2=new BigInteger(num2);
		BigInteger sum=n1.add(n2);
		return sum.toString();

	}

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String num1=sc.nextLine();
		String num2=sc.nextLine();
		String result= findSum(num1, num2);
	
	   System.out.println(result);
	}
}