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

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.ImageIcon;

import Controler.Gerenciador;
import Controler.Produto;

public class ViewEntrada extends JFrame {
	private JTextField textNome;
	private JTextField textQntatual;
	private JTextField textEntrada;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Gerenciador gerenciador = new Gerenciador();
	private JTextField textQntfinal;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEntrada frame = new ViewEntrada();
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
	public ViewEntrada() {
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
		
			
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(348, 285, 77, 25);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEntrada.this.dispose();
				ViewMovimentacao frame = new ViewMovimentacao();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnVoltar);
		
		JButton btnConsulta = new JButton("");
		btnConsulta.setBounds(246, 105, 24, 24);
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = textNome.getText();
				Produto produtoConsulta = gerenciador.consultaProdutoo(nome);
				if(produtoConsulta != null){
					textQntatual.setText(String.valueOf(produtoConsulta.getQuantidade()));
				}else{
					JOptionPane.showMessageDialog(null, "Produto não encontrado");
				}
				
			}
		});
		btnConsulta.setIcon(new ImageIcon("/home/ricardo/Área de Trabalho/Eclipse Arquivos/Programação II/Trabalho Controle de Estoque/Imagens/icone_lupa.jpeg"));
		contentPane.add(btnConsulta);
		
		JButton btnLimpa = new JButton("Limpa");
		btnLimpa.setBounds(193, 265, 117, 25);
		btnLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome.setText(null);
				textQntatual.setText(null);
				textEntrada.setText(null);
				textQntfinal.setText(null);
			}
		});
		contentPane.add(btnLimpa);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(129, 82, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblQntatual = new JLabel("Quantidade Atual");
		lblQntatual.setBounds(63, 138, 136, 15);
		contentPane.add(lblQntatual);
		
		JLabel lblEntrada = new JLabel("Entrada");
		lblEntrada.setBounds(121, 165, 70, 15);
		contentPane.add(lblEntrada);
		
		textNome = new JTextField();
		textNome.setBounds(196, 82, 114, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textQntatual = new JTextField();
		textQntatual.setBounds(196, 138, 114, 19);
		contentPane.add(textQntatual);
		textQntatual.setColumns(10);
		
		textEntrada = new JTextField();
		textEntrada.setBounds(196, 165, 114, 19);
		contentPane.add(textEntrada);
		textEntrada.setColumns(10);
		
		JLabel lblEntradaEstoque = new JLabel("Entrada Estoque:");
		lblEntradaEstoque.setForeground(Color.BLUE);
		lblEntradaEstoque.setBounds(142, 47, 168, 15);
		contentPane.add(lblEntradaEstoque);
		
		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNome.getText();
				Produto produtoAltera = gerenciador.consultaProdutoo(nome);
				if(produtoAltera == null){
					JOptionPane.showMessageDialog(null, "Primeiro encontre o produto a ser alterado.");
				}else{
					if((textEntrada.getText().trim().equals(""))){
						JOptionPane.showMessageDialog(null, "Preencha o campo Entrada");
					}else{
						if(JOptionPane.showConfirmDialog(null, "Confirma Entrada?") == 0){
							int novaQnt = produtoAltera.getQuantidade() + Integer.parseInt(textEntrada.getText());
							produtoAltera.setQuantidade(novaQnt);
							gerenciador.alteraProdutoo(produtoAltera);
							textQntfinal.setText(String.valueOf(novaQnt));
							JOptionPane.showMessageDialog(null, "Entrada concluida!");
						}else{
							JOptionPane.showMessageDialog(null, "Entrada cancelada!");
						}
						
					}
				}
			}
		});
		btnConfirma.setBounds(193, 228, 117, 25);
		contentPane.add(btnConfirma);
		
		JLabel labelQntfinal = new JLabel("Quantidade Final");
		labelQntfinal.setBounds(63, 192, 128, 15);
		contentPane.add(labelQntfinal);
		
		textQntfinal = new JTextField();
		textQntfinal.setColumns(10);
		textQntfinal.setBounds(196, 192, 114, 19);
		contentPane.add(textQntfinal);
		
	}
}
