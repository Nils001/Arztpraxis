import java.awt.event.WindowEvent;
import java.awt.EventQueue;
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
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.TextArea;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class gui_awt {

    private JFrame frmIni;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private Rezeption rez;
    private JFrame frmArztpraxisBeta;
    public gui_awt()
    {
        initialize_popup();
    }
    private void initialize_popup() {
        
        frmIni = new JFrame();
        frmIni.setResizable(false);
        frmIni.setIconImage(Toolkit.getDefaultToolkit().getImage(popup.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
        frmIni.setTitle("Initialisierung");
        frmIni.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        frmIni.setBounds(100, 100, 550, 234);
        frmIni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmIni.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(448, 11, 86, 34);
        frmIni.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(448, 56, 86, 34);
        frmIni.getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(448, 101, 86, 34);
        frmIni.getContentPane().add(textField_2);

        JLabel lblAnzahlDerWartezimmer = new JLabel("Anzahl der Wartezimmer");
        lblAnzahlDerWartezimmer.setBounds(10, 11, 428, 34);
        frmIni.getContentPane().add(lblAnzahlDerWartezimmer);

        JLabel lblAnzahlDerBehandlungszimmer = new JLabel("Anzahl der Behandlungszimmer");
        lblAnzahlDerBehandlungszimmer.setBounds(10, 56, 428, 34);
        frmIni.getContentPane().add(lblAnzahlDerBehandlungszimmer);

        JLabel lblPltzeProWartezimmer = new JLabel("Pl\u00E4tze pro Wartezimmer");
        lblPltzeProWartezimmer.setBounds(10, 101, 428, 34);
        frmIni.getContentPane().add(lblPltzeProWartezimmer);

        JButton btnNewButton = new JButton("Start !");
        btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    int aa = Integer.parseInt(textField.getText());
                    int bb = Integer.parseInt(textField_1.getText());
                    int cc = Integer.parseInt(textField_2.getText());
                    rez = new Rezeption(aa,bb,cc);
                    initialize();
                }
            });
        btnNewButton.setBounds(10, 146, 524, 42);
        frmIni.getContentPane().add(btnNewButton);
        frmIni.setVisible(true);
    }
    
    private void initialize() {
		frmArztpraxisBeta = new JFrame();
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
			}
		});
		
		mnHilfe.add(menuItem);
		frmArztpraxisBeta.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("Log");
		tabbedPane.setBounds(10, 10, 400, 945);
		frmArztpraxisBeta.getContentPane().add(tabbedPane);
		
		TextArea textAream_2 = new TextArea();
		tabbedPane.addTab("Log", null, textAream_2, null);
		tabbedPane.setEnabledAt(0, true);
		
		TextArea textAream_1 = new TextArea();
		tabbedPane.addTab("Status", null, textAream_1, null);
		tabbedPane.setEnabledAt(1, true);
		
		JButton btnNewButton = new JButton("Patient hinzuf\u00FCgen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.out.println("works");
			 }
		});
		btnNewButton.setBounds(420, 30, 354, 32);
		frmArztpraxisBeta.getContentPane().add(btnNewButton);
		
		JButton btnBewegeArzt = new JButton("Bewege Arzt\r\n");
		btnBewegeArzt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBewegeArzt.setBounds(420, 73, 354, 32);
		frmArztpraxisBeta.getContentPane().add(btnBewegeArzt);
		
		JButton btnQueueZuWartezimmer = new JButton("Queue zu Wartezimmer");
		btnQueueZuWartezimmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQueueZuWartezimmer.setBounds(420, 116, 354, 32);
		frmArztpraxisBeta.getContentPane().add(btnQueueZuWartezimmer);
		
		JButton btnWartezimmerZuBehandlungsraum = new JButton("Wartezimmer zu Behandlungsraum\r\n");
		btnWartezimmerZuBehandlungsraum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWartezimmerZuBehandlungsraum.setBounds(420, 159, 354, 32);
		frmArztpraxisBeta.getContentPane().add(btnWartezimmerZuBehandlungsraum);
		
		JButton btnBehandlungsraumLeeren = new JButton("Behandlungsraum Leeren\r\n");
		btnBehandlungsraumLeeren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBehandlungsraumLeeren.setBounds(420, 202, 354, 32);
		frmArztpraxisBeta.getContentPane().add(btnBehandlungsraumLeeren);
		
		JButton btnBehandeln = new JButton("Behandeln");
		btnBehandeln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBehandeln.setBounds(420, 245, 354, 32);
		frmArztpraxisBeta.getContentPane().add(btnBehandeln);
		
		JButton btnLogAusgeben = new JButton("Log ausgeben\r\n");
		btnLogAusgeben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogAusgeben.setBounds(420, 288, 354, 32);
		frmArztpraxisBeta.getContentPane().add(btnLogAusgeben);
		
		JButton btnStatusAusgeben = new JButton("Status ausgeben\r\n");
		btnStatusAusgeben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStatusAusgeben.setBounds(420, 331, 354, 32);
		frmArztpraxisBeta.getContentPane().add(btnStatusAusgeben);
		
		JButton btnIstEinBehandlungsraum = new JButton("Ist ein Behandlungsraum besetzt ?");
		btnIstEinBehandlungsraum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIstEinBehandlungsraum.setBounds(420, 374, 354, 32);
		frmArztpraxisBeta.getContentPane().add(btnIstEinBehandlungsraum);
		
		JButton btnIstEinWartezimmer = new JButton("Ist ein Wartezimmer besetzt ?\r\n");
		btnIstEinWartezimmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
    
}

