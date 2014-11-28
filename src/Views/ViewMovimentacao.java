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

public class ViewMovimentacao extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Gerenciador gerenciador = new Gerenciador();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMovimentacao frame = new ViewMovimentacao();
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
	public ViewMovimentacao() {
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
		
		JButton btnEntrada = new JButton("Entrada");
		btnEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEntrada frame = new ViewEntrada();
				ViewMovimentacao.this.dispose();
				frame.setVisible(true);
			}
		});
		btnEntrada.setFont(new Font("Dialog", Font.BOLD, 10));
		btnEntrada.setBounds(12, 47, 90, 25);
		btnEntrada.setPreferredSize(new Dimension(100, 25));
		contentPane.add(btnEntrada);
		
		JButton btnSaida = new JButton("Saida");
		btnSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSaida frame = new ViewSaida();
				ViewMovimentacao.this.dispose();
				frame.setVisible(true);
			}
		});
		btnSaida.setFont(new Font("Dialog", Font.BOLD, 10));
		btnSaida.setBounds(114, 47, 90, 25);
		contentPane.add(btnSaida);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(348, 235, 77, 25);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMovimentacao.this.dispose();
				ViewInicial frame = new ViewInicial();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnVoltar);
	}
}
