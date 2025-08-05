/*Create a Swing based GUI application to manage details about doctors for XYZ hospital.
Create a class Doctor with details like name, specialization, visiting day.
Create another class called HospitalManagement. In this class create an ArrayList to store the
objects of Doctor class. Create methods to perform the following activities.
- In the constructor of this class create 10 doctor objects (with hardcoded values) and
store the objects in the array list.
- Search doctor - This method should accept a day of a week(String) as a parameter
and return array list of all the doctors visiting that day. If no doctors visiting that
day, then it should throw a user defined exception “No doctors available on the
given day”.
- List doctor – This method should return array list of all the doctors sorted by visiting
day.

In swing application, use appropriate components for accepting input and displaying the output.
Use drop down list to accept visiting day input.
Create three buttons namely “Search Doctor” and “Display Doctors”.

 Search Doctor – Read visiting day from the drop down list component and
pass this to search doctor method of HospitalManagement class. Get the
array list as a result from the method, iterate it, and display the output in a
text area. (Concatenate all doctors details as a string and display it).
 Display Doctors - Call the list doctor method of HopitalManagement class
and get the array list from the method. Iterate the method and display the
doctors details in a text area component.*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
class Exception1 extends Exception
{
	Exception1(String s)
	{
		super(s);
	}
}
class Doctor
{
	String name,vday,spec;
	int d;
	Doctor(String a,String b,String c,int m)
	{
		name=a;
		spec=b;
		vday=c;
		d=m;
	}
	public String toString()
	{
		return "doctor name:"+name+"  specilisation:"+spec+"  visiting day:"+vday;
	}
}
class First implements Comparator<Doctor>
{
	public int compare(Doctor d1,Doctor d2)
	{
		return Integer.compare(d1.d,d2.d);
	}
}
class HospitalManagement extends JFrame implements Runnable,ActionListener
{
	ArrayList<Doctor>a;
	JTextField t1,t2;
	JLabel l1,l2,l3,l4;
	JTextArea ta1,ta2;
	String[] days={"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
	int x=0;
	JComboBox<String>cb1,cb2;
	JButton b1,b2,b3,b4;
	HospitalManagement()
	{
		t1=new JTextField(20);
		t2=new JTextField(20);
		ta1=new JTextArea(10,10);
		ta2=new JTextArea(20,20);
		l1=new JLabel("name");
		l3=new JLabel("visiting day");
		l2=new JLabel("specilisation");
		l4=new JLabel("enter the day for appointment");
		cb1=new JComboBox<String>(days);
		cb2=new JComboBox<String>(days);
		b1=new JButton("submit");
		b2=new JButton("clear");
		b3=new JButton("search");
		b4=new JButton("display");
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(cb1);
		add(b1);
		add(b2);
		add(l4);
		add(cb2);
		add(b3);
		add(ta1);
		add(b4);
		add(ta2);
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		a=new ArrayList<>();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String s1=t1.getText();
			String s2=t2.getText();
			String s3=(String)cb1.getSelectedItem();
			int s4=cb1.getSelectedIndex();
			Doctor d=new Doctor(s1,s2,s3,s4);
			a.add(d);
		}
		else if(ae.getSource()==b2)
		{
			t1.setText("");
			t2.setText("");
			cb1.setSelectedIndex(0);
			ta1.setText("");
			ta2.setText("");
		}
		else if(ae.getSource()==b3)
		{
			try{
			String s3=(String)cb2.getSelectedItem();
			int n=0;
			Doctor m=null;
			boolean found=false;
			for(Doctor d:a)
			{
				if(d.vday.equals(s3))
				{
					ta1.append(d.toString()+"\n");
					n=1;
					found=true;
					m=d;
					
				}
			}
			if(found==true)
			{
				try(FileOutputStream fout=new FileOutputStream("output.txt"))
				{
					String s=m.toString();
					byte b[]=new byte[100];
					b=s.getBytes();
					fout.write(b);
				}
				catch(IOException e)
				{}
			}
					
			if(n==0)
			{
				throw new Exception1("no doctors available in the day");
			}}
			catch(Exception1 e)
			{
				ta1.setText(e.getMessage());
			}
		}
		else if(ae.getSource()==b4)
		{
			Collections.sort(a,new First());
			for(Doctor d:a)
			{
				ta2.append(d.toString()+"\n");
			}
		}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		if(x>780)
			x=0;
		g.drawString("Welcome to ABC hospital",x,40);
	}
	public void run()
	{
		while(true)
		{
		x+=20;
		repaint();
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{}
		}
	}
	public static void main(String[]args)
	{
		HospitalManagement h=new HospitalManagement();
		Thread t=new Thread(h);
		t.start();
	}
}
		
			
		
	