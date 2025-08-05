/*Football board wants to maintain the player's profile and find the top  goalkeepers based on 
their shot stopping rate and also finds top  fieldplayers based on their number of goals shot. For 
these purpose  create a class called "Human" which has three data members "Name" of string 
datatype, "count" of int type to mention the number of matches played by the player, "id" of 
int type is used to identify the player uniquely. Create subclass called "Goalkeeper" which is 
derived from "Human" which includes data member "Total_stopping_shots" of int type to 
mention the total number of shots stopped so far, another data member "stoprate" of int type 
and it is calculated by dividing Total_stopping_shots by count. Create another subclass 
"FieldPlayer" from “Human” which includes data member "goal_count" of int type. Create a 
GUI with the following Swing components. 
1.Two Radio button with caption "Field Player" and "Goalie" 
2.Four text fields to receive name, id, match count, total stopping shots(if Goalie) /  goals count 
(if Fieldplayer) 
3.One text area to display the player details 
4.Seven buttons with caption "Insert", "search", "best player", "<<", "<", ">", ">>" 
To get the field player details, first press the radio button "Field Player", enter the details in the 
corresponding text field then add the details in the Arraylist1 by pressing "Insert" button. 
To get the Goalie details, first press the radio button "Goalie", enter the details in the 
corresponding text field then add the details in the Arraylist2 by pressing "Insert" button. Check 
that all required fields are filled or not before pressing the "Insert" button. If it is not properly 
filled out, throw the user-defined Exception. 
When we press the "search" button, Search the player details based on the id. When we press 
the button "bestplayer" displays the best Field player details based on goal count and best goalie 
details based on the stop rate in the text area. 
When we press the "<<" button shows the first field player details in the text area. 
When we press "<", ">", ">>" these buttons show the previous, next, last field player details 
respectively in the text area.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Human
{
	String name;
	int id,count;
	Human(String a,int b,int c)
	{
		name=a;
		id=b;
		count=c;
	}
}
class GoalKeeper extends Human
{
	int tss,stoprate;
	GoalKeeper(String name,int id,int count,int a)
	{
		super(name,id,count);
		tss=a;
		if(count==0)
		{
			stoprate=0;
		}
		else if(count<=0)
		{
			stoprate=tss/count;
		}
	}
	public String toString()
	{
		return "name:"+name+" id:"+id+" count:"+count+" total stopping shots:"+tss+" stoprate:"+stoprate;
	}
}
class FieldPlayer extends Human
{
	int gcount;
	FieldPlayer(String name,int id,int count,int a)
	{
		super(name,id,count);
		gcount=a;
	}
	public String toString()
	{
		return "name:"+name+" id:"+id+" count:"+count+" goal count:"+gcount;
	}
}
class Player extends JFrame implements ActionListener
{
	ArrayList<GoalKeeper>a1;
	ArrayList<FieldPlayer>a2;
	JRadioButton r1,r2;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3,b4,b5,b6,b7;
	JTextArea ta1;
	ButtonGroup bg1;
	Player()
	{
		r1=new JRadioButton("field player");
		r2=new JRadioButton("goal keeper");
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		ta1=new JTextArea(20,20);
		b1=new JButton("insert");
		b2=new JButton("search");
		b3=new JButton("best player");
		b4=new JButton("<<");
		b5=new JButton("<");
		b6=new JButton(">");
		b7=new JButton(">>");
		l1=new JLabel("name");
		l2=new JLabel("id");
		l3=new JLabel("count");
		l4=new JLabel("total stoping rate/goal count");
		l5=new JLabel("id to be searched");
		bg1=new ButtonGroup();
		bg1.add(r1);
		bg1.add(r2);
		add(r1);
		add(r2);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(b1);
		add(l5);
		add(t5);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(ta1);
		t1.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent e)
			{
				if(t1.getText().equals("enter"))
				{
					t1.setText("");
				}
			}
			public void focusLost(FocusEvent e)
			{
				if(t1.getText().equals(""))
				{
					t1.setText("enter");
				}
			}
		});
		t3.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent e)
			{
				if(t3.getText().equals("enter"))
				{
					t3.setText("");
				}
			}
			public void focusLost(FocusEvent e)
			{
				if(t3.getText().equals(""))
				{
					t3.setText("enter");
				}
			}
		});
		t4.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent e)
			{
				if(t4.getText().equals("enter"))
				{
					t4.setText("");
				}
			}
			public void focusLost(FocusEvent e)
			{
				if(t4.getText().equals(""))
				{
					t4.setText("enter");
				}
			}
		});
		t2.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent e)
			{
				if(t2.getText().equals("enter"))
				{
					t2.setText("");
				}
			}
			public void focusLost(FocusEvent e)
			{
				if(t2.getText().equals(""))
				{
					t2.setText("enter");
				}
			}
		});
		t5.addFocusListener(new FocusAdapter()
		{
			public void focusGained(FocusEvent e)
			{
				if(t5.getText().equals("enter"))
				{
					t5.setText("");
				}
			}
			public void focusLost(FocusEvent e)
			{
				if(t5.getText().equals(""))
				{
					t5.setText("enter");
				}
			}
		});
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		setSize(800,800);
		setVisible(true);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		a1=new ArrayList<>();
		a2=new ArrayList<>();
	}
		
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			if(r1.isSelected())
			{
				String s1=t1.getText();
				int s2=Integer.parseInt(t2.getText());
				int s3=Integer.parseInt(t3.getText());
				int s4=Integer.parseInt(t4.getText());
				FieldPlayer f=new FieldPlayer(s1,s2,s3,s4);
				a2.add(f);
			}
			else
			{
				String s1=t1.getText();
				int s2=Integer.parseInt(t2.getText());
				int s3=Integer.parseInt(t3.getText());
				int s4=Integer.parseInt(t4.getText());
				GoalKeeper g=new GoalKeeper(s1,s2,s3,s4);
				a1.add(g);
			}
		}
		else if(ae.getSource()==b2)
		{
			int s=Integer.parseInt(t5.getText());
			if(r1.isSelected())
			{
				for(FieldPlayer p:a2)
				{
					if(p.id==s)
					{
						ta1.setText(p.toString());
					}
				}
			}
			else
			{
				for(GoalKeeper g:a1)
				{
					if(g.id==s)
					{
						ta1.setText(g.toString());
					}
				}
			}
		}
		else if(ae.getSource()==b3)
		{
			int max=0,pos=0,i=0;
			if(r1.isSelected())
			{
				for(FieldPlayer p:a2)
				{
					
					if(p.gcount>max)
					{
						max=p.gcount;
						pos=i;
					}
					i++;
				}
				ta1.setText(a2.get(pos).toString());
			}
			else
			{
				for(GoalKeeper g:a1)
				{
					if(g.stoprate>max)
					{
						max=g.stoprate;
						pos=i;
					}
					i++;
				}
				ta1.setText(a1.get(pos).toString());
			}
		}
		else if(ae.getSource()==b4)
		{
			if(r1.isSelected()){	
				ta1.setText((a2.get(0)).toString());
		    }
		    else
			{
				ta1.setText(a1.get(0).toString());
			}
		}
		else if(ae.getSource()==b5)
		{
			String s=ta1.getText();
			String arr[]=s.split(" ");
			String name[]=arr[0].split(":");
			String playername=name[1];
			int i=0,pos=-1;
			if(r1.isSelected())
			{
				for(FieldPlayer p:a2)
				{
					if(p.name.equals(playername))
					{
						pos=i;
						break;
					}
					i++;
				}
				if(pos<=0)
				{
					ta1.setText("no previous player");
				}
				else
				{
					ta1.setText(a2.get(pos-1).toString());
				}
			}
			else
			{
				for(GoalKeeper g:a1)
				{
					if(g.name.equals(playername))
					{
						pos=i;
						break;
					}
					i++;
				}
				if(pos<=0)
				{
					ta1.setText("no previous player");
				}
				else
				{
					ta1.setText(a1.get(pos-1).toString());
				}
			}
		}
		else if(ae.getSource()==b6)
		{
			String s=ta1.getText();
			String arr[]=s.split(" ");
			String name[]=arr[0].split(":");
			String playername=name[1];
			int i=0,pos=-1;
			if(r1.isSelected())
			{
				for(FieldPlayer p:a2)
				{
					if(p.name.equals(playername))
					{
						pos=i;
						break;
					}
					i++;
				}
				if(pos>=a2.size())
				{
					ta1.setText("no next player");
				}
				else
				{
					ta1.setText(a2.get(pos+1).toString());
				}
			}
			else
			{
				for(GoalKeeper g:a1)
				{
					if(g.name.equals(playername))
					{
						pos=i;
						break;
					}
					i++;
				}
				if(pos>=a1.size())
				{
					ta1.setText("no previous player");
				}
				else
				{
					ta1.setText(a1.get(pos+1).toString());
				}
			}
		}
		else
		{
			if(r1.isSelected()){	
				ta1.setText((a2.get(a2.size()-1)).toString());
		    }
		    else
			{
				ta1.setText(a1.get(a1.size()-1).toString());
			}
		}
	}
	public static void main(String[]args)
	{
		new Player();
	}
}
			
	
	
		