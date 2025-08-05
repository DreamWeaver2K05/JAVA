/*SASTRA University has decided to collect the feedback from students related to the end 
semester hybrid exams. Create a Swing application to capture the responses for the following 
questions from the students. 
 Course Code and Name 
 Whether all the required data are given? (Yes / No) 
 Is any question from out of syllabus? (Yes / No) 
 Standard of Questions in QP. (Good/Medium/Low) 
 Is time allotted sufficient? (Sufficient/Insufficient) 
 Nature of QP (Tough/Normal/Easy) 
For getting these details, use appropriate controls such as Textfield, Textarea, List/Choice and 
Radio Button.  
Create two buttons namely “Add” and “Display”. - - 
When the user clicks the Add button - Read the information from the GUI and store 
the feedback details in the array list. 
When the user clicks the Display button – Display the feedback details in a text area 
by iterating the array list. (Concatenate all the details into one single string and set 
this string to text area). 
Apply below validations to feedback response page. 
1. Display an user defined exception when the input for course code is missing */
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
	String name,code,dat,sy,st,ti,na;
	Student(String a,String b,String c,String d,String e,String f,String g)
	{
		name=a;
		code=b;
		dat=c;
		sy=d;
		st=e;
		ti=f;
		na=g;
	}
	public String toString()
	{
		return "course name:"+name+ "  course code:"+code+"  required data:"+dat+"  out of syllabus?:"+sy+"   standard of qp:"+st+"  time:"+ti+"  nature of qp"+na;
	}
}
class Feed extends JFrame implements ActionListener
{
	ArrayList<Student>s;
	String cname[]={"co","java","ds","dsd","em3"};
	String ccode[]={"cse105","cse208","cse103","ece101","mat 301 r01"};
	String sta[]={"good","medium","low"};
	String nat[]={"tough","normal","easy"};
	JComboBox<String> cb1,cb2,cb3,cb4;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextArea ta;
	JButton b1,b2;
	JRadioButton r1,r2,r3,r4,r5,r6;
	ButtonGroup bg1,bg2,bg3;
	Feed()
	{
	l1=new JLabel("STUDENT FEEDBACK");
	l2=new JLabel("course name");
	l3=new JLabel("course code");
	l4=new JLabel("whether the required data is given");
	l5=new JLabel("is any question from out of syllabus?");
	l6=new JLabel("standard of qs in qp");
	l7=new JLabel("is the time sufficient");
	l8=new JLabel("nature of question paper");
	b1=new JButton("add");
	b2=new JButton("display");
	cb1=new JComboBox<>(cname);
	cb2=new JComboBox<>(ccode);
	cb3=new JComboBox<>(sta);
	cb4=new JComboBox<>(nat);
	ta=new JTextArea(20,20);
	r1=new JRadioButton("yes");
	r2=new JRadioButton("no");
	r3=new JRadioButton("yes");
	r4=new JRadioButton("no");
	r5=new JRadioButton("sufficient");
	r6=new JRadioButton("insufficient");
	bg1 = new ButtonGroup();
    bg2 = new ButtonGroup();
    bg3 = new ButtonGroup();

	bg1.add(r1);
	bg1.add(r2);
	bg2.add(r3);
	bg2.add(r4);
	bg3.add(r5);
	bg3.add(r6);
	add(l1);
	add(l2);
	add(cb1);
	add(l3);
	add(cb2);
	add(l4);
	add(r1);
	add(r2);
	add(l5);
	add(r3);
	add(r4);
	add(l6);
	add(cb3);
	add(l7);
	add(r5);
	add(r6);
	add(l8);
	add(cb4);
	add(b1);
	add(b2);
	add(ta);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new FlowLayout());
	b1.addActionListener(this);
	b2.addActionListener(this);
	setSize(800,800);
	s=new ArrayList<Student>();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try{
			String s1=(String)cb1.getSelectedItem();
			String s2=(String)cb2.getSelectedItem();
			if(s1.isEmpty())
			{
				throw new Exception1("the course name should not be empty");
			}
			String s3=r1.isSelected()?"yes":"no";
			String s4=r3.isSelected()?"yes":"no";
			String s5=(String)cb3.getSelectedItem();
			String s6=r5.isSelected()?"sufficient":"insufficient";
			String s7=(String)cb4.getSelectedItem();
			Student n=new Student(s1,s2,s3,s4,s5,s6,s7);
			s.add(n);
			}
			catch(Exception1 e)
			{
				ta.setText(e.getMessage());
			}
		}
		else
		{
			for(Student a:s)
			{
				
				ta.append(a.toString()+"\n");
			}
		}
		
	}
	public static void main(String[]args)
	{
		new Feed();
	}
	}
	