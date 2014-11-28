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

public class ViewInclui extends JFrame {
	private JTextField textNome;
	private JTextField textPreco;
	private JTextField textUnidade;
	private JTextField textQuantidade;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Gerenciador gerenciador = new Gerenciador();
	private JTextField textNomeInclui;
	private JTextField textPrecoInclui;
	private JTextField textUnidadeInclui;
	private JTextField textQuantidadeInclui;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInclui frame = new ViewInclui();
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
	public ViewInclui() {
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
		
		JButton btnNewButton = new JButton("Inclui");
		btnNewButton.setBounds(70, 192, 90, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((textNomeInclui.getText().trim().equals("")) 
					|| (textPrecoInclui.getText().trim().equals("")) 
					|| (textUnidadeInclui.getText().trim().equals(""))
					|| (textQuantidadeInclui.getText().trim().equals(""))  
				){
					JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
				}else{
					if(JOptionPane.showConfirmDialog(null, "Confirma Inclusão?") == 0){
						gerenciador.cadastraProdutoo(textNomeInclui.getText(), 
								Double.parseDouble(textPrecoInclui.getText()), 
								textUnidadeInclui.getText(), 
								Integer.parseInt(textQuantidadeInclui.getText())
								);
						textNomeInclui.setText(null);
						textPrecoInclui.setText(null);
						textUnidadeInclui.setText(null);
						textQuantidadeInclui.setText(null);
						JOptionPane.showMessageDialog(null, "Inclusão concluida!");
					}else{
						JOptionPane.showMessageDialog(null, "Inclusão cancelada!");
					}
					
				}
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton.setPreferredSize(new Dimension(100, 25));
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(361, 263, 77, 25);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewInclui.this.dispose();
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
		
		JLabel lblConsulta = new JLabel("Consulta Produto");
		lblConsulta.setForeground(Color.BLUE);
		lblConsulta.setBounds(285, 47, 124, 15);
		contentPane.add(lblConsulta);
		
		JLabel lblNomeInclui = new JLabel("Nome");
		lblNomeInclui.setBounds(12, 82, 70, 15);
		contentPane.add(lblNomeInclui);
		
		JLabel lblPrecoInclui = new JLabel("Preço");
		lblPrecoInclui.setBounds(12, 105, 70, 15);
		contentPane.add(lblPrecoInclui);
		
		JLabel lblUnidadeInclui = new JLabel("Unidade");
		lblUnidadeInclui.setBounds(12, 132, 70, 15);
		contentPane.add(lblUnidadeInclui);
		
		JLabel lblQuantidadeInclui = new JLabel("Quantidade");
		lblQuantidadeInclui.setBounds(12, 159, 83, 15);
		contentPane.add(lblQuantidadeInclui);
		
		textNomeInclui = new JTextField();
		textNomeInclui.setColumns(10);
		textNomeInclui.setBounds(100, 80, 114, 19);
		contentPane.add(textNomeInclui);
		
		textPrecoInclui = new JTextField();
		textPrecoInclui.setColumns(10);
		textPrecoInclui.setBounds(100, 105, 114, 19);
		contentPane.add(textPrecoInclui);
		
		textUnidadeInclui = new JTextField();
		textUnidadeInclui.setColumns(10);
		textUnidadeInclui.setBounds(100, 130, 114, 19);
		contentPane.add(textUnidadeInclui);
		
		textQuantidadeInclui = new JTextField();
		textQuantidadeInclui.setColumns(10);
		textQuantidadeInclui.setBounds(100, 157, 114, 19);
		contentPane.add(textQuantidadeInclui);
		
		JLabel lblInclui = new JLabel("Inclui Produto");
		lblInclui.setForeground(Color.BLUE);
		lblInclui.setBounds(36, 47, 124, 15);
		contentPane.add(lblInclui);
		

		
	}
}
