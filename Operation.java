import java.util.*;
class Badoperation extends Exception
{
	public Badoperation(Throwable cause) {
	super(cause);}
	public String toString()
	{
		return "Operation failed";
	}
}
class Badoperator extends Exception
{
	public String toString()
	{
		return"Bad operator";
	}
}
class Badoperand extends Exception
{
	public String toString()
	{
		return"bad operand";
	}
}

class Operation
{
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		try
		{
			System.out.println("enter the first operand and second operand and operation");
		    int a=s.nextInt();
		    int b=s.nextInt();
		    String c=s.next();
			//System.out.println(!c.equals("+"));
			if(a<10000||a>50000)
			{
				throw new Badoperation(new Badoperand());
			}
			if(b<500||b>5000)
			{
				throw new Badoperation(new Badoperand());
			}
			if(!c.equals("+")&&!c.equals("-")&&!c.equals("*")&&!c.equals("/"))
			{
				throw new Badoperation(new Badoperator());
	        }
			int res=0;
			switch(c)
			{
				case "+":
				{
					res=a+b;
					break;
				}
				case "-":
				{
					res=a-b;
					break;
				}
			    case "*":
				{
					res=a*b;
					break;
				}
			    case "/":
				{
					res=a/b;
					break;
				}
			}
			System.out.println("the result of the expression is"+res);
		}
    	catch(Badoperation ae)
		{
			System.out.println(ae);
			System.out.println(ae.getCause());
		}
	}
}