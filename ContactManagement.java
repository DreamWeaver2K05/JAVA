/*Create a class Contact with details like Name, mobile number, type of conctact(family,
official).
Create another class called ContactManagement. In this class create an TreeSet to store
<mobile number, objects of contact class>. Create methods to perform following activities.
- Add a contact. This method should receive a contact class object and insert it into
Tree Set.
- Search contact - this method should accept a mobile number and searches it in the
Tree Set. If it is available, then return the contact object, if not exist it should return
“Contact Not Found” message through user defined exception.
- Display contacts - this method should read all the values from tree set and convert
each object in the format “mobile number – contact name – type of contact”, store
it in a temporary array list<String> and return the array list.

In swing application create text fields to get inputs(name and mobile number) and radio button
to get type of contact. Create three buttons, “Add contact”, “Search Contact” and “Display All*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Iterator;
class Exception1 extends Exception
{
	Exception1(String s)
	{
		super(s);
	}
}
class Contact
{
	String name;
	int no;
	String type;
	Contact(String a,int b,String c)
	{
		name=a;
		no=b;
		type=c;
	}
	public String toString()
	{
		return "name:"+name+" mobile number:"+no+" type of contact:"+type;
	}
}
class ContactManagement extends JFrame implements ActionListener
{
	TreeSet<Contact>a;
	JPanel jp1,jp2,jp3;
	JTextField t1,t2,t3;;
	JRadioButton r1,r2;
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2,b3,b4;
	JTextArea ta1,ta2;
	ButtonGroup bg1;
	Timer t;
	ContactManagement()
	{
		setLayout(new GridLayout(3,1));
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		r1=new JRadioButton("family");
		r2=new JRadioButton("official");
		l1=new JLabel("name");
		l2=new JLabel("mobile");
		l3=new JLabel("type of contact");
		l4=new JLabel("mobile number to search");
		l5=new JLabel();
		b1=new JButton("add");
		b2=new JButton("clear");
		b3=new JButton("search");
		b4=new JButton("display");
		ta1=new JTextArea(10,10);
		ta2=new JTextArea(20,20);
		bg1=new ButtonGroup();
		t=new Timer(500,new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			l5.setText("WELCOME TO ABC Contact");
			}
		}
		);
		t.start();
		bg1.add(r1);
		bg1.add(r2);
		jp1.add(l5);
		jp2.add(l1);
		jp2.add(t1);
		jp2.add(l2);
		jp2.add(t2);
		jp2.add(l3);
		jp2.add(r1);
		jp2.add(r2);
		jp2.add(b1);
		jp2.add(b2);
		jp3.add(l4);
		jp3.add(t3);
		jp3.add(b3);
		jp3.add(ta1);
		jp3.add(b4);
		jp3.add(ta2);
		jp2.setLayout(new FlowLayout());
		jp3.setLayout(new FlowLayout());
		add(jp1);
		add(jp2);
		add(jp3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		a=new TreeSet<>();
	}
	public void actionPerformed(ActionEvent ae)
	{
		repaint();
		if(ae.getSource()==b1)
		{
			try{
			String s1=t1.getText();
			int n=Integer.parseInt(t2.getText());
			String s2;
			if(r1.isSelected())
			{
				s2="family";
			}
			else
			{
				s2="official";
			}
			if((String.valueOf(n)).length()!=10)
			{
				throw new Exception1("invalid mobile number");
			}
			Contact c=new Contact(s1,n,s2);
			a.add(c);
		}
		catch(Exception1 e)
		{
			ta1.setText(e.getMessage());
		}
		}
		else if(ae.getSource()==b2)
		{
			t1.setText("");
			t2.setText("");
			bg1.clearSelection();
			ta1.setText("");
			ta2.setText("");
		}
		else if(ae.getSource()==b3)
		{
			try{
			int s=Integer.parseInt(t3.getText());
			boolean found=false;
			Iterator<Contact>itr=a.iterator();
			while(itr.hasNext())
			{
				if(s==(itr.next().no))
				{
					ta1.setText(itr.toString());
					found=true;
					break;
				}
			}
			if(found==false)
			{
				throw new Exception1("mobile number not found");
			}
			}
			catch(Exception1 e)
			{
				ta1.setText(e.getMessage());
			}
		}
		else
		{
			ArrayList<Contact>al=new ArrayList<>(a);
			for(Contact m:al)
			{
				ta2.append(m.toString()+"\n");
			}
		}
	}
	/*public void paint(Graphics g)
	{
		super.paint(g);
		g.drawString("Welcome to ABC contacts",60,400);
	}*/
	public static void main(String[]args)
	{
		new ContactManagement();
	}
}
			
			
			
			
			
		
	
		
		
		
		
		