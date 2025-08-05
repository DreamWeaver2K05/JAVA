/*1. Develop a JAVA application for The ABC Insurance agency near your location is looking for 
automation for an online policy renewal portal. The agency approaches you to help them by 
developing a Java swing-based application for the above.  
 Create a class Insurance with the following attributes  
a. policy_Number – int,  
b. policy_Name – String,  
c. policy_Holder_Name – String,  
d. premium –double  
e. policytype – String (VehicleInsurance or PersonalInsurance).  
Include required constructors and methods.  
 Create a Swing application to get the details as mentioned above.  
 Display the message as ‘Welcome to Online Policy Booking Portal’ at the top of the frame.  
 Use Textfields for policy_Number, policy_Name, policy_Holder_Name,  
premium and policytype.  
 Add a button named submit- When the submit button is pressed, create an insurance class 
object using the entered details and save the object in the Collection Type  
 Add another button Clear  –used to clear all the details entered in the GUI components.  
 Five data sets, each requesting one policy type, are to be entered and saved in the collection 
type  
 If the same policy_Number is entered by the user, then a user-defined exception is to be 
raised and to be handled.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
class Exception1 extends Exception
{
	Exception1(String s)
	{
		super(s);
	}
}
class Insurance
{
	int pno;
	String pname,phname,poli,type;
	double premium;
	Insurance(int a,String b,String c,String d,double e)
	{
		pno=a;
		pname=b;
		phname=c;
		poli=d;
		premium=e;
	}
	public String toString()
	{
		return "poilcy number:"+pno+"   policy name:"+pname+"    policy holder name:"+phname+"   policy:"+poli+"   premium:"+premium;
	}
}
class Policy extends JFrame implements ActionListener
{
	ArrayList<Insurance>a;
	JButton b1,b2,b3;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JTextArea ta;
	Timer t;
	int x=0;
	Policy()
	{
		setLayout(new GridLayout(2,1));
		JPanel jp=new JPanel();
		JPanel jp1=new JPanel();
		jp1.setLayout(new FlowLayout());
		t=new Timer(500,this);
		t.start();
		b1=new JButton("submit");
		b2=new JButton("clear");
		b3=new JButton("display");
		l1=new JLabel("enter the policy number");
		l2=new JLabel("enter the policy name");
		l3=new JLabel("enter the policy holder name");
		l4=new JLabel("enter the policy type");
		l5=new JLabel("enter the premium amount");
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		ta=new JTextArea(20,20);
		jp1.add(l1);
		jp1.add(t1);
		jp1.add(l2);
		jp1.add(t2);
		jp1.add(l3);
		jp1.add(t3);
		jp1.add(l4);
		jp1.add(t4);
		jp1.add(l5);
		jp1.add(t5);
		jp1.add(b1);
		jp1.add(b2);
		jp1.add(b3);
		jp1.add(ta);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setSize(800,800);
		setVisible(true);
		add(jp);
		add(jp1);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		a=new ArrayList<Insurance>();
	}
	public void actionPerformed(ActionEvent ae)
	{
		x+=20;
		repaint();
		if(ae.getSource()==b1)
		{
			try{
			int b=Integer.parseInt(t1.getText());
			String c=t2.getText();
			String d=t3.getText();
			String e=t4.getText();
			Double f=Double.parseDouble(t5.getText());
			for(Insurance s:a)
			{
				if(s.pno==b)
				{
					throw new Exception1("policy number invalid");
				}
			}
			Insurance i=new Insurance(b,c,d,e,f);
			a.add(i);
		    }
		    catch(Exception1 e)
		    {
				t1.setText(e.getMessage());
			}
		}
		else if(ae.getSource()==b2)
		{
			t1.setText(" ");
			t2.setText(" ");
			t3.setText(" ");
			t4.setText(" ");
			t5.setText(" ");
		}
		else if(ae.getSource()==b3)
		{
			for(Insurance s:a)
			{
				ta.append(s.toString());
			}
		}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		if(x>780)
			x=0;
		g.drawString("WELCOME TO ABC INSURANCE",x,70);
	}
	public static void main(String[]args)
	{
		new Policy();
	}
}
		
	
