import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Exception1 extends Exception {
    Exception1(String s) {
        super(s);
    }
}

class Airline {
    String pname;
    int pid;
    int fno;
    String source;
    String dest;

    Airline(String a, int b, int c, String d, String e) {
        pname = a;
        pid = b;
        fno = c;
        source = d;
        dest = e;
    }
    public String toString() {
        return "Passenger Name: " + pname + ", Passenger ID: " + pid + ", Flight Number: " + fno + ", Source: " + source + ", Destination: " + dest;
    }
}

class First implements Comparator<Airline> {
    public int compare(Airline a, Airline b) {
        return a.pname.compareTo(b.pname);
    }
}

class Air1 extends JFrame implements ActionListener {
    TreeSet<Airline> treeSet;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton b1, b2, b3;
    JTextArea ta1, ta2;

    Air1() {
        l1 = new JLabel("Enter the passenger name");
        l2 = new JLabel("Enter the passenger id");
        l3 = new JLabel("Enter the flight number");
        l4 = new JLabel("Enter the source");
        l5 = new JLabel("Enter the destination");
        l6 = new JLabel("Enter the passenger id to be searched");

        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        t4 = new JTextField(20);
        t5 = new JTextField(20);
        t6 = new JTextField(20);

        ta1 = new JTextArea(10, 20);
        ta2 = new JTextArea(10, 20);

        b1 = new JButton("Submit");
        b2 = new JButton("Display");
        b3 = new JButton("Search");

        setLayout(new FlowLayout());

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
        add(l6);
        add(t6);
        add(b3);
        add(ta1);
        add(ta2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        setSize(800, 800);
        setVisible(true);

        treeSet = new TreeSet<>(new First());
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String s1 = t1.getText();
            int x = Integer.parseInt(t2.getText());
            int y = Integer.parseInt(t3.getText());
            String s2 = t4.getText();
            String s3 = t5.getText();
            Airline a = new Airline(s1, x, y, s2, s3);
            treeSet.add(a);
        } else if (ae.getSource() == b2) {
            ta1.setText("");
            for (Airline a : treeSet) {
                ta1.append(a.toString() + "\n");
            }
        } else if (ae.getSource() == b3) {
            try {
                int x = Integer.parseInt(t6.getText());
                boolean found = false;
                for (Airline a : treeSet) {
                    if (x == a.pid) {
                        ta2.setText(a.toString());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    throw new Exception1("Passenger not found");
                }
            } catch (Exception1 e) {
                ta2.setText(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Air1();
    }
}
