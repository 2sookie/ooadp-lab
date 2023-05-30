package bridge;

interface Discount
{
	double calc(double price);
}
class discount1 implements Discount
{
	public double calc(double price)
	{
		System.out.println("15% discount applied");
		return price*0.85;
	}
}
class discount2 implements Discount
{
	public double calc(double price)
	{
		System.out.println("20% discount applied");
		return price*0.80;
	}
}
class discount3 implements Discount
{
	public double calc(double price)
	{
		System.out.println("25% discount applied");
		return price*0.75;
	}
}
class discount4 implements Discount
{
	public double calc(double price)
	{
		System.out.println("30% discount");
		return price*0.70;
	}
}
abstract class Customer
{
	Discount d;
	Customer(Discount d)
	{
		this.d = d;
	}
	abstract double calculate(double price);
}
class regular extends Customer
{
	regular(Discount d)
	{
		super(d);
	}
	double calculate(double price)
	{
		System.out.println("welcome regular customer");
		return d.calc(price);
	}
}
class seniorcitizen extends Customer
{
	seniorcitizen(Discount d)
	{
		super(d);
	}
	double calculate(double price)
	{
		System.out.println("welcome senior citizen customer");
		return d.calc(price);
	}
}
class firsttime extends Customer
{
	firsttime(Discount d)
	{
		super(d);
	}
	double calculate(double price)
	{
		System.out.println("welcome first time customer");
		return d.calc(price);
	}
}

public class BridgeDemo {

	public static void main(String[] args) {
		
		Customer c1 = new regular(new discount1());
		System.out.println("total amount to be paid " + c1.calculate(100));
		
		System.out.println("\t--------");
		
		Customer c2 = new regular(new discount2());
		System.out.println("total amount to be paid " + c2.calculate(100));
		
		System.out.println("\t--------");
		
		Customer c3 = new firsttime(new discount1());
		System.out.println("total amount to be paid " + c3.calculate(100));
	}

}
