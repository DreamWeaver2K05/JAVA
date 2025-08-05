import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Comparator;
import java.util.TreeSet;
class Exception1 extends Exception
{
	Exception1(String s)
	{
		super(s);
	}
}
class Co
{
	String cname;
	int cid;
	String state;
	String gen;
	String it;
	Co(String a,int b,String c,String d,String e)
	{
		cname=a;
		cid=b;
		state=c;
		gen=d;
		it=e;
	}
	public String toString()
	{
		return "customer name:"+cname+" customer id:"+cid+" state:"+state+" gender:"+gen+" items"+it;
	}
}
class First implements Comparator<Co>
{
	public int compare(Co Co1,Co Co2)
	{
		return (Co1.cname).compareTo(Co2.cname);
	}
}
class Applicant extends JFrame implements ActionListener,ItemListener
{
	Timer t;
	int x=0;
	JPanel jp1,jp2,jp3;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2;
	JComboBox<String>cb1;
	JRadioButton r1,r2;
	JCheckBox c1,c2,c3,c4;
	JButton b1,b2,b3;
	StringBuilder sb=new StringBuilder();
	JTextArea ta1,ta2;
	String state[]={"tamilnadu","kerala","karnataka","telangana","madhya pradesh","gujarat","assam","rajasthan"};
	TreeSet<Co>ts;
	ButtonGroup bg1;
	Applicant()
	{
		setLayout(new GridLayout(3,1));
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp2.setLayout(new FlowLayout());
		jp3.setLayout(new FlowLayout());
		t=new Timer(500,this);
		t.start();
		l1=new JLabel("customer name");
		l2=new JLabel("customer id");
		l3=new JLabel("customer state");
		l4=new JLabel("customer gender ");
		l5=new JLabel("items");
		t1=new JTextField(20);
		t2=new JTextField(20);
		cb1=new JComboBox<String>(state);
		r1=new JRadioButton("male");
		r2=new JRadioButton("female");
		b1=new JButton("submit");
		b2=new JButton("clear");
		b3=new JButton("display");
		c1=new JCheckBox("rice");
		c2=new JCheckBox("wheat");
		c3=new JCheckBox("soap");
		c4=new JCheckBox("paper");
		ta1=new JTextArea(10,20);
		ta2=new JTextArea(10,20);
		bg1=new ButtonGroup();
		bg1.add(r1);
		bg1.add(r2);
		jp2.add(l1);
		jp2.add(t1);
		jp2.add(l2);
		jp2.add(t2);
		jp2.add(l3);
		jp2.add(cb1);
		jp2.add(l4);
		jp2.add(r1);
		jp2.add(r2);
		jp2.add(l5);
		jp2.add(c1);
		jp2.add(c2);
		jp2.add(c3);
		jp2.add(c4);
		jp2.add(b1);
		jp2.add(ta1);
		jp2.add(b2);
		jp3.add(b3);
		jp3.add(ta2);
		add(jp1);
		add(jp2);
		add(jp3);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
        c4.addItemListener(this);
		setSize(800,800);
		ts=new TreeSet<Co>(new First());
	}
	public void actionPerformed(ActionEvent ae)
	{
		repaint();
		x+=20;
		if(ae.getSource()==b1)
		{
			try{
			String s1=t1.getText();
			int s2=Integer.parseInt(t2.getText());
			String s3=(String)cb1.getSelectedItem();
			String s4=r1.isSelected()?"male":"female";
			String s5=sb.toString();
			for(Co c:ts)
			{
				if(c.cid==s2)
				{
					throw new Exception1("the customer id already exists");
				}
			}
			Co n=new Co(s1,s2,s3,s4,s5);
			ts.add(n);
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
			cb1.setSelectedIndex(0);
			c1.setSelected(false);
			c2.setSelected(false);
			c3.setSelected(false);
			c4.setSelected(false);
		}
		else if(ae.getSource()==b3)
		{
			for(Co a:ts)
			{
				ta2.append(a.toString()+"\n");
			}
		}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		if(x>780)
			x=0;
		g.drawString("welcome to abc store",x,60);
	}
	public void itemStateChanged(ItemEvent e)
	{
		sb.setLength(0);
		if(c1.isSelected())
		{
			sb.append(c1.getActionCommand());
		}
		if(c2.isSelected())
		{
			sb.append(c2.getActionCommand());
		}
		if(c3.isSelected())
		{
			sb.append(c3.getActionCommand());
		}
		if(c4.isSelected())
		{
			sb.append(c4.getActionCommand());
		}
	}
	public static void main(String[]args)
	{
		new Applicant();
	}
}	
		
		
		