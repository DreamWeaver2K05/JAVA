import java.util.*;
import pkg.*;
class Test implements Inter1
{
    int max,min;
    public void maxmin(int a[],int n)
    {
        max=a[0];
        for(int i=0;i<n;i++)
        {
	if(max<a[i])
	max=a[i];
        }
	min=a[0];
        for(int i=0;i<n;i++)
        {
	if(min>a[i])
	min=a[i];
        }

       
        System.out.println("the largest value is"+max);
        System.out.println("the smallest value is"+min);
    }
    public static void main(String[]ags)
    {
        Scanner s=new Scanner(System.in);
        System.out.println("enter the number of inputs");
        int n=s.nextInt();
        Test t=new Test();
        for(int i=0;i<n;i++)
        {
            a[i]=s.nextInt();
        }
        t.maxmin(a,n);
    }
}