import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Student 
{
	int reg;
	String name;
	double cgpa;
	Student(int a,String b,double c)
	{
		reg=a;
		name=b;
		cgpa=c;
	}
	public String toString()
	{
		return "register number:"+reg+"  name:"+name+"  cgpa:"+cgpa;
	}
}
class StudentManage extends JFrame implements ActionListener
{
	TreeMap<Integer,Student>tm;
	JTextField t1,t2,t3,t4;
	JLabel l1,l2,l3,l4;
	JButton b1,b2,b3;
	JTextArea ta1,ta2;
	StudentManage()
	{
		t1=new JTextField(10);
		t2=new JTextField(10);
		t3=new JTextField(10);
		t4=new JTextField(10);
		ta1=new JTextArea(10,10);
		ta2=new JTextArea(20,20);
		b1=new JButton("add");
		b2=new JButton("search");
		b3=new JButton("display");
		l1=new JLabel("reg ");
		l2=new JLabel("name");
		l3=new JLabel("mark"); 
		l4=new JLabel("reg number to search");
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
		add(ta1);
		add(b3);
		add(ta2);
		setSize(800,800);
		setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setLayout(new FlowLayout());
		tm=new TreeMap<>();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			int a=Integer.parseInt(t1.getText());
			String b=t2.getText();
			double c=Double.parseDouble(t3.getText());
			Student s=new Student(a,b,c);
			tm.put(a,s);
		}
		else if(ae.getSource()==b2)
		{
			int x=Integer.parseInt(t4.getText());
			Student s=tm.get(x);
			ta1.append(s.toString());
		}
		else
		{
			//Set<Map.Entry<Integer,Student>>h=tm.entrySet();
			TreeSet<Map.Entry<Integer,Student>>ts=new TreeSet<>(tm.entrySet());
			for(Map.Entry<Integer,Student>m:ts)
			{
				ta2.append(m.getValue().toString()+"\n");
			}
		}
	} 
	public static void main(String[]args)
	{
		new StudentManage();
	}
}
			
				
			