import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
class Tabledemo extends JFrame
{
	String[] colheads={"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
	Object[][]data={
		{"","","","","1","2","3"},
		{"4","5","6","7","8","9","10"},
		{"11","12","13","14","15","16","17"},
		{"18","19","20","21","22","23","24"},
		{"25","26","27","28","29","30",""}};
	JLabel l1,l2;
	JScrollPane sp;
	Timer t;
	JTable ta;
	Double x=00.00;
	DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	Tabledemo()
	{
		setLayout(new FlowLayout());
		t=new Timer(1000,new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				updateTime();
			}
		});
		t.start();
		l1=new JLabel("November,2024");
		l2=new JLabel();
		ta=new JTable(data,colheads);
		sp=new JScrollPane(ta);
		add(l1);
		add(l2);
		add(sp);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,800);
	}
	void updateTime()
	{
		LocalTime currentTime=LocalTime.now();
		l2.setText(currentTime.format(timeFormatter));
	}
	public static void main(String[]args)
	{
		SwingUtilities.invokeLater(()->new Tabledemo());
	}
}
	
	
		
		
		
		
		
	
