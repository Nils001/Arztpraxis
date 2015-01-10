import java.awt.EventQueue;
import java.text.NumberFormat;
import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.TextArea;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Window.Type;
import javax.swing.JFormattedTextField;
import java.text.NumberFormat;
import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;
import javax.swing.JFormattedTextField;
import javax.swing.JFileChooser;

public class gui_awt {
    private JFrame frmArztpraxisBeta;
    private JFrame frmPopup;
    private Rezeption rez;
    private JOptionPane popup;
    private credits credits;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        gui_awt window = new gui_awt();
                        window.frmPopup.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    }

    /**
     * Create the application.
     */
    public gui_awt() {
        initialize1();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmArztpraxisBeta = new JFrame();
        frmArztpraxisBeta.setVisible(true);
        frmArztpraxisBeta.setTitle("Arztpraxis Beta");
        frmArztpraxisBeta.setBounds(100, 100, 800, 1022);
        frmArztpraxisBeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setMargin(new Insets(2, 2, 2, 0));
        frmArztpraxisBeta.setJMenuBar(menuBar);

        JMenu mnHilfe = new JMenu("Hilfe");
        menuBar.add(mnHilfe);

        JMenuItem menuItem = new JMenuItem("Credits");
        menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    credits = new credits();
                }
            });

        mnHilfe.add(menuItem);
        frmArztpraxisBeta.getContentPane().setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setToolTipText("Log");
        tabbedPane.setBounds(10, 10, 400, 945);
        frmArztpraxisBeta.getContentPane().add(tabbedPane);

        TextArea textAream_2 = new TextArea();
        textAream_2.setEditable(false);
        tabbedPane.addTab("Log", null, textAream_2, null);
        tabbedPane.setEnabledAt(0, true);

        TextArea textAream_1 = new TextArea();
        textAream_1.setEditable(false);
        tabbedPane.addTab("Status", null, textAream_1, null);
        tabbedPane.setEnabledAt(1, true);

        JButton btnNewButton = new JButton("Patient hinzuf\u00FCgen");
        btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    rez.neuerPatient();
                    textAream_2.setText(rez.logAusgeben());
                    textAream_1.setText(rez.statusAusgabe());
                }
            });
        btnNewButton.setBounds(420, 30, 354, 32);
        frmArztpraxisBeta.getContentPane().add(btnNewButton);

        JButton btnBewegeArzt = new JButton("Bewege Arzt\r\n");
        btnBewegeArzt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    rez.bewegeArzt();
                    textAream_2.setText(rez.logAusgeben());
                    textAream_1.setText(rez.statusAusgabe());
                }
            });
        btnBewegeArzt.setBounds(420, 73, 354, 32);
        frmArztpraxisBeta.getContentPane().add(btnBewegeArzt);

        JButton btnQueueZuWartezimmer = new JButton("Queue zu Wartezimmer");
        btnQueueZuWartezimmer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    rez.queueZuWartezimmer();
                    textAream_2.setText(rez.logAusgeben());
                    textAream_1.setText(rez.statusAusgabe());
                }
            });
        btnQueueZuWartezimmer.setBounds(420, 116, 354, 32);
        frmArztpraxisBeta.getContentPane().add(btnQueueZuWartezimmer);

        JButton btnWartezimmerZuBehandlungsraum = new JButton("Wartezimmer zu Behandlungsraum\r\n");
        btnWartezimmerZuBehandlungsraum.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    rez.wartezimmerZuBehandlungsraum();
                    textAream_2.setText(rez.logAusgeben());
                    textAream_1.setText(rez.statusAusgabe());
                }
            });
        btnWartezimmerZuBehandlungsraum.setBounds(420, 159, 354, 32);
        frmArztpraxisBeta.getContentPane().add(btnWartezimmerZuBehandlungsraum);

        JButton btnBehandlungsraumLeeren = new JButton("Behandlungsraum Leeren\r\n");
        btnBehandlungsraumLeeren.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    rez.behandlungeraumLeeren();
                    textAream_2.setText(rez.logAusgeben());
                    textAream_1.setText(rez.statusAusgabe());
                }
            });
        btnBehandlungsraumLeeren.setBounds(420, 202, 354, 32);
        frmArztpraxisBeta.getContentPane().add(btnBehandlungsraumLeeren);

        JButton btnBehandeln = new JButton("Behandeln");
        btnBehandeln.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    rez.behandeln();
                    textAream_2.setText(rez.logAusgeben());
                    textAream_1.setText(rez.statusAusgabe());
                }
            });
        btnBehandeln.setBounds(420, 245, 354, 32);
        frmArztpraxisBeta.getContentPane().add(btnBehandeln);

        JButton btnLogAusgeben = new JButton("Log ausgeben\r\n");
        btnLogAusgeben.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    textAream_2.setText(rez.logAusgeben());

                }
            });
        btnLogAusgeben.setBounds(420, 288, 354, 32);
        frmArztpraxisBeta.getContentPane().add(btnLogAusgeben);

        JButton btnStatusAusgeben = new JButton("Status ausgeben\r\n");
        btnStatusAusgeben.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    textAream_1.setText(rez.statusAusgabe());

                }
            });
        btnStatusAusgeben.setBounds(420, 331, 354, 32);
        frmArztpraxisBeta.getContentPane().add(btnStatusAusgeben);

        JButton btnIstEinBehandlungsraum = new JButton("Ist ein Behandlungsraum besetzt ?");
        btnIstEinBehandlungsraum.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
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
            });
        btnIstEinBehandlungsraum.setBounds(420, 374, 354, 32);
        frmArztpraxisBeta.getContentPane().add(btnIstEinBehandlungsraum);

        JButton btnIstEinWartezimmer = new JButton("Ist ein Wartezimmer besetzt ?\r\n");
        btnIstEinWartezimmer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

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
            });
        btnIstEinWartezimmer.setBounds(420, 417, 354, 32);
        frmArztpraxisBeta.getContentPane().add(btnIstEinWartezimmer);

        JButton btnClear = new JButton("Clear\r\n");
        btnClear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
        btnClear.setBounds(420, 460, 354, 32);
        frmArztpraxisBeta.getContentPane().add(btnClear);
    }

    private void initialize1() {
        frmPopup = new JFrame();
        frmPopup.setResizable(false);
        frmPopup.setVisible(true);
        frmPopup.setTitle("Initialisierung");

        frmPopup.setBounds(100, 100, 550, 234);
        frmPopup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPopup.getContentPane().setLayout(null);
        JFormattedTextField textField = new  JFormattedTextField(NumberFormat.getInstance());
        textField.setBounds(448, 11, 86, 34);
        frmPopup.getContentPane().add(textField);
        textField.setColumns(10);

        JFormattedTextField textField_1 = new JFormattedTextField(NumberFormat.getInstance());
        textField_1.setColumns(10);
        textField_1.setBounds(448, 56, 86, 34);
        frmPopup.getContentPane().add(textField_1);

        JFormattedTextField textField_2 = new  JFormattedTextField(NumberFormat.getInstance());
        textField_2.setColumns(10);
        textField_2.setBounds(448, 101, 86, 34);
        frmPopup.getContentPane().add(textField_2);

        JLabel lblAnzahlDerWartezimmer = new JLabel("Anzahl der Wartezimmer");
        lblAnzahlDerWartezimmer.setBounds(10, 11, 428, 34);
        frmPopup.getContentPane().add(lblAnzahlDerWartezimmer);

        JLabel lblAnzahlDerBehandlungszimmer = new JLabel("Anzahl der Behandlungszimmer");
        lblAnzahlDerBehandlungszimmer.setBounds(10, 56, 428, 34);
        frmPopup.getContentPane().add(lblAnzahlDerBehandlungszimmer);

        JLabel lblPltzeProWartezimmer = new JLabel("Pl\u00E4tze pro Wartezimmer");
        lblPltzeProWartezimmer.setBounds(10, 101, 428, 34);
        frmPopup.getContentPane().add(lblPltzeProWartezimmer);

        JButton btnNewButton = new JButton("Start !");
        btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(textField.getText()!="" && textField_1.getText()!="" && textField_2.getText()!="" )
                    {
                        int aa = Integer.parseInt(textField.getText());
                        int bb = Integer.parseInt(textField_1.getText());
                        int cc = Integer.parseInt(textField_2.getText());
                        if(aa !=0 && bb!=0 && cc!=0)
                        {
                            rez = new Rezeption(aa,bb,cc);
                            frmPopup.dispose();
                            initialize();
                        }
                        else
                        {

                            frmPopup.dispose();

                            initialize1();
                        }
                    }
                }

            });
        btnNewButton.setBounds(10, 146, 524, 42);
        frmPopup.getContentPane().add(btnNewButton);
    }

    public void speichern()
    {
        String currDir;
        JFileChooser chooser = new JFileChooser();
        OkjektSchreiben o = new OkjektSchreiben();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            
             currDir = chooser.getSelectedFile().getAbsolutePath();
            
            o.schreiben(rez,currDir);
            
        }

    }
}