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

public class ViewAltera extends JFrame {
	private JTextField textNome;
	private JTextField textPreco;
	private JTextField textUnidade;
	private JTextField textQuantidade;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Gerenciador gerenciador = new Gerenciador();
	private JTextField textPrecoAltera;
	private JTextField textUnidadeAltera;
	private JTextField textQuantidadeAltera;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAltera frame = new ViewAltera();
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
	public ViewAltera() {
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
		
		JButton btnAltera = new JButton("Altera");
		btnAltera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = textNome.getText();
				Produto produtoAltera = gerenciador.consultaProdutoo(nome);
				if(produtoAltera == null){
					JOptionPane.showMessageDialog(null, "Primeiro encontre o produto a ser alterado.");
				}else{
					if((textPrecoAltera.getText().trim().equals("")) 
						|| (textUnidadeAltera.getText().trim().equals(""))
						|| (textQuantidadeAltera.getText().trim().equals(""))
					){  
						JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
					}else{
						produtoAltera.setPreco(Double.parseDouble(textPrecoAltera.getText()));
						produtoAltera.setUnidade(textUnidadeAltera.getText());
						produtoAltera.setQuantidade(Integer.parseInt(textQuantidadeAltera.getText()));
						gerenciador.alteraProdutoo(produtoAltera);
						JOptionPane.showMessageDialog(null, "Produto alterado com Sucesso!");
						textUnidadeAltera.setText(null);
						textPrecoAltera.setText(null);
						textQuantidadeAltera.setText(null);
					}
				}
			}
		});
		btnAltera.setBounds(70, 192, 90, 25);
		btnAltera.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAltera.setPreferredSize(new Dimension(100, 25));
		contentPane.add(btnAltera);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(361, 263, 77, 25);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAltera.this.dispose();
				ViewCadastro frame = new ViewCadastro();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnVoltar);
		
		JButton btnConsulta = new JButton("");
		btnConsulta.setBounds(374, 105, 24, 24);
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = textNome.getText();
				Produto produtoConsulta = gerenciador.consultaProdutoo(nome);
				if(produtoConsulta != null){
					textPreco.setText(String.valueOf(produtoConsulta.getPreco()));
					textUnidade.setText(produtoConsulta.getUnidade());
					textQuantidade.setText(String.valueOf(produtoConsulta.getQuantidade()));
				}else{
					JOptionPane.showMessageDialog(null, "Produto não encontrado");
				}
				
			}
		});
		btnConsulta.setIcon(new ImageIcon("/home/ricardo/Área de Trabalho/Eclipse Arquivos/Programação II/Trabalho Controle de Estoque/Imagens/icone_lupa.jpeg"));
		contentPane.add(btnConsulta);
		
		JButton btnLimpa = new JButton("Limpa");
		btnLimpa.setBounds(321, 221, 117, 25);
		btnLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome.setText(null);
				textPreco.setText(null);
				textUnidade.setText(null);
				textQuantidade.setText(null);
			}
		});
		contentPane.add(btnLimpa);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(257, 82, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setBounds(257, 138, 70, 15);
		contentPane.add(lblPreco);
		
		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setBounds(249, 165, 70, 15);
		contentPane.add(lblUnidade);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(236, 192, 83, 15);
		contentPane.add(lblQuantidade);
		
		textNome = new JTextField();
		textNome.setBounds(324, 82, 114, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textPreco = new JTextField();
		textPreco.setBounds(324, 138, 114, 19);
		contentPane.add(textPreco);
		textPreco.setColumns(10);
		
		textUnidade = new JTextField();
		textUnidade.setBounds(324, 165, 114, 19);
		contentPane.add(textUnidade);
		textUnidade.setColumns(10);
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(324, 190, 114, 19);
		contentPane.add(textQuantidade);
		textQuantidade.setColumns(10);
		
		JLabel lblConsulta = new JLabel("Selecione o produto:");
		lblConsulta.setForeground(Color.BLUE);
		lblConsulta.setBounds(257, 47, 168, 15);
		contentPane.add(lblConsulta);
		
		JLabel lblPrecoInclui = new JLabel("Preço");
		lblPrecoInclui.setBounds(12, 105, 70, 15);
		contentPane.add(lblPrecoInclui);
		
		JLabel lblUnidadeInclui = new JLabel("Unidade");
		lblUnidadeInclui.setBounds(12, 132, 70, 15);
		contentPane.add(lblUnidadeInclui);
		
		JLabel lblQuantidadeInclui = new JLabel("Quantidade");
		lblQuantidadeInclui.setBounds(12, 159, 83, 15);
		contentPane.add(lblQuantidadeInclui);
		
		textPrecoAltera = new JTextField();
		textPrecoAltera.setColumns(10);
		textPrecoAltera.setBounds(100, 105, 114, 19);
		contentPane.add(textPrecoAltera);
		
		textUnidadeAltera = new JTextField();
		textUnidadeAltera.setColumns(10);
		textUnidadeAltera.setBounds(100, 130, 114, 19);
		contentPane.add(textUnidadeAltera);
		
		textQuantidadeAltera = new JTextField();
		textQuantidadeAltera.setColumns(10);
		textQuantidadeAltera.setBounds(100, 157, 114, 19);
		contentPane.add(textQuantidadeAltera);
		
		JLabel lblAltera = new JLabel("Novos dados:");
		lblAltera.setForeground(Color.BLUE);
		lblAltera.setBounds(36, 47, 124, 15);
		contentPane.add(lblAltera);

		
	}
}
