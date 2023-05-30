package strategy;
abstract class pricingstrategy
{
	abstract double calc(double price);
}
class regular extends pricingstrategy
{
	double calc(double price)
	{
		return price*0.12;
	}
}
class seniorcitizen extends pricingstrategy
{
	double calc(double price)
	{
		return price*0.10;
	}
}
class firsttime extends pricingstrategy
{
	double calc(double price)
	{
		return price*0.15;
	}
}
class storeleveldiscount
{
	double discount = 100;
	double storediscount(double price)
	{
		if(price > 2000)
			price -= discount;
		return price;
	}
}
class context
{
	pricingstrategy s;
	storeleveldiscount sd = new storeleveldiscount();
	context(pricingstrategy s)
	{
		this.s = s;
	}	
	void calculate(double price)
	{
		double amt = sd.storediscount(price);
		double customerdis = s.calc(amt);
		double total = amt - customerdis;
		System.out.println("amount to be paid after discount is " + total);
	}
}
public class StrategyDemo {

	public static void main(String[] args) {
		
		pricingstrategy rc = new regular();
		pricingstrategy sc = new seniorcitizen();
		
		context c1 = new context(rc);
		c1.calculate(2100);
		
		context c2 = new context(sc);
		c2.calculate(2100);

	}

}
