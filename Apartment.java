/*You are the owner of an apartment comprising of 6 houses. Two houses are of 1BHK type, two
houses are of 2BHK type and two houses are of 3BHK type. Create a GUI based java
application for requesting a house for rent.
 Create an Apartment class with the following instance variables: Name, number of
persons in the family, address, monthly income, preferred house type.
 Create a swing application to get the above mentioned details.
o Add textfields to get details like number of persons in family, name, address,
monthly income
o Add radio buttons to get preferred house type(1BHK, 2BHK or 3BHK)
o Add a button called ‘Submit’
o When the ‘Submit’ button is clicked, Create an object of Apartment class from
the entered details and store the object in an ArrayList
o Details are to be saved for 6 house requests two each for each type of house
o If the number of persons in family exceeds 4, an user defined exception
‘WaterProblemException’ is to be raised and to be handled.*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
class Exception1 extends Exception
{
	Exception1(String s)
	{
		super(s);
	}
}
class Rent
{
	String name,address,house,ac;
	int n;
	double income;
	Rent(String a,int b,String c,double d,String e,String f)
	{
		name=a;
		n=b;
		address=c;
		income=d;
		house=e;
		ac=f;
	}
	public String toString()
	{
		return "name:"+name+"  no of persons:"+n+"  address:"+address+"  income:"+income+"  type of house:"+house+"  accomodation:"+ac;
	}
}
class Apartment extends JFrame implements ActionListener,ItemListener,Runnable 
{
	int x=0;
	ArrayList<Rent>a;
	JTextField t1,t2,t3,t4;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextArea ta1,ta2;
	JButton b1,b2;
	StringBuilder sb1=new StringBuilder();
	JRadioButton r1,r2,r3;
	JCheckBox c1,c2,c3;
	ButtonGroup bg1;
	Apartment()
	{
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		l1=new JLabel("name");
		l2=new JLabel("no of persons");
		l3=new JLabel("address");
		l4=new JLabel("income");
		l5=new JLabel("type of house");
		l6=new JLabel("accomodation");
		ta1=new JTextArea(10,10);
		ta2=new JTextArea(10,20);
		b1=new JButton("submit");
		b2=new JButton("display");
		r1=new JRadioButton("1bhk");
		r2=new JRadioButton("2bhk");
		r3=new JRadioButton("3bhk");
		bg1=new ButtonGroup();
		c1=new JCheckBox("furniture");
		c2=new JCheckBox("ac");
		c3=new JCheckBox("lights");
		bg1.add(r1);
		bg1.add(r2);
		bg1.add(r3);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(l5);
		add(r1);
		add(r2);
		add(r3);
		add(l6);
		add(c1);
		add(c2);
		add(c3);
		add(b1);
		add(ta1);
		add(b2);
		add(ta2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		setLayout(new FlowLayout());
		setSize(800,800);
		setVisible(true);
		a=new ArrayList<Rent>();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try{
			String s1=t1.getText();
			int s2=Integer.parseInt(t2.getText());
			String s3=t3.getText();
			double s4=Double.parseDouble(t4.getText());
			String s5;
			if(r1.isSelected())
			{
				s5="1bhk";
			}
			else if(r2.isSelected())
			{
				 s5="2bhk";
			}
			else
			{
					s5="3bhk";
			}
			String s6=sb1.toString();
			if(s2>4)
			{
				throw new Exception1("invalid number of persons");
			}
			Rent r=new Rent(s1,s2,s3,s4,s5,s6);
			a.add(r);
			}
			catch(Exception1 e)
			{
				ta1.setText(e.getMessage());
			}
		}
		else 
		{
			ta2.setText("");
			for(Rent s:a)
			{
				ta2.append(s.toString());
			}
		}
	}
	public void itemStateChanged(ItemEvent e)
	{
		sb1.setLength(0);
		if(c1.isSelected())
		{
			sb1.append(c1.getActionCommand());
		}
		if(c2.isSelected())
		{
			sb1.append(c2.getActionCommand());
		}
        if(c3.isSelected())
		{
			sb1.append(c3.getActionCommand());
		}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		if(x>780)
			x=0;
		g.drawString("Welcome to ABC homes",x,40);
	}
		
	public void run()
	{
		while(true)
		{
			x+=20;
			repaint();
			try{
			Thread.sleep(100);}
			catch(InterruptedException e)
			{}
		}
	}
	public static void main(String[]args)
	{
		Apartment s=new Apartment();
		Thread t=new Thread(s);
		t.start();
	}
}
	
			
			
		
		
		
		
		
	