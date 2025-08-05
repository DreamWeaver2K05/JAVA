/*2. Create a swing GUI application to manage the passport registration.  
 Create a class named Passport with attributes like username, password, name, date of birth, 
gender, state, Aadhar number and mobile number.  
 Create another class called PassportRegistration. In this class create an ArrayList to store 
the details of passport registered candidates.  
 Create methods to perform following activities.  
 Submit() – This method should receive all the details entered for registration and insert it 
into array list after validation.  
 Clear() – This method used to clear all the details entered in the GUI components.  
 Display() – This method should display the Name, Aadhaar number, mobile number of the 
registered candidates in the TextArea.  
 Create a Swing application to get the above mentioned details  
o Display the Heading as “Passport Registration” in the top middle of the frame.  
o Use Textfields for username, name, date of birth, Aadhaar and mobile number.  
o Use passwordfield for password.  
o Use radio button for gender selection.  
o Use ComboBox for selecting the state.  
 Exception: 
 While pressing the submit button, it call the submit method and the following condition 
should be checked.  
1. Check the entered password character count should be between 8 and 12, if it not 
then throw the user defined exception with the message “Enter the password 
correctly”.  
2. Check the Aadhaar number and mobile number should be 12 and 10 digits, 
otherwise throw the user defined exception with the message “ Aadhar number 
should be 12 digits” / “ Mobile number should be 10 digits”  
3. If both the above conditions are satisfied then display the message “ Registered 
Sucessfully”.  
 While pressing the clear button, it call the clear method and clear the data’s entered in the 
components. While pressing the display button, it call the display method and display all the 
registered candidate details in a text area by iterating the array list ( Concatenate name, 
Aadhar and mobile number into one string and set this string to text area).  
 A flash message “WELCOME TO PASSPORT REGISTRATION” should be displayed at 
the top of the page, which should move from right to left using multithreading. */

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
class Info
{
	String u,name,da,gen,st,pas,mo,aad;
	Info(String a,String b,String c,String d,String e,String f,String g,String h)
	{
		u=a;
		pas=b;
		name=c;
		da=d;
		gen=e;
		st=f;
		aad=g;
		mo=h;
	}
	public String toString()
	{
		return "username:"+u+"  password:"+pas+"  name:"+name+"  date of birth:"+da+"  gender:"+gen+"  state:"+st+"   aadhar number:"+aad+"   mobile number:"+mo;
	}
}
class Passport extends JFrame implements ActionListener
{
	ArrayList<Info>a;
	String state[]={"tamilnadu","kerala","karnataka","telangana","madhya pradesh","gujarat","assam","rajasthan"};
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5;
	JPasswordField p;
	JRadioButton r1,r2;
	JComboBox<String> cb1;
	ButtonGroup bg1;
	JButton b1,b2,b3;
	JTextArea ta1,ta2;
	JScrollPane j;
	Timer t;
	int x=0;
	Passport()
	{
		setLayout(new GridLayout(3,1));
		JPanel jp=new JPanel();
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		jp1.setLayout(new FlowLayout());
		jp2.setLayout(new FlowLayout());
		t=new Timer(500,this);
		t.start();
		l1=new JLabel("enter the username");
		l2=new JLabel("enter the password");
		l3=new JLabel("enter the name");
		l4=new JLabel("enter the date of birth");
		l5=new JLabel("enter the gender");
		l6=new JLabel("enter the state");
		l7=new JLabel("enter the aadhar number");
		l8=new JLabel("enter the mobile number");
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		p=new JPasswordField(20);
		b1=new JButton("submit");
		b2=new JButton("clear");
		b3=new JButton("display");
		r1=new JRadioButton("male");
		r2=new JRadioButton("female");
		ta1=new JTextArea(10,20);
		ta2=new JTextArea(10,40);
		j=new JScrollPane(ta2);
		cb1=new JComboBox<String>(state);
		bg1=new ButtonGroup();
		bg1.add(r1);
		bg1.add(r2);
		jp1.add(l1);
		jp1.add(t1);
		jp1.add(l2);
		jp1.add(p);
		jp1.add(l3);
		jp1.add(t2);
		jp1.add(l4);
		jp1.add(t3);
		jp1.add(l5);
		jp1.add(r1);
		jp1.add(r2);
		jp1.add(l6);
		jp1.add(cb1);
		jp1.add(l7);
		jp1.add(t4);
		jp1.add(l8);
		jp1.add(t5);
		jp1.add(b1);
		jp1.add(ta1);
		jp2.add(b2);
		jp2.add(b3);
		jp2.add(ta2);
		add(j);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		add(jp);
		add(jp1);
		add(jp2);
		setSize(800,800);
		a=new ArrayList<Info>();
	}
	public void actionPerformed(ActionEvent ae)
	{
		repaint();
		x+=20;
		if(ae.getSource()==b1)
		{
			try{
			String s1=t1.getText();
			String s2=new String(p.getPassword());
			String s3=t2.getText();
			String s4=t3.getText();
			String s5=r1.isSelected()?"male":"female";
			String s6=(String)cb1.getSelectedItem();
			String s7=t4.getText();
			String s8=t5.getText();
			if(s7.length()!=12)
			{
				throw new Exception1("invalid aadhar number");
			}
			if(s8.length()!=10)
			{
				throw new Exception1("invalid mobile number");
			}
			if(!(s2.length()>8&&s2.length()<12))
			{
				throw new Exception1("invalid password");
			}
			Info n=new Info(s1,s2,s3,s4,s5,s6,s7,s8);
			a.add(n);
			}
			catch(Exception1 e)
			{
				ta1.setText(e.getMessage());
			}
		}
		else if(ae.getSource()==b2)
		{
			t1.setText(" ");
			t2.setText(" ");
			t3.setText(" ");
			t4.setText(" ");
			t5.setText(" ");
			p.setText(" ");
			r1.setSelected(false);
			r2.setSelected(false);
			cb1.setSelectedIndex(0);
		}
		else if(ae.getSource()==b3)
		{
			for(Info i:a)
			{
				ta2.append(i.toString()+"\n");
			}
		}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		if(x>780)
			x=0;
		g.drawString("WELCOME TO PASSWORD REGISTRATION",x,60);
	}
	public static void main(String[] args)
	{
		new Passport();
	}
}
		
			