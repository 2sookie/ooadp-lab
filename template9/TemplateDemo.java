package template9;

import java.util.Scanner;

abstract class orderprocessing
{
	public void processorder()
	{
		selectitem();
		dopayment();
		dodelivery();
	}
	abstract void selectitem();
	abstract void dopayment();
	abstract void dodelivery();
}
class onlineorderprocessing extends orderprocessing
{
	int totalamt = 0;
	void selectitem()
	{
		System.out.println("welcome to online store");
		System.out.println("Items choosen");
		System.out.println("1 | 400Rs");
		System.out.println("2 | 600Rs");
		System.out.println("3 | 200Rs");
		System.out.println("4 | 300Rs");
		totalamt = 400+600+200+300;
	}
	void dopayment()
	{
		System.out.println("pay via net banking");
	}
	void dodelivery()
	{
		String s = "Rit";
		int shippingcharge = 100;
		System.out.println("shipping charge for address " + s + " is "+ shippingcharge);
		System.out.println("total bill amount " + (totalamt + shippingcharge));
		System.out.println("thank you for shopping with us");
	}
}
class offlineorderprocessing extends orderprocessing
{
	int totalamt = 0;
	Scanner sc = new Scanner(System.in);
	void selectitem()
	{
		System.out.println("welcome to offline store");
		System.out.println("select items ");
		System.out.println("1 | 400Rs");
		System.out.println("2 | 600Rs");
		System.out.println("3 | 200Rs");
		System.out.println("4 | 300Rs");
		System.out.println("Items choosen");
		System.out.println("2 | 600Rs");
		System.out.println("3 | 200Rs");
		totalamt = 600+200;
	}
	void dopayment()
	{
		System.out.println("pay bill through\n1.cash\n2.swipe-card");
	}
	void dodelivery()
	{
		System.out.println("total bill amount " + totalamt);
		System.out.println("You can collect your item at counter 1\nThank you for shopping with us");
	}
}
public class TemplateDemo {

	public static void main(String[] args) {
		
		orderprocessing online = new onlineorderprocessing();
		online.processorder();
		orderprocessing offline = new offlineorderprocessing();
		offline.processorder();
	}

}
