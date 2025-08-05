Create a swing GUI application for a vehicle service center to automate process of managing
vehicles.
Create a class Vehicle with the following details. Register Number, Vehicle Type (can be Two
wheeler or Four Wheeler – drop down list), Vehicle Make, Owner Contact Number, Service
Cost.
Create another class called ServiceManagement. In this class create a TreeSet to store
<serviceId, object of vehicle class>. Create methods to perform following activities.
- Add vehicle - This method accepts the vehicle object and inserts the vehicle details
and into Tree Set. Service Id is number of vehicles in the tree set + 1, this should
be automatically generated and used while adding vehicle object into the tree set.
- Get service cost - This method accepts vehicle registration number as argument,
and retrieves the service cost of vehicle with given registration number. If no such
vehicle found, then throw user defined exception with message “Vehicle not
found”.
- List all vehicles – This method should return all the vehicle details as array list,
sorted by service cost.

In swing application, use appropriate components for accepting input and displaying the output.
/*Bank X has decided to collect and store the customer details. They are interested in developing 
a graphical user interface for the transaction purpose. Assume that you are the programming 
expert, so that they are requesting your service to develop a swing-based java application to 
store and manipulate the customer details using the following specifications: 
Create an interface named as “Bank” with the following methods: 
deposit(double); 
wthdrawal(double); 
checkBalance(); 
Create a class “Customer” which implements the above interface along with data members 
such as customerName, accountNumber (unique for a customer), balance.  
Create another class called “BankDemo”.  In this class create an ArrayList to store the objects 
of Customer class.  Create methods to perform the following activities: - - - - 
add_customer() - this method should receive a customer class object and insert it 
into array list. 
deposit() – have to reflect the balance by adding the deposit amount 
withdrawal() – have to reflect the balance by subtracting the withdrawal amount 
checkBalance() - this method should accept a AccountNumber and returns the 
corresponding customer balance. 
Note: (initialize the arraylist with 5 records). 
Create a frame window with 3 text field to accept the input values for customerName, 
accountNumber and amount along with 1 textarea component to display the customer details. 
Create five buttons namely “Add Customer”, “Deposit”, “Withdrawal”, and “Check Balance” 
and Display”. 
Add button - is used to read the information from the GUI and pass this information to array 
list. 
Deposit button – get the deposit amount from the “amount” textfield and perform the deposit 
operation.  If the deposit amount is invalid (i.e., <= 0), then throw the user-defined exception 
“InvalidAmountException”. 
Withdrawal button – get the withdrawal amount from the “amount” textfield and perform the 
withdrawal operation.  If the balance is not sufficient to withdraw, then throw the user-defined 
exception called as “InSufficientFundException”. 
CheckBalance button - read an accountNumber and pass this to checkBalance method of 
BankDemo class.  If found, then display the balance in the “amount“ textfield itself. 
Display button – display all customer details in the textarea component.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Exception1 extends Exception
{
	Exception1(String s)
	{
		super(s);
	}
}
interface Bank
{
	void deposit(double amount)throws Exception1;
	void withdraw(double amount)throws Exception1;
	double checkBalance();
}
class Customer implements Bank
{
	int cid;
	String cname;
	double balance;
	Customer(int a,String b,double c)
	{
		cid=a;
		cname=b;
		balance=c;
	}
	public void deposit(double amount)throws Exception1
	{
		if(amount<=0)
		{
			throw new Exception1("invalid deposit amount");
		}
		balance+=amount;
	}
	public void withdraw(double amount)throws Exception1
	{
		if(amount>balance)
		{
			throw new Exception1("withdrawal amount is greater than the balance");
		}
		balance-=amount;
		
	}
	public double checkBalance()
	{
		return balance;
	}
	public String toString()
	{
		return "customer id:"+cid+"  customer name:"+cname+"  balance:"+balance;
	}
}
class Inter extends JFrame implements ActionListener
{
	ArrayList<Customer>a;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b1,b2,b3,b4,b5;
	JTextArea ta1,ta2,ta3;
	Inter()
	{
		l1=new JLabel("customer id");
		l2=new JLabel("customer name");
		l3=new JLabel("balance");
		l4=new JLabel("amount to be deposited");
		l5=new JLabel("amount to be withdrawn");
		l6=new JLabel("check balance");
		t1=new JTextField(10);
		t2=new JTextField(10);
		t3=new JTextField(10);
		t4=new JTextField(10);
		t5=new JTextField(10);
		t6=new JTextField(10);
		ta1=new JTextArea(10,10);
		ta2=new JTextArea(20,20);
		ta3=new JTextArea(10,10);
		b1=new JButton("add");
		b2=new JButton("deposit");
		b3=new JButton("withdraw");
		b4=new JButton("check balance");
		b5=new JButton("display");
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(b1);
		add(l4);
		add(t4);
		add(b2);
		add(l5);
		add(t5);
		add(b3);
		add(b4);
		add(l6);
		add(b5);
		add(ta3);
		add(ta1);
		add(ta2);
		setSize(800,800);
		setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		setLayout(new FlowLayout());
		a=new ArrayList<>();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try{
			int i=Integer.parseInt(t1.getText());
			String b=t2.getText();
			double c=Double.parseDouble(t3.getText());
			for(Customer o:a)
			{
				if(o.cid==i)
				{
					throw new Exception1("invalid customer id");
				}
			}
			Customer f=new Customer(i,b,c);
			a.add(f);
			}
			catch(Exception1 e)
			{
				ta1.setText(e.getMessage());
			}
		}
		else if(ae.getSource()==b2)
		{
			try{
			int id=Integer.parseInt(t1.getText());
			Customer f=find(id);
			if(f!=null)
			{
				double d=Double.parseDouble(t4.getText());
			    f.deposit(d);
			}
			else
			{
				ta1.setText("Customer not found.");
			}
			}
			catch(Exception e)
			{
			ta1.setText(e.getMessage());
			}
		}
		else if(ae.getSource()==b3)
		{
			try{
			int id=Integer.parseInt(t1.getText());
			Customer f=find(id);
			if(f!=null)
			{
				double e=Double.parseDouble(t5.getText());
				f.withdraw(e);
			}
			else
				ta1.setText("Customer not found.");
			}
			catch(Exception1 e)
			{
				ta1.setText(e.getMessage());
			}
		}
		else if(ae.getSource()==b4)
		{
			int id=Integer.parseInt(t1.getText());
			Customer f=find(id);
			if(f!=null)
				ta3.setText(Double.toString(f.checkBalance()));
			else
				ta1.setText("Customer not found.");
		}
		else if(ae.getSource()==b5)
		{
			for(Customer c:a)
			{
				ta2.append(c.toString()+"\n");
			}
		}
	}
	Customer find(int id)
	{
		for(Customer c:a)
		{
			if(c.cid==id)
			{
				return c;
			}
		}
		return null;
	}
		
	public static void main(String[]args)
	{
		new Inter();
	}
}
		
		
		
		
	
	
	