package facade;
import java.util.*;
class itempurschased
{
	HashMap<String, Integer> hm;
	int typecount;
	Scanner sc = new Scanner(System.in);
	itempurschased()
	{
		hm = new HashMap<>();
		storepurschase();
	}
	void storepurschase()
	{
		System.out.println("welcome to store");
		System.out.println("enter the number of different types of items u wanna buy?");
		typecount = sc.nextInt();
		for(int i = 0; i < typecount; i++)
		{
			System.out.println("enter the name of product");
			String n = sc.next();
			System.out.println("enter quantity required");
			int q = sc.nextInt();
			hm.put(n, q);
		}
	}
	void displayitems()
	{
		for(Map.Entry<String, Integer> i : hm.entrySet())
			System.out.println(i.getKey() + " : " + i.getValue());
	}
	int gettypecount()
	{
		return typecount;
	}
}
class processsales
{
	boolean cert;
	double amt;
	int qty;
	Scanner sc = new Scanner(System.in);
	processsales(boolean cert, double amt, int qty)
	{
		this.cert = cert;
		this.amt = amt;
		this.qty = qty;
	}
	
	void processorder()
	{
		if(!cert)
		{
			System.out.println("oops... no gift coupon available pay " + amt + "through cash");
		}
		else
		{
			System.out.println("enter the gift certificate value");
			int certvalue = sc.nextInt();
			
			if(qty < 0)
				System.out.println("no items in cart");
			else if(qty > 1)
				System.out.println("only one item can be purschased with gift certificate");
			else if(amt > certvalue)
				System.out.println("pay balance amount using cash " + (amt - certvalue));
			else if(certvalue > amt)
				System.out.println("no cash will be provided. thank you for shopping with us");
		}
	}
}
class sport2000facade
{
	itempurschased i;
	processsales p;
	sport2000facade(boolean c, double amt)
	{
		i = new itempurschased();
		p = new processsales(c, amt, i.gettypecount());
	}
	
	void showitems()
	{
		i.displayitems();
	}
	void processcart()
	{
		p.processorder();
	}
}
public class FacadeDemo {

	public static void main(String[] args) {
		
		sport2000facade sf = new sport2000facade(true, 2000);
		sf.showitems();
		sf.processcart();
		
	}

}
