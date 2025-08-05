/*Create three threads namely Factorial, SumOfSeries and MultiplicationTable. Fact thread should produce factorial
 value. Sum thread should produce sum of natural numbers. MultiplicationTable thread class should produce
 multiplication table. From the main class, create the thread objects. Demonstrate the use of the methods 
 like sleep(), isAlive() and join() methods
 (Note: Practice creation of thread in both ways(i.e using interface, extending class))*/
class Factorial implements Runnable
{
	int n;
	Factorial(int v)
	{
		n=v;
	}
	public void run()
	{
		try{
			int fact=1;
			for(int i=1;i<=10;i++)
			{
				fact=fact*i;
				System.out.println(Thread.currentThread().getName());
				System.out.println("factorial:"+fact);
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{}
	}
}
class Sum implements Runnable
{
	int n;
	Sum(int v)
	{
		n=v;
	}
	public void run()
	{
		try{
			int sum=0;
			for(int i=1;i<=10;i++)
			{
				sum+=i;
				System.out.println(Thread.currentThread().getName());
				System.out.println("sum:"+sum);
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{}
	}
}
class Multiply implements Runnable
{
	int n;
	Multiply(int v)
	{
		n=v;
	}
	public void run()
	{
		try{
			Thread t=Thread.currentThread();
			for(int i=1;i<=10;i++)
			{
				System.out.println(Thread.currentThread().getName());
				System.out.println(n+"*"+i+"="+(n*i));
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{}
	}
}			
class Demoin
{
	public static void main(String args[])
	{
		Factorial f=new Factorial(10);
		Thread t=new Thread(f,"child1");
		t.start();
		Sum s=new Sum(10);
		Thread n=new Thread(s,"child2");
		n.start();
		Multiply m=new Multiply(10);
		Thread r=new Thread(m,"child3");
		r.start();
		try{
			Thread q=Thread.currentThread();
			for(int i=1;i<=10;i++)
			{
				n.join();
				t.join();
				r.join();
				System.out.println(q.getName());
				System.out.println("child1"+t.isAlive());
				System.out.println("child2"+n.isAlive());
				System.out.println("child3"+r.isAlive());
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{}
	}
}
			
