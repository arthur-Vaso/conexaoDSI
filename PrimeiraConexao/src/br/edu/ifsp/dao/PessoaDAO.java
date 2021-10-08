package br.edu.ifsp.dao;
import br.edu.ifsp.conexao.Conexao;
import br.edu.ifsp.modelo.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO {
	
	Connection conexao = null;
	
	public PessoaDAO() {
		conexao = Conexao.obterConexao();
	}
	/**
	 * Este método é responsável por inserir o modelo na base de dados
	 */
	public void inserirPessoa(Pessoa pessoa) {
		
		String SQL = "INSERT INTO pessoa(nome, idade, endereco) VALUE (?,?,?)";
		
		try {
			
			PreparedStatement pstm = conexao.prepareStatement(SQL);
			
			pstm.setString(1, pessoa.getNome());
			pstm.setInt(2, pessoa.getIdade());
			pstm.setString(3, pessoa.getEndereco());
			
			pstm.executeUpdate();

			
			
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
			System.out.println("Erro ao executar SQL de insercao de Pessoa");
		}
	}
	
	/**
	 * Este método é responsavel por recuperar todos os registros na base de
	 * dados
	 */
	public void listarTodasPessoas() {
		
	}
}
