import java.util.*;
class Rectangle
{
        int l,b,area;
	Rectangle()
	{
	   l=b=0;
	}
	Rectangle(int a,int c)
	{
	    l=a;
            b=c;
	}
	void input()
	{
	        System.out.println("enter the length and breadth");
		Scanner s=new Scanner(System.in);
		l=s.nextInt();
		b=s.nextInt();
	}
	public int calc()
	{
	    area=l*b;
	    return area;
	}
	public static Rectangle greatest(Rectangle r[],int n)
	{
            if(n==0)
            {
                return null;
            }
	    Rectangle largest=r[0];
	    for(int i=0;i<n;i++)
	    {
		    if(r[i].calc()>largest.calc())
		    {
			largest=r[i];
                    }
            }
	    return largest;
	}
}
class RectangleDemo
{
    public static void main(String[]args)
    {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the number of data to be inputed");
		int n=s.nextInt();
		Rectangle r[]=new Rectangle[n];
                Rectangle large=Rectangle.greatest(r,n);
                System.out.println("enter the data");
                for(int i=0;i<n;i++)
                {
                     r[i].input();
                }
                if(large!=null)
                {
                     System.out.println("the rectangle with largest area");
                     System.out.println("length:"+large.l);
                     System.out.println("breath:"+large.b);
                     System.out.println("area:"+large.area);
                }		
    }
}