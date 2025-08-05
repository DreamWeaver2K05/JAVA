import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
class Game
{
	int max;
	int attempts;
	int target;
	int rounds;
	Game()
	{
		max=10;
		attempts=0;
		rounds=0;
		target=generate();
	}
	int generate()
	{
		Random random=new Random();
		return random.nextInt(100)+1;
	}
	int getRounds()
	{
		return rounds;
	}
	int incAttempts()
	{
		return attempts++;
	}
	boolean maxAttempts()
	{
		return attempts>=max;
	}
	int getTarget()
	{
		return target;
	}
	int getAttempts()
	{
		return attempts;
	}
	int getMax()
	{
		return max;
	}
	void setup()
	{
		target=generate();
		attempts=0;
	}
	void incRounds()
	{
		rounds++;
	}
}
class Guess extends JFrame implements ActionListener
{
	JTextField t1;
	JButton b1;
	JLabel l1,l2,l3;
	JPanel p1;
	int score;
	Game g=new Game();
	Guess()
	{
		t1=new JTextField(3);
		b1=new JButton("guess number");
		l1=new JLabel("Welcome to Number Guessing game",JLabel.CENTER);
		l2=new JLabel("guess a number between 1 to 100");
		l3=new JLabel("attempts remaining"+(g.getMax()-g.getAttempts()));
		p1=new JPanel();
		p1.setLayout(new GridLayout(5,1));
		p1.add(l1);
		p1.add(l2);
		p1.add(t1);
		p1.add(b1);
		p1.add(l3);
		add(p1);
		setVisible(true);
		setSize(800,800);
		b1.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	void resetGame()
	{
        g.setup();
        l2.setText("Enter your guess above.");
        l3.setText("Attempts left: " + (g.getMax() - g.getAttempts()));
        t1.setText("");
        b1.setEnabled(true);
    }
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try
			{
				g.incAttempts();
				int n=Integer.parseInt(t1.getText());
				if(g.getTarget()>n)
				{
					l2.setText("too low,try again");
				}
				else if(g.getTarget()<n)
				{
					l2.setText("too high,try again");
				}
				else 
				{
					l2.setText("Correct! The number was " + g.getTarget() + ".");
                    score +=(g.getMax() - g.getAttempts() + 1);
                    b1.setEnabled(false);
                    int option = JOptionPane.showConfirmDialog(this,"You guessed the number! Play again?", "Play Again", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION)
					{
                        g.incRounds();
                        resetGame();
                    } else {
                        JOptionPane.showMessageDialog(this, "Thank you for playing! You played " + (g.getRounds() + 1) + " round(s) with a score of " + score + ".");
                        System.exit(0);
                    }
				}
                /*if (!g.maxAttempts() && n != g.getTarget()) {
                    l3.setText("Attempts remaining: " + (g.getMax() - g.getAttempts()));
                } 
				else if (n!= g.getTarget()) 
				{
                    l2.setText("Sorry! You've used all your attempts. The correct number was: " + g.getTarget());
                    b1.setEnabled(false);
                }
				t1.setText("");*/
				 if (g.getAttempts() >= g.getMax() && n!= g.getTarget())
				 {
                    l2.setText("Out of attempts! The number was " + g.getTarget() + ".");
                    b1.setEnabled(false);
                    int option = JOptionPane.showConfirmDialog( this,"Out of attempts! Play again?", "Play Again", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        g.incRounds();
                        resetGame();
                    } else {
                        JOptionPane.showMessageDialog(this,"Thank you for playing! You played " + (g.getRounds()+ 1) + " round(s) with a score of " + score + ".");
                        System.exit(0);
                    }
                }

                l3.setText("Attempts left: " + (g.getMax()-g.getAttempts()));
			}
			catch(NumberFormatException e)
			{
				l2.setText("enter a valid number");
			}
		}
	}
	public static void main(String args[])
	{
		new Guess();
	}
}
