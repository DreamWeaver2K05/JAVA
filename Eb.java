/*You are the owner of an apartment comprising of 4 houses. You have to develop a GUI
based java application for calculation of electricity charges incurred by the occupants of
the houses.
 Create a class called “EBBill” with the following instance variables: house number,
name of the tenant, starting energymeter reading, ending energymeter reading and
bill amount.
 Create a swing application to get the above mentioned details.
o Use text fields to get House number, name of the tenant, starting energy
meter reading and ending energy meter reading.
o Add two buttons ‘SaveData’ and ‘CalculateBill’.
o Add a textarea for displaying the details
o When ‘SaveData’ is pressed, create a EBBill class object from the entered
details and store it in an ArrayList.
o The data is to be entered for all the 4 houses and to be saved.
o The amount is to be calculated as (ending energy meter reading – starting
energymeter reading) X Rs. 10 per unit.
o After entering the house number for which bill amount is to be calculated
the ‘CalculateBill’ button is to be pressed and the details to be displayed in
the textarea
o If any number other than 1 to 4 is entered in House Number field, an user
defined exception ‘HouseNotFoundException’ is to be raised and to be
handled.*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
class Exception1 extends Exception
{
	Exception1(String s)
	{
		super(s);
	}
}
class Ebill
{
	double st,end,bill,unit;
	int n;
	String name,are;
	Ebill(int a,String b,double c,double d,double e,double f,String g)
	{
		n=a;
		name=b;
		st=c;
		end=d;
		unit=e;
		bill=f;
		are=g;
	}
	public String toString()
	{
		return "house number:"+n+" tenant name:"+name+" starting:"+st+" ending:"+end+" unit:"+unit+"  bill amount:"+bill+" area:"+are;
	}
}
class Eb extends JFrame implements ActionListener
{
	ArrayList<Ebill>a;
	JScrollPane sp;
	JTextArea ta1,ta2;
	String[] area={"anna nagar","omr","pallavaram","chrompret"};
	JList<String>j1;
	JTextField t1,t2,t3,t4,t5,t6;
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2,b3;
	Eb()
	{
		t1=new JTextField(10);
		t2=new JTextField(10);
		t3=new JTextField(10);
		t4=new JTextField(10);
		t5=new JTextField(10);
		t6=new JTextField(10);
		ta1=new JTextArea(10,10);
		l1=new JLabel("house number");
		l2=new JLabel("tenant name");
		l3=new JLabel("starting meter");
		l4=new JLabel("ending meter");
		l5=new JLabel("unit");
		b1=new JButton("add");
		b2=new JButton("bill");
		b3=new JButton("display");
		j1=new JList<>(area);
		ta2=new JTextArea(10,10);
		sp=new JScrollPane(ta2);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(l5);
		add(t5);
		add(j1);
		add(b1);
		add(b2);
		add(t6);
		add(ta1);
		add(b3);
		add(sp);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);		
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		a=new ArrayList<>();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try{
			int s1=Integer.parseInt(t1.getText());
			String s2=t2.getText();
			Double s3=Double.parseDouble(t3.getText());
			Double s4=Double.parseDouble(t4.getText());
			Double s5=Double.parseDouble(t5.getText());
			Double s6=((s4-s3)*10*s5);
			List<String>obs=j1.getSelectedValuesList();
			String s7=obs.toString();
			if(!(s1>0&&s1<5))
			{ 
				throw new Exception1("house not found");
			}
			Ebill e=new Ebill(s1,s2,s3,s4,s5,s6,s7);
			a.add(e);}
			catch(Exception1 e)
			{
				ta1.setText(e.getMessage());
			}
		}
		else if(ae.getSource()==b2)
		{
			int s=Integer.parseInt(t1.getText());
			Double s3=Double.parseDouble(t3.getText());
			Double s4=Double.parseDouble(t4.getText());
			Double s5=Double.parseDouble(t5.getText());
			Double s6=((s4-s3)*10*s5);
			//Ebill m=find(s);
			//if(m!=null)
				t6.setText(s6.toString());
		}
		else if(ae.getSource()==b3)
		{
			for(Ebill e:a)
			{
				ta2.append(e.toString()+"\n");
			}
		}
	}
	public static void main(String[]args)
	{
		new Eb();
	}
}
			
	