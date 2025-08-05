import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class Button extends JFrame implements ActionListener
{
	JButton b1,b2;
	Button()
	{
		b1=new JButton("red");
		b2=new JButton("blue");
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setSize(500,500);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		if(s.equals("red"))
		{
			System.out.println("red button is selected");
		}
		else
		{
			System.out.println("blue button is selected");
		}
	}
	public static void main(String[] args)
	{
		Button b=new Button();
	}
}