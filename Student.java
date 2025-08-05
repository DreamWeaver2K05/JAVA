import java.util.*;
class Exception1 extends Exception
{
	public String toString()
	{
		return "the mark is out of range";
	}
}
class Student 
{
		public static void main(String a[])
		{
			try
			{
				double total=0;
				double per=0;
			    for(int i=1;i<7;i++)
				{
					int n=Integer.parseInt(a[i]);
					if(n>0&&n<100)
					{
						total+=n;
						per=(total/600)*100;
					}
					else
					{
						throw new Exception1();
					}
				}
				System.out.println("the total marks is"+total);
				System.out.println("the percentage is"+per);
			}
			catch(Exception1 ae)
			{
				System.out.println(ae);
			}
						
		}
}
		
	
	