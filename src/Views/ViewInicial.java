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

public class ViewInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Gerenciador gerenciador = new Gerenciador();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInicial frame = new ViewInicial();
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
	public ViewInicial() {
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
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastro frame = new ViewCadastro();
				ViewInicial.this.dispose();
				frame.setVisible(true);
			}
		});
		btnCadastro.setFont(new Font("Dialog", Font.BOLD, 10));
		btnCadastro.setBounds(12, 47, 90, 25);
		btnCadastro.setPreferredSize(new Dimension(100, 25));
		contentPane.add(btnCadastro);
		
		JButton btnMovimentacao = new JButton("Movimentação");
		btnMovimentacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMovimentacao frame = new ViewMovimentacao();
				ViewInicial.this.dispose();
				frame.setVisible(true);
			}
		});
		btnMovimentacao.setFont(new Font("Dialog", Font.BOLD, 10));
		btnMovimentacao.setBounds(114, 47, 117, 25);
		contentPane.add(btnMovimentacao);
		
		JButton btnPreco = new JButton("Preço");
		btnPreco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewPrecoTodos frame = new ViewPrecoTodos();
				ViewInicial.this.dispose();
				frame.setVisible(true);
			}
		});
		btnPreco.setFont(new Font("Dialog", Font.BOLD, 10));
		btnPreco.setBounds(238, 47, 66, 25);
		contentPane.add(btnPreco);
		
		JButton btnRelatorio = new JButton("Relatórios");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewRelatorios frame = new ViewRelatorios();
				ViewInicial.this.dispose();
				frame.setVisible(true);
			}
		});
		btnRelatorio.setFont(new Font("Dialog", Font.BOLD, 10));
		btnRelatorio.setBounds(316, 47, 109, 25);
		contentPane.add(btnRelatorio);
	}
}
