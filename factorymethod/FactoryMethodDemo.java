package factorymethod;

import java.util.Scanner;

abstract class customer
{
	abstract void gettype();
}
class regular extends customer
{
	void gettype()
	{
		System.out.println("regular customer");
	}
}
class seniorcitizen extends customer
{
	void gettype()
	{
		System.out.println("senior citizen customer");
	}
}
class firsttime extends customer
{
	void gettype()
	{
		System.out.println("first time customer");
	}
}
class customerfactory
{
	customer getcustomer(String type)
	{
		if(type.equalsIgnoreCase("regular"))
			return new regular();
		else if(type.equalsIgnoreCase("senior citizen"))
			return new seniorcitizen();
		else
			return new firsttime();			
	}
}
public class FactoryMethodDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome...");
		
		customerfactory cf = new customerfactory();
		customer c1 = cf.getcustomer("regular");
		customer c2 = cf.getcustomer("senior citizen");
		customer c3 = cf.getcustomer("first time");
		
		c1.gettype();
		c2.gettype();
		c3.gettype();
		
	}

}
