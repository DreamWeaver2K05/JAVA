import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class Mouse implements MouseListener
{
	JFrame f;
	JTextField t1;
	Mouse()
	{
		f=new JFrame("Demonstrating mouse actions");
		t1=new JTextField(10);
		f.setLayout(new FlowLayout());
		f.add(t1);
		f.addMouseListener(this);
		f.setSize(200,200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void mouseEntered(MouseEvent e)
	{}
	public void mouseExited(MouseEvent e)
	{}
	public void mousePressed(MouseEvent e)
	{}
	public void mouseReleased(MouseEvent e)
	{}
	public void mouseClicked(MouseEvent e)
	{
		String x=Integer.toString(e.getX());
		String y=Integer.toString(e.getY());
		t1.setText(x+","+y);
	}
	public static void main(String[]args)
	{
		Mouse f=new Mouse();
	}
}