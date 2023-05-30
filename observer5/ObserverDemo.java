package observer5;
import java.util.*;
interface observer 
{
	void update(String festival, int discount);
}
class Customer implements observer
{
	private String name;
	Customer(String name)
	{
		this.name = name;
	}
	public void update(String festival, int discount)
	{
		System.out.println("welcome " + name + "... CONGRATULATIONS on the eve of " + festival + " you will be given discount of " + discount + "%");
	}
}
abstract class Subject
{
	abstract void subscribe(Customer c);
	abstract void unsubscribe(Customer c);
	abstract void festivediscount(String festival, int discount);
}
class festiveSubject extends Subject
{
	ArrayList<Customer> list = new ArrayList<>();
	String currentfestival;
	int currentdiscount;
	void subscribe(Customer c)
	{
		list.add(c);
	}
	void unsubscribe(Customer c)
	{
		list.remove(c);
	}
	void festivediscount(String festival, int discount)
	{
		currentfestival = festival;
		currentdiscount = discount;
		notifyall();
	}
	void notifyall()
	{
		for(Customer c: list)
			c.update(currentfestival, currentdiscount);
	}
}
public class ObserverDemo {

	public static void main(String[] args) {
		
		Subject sub = new festiveSubject();
		Customer c1 = new Customer("Sanchi");
		Customer c2 = new Customer("Sujal");
		
		sub.subscribe(c1);
		sub.subscribe(c2);
		
		sub.festivediscount("diwali", 20);
		
		sub.unsubscribe(c2);
		
		sub.festivediscount("udagi", 10);
	}

}
