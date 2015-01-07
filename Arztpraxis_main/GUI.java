import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoundedRangeModel;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;


public class GUI extends JFrame implements ActionListener
{
    private JTextArea tAusgabe; 
    private Rezeption rez;
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
    private JScrollPane scr;
    public GUI ()
    {
        
        super("Arztpraxis"); 
       
        
        
        
        
        
        
        
        
        setSize(550, 1000);
        setLayout(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        tAusgabe = new JTextArea();
        tAusgabe.setBounds(10,10, 400, 945);
        add(tAusgabe);

        bButton1 = new JButton("Patient hinzufügen");
        bButton1.setBounds(420,10, 100, 30);
        bButton1.addActionListener(this); 
        add(bButton1);

        bButton2 = new JButton("Bewege Arzt");
        bButton2.setBounds(420,50, 100, 30);
        bButton2.addActionListener(this); 
        add(bButton2);

        bButton3 = new JButton("Queue Zu Wartezimmer");
        bButton3.setBounds(420,90, 100, 30);
        bButton3.addActionListener(this); 
        add(bButton3);

        bButton4 = new JButton("Wartezimmer Zu Behandlungsraum");
        bButton4.setBounds(420,130, 100, 30);
        bButton4.addActionListener(this); 
        add(bButton4);

        bButton5 = new JButton("Behandlungeraum Leeren");
        bButton5.setBounds(420,170, 100, 30);
        bButton5.addActionListener(this); 
        add(bButton5);

        bButton6 = new JButton("Behandeln");
        bButton6.setBounds(420,210, 100, 30);
        bButton6.addActionListener(this); 
        add(bButton6);

        bButton7 = new JButton("Log ausgeben");
        bButton7.setBounds(420,250, 100, 30);
        bButton7.addActionListener(this); 
        add(bButton7);

        bButton8 = new JButton("Status ausgeben");
        bButton8.setBounds(420,290, 100, 30);
        bButton8.addActionListener(this); 
        add(bButton8);

        bButton9 = new JButton("Button 9");
        bButton9.setBounds(420,330, 100, 30);
        bButton9.addActionListener(this); 
        add(bButton9);

        bButton10 = new JButton("Button 10");
        bButton10.setBounds(420,370, 100, 30);
        bButton10.addActionListener(this); 
        add(bButton10);

        bButton11 = new JButton("Button 11");
        bButton11.setBounds(420,410, 100, 30);
        bButton11.addActionListener(this); 
        add(bButton11);

        bButton12 = new JButton("Button 12");
        bButton12.setBounds(420,450, 100, 30);
        bButton12.addActionListener(this); 
        add(bButton12);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {               
        if (e.getSource() == bButton1)
        {
            rez.neuerPatient();
        }
        if (e.getSource() == bButton2)
        {
            rez.bewegeArzt();
        }
        if (e.getSource() == bButton3)
        {
            rez.queueZuWartezimmer();
        }
        if (e.getSource() == bButton4)
        {
            rez.wartezimmerZuBehandlungsraum();
        }
        if (e.getSource() == bButton5)
        {
            rez.behandlungeraumLeeren();
        }
        if (e.getSource() == bButton6)
        {
            rez.behandeln();
        }
        if (e.getSource() == bButton7)
        {
            String a =rez.logAusgeben();
            tAusgabe.setText(a);
        }
        if (e.getSource() == bButton8)
        {
            String a = rez.statusAusgabe();
            tAusgabe.setText(a);
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