package singleton10;
import java.util.*;
class Browser
{
	private static Browser instance;  //remember to make this variable static
	private ArrayList<String> history = new ArrayList<>();
	private Browser()
	{		
	}
	public static Browser getinstance() //remember to make this method static
	{
		if(instance == null)
			instance = new Browser();
		else
			System.out.println("instance already created");
		return instance;
	}
	
	public void add(String url)
	{
		history.add(url);
	}
	
	public void gethistory()
	{
		for(String str : history)
			System.out.println(str);
	}
	
}

public class Singleton {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Browser obj = Browser.getinstance();
		while(true)
		{
			System.out.println("1.Create instance   2.add url  3.view history  4.exit");
			int choice = sc.nextInt();
			
			if(choice == 1)
				obj = Browser.getinstance();
			else if(choice == 2)
			{
				System.out.println("enter the url");
				String s = sc.next();
				obj.add(s);
			}
			else if(choice == 3)
				obj.gethistory();
			else if(choice == 4)
				break;
			else
				System.out.println("invalid choice");
		}
		sc.close();
	}

}
