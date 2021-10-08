package br.edu.ifsp.tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.ifsp.modelo.Pessoa;
import br.edu.ifsp.dao.PessoaDAO;

public class TelaPessoa extends JFrame {
	
	// Labels
	JLabel texto1 = null;
	JLabel texto2 = null;
	JLabel texto3 = null;
	
	// Campo texto
	JTextField campo1 = null;
	JTextField campo2 = null;
	JTextField campo3 = null;
	
	// Botao
	JButton botao = null;
	
	public TelaPessoa(String titulo) {
		super(titulo);
		inicializaComponentes();
	}
		
	public void inicializaComponentes() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,300, 325, 200);
		
		texto1 = new JLabel("Nome: ");
		texto2 = new JLabel("Idade: ");
		texto3 = new JLabel("Endereco: ");
		
		campo1 = new JTextField(20);
		campo2 = new JTextField(20);
		campo3 = new JTextField(20);
		
		botao = new JButton("Salvar");
		botao.addActionListener( new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				botaoSalvarPessoa(e);
			}
		});
		
		JPanel panel = new JPanel();
		panel.add(texto1);
		panel.add(campo1);
		panel.add(texto2);
		panel.add(campo2);
		panel.add(texto3);
		panel.add(campo3);
		panel.add(botao);
		
		getContentPane().add(panel);
		
		setVisible(true);
	}
	
	private void botaoSalvarPessoa(ActionEvent e) {
		// Instancio o modelo Pessoa
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(campo1.getText());
		pessoa.setIdade(Integer.parseInt(campo2.getText()));
		pessoa.setEndereco(campo3.getText());
		
		// instacio o DAO Pessoa e insiro na base de dados
		new PessoaDAO().inserirPessoa(pessoa);
	}
}
