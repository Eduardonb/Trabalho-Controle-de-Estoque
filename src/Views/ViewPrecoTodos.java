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

import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class ViewPrecoTodos extends JFrame {
	private JTextField textReajuste;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Gerenciador gerenciador = new Gerenciador();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrecoTodos frame = new ViewPrecoTodos();
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
	public ViewPrecoTodos() {
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
				ViewPrecoTodos.this.dispose();
				ViewInicial frame = new ViewInicial();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnVoltar);
		
		JButton btnLimpa = new JButton("Limpa");
		btnLimpa.setBounds(193, 265, 117, 25);
		btnLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textReajuste.setText(null);
			}
		});
		contentPane.add(btnLimpa);
		
		JLabel lblReajuste = new JLabel("Reajuste %");
		lblReajuste.setBounds(100, 165, 91, 15);
		contentPane.add(lblReajuste);
		
		textReajuste = new JTextField();
		textReajuste.setBounds(196, 165, 114, 19);
		contentPane.add(textReajuste);
		textReajuste.setColumns(10);
		
		JLabel lblAlteraPreco = new JLabel("Altera Preco Todos:");
		lblAlteraPreco.setForeground(Color.BLUE);
		lblAlteraPreco.setBounds(142, 47, 168, 15);
		contentPane.add(lblAlteraPreco);
		
		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double reajuste = (Double.parseDouble(textReajuste.getText())/100);
				if(JOptionPane.showConfirmDialog(null, "Confirma Reajuste de Todos produtos?") == 0){
					gerenciador.alteraPrecoTodos(reajuste);
					JOptionPane.showMessageDialog(null, "Reajuste concluido!");
				}else{
					JOptionPane.showMessageDialog(null, "Reajuste cancelado!");
				}
			}
		});
		btnConfirma.setBounds(193, 228, 117, 25);
		contentPane.add(btnConfirma);
		
	}
}
