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
class Book
{
	String title,author,genre;
	Double price;
	Book(String a,String b,String c,Double d)
	{
		title=a;
		author=b;
		genre=c;
		price=d;
	}
	public String toString()
	{
		return "Title:"+title+"  author:"+author+"  genre:"+genre+"   price:"+price;
	}
}
class First implements Comparator<Book>
{
	public int compare(Book b1,Book b2)
	{
		return Double.compare(b1.price,b2.price);
	}
}
class BookSearchEngine extends JFrame implements ActionListener
{
	JPanel jp1,jp2,jp3;
	ArrayList<Book>ts;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4;
	JComboBox<String> cb1;
	JButton b1,b2,b3,b4;
	JTextArea ta1,ta2;
	String gen[]={"fiction","non fiction","comedy","action thriller","killer","science fiction","adventure","mystery"};
	BookSearchEngine()
	{
		setLayout(new GridLayout(3,1));
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp2.setLayout(new FlowLayout());
		jp3.setLayout(new FlowLayout());
		l1=new JLabel("title:");
		l2=new JLabel("author:");
		l3=new JLabel("genre:");
		l4=new JLabel("price:");
		l5=new JLabel("enter the genre to be searched");
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		ta1=new JTextArea(10,20);
		ta2=new JTextArea(20,20);
		b1=new JButton("submit");
		b2=new JButton("clear");
		b3=new JButton("search");
		b4=new JButton("display");
		cb1=new JComboBox<String>(gen);
		jp2.add(l1);
		jp2.add(t1);
		jp2.add(l2);
		jp2.add(t2);
		jp2.add(l3);
		jp2.add(cb1);
		jp2.add(l4);
		jp2.add(t3);
		jp2.add(b1);
		jp2.add(b2);
		jp2.add(l5);
		jp2.add(t4);
		jp2.add(b3);
		jp2.add(ta1);
		jp3.add(b4);
		jp3.add(ta2);
		add(jp1);
		add(jp2);
		add(jp3);
		setVisible(true);
		setSize(800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		ts=new ArrayList<Book>();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String s1=t1.getText();
			String s2=t2.getText();
			String s3=(String)cb1.getSelectedItem();
			Double s4=Double.parseDouble(t3.getText());
			Book b=new Book(s1,s2,s3,s4);
			ts.add(b);
		}
		else if(ae.getSource()==b2)
		{
			t1.setText(" ");
			t2.setText(" ");
			t3.setText(" ");
			cb1.setSelectedIndex(0);
		}
		else if(ae.getSource()==b3)
		{
			try{
			Boolean n=false;
			ta2.setText(" ");
			for(Book b:ts)
			{
				if((b.genre).equals(t4.getText()))
				{
					ta1.append(b.toString()+"\n");
					n=true;
				}
			}
			if(n==false)
			{
				throw new Exception1("no books found with the given genre");
			}
			}
			catch(Exception1 e)
			{
				ta1.setText(e.getMessage());
			}
		}
		else if(ae.getSource()==b4)
		{
			ta2.setText(" ");
			Collections.sort(ts,new First());
			for(Book c:ts)
			{
				ta2.append(c.toString()+"\n");
			}
		}
	}
	public static void main(String[] args)
	{
		new BookSearchEngine();
	}
}
		
		
		
		
		
		