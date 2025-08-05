import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class Text extends JFrame 
{
	JPopupMenu p;
	JMenuBar mb;
	JMenu f,e,v;
	JMenuItem f1,f2,f3,f4,f5,e1,e2,e3,v1,v2,v3;
	Text()
	{
		p=new JPopupMenu();
		mb=new JMenuBar();
		f=new JMenu("file");
		f1=new JMenuItem("new");
		f2=new JMenuItem("open");
		f3=new JMenuItem("save");
		f4=new JMenuItem("save as");
		f5=new JMenuItem("rename");
		e=new JMenu("edit");
		e.setToolTipText("edit");
		f1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		f.setToolTipText("edit");
		e1=new JMenuItem("cut");
		e2=new JMenuItem("copy");
		e3=new JMenuItem("paste");
		v=new JMenu("view");
		v1=new JMenu("zoom");
		v2=new JMenuItem("zoom in");
		v3=new JMenuItem("zom out");
		f.add(f1);
		f.add(f2);
		f.add(f3);
		f.add(f4);
		f.add(f5);
		e.add(e1);
		e.add(e2);
		e.add(e3);
		v.add(v1);
		v1.add(v2);
		v1.add(v3);
		setJMenuBar(mb);
		mb.add(f);
		mb.add(e);
		mb.add(v);
		p.add(e1);
		p.add(e2);
		p.add(e3);
		addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent s)
			{
				if(s.isPopupTrigger())
				{
					p.show(s.getComponent(),s.getX(),s.getY());
				}
		}});
		add(p);
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[]args)
	{
		new Text();
	}
}
	
		
		
		
		
		
		
		
		