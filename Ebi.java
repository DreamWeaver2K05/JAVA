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
class Ebill
{
	double st,end,bill,unit;
	int n;
	String name;
	Ebill(int a,String b,double c,double d,double e,double f)
	{
		n=a;
		name=b;
		st=c;
		end=d;
		unit=e;
		bill=f;
	}
	public String toString()
	{
		return "house number:"+n+" tenant name:"+name+" starting:"+st+" ending:"+end+" unit:"+unit+"  bill amount:"+bill;
	}
}
class Ebi extends JFrame implements ActionListener
{
	HashMap<Integer,Ebill>a;
	JTextArea ta1,ta2,ta3;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JLabel l1,l2,l3,l4,l5,l6;
	JButton b1,b2,b3,b4;
	Ebi()
	{
		t1=new JTextField(10);
		t2=new JTextField(10);
		t3=new JTextField(10);
		t4=new JTextField(10);
		t5=new JTextField(10);
		t6=new JTextField(10);
		t7=new JTextField(10);
		ta1=new JTextArea(10,10);
		ta2=new JTextArea(20,20);
		ta3=new JTextArea(10,10);
		l1=new JLabel("house number");
		l2=new JLabel("tenant number");
		l3=new JLabel("starting meter");
		l4=new JLabel("ending meter");
		l5=new JLabel("unit");
		l6=new JLabel("enter the house number to be searched");
		b1=new JButton("add");
		b2=new JButton("bill");
		b3=new JButton("display");
		b4=new JButton("search");
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
		add(b2);
		add(t6);
		add(ta1);
		add(b3);
		add(ta2);
		add(l6);
		add(t7);
		add(b4);
		add(ta3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		setSize(800,800);
		setVisible(true);
		b1.setBackground(Color.cyan);
		b2.setBackground(Color.pink);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		a=new HashMap<Integer,Ebill>();
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
			if(!(s1>0&&s1<5))
			{ 
				throw new Exception1("house not found");
			}
			Ebill e=new Ebill(s1,s2,s3,s4,s5,s6);
			a.put(s1,e);}
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
			t6.setText(s6.toString());
		}
		else if(ae.getSource()==b3)
		{
			Set<Map.Entry<Integer,Ebill>>s=a.entrySet();
			for(Map.Entry<Integer,Ebill>e:s)
			{
				ta2.append(e.toString()+"\n");
			}
		}
		else
		{
			int x=Integer.parseInt(t7.getText());
			/*Set<Map.Entry<Integer,Ebill>>s=a.entrySet();
			for(Map.Entry<Integer,Ebill>h:s)
			{
				
				if(x==h.getKey())
				{
					ta3.setText(h.toString());
					break;
				}
			}*/
			Ebill s=a.get(x);
			ta3.setText(s.toString());
		}
	}
	public static void main(String[]args)
	{
		new Ebi();
	}
}
			