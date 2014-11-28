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

public class ViewConsulta extends JFrame {
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
					ViewConsulta frame = new ViewConsulta();
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
	public ViewConsulta() {
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
		btnVoltar.setBounds(193, 256, 77, 25);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConsulta.this.dispose();
				ViewCadastro frame = new ViewCadastro();
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
		btnLimpa.setBounds(168, 219, 117, 25);
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
		lblNome.setBounds(129, 82, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setBounds(129, 138, 70, 15);
		contentPane.add(lblPreco);
		
		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setBounds(121, 165, 70, 15);
		contentPane.add(lblUnidade);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(108, 192, 83, 15);
		contentPane.add(lblQuantidade);
		
		textNome = new JTextField();
		textNome.setBounds(196, 82, 114, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textPreco = new JTextField();
		textPreco.setBounds(196, 138, 114, 19);
		contentPane.add(textPreco);
		textPreco.setColumns(10);
		
		textUnidade = new JTextField();
		textUnidade.setBounds(196, 165, 114, 19);
		contentPane.add(textUnidade);
		textUnidade.setColumns(10);
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(196, 190, 114, 19);
		contentPane.add(textQuantidade);
		textQuantidade.setColumns(10);
		
		JLabel lblConsulta = new JLabel("Consulta Produto:");
		lblConsulta.setForeground(Color.BLUE);
		lblConsulta.setBounds(142, 47, 168, 15);
		contentPane.add(lblConsulta);
		
	}
}
