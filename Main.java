import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Main implements ActionListener
{
    JFrame f;
    JLabel l1,l2;
    JTextField t1,t2,t3;
    JButton b1;
    Main()
    {
        f=new JFrame("logic screen");
        l1=new JLabel("enter the username");
        l2=new JLabel("enter the password");
        t1=new JTextField(10);
        t2=new JTextField(10);
        t3=new JTextField(10);
        b1=new JButton("submit");
        f.setLayout(new FlowLayout());
        f.add(l1);
		f.add(t1);
        f.add(l2);
		f.add(t2);
        f.add(b1);
        f.add(t3);
        f.setSize(400,400);
        f.setVisible(true);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String s=t1.getText();
        String s1=t2.getText();
        int x=Integer.parseInt(s1);
        if(s.equals("SASTRA")&&x==12345)
        {
            t3.setText("valid user");
        }
        else
        {
            t3.setText("access denied");
        }
    }
    public static void main(String[]args)
    {
        new Main();
    }
}