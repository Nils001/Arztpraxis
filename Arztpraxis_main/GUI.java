import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;

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
    private JLabel lanzahlw;
    private JLabel lanzahlb;
    private JLabel lwartezimmer;
    private JOptionPane popup;
    private JTextField anzahlw;
    private JTextField anzahlb;
    private JTextField wartezimmerplaetze;
    private JButton start;

    public GUI ()
    {
        super("Arztpraxis Alpha"); 
        setSize(770, 1000);
        setLayout(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        popup = new JOptionPane();

        lanzahlw = new JLabel("Anzahl Wartezimmer");
        lanzahlw.setBounds(170,100, 200, 30);
        add(lanzahlw);

        lanzahlb = new JLabel("Anzahl Behandlungsräume");
        lanzahlb.setBounds(170,140, 200, 30);
        add(lanzahlb);

        lwartezimmer = new JLabel("Plätze im Wartezimmer");
        lwartezimmer.setBounds(170,180, 200, 30);
        add(lwartezimmer);

        anzahlw = new JTextField();
        anzahlw.setBounds(390,100, 100, 30);
        add(anzahlw);

        anzahlb = new JTextField();
        anzahlb.setBounds(390,140, 100, 30);
        add(anzahlb);

        wartezimmerplaetze = new JTextField();
        wartezimmerplaetze.setBounds(390,180, 100, 30);
        add(wartezimmerplaetze);

        start = new JButton("Start");
        start.setBounds(390,220, 100, 30);
        start.addActionListener(this);
        add(start);

        tAusgabe = new JTextArea();
        tAusgabe.setBounds(10,10, 400, 945);
        tAusgabe.setVisible(false);
        add(tAusgabe);

        bButton1 = new JButton("Patient hinzufügen");
        bButton1.setBounds(420,10, 300, 30);
        bButton1.addActionListener(this); 
        bButton1.setVisible(false);
        add(bButton1);

        bButton2 = new JButton("Bewege Arzt");
        bButton2.setBounds(420,50, 300, 30);
        bButton2.addActionListener(this); 
        bButton2.setVisible(false);
        add(bButton2);

        bButton3 = new JButton("Queue Zu Wartezimmer");
        bButton3.setBounds(420,90, 300, 30);
        bButton3.addActionListener(this); 
        bButton3.setVisible(false);
        add(bButton3);

        bButton4 = new JButton("Wartezimmer Zu Behandlungsraum");
        bButton4.setBounds(420,130, 300, 30);
        bButton4.addActionListener(this); 
        bButton4.setVisible(false);
        add(bButton4);

        bButton5 = new JButton("Behandlungeraum Leeren");
        bButton5.setBounds(420,170, 300, 30);
        bButton5.addActionListener(this); 
        bButton5.setVisible(false);
        add(bButton5);

        bButton6 = new JButton("Behandeln");
        bButton6.setBounds(420,210, 300, 30);
        bButton6.addActionListener(this); 
        bButton6.setVisible(false);
        add(bButton6);

        bButton7 = new JButton("Log ausgeben");
        bButton7.setBounds(420,250, 300, 30);
        bButton7.addActionListener(this); 
        bButton7.setVisible(false);
        add(bButton7);

        bButton8 = new JButton("Status ausgeben");
        bButton8.setBounds(420,290, 300, 30);
        bButton8.addActionListener(this); 
        bButton8.setVisible(false);
        add(bButton8);

        bButton9 = new JButton("Ist ein Behandlungsraum besetzt ?");
        bButton9.setBounds(420,330, 300, 30);
        bButton9.addActionListener(this); 
        bButton9.setVisible(false);
        add(bButton9);

        bButton10 = new JButton("Ist ein Wartezimmer besetzt ?");
        bButton10.setBounds(420,370, 300, 30);
        bButton10.addActionListener(this); 
        bButton10.setVisible(false);
        add(bButton10);

        bButton11 = new JButton("Button 11");
        bButton11.setBounds(420,410, 300, 30);
        bButton11.addActionListener(this); 
        bButton11.setVisible(false);
        add(bButton11);

        bButton12 = new JButton("Clear");
        bButton12.setBounds(420,450, 300, 30);
        bButton12.addActionListener(this); 
        bButton12.setVisible(false);
        add(bButton12);   

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {   
        Object src = e.getSource();
        if (src == start)
        {
            int aa = Integer.parseInt(anzahlw.getText());
            int bb = Integer.parseInt(anzahlb.getText());
            int cc = Integer.parseInt(wartezimmerplaetze.getText());

            /*
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
             */
            rez = new Rezeption(aa,bb,cc);

            anzahlw.setVisible(false);
            anzahlb.setVisible(false);
            wartezimmerplaetze.setVisible(false);
            start.setVisible(false);

            bButton12.setVisible(true);
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
            bButton1.setVisible(true);
            tAusgabe.setVisible(true);
        }
        else if (src == bButton1)
        {
            rez.neuerPatient();
            tAusgabe.setText(rez.logAusgeben());
        }
        else if (src == bButton2)
        {
            rez.bewegeArzt();
            tAusgabe.setText(rez.logAusgeben());
        }
        else if (src == bButton3)
        {
            rez.queueZuWartezimmer();
            tAusgabe.setText(rez.logAusgeben());
        }
        else if (src == bButton4)
        {
            rez.wartezimmerZuBehandlungsraum();
            tAusgabe.setText(rez.logAusgeben());
        }
        else if (src == bButton5)
        {
            rez.behandlungeraumLeeren();
            tAusgabe.setText(rez.logAusgeben());
        }
        else if (src == bButton6)
        {
            rez.behandeln();
            tAusgabe.setText(rez.logAusgeben());
        }
        else if (src == bButton7)
        {
            String a =rez.logAusgeben();
            tAusgabe.setText(a);
        }
        else if (src == bButton8)
        {
            String a = rez.statusAusgabe();
            tAusgabe.setText(a);
        }
        else if (src == bButton9)
        {
            boolean a = rez.behandlungsraumBesetzt();
            if (a)
            {
                JOptionPane.showMessageDialog(popup, "Mindestens ein Behandlungszimmer ist besetzt!");
            }
            else
            {
                JOptionPane.showMessageDialog(popup, "Alle Behandlungszimmer sind leer!");

            }
        }
        else if (src == bButton10)
        {
            boolean a = rez.wartezimmerBesetzt();
            if (a)
            {
                JOptionPane.showMessageDialog(popup, "Es befindet sich mindestens ein Patient in einem Wartezimmer!");
            }
            else
            {
                JOptionPane.showMessageDialog(popup, "Alle Wartezimmer sind leer!");

            }
        }
        else if (src == bButton11)
        {

        }
        else if (src == bButton12)
        {
            tAusgabe.setText("");
        }

    }

}