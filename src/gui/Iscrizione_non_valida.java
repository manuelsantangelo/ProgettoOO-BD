package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import logic.Controller;

import java.awt.Window.Type;
import java.awt.Dimension;

public class Iscrizione_non_valida extends JFrame {
	
	private Controller controller;

	private JPanel contentPane;

	public Iscrizione_non_valida(Controller controller) {
		
		this.controller = controller;
		
		setAlwaysOnTop(true);
		setType(Type.POPUP);
		getContentPane().setBackground(new Color(51, 102, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\LogoPiccolo.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(460, 300, 359, 93);
		
		JLabel lblIconaDiErrore = new JLabel("");
		lblIconaDiErrore.setIcon(new ImageIcon("errore icon.png"));
		lblIconaDiErrore.setBounds(15, 8, 54, 43);
		getContentPane().add(lblIconaDiErrore);
		
		JTextArea txtrCampiInseritiNon = new JTextArea();
		txtrCampiInseritiNon.setBackground(new Color(51, 102, 255));
		txtrCampiInseritiNon.setFont(new Font("Gadugi", Font.BOLD, 20));
		txtrCampiInseritiNon.setEditable(false);
		txtrCampiInseritiNon.setText("Campi inseriti non validi");
		txtrCampiInseritiNon.setBounds(65, 11, 249, 32);
		getContentPane().add(txtrCampiInseritiNon);
	}

}
