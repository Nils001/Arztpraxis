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

    private JTextArea anzahlw;
    private JTextArea anzahlb;
    private JTextArea wartezimmerplaetze;
    private JButton start;

    public GUI ()
    {
        super("Arztpraxis"); 
        setSize(770, 1000);
        setLayout(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        
        JTextArea anzahlw = new JTextArea();
        anzahlw.setBounds(640,10, 100, 30);
        add(anzahlw);

        JTextArea anzahlb = new JTextArea();
        anzahlb.setBounds(640,50, 100, 30);
        add(anzahlb);

        JTextArea wartezimmerplaetze = new JTextArea();
        wartezimmerplaetze.setBounds(640,90, 100, 30);
        add(wartezimmerplaetze);

        start = new JButton("Start");
        start.setBounds(640,130, 100, 30);
        start.addActionListener(this);
        add(start);

        tAusgabe = new JTextArea();
        tAusgabe.setBounds(10,10, 400, 945);
        tAusgabe.setVisible(true);
        add(tAusgabe);
        

        bButton1 = new JButton("Patient hinzufügen");
        bButton1.setBounds(420,10, 200, 30);
        bButton1.addActionListener(this); 
        //bButton1.setVisible(false);
        add(bButton1);

        bButton2 = new JButton("Bewege Arzt");
        bButton2.setBounds(420,50, 200, 30);
        bButton2.addActionListener(this); 
        //bButton2.setVisible(false);
        add(bButton2);

        bButton3 = new JButton("Queue Zu Wartezimmer");
        bButton3.setBounds(420,90, 200, 30);
        bButton3.addActionListener(this); 
        //bButton3.setVisible(false);
        add(bButton3);

        bButton4 = new JButton("Wartezimmer Zu Behandlungsraum");
        bButton4.setBounds(420,130, 200, 30);
        bButton4.addActionListener(this); 
        //bButton4.setVisible(false);
        add(bButton4);

        bButton5 = new JButton("Behandlungeraum Leeren");
        bButton5.setBounds(420,170, 200, 30);
        bButton5.addActionListener(this); 
        //bButton5.setVisible(false);
        add(bButton5);

        bButton6 = new JButton("Behandeln");
        bButton6.setBounds(420,210, 200, 30);
        bButton6.addActionListener(this); 
        //bButton6.setVisible(false);
        add(bButton6);

        bButton7 = new JButton("Log ausgeben");
        bButton7.setBounds(420,250, 200, 30);
        bButton7.addActionListener(this); 
        //bButton7.setVisible(false);
        add(bButton7);

        bButton8 = new JButton("Status ausgeben");
        bButton8.setBounds(420,290, 200, 30);
        bButton8.addActionListener(this); 
        //bButton8.setVisible(false);
        add(bButton8);

        bButton9 = new JButton("Button 9");
        bButton9.setBounds(420,330, 200, 30);
        bButton9.addActionListener(this); 
        //bButton9.setVisible(false);
        add(bButton9);

        bButton10 = new JButton("Button 10");
        bButton10.setBounds(420,370, 200, 30);
        bButton10.addActionListener(this); 
        //bButton10.setVisible(false);
        add(bButton10);

        bButton11 = new JButton("Button 11");
        bButton11.setBounds(420,410, 200, 30);
        bButton11.addActionListener(this); 
        //bButton11.setVisible(false);
        add(bButton11);

        bButton12 = new JButton("Button 12");
        bButton12.setBounds(420,450, 200, 30);
        bButton12.addActionListener(this); 
        //bButton12.setVisible(false);
        add(bButton12);   

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {   
        Object src = e.getSource();
        if (src == start)
        {
            System.out.println("start");
            String a = anzahlw.getText();
            System.out.println("string a");
            String b = anzahlb.getText();
            System.out.println("string b");
            String c = wartezimmerplaetze.getText();
            System.out.println("string c");
            int aa = Integer.parseInt(a);
            System.out.println("int aa");
            int bb = Integer.parseInt(b);
            System.out.println("int bb");
            int cc = Integer.parseInt(c);
            System.out.println("int cc");
            rez = new Rezeption(aa,bb,cc);
            System.out.println("neue rezeption");
            //anzahlw.setVisible(false);
            //anzahlb.setVisible(false);
            //wartezimmerplaetze.setVisible(false);
            //start.setVisible(false);

            /*bButton12.setVisible(true);
            bButton11.setVisible(true);
            bButton10.setVisible(true);
            bButton9.setVisible(true);
            bButton8.setVisible(true);
            bButton7.setVisible(true);
            bButton6.setVisible(true);
            bButton5.setVisible(true);
            bButton4.setVisible(true);
            bButton3.setVisible(true);
            bButton2.setVisible(true);
            bButton1.setVisible(true);*/
        }
        if (src == bButton1)
        {
            rez.neuerPatient();
        }
        if (src == bButton2)
        {
            rez.bewegeArzt();
        }
        if (src == bButton3)
        {
            rez.queueZuWartezimmer();
        }
        if (src == bButton4)
        {
            rez.wartezimmerZuBehandlungsraum();
        }
        if (src == bButton5)
        {
            rez.behandlungeraumLeeren();
        }
        if (src == bButton6)
        {
            rez.behandeln();
        }
        if (src == bButton7)
        {
            String a =rez.logAusgeben();
            tAusgabe.setText(a);
        }
        if (src == bButton8)
        {
            String a = rez.statusAusgabe();
            tAusgabe.setText(a);
        }
        if (src == bButton9)
        {

        }
        if (src == bButton10)
        {

        }
        if (src == bButton11)
        {

        }
        if (src == bButton12)
        {

        }
    }
}