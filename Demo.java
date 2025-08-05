
import java.util.*;
abstract class Account
{
    int accid,cusid;
    Account()
    {}
    Account(int a,int b)
    {
        accid=a;
        cusid=b;
    }
    abstract double deposit();
    abstract double withdrawal();
}
class SavingsAcc extends Account
{
    double balance;
    SavingsAcc()
    {}
    SavingsAcc(double a)
    {
        balance=a;
    }
    double deposit(int accid,double depos)
    {
        if(accid>0)
        {
            balance=depos+balance;
            return balance;
        }
        else
        {
            return -1;
        }
        
    }
    double withdrawal(int accid,double withdraw)
    {
        if(accid>0)
        {
            balance=balance-withdraw;
            return balance;
        }
        else
        {
            return -1;
        }
    }
}
class Demo
{
    public static void main(String[]args)
    {
        Scanner s=new Scanner(System.in);
        String n=s.next();
        do
        {
            System.out.println("MENU");
            System.out.println("1.DEPOSIT");
            System.out.println("2.WITHDRAWAL");
            System.out.println("3.DISP");
            System.out.println("4.EXIT");
            System.out.println("enter ur choice");
            int ch=s.nextInt();
            switch(n)
            {
                case "deposit":
                {
                    System.out.println("enter the amount to be deposited");
                    double deposit=s.nextDouble();
                    System.out.println("enter the account id");
                    System.out.println("enter the customer id");
                    int a=s.nextInt();
                    int b=s.nextInt();
                    SavingsAcc c=new SavingsAcc(a,b);
                    c.deposit(a,deposit);
                    break;
                }
                case "withdrawal":
                {
                    System.out.println("enter the amount to be withdrawal");
                    double withdrawal=s.nextDouble();
                    System.out.println("enter the account id");
                    System.out.println("enter the customer id");
                    int a=s.nextInt();
                    int b=s.nextInt();
                    SavingsAcc c=new SavingsAcc(a,b);
                    c.withdrawal(a,withdrawal);
                    break;
                }
                case "disp":
                {
                    System.out.println("enter the account id");
                    System.out.println("enter the customer id");
                    int a=s.nextInt();
                    int b=s.nextInt();
                    SavingsAcc c=new SavingsAcc(a,b);
                    System.out.println("balance is"+balance);
                }
            }
        }while(ch!=4);
    }
}