package p1;
import java.util.*;
public class Publication
{
	String title;
	double price;
	public void get()
	{
		System.out.println("enter the title of the book");
		Scanner s=new Scanner(System.in);
		title=s.next();
		System.out.println("enter the price of the book");
		price=s.nextDouble();

	}
	public void put()
	{
		
		System.out.println("title of the book"+title);
		System.out.println("price of the book"+price);
	}
}
	
		