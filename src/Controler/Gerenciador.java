package Controler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

import javax.swing.JOptionPane;

public class Gerenciador {

	public void excluiProdutoo(String nome){
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = ConectaBanco.getConn();
			st = conn.createStatement();
			st.execute("DELETE FROM produto WHERE nome_produto='"+nome+"'");
					
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if(st != null){
					st.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch(Exception e){}
				
		}
	}
	
	public void alteraProdutoo(Produto produto){
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = ConectaBanco.getConn();
			st = conn.createStatement();
			st.execute("UPDATE produto SET preco_produto="+produto.getPreco()+
									    ", unidade_produto='"+produto.getUnidade()+"'"+
									    ", quantidade_produto="+produto.getQuantidade()+
									    " WHERE nome_produto='"+produto.getNome()+"'"
					   );
					
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if(st != null){
					st.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch(Exception e){}
				
		}
	}
	
	public Produto consultaProdutoo(String nome){
		Connection conn = null;
		String SQL = "SELECT id, nome_produto, preco_produto, unidade_produto, quantidade_produto FROM produto WHERE nome_produto='"+nome+"'";
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			conn = ConectaBanco.getConn();
			stm = conn.createStatement();	
			
			rs = stm.executeQuery(SQL);
			if(rs.next()){
				int id = rs.getInt("id");
				String nomeProduto = rs.getString("nome_produto");
				double precoProduto = rs.getDouble("preco_produto");
				String unidadeProduto = rs.getString("unidade_produto");
				int quantidadeProduto = rs.getInt("quantidade_produto");
				Produto produtoConsulta = new Produto(id, nomeProduto, precoProduto, unidadeProduto, quantidadeProduto);
				return produtoConsulta;
			}
			
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(stm != null){
					stm.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch(Exception e){}
				
		}
		return null;
	}
	

	public void cadastraProdutoo(String nome, double preco, String unidade, int quantidade) {
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = ConectaBanco.getConn();
			st = conn.createStatement();
			st.execute("INSERT INTO produto (nome_produto, preco_produto, unidade_produto, quantidade_produto)"
					+ "VALUES ('"+nome+"', "+preco+", '"+unidade+"', "+quantidade+");"
					   );
					
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if(st != null){
					st.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch(Exception e){}
				
		}
	}

	public void geraRelatorio1() {
		Connection conn = null;
		String SQL = "SELECT nome_produto, preco_produto, unidade_produto, quantidade_produto FROM produto";
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			conn = ConectaBanco.getConn();
			stm = conn.createStatement();	
			
			rs = stm.executeQuery(SQL);
			String relatorio = "";
			while(rs.next()){
				String nomeProduto = rs.getString("nome_produto");
				double precoProduto = rs.getDouble("preco_produto");
				String unidadeProduto = rs.getString("unidade_produto");
				int quantidadeProduto = rs.getInt("quantidade_produto");
				
				relatorio = relatorio + "Nome do produto: "+nomeProduto+"\n"
								+"Preço do produto: "+precoProduto+"\n"
								+"Unidade: "+unidadeProduto+"\n"
								+"quantidadeProduto: "+quantidadeProduto+"\n"+"\n";
			}
			if(relatorio != "") {
				geraArquivoTxt(relatorio);
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(stm != null){
					stm.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch(Exception e){}
				
		}
	}
	
	public void geraRelatorio2() {
		Connection conn = null;
		String SQL = "SELECT nome_produto, preco_produto, unidade_produto, quantidade_produto FROM produto";
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			conn = ConectaBanco.getConn();
			stm = conn.createStatement();	
			
			rs = stm.executeQuery(SQL);
			String relatorio = "";
			double totalEstoque = 0;
			while(rs.next()){
				String nomeProduto = rs.getString("nome_produto");
				double precoProduto = rs.getDouble("preco_produto");
				String unidadeProduto = rs.getString("unidade_produto");
				int quantidadeProduto = rs.getInt("quantidade_produto");
				
				double total = (precoProduto * precoProduto); 
				totalEstoque = totalEstoque + total;
				relatorio = relatorio + "Total em estoque de "+nomeProduto+" = "+total+"\n"+"\n";
			}
			relatorio = relatorio + "Total em estoque = "+totalEstoque;
			
			geraArquivoTxt(relatorio);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(stm != null){
					stm.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch(Exception e){}
				
		}
	}

	public void alteraPrecoTodos(double reajuste) {
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = ConectaBanco.getConn();
			st = conn.createStatement();
			st.execute("UPDATE produto set preco_produto = (preco_produto + (preco_produto * "+reajuste+"))");
					
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if(st != null){
					st.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch(Exception e){}
		}

	}
	
	private void geraArquivoTxt(String relatorio)
	{
		File arquivo = new File( "/home/eduardo/codigos/java/Trabalho Controle de Estoque/relarotio.txt" );
		try {
			if(!arquivo.exists()) {
				arquivo.createNewFile();
			}
			FileWriter fw = new FileWriter( arquivo );
			BufferedWriter bw = new BufferedWriter( fw );
			try {
				bw.write(relatorio);
				bw.close();
				fw.close();
				JOptionPane.showMessageDialog(null,"Arquivo criado com sucesso!");
			} catch (Exception e) {
				System.err.println(e);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
