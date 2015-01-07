import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener
{
    private JTextField tAusgabe; 

    private JButton bButton1;
    private JButton bButton2;
    private JButton bButton3;
    private JButton bButton4;
    private JButton bButton5;
    private JButton bButton6;
    private JButton bButton7;
    private JButton bButton8;
    private JButton bButton9;
    private JButton bButton10;
    private JButton bButton11;
    private JButton bButton12;
    
    public GUI ()
    {
        super("Arztpraxis"); 
        setSize(500, 500);
        setLayout(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        tAusgabe = new JTextField();
        tAusgabe.setBounds(10,10, 200, 500);
        add(tAusgabe);

        bButton1 = new JButton("Button 1");
        bButton1.setBounds(280,10, 100, 30);
        bButton1.addActionListener(this); 
        add(bButton1);

        bButton2 = new JButton("Button 2");
        bButton2.setBounds(280,10, 100, 30);
        bButton2.addActionListener(this); 
        add(bButton1);

        bButton3 = new JButton("Button 3");
        bButton3.setBounds(280,10, 100, 30);
        bButton3.addActionListener(this); 
        add(bButton3);

        bButton4 = new JButton("Button 4");
        bButton4.setBounds(280,10, 100, 30);
        bButton4.addActionListener(this); 
        add(bButton4);

        bButton5 = new JButton("Button 5");
        bButton5.setBounds(280,10, 100, 30);
        bButton5.addActionListener(this); 
        add(bButton5);

        bButton6 = new JButton("Button 6");
        bButton6.setBounds(280,10, 100, 30);
        bButton6.addActionListener(this); 
        add(bButton6);

        bButton7 = new JButton("Button 7");
        bButton7.setBounds(280,10, 100, 30);
        bButton7.addActionListener(this); 
        add(bButton7);

        bButton8 = new JButton("Button 8");
        bButton8.setBounds(280,10, 100, 30);
        bButton8.addActionListener(this); 
        add(bButton8);

        bButton9 = new JButton("Button 9");
        bButton9.setBounds(280,10, 100, 30);
        bButton9.addActionListener(this); 
        add(bButton9);

        bButton10 = new JButton("Button 10");
        bButton10.setBounds(280,10, 100, 30);
        bButton10.addActionListener(this); 
        add(bButton10);

        bButton11 = new JButton("Button 11");
        bButton11.setBounds(280,10, 100, 30);
        bButton11.addActionListener(this); 
        add(bButton11);

        bButton12 = new JButton("Button 12");
        bButton12.setBounds(280,10, 100, 30);
        bButton12.addActionListener(this); 
        add(bButton12);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {               
        if (e.getSource() == bButton1)
        {

        }
        if (e.getSource() == bButton2)
        {

        }
        if (e.getSource() == bButton3)
        {

        }
        if (e.getSource() == bButton4)
        {

        }
        if (e.getSource() == bButton5)
        {

        }
        if (e.getSource() == bButton6)
        {

        }
        if (e.getSource() == bButton7)
        {

        }
        if (e.getSource() == bButton8)
        {

        }
        if (e.getSource() == bButton9)
        {

        }
        if (e.getSource() == bButton10)
        {

        }
        if (e.getSource() == bButton11)
        {

        }
        if (e.getSource() == bButton12)
        {

        }
    }
}