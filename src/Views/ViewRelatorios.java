package Views;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;

import Controler.Gerenciador;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewRelatorios extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Gerenciador gerenciador = new Gerenciador();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRelatorios frame = new ViewRelatorios();
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
	public ViewRelatorios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNesistemaDeControle = new JLabel("Sistema de Controle de Estoque Boeing");
		lblNesistemaDeControle.setBounds(26, 13, 399, 22);
		lblNesistemaDeControle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNesistemaDeControle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNesistemaDeControle.setForeground(Color.BLACK);
		lblNesistemaDeControle.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(lblNesistemaDeControle);
		
		JButton btnRelatorio1 = new JButton("Relatorio 01");
		btnRelatorio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciador.geraRelatorio1();
			}
		});
		btnRelatorio1.setFont(new Font("Dialog", Font.BOLD, 10));
		btnRelatorio1.setBounds(12, 47, 111, 25);
		btnRelatorio1.setPreferredSize(new Dimension(100, 25));
		contentPane.add(btnRelatorio1);
		
		JButton btnRelatorio2 = new JButton("Relatorio 02");
		btnRelatorio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciador.geraRelatorio2();
			}
		});
		btnRelatorio2.setFont(new Font("Dialog", Font.BOLD, 10));
		btnRelatorio2.setBounds(149, 47, 133, 25);
		contentPane.add(btnRelatorio2);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(348, 235, 77, 25);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewRelatorios.this.dispose();
				ViewInicial frame = new ViewInicial();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnVoltar);
	}
}
