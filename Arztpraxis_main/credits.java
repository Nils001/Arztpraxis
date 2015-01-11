 

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Credits extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Credits frame = new Credits();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Credits() {
		setTitle("Credits");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProjektVonNils = new JLabel("Projekt von Nils Stallkamp und Jonas Fritsch");
		lblProjektVonNils.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProjektVonNils.setBounds(10, 11, 401, 39);
		contentPane.add(lblProjektVonNils);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			
			}
		});
		btnNewButton.setBounds(271, 74, 89, 23);
		contentPane.add(btnNewButton);
		
		URLLabel  lblPublishedAtGithub = new URLLabel ("Published at Github", "https://github.com/Nils001/Arztpraxis");
		lblPublishedAtGithub.setBounds(10, 78, 195, 14);
		contentPane.add(lblPublishedAtGithub);
	}
}
