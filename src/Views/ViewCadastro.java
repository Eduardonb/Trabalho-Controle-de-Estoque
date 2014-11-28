package Views;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class ViewCadastro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Gerenciador gerenciador = new Gerenciador();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastro frame = new ViewCadastro();
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
	public ViewCadastro() {
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
		
		JButton btnInclui = new JButton("Inclusão");
		btnInclui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewInclui frame = new ViewInclui();
				ViewCadastro.this.dispose();
				frame.setVisible(true);
			}
		});
		btnInclui.setFont(new Font("Dialog", Font.BOLD, 10));
		btnInclui.setBounds(12, 47, 90, 25);
		btnInclui.setPreferredSize(new Dimension(100, 25));
		contentPane.add(btnInclui);
		
		JButton btnAltera = new JButton("Alteração");
		btnAltera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAltera frame = new ViewAltera();
				ViewCadastro.this.dispose();
				frame.setVisible(true);
			}
		});
		btnAltera.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAltera.setBounds(114, 47, 90, 25);
		contentPane.add(btnAltera);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConsulta frame = new ViewConsulta();
				ViewCadastro.this.dispose();
				frame.setVisible(true);
			}
		});
		btnConsulta.setFont(new Font("Dialog", Font.BOLD, 10));
		btnConsulta.setBounds(216, 47, 88, 25);
		contentPane.add(btnConsulta);
		
		JButton btnExclui = new JButton("Exclusão");
		btnExclui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastro.this.dispose();
				ViewExclui frame = new ViewExclui();
				frame.setVisible(true);
			}
		});
		btnExclui.setFont(new Font("Dialog", Font.BOLD, 10));
		btnExclui.setBounds(316, 47, 109, 25);
		contentPane.add(btnExclui);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(348, 235, 77, 25);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastro.this.dispose();
				ViewInicial frame = new ViewInicial();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnVoltar);
	}
}
