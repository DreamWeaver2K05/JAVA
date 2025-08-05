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
class Student
{
	int m1,m2,m3;
	double cgpa;
	String name;
	int reg;
	Student(int r,String n,int a,int b,int c)
	{
		reg=r;
		name=n;
		m1=a;
		m2=b;
		m3=c;
		cgpa=(m1+m2+m3)*0.03333;
	}
	public String toString()
	{
		return "reg no:"+ reg + "  name:"  + name + "  mark1:" + m1 +"   mark2:" + m2 + "   mark3:" + m3 + "   cgpa" +cgpa;
	}
}
class First implements Comparator<Student>
{
	public int compare(Student s1,Student s2)
	{
		return Double.compare(s1.cgpa,s2.cgpa);
	}
}
class Mark extends JFrame implements ActionListener
{
	TreeSet<Student>t;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b1,b2,b3;
	JTextArea ta,ta1,ta2;
	Mark()
	{
		l1=new JLabel("enter the student name");
		l2=new JLabel("enter the student reg number");
	    l3=new JLabel("enter mark 1");
		l4=new JLabel("enter mark 2");
		l5=new JLabel("enter mark 3");
		l6=new JLabel("enter the student reg number to be searched");
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		t6=new JTextField(20);
		ta=new JTextArea(5,20);
		ta1=new JTextArea(10,20);
		ta2=new JTextArea(10,20);
		b1=new JButton("submit");
		b2=new JButton("display");
		b3=new JButton("search");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
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
		add(b1);
		add(ta);
		add(b2);
		add(ta1);
		add(l6);
		add(t6);
		add(b3);
		add(ta2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setSize(800,800);
		setVisible(true);
		t=new TreeSet<Student>(new First());
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
		try{
			int reg=Integer.parseInt(t2.getText());
			String name=t1.getText();
			int m1=Integer.parseInt(t3.getText());
			int m2=Integer.parseInt(t4.getText());
			int m3=Integer.parseInt(t5.getText());
			Student a=new Student(reg,name,m1,m2,m3);
			t.add(a);
			ta.setText("student added with cgpa"+a.cgpa);
		}
		catch (NumberFormatException e) {
                ta.setText("Please enter valid numeric values for marks and registration number.");
            }
		}
		else if(ae.getSource()==b2)
		{
			ta1.setText(" ");
			for(Student a:t)
			{
				ta1.append(a.toString()+"\n");
			}
		}
		else
		{
			try{
			int x=Integer.parseInt(t6.getText());
			boolean found=false;
			for(Student a:t)
			{
				if(x==a.reg)
				{
					ta2.setText(a.toString());
					found=true;
					break;
				}
			}
			if(!found)
			{
				throw new Exception1("Student not found");
			}
			}
			catch(Exception1 e)
			{
				ta2.setText(e.getMessage());
			}
			catch (NumberFormatException e) {
                ta2.setText("Please enter valid numeric values for marks and registration number.");
            }
		}
	}
	public static void main(String[]args)
	{
		new Mark();
	}
}

	