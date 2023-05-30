package adaptor;

class MauriTax
{
	double getvat(double amt)
	{
		return amt*0.15;
	}
}
interface decathlontaxcalc
{
	double taxcalc(double amt);
}
class mauritaxadapter implements decathlontaxcalc
{
	MauriTax mt = new MauriTax();
	public double taxcalc(double amt)
	{
		return mt.getvat(amt);
	}
}

public class AdaptorDemo {

	public static void main(String[] args) {
		
		decathlontaxcalc tc = new mauritaxadapter();
		double taxamt = tc.taxcalc(1000);
		System.out.println("tax " + taxamt + " to be paid on bill price of 1000Rs.");
	}

}
