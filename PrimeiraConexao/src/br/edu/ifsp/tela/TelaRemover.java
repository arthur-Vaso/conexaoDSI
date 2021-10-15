package br.edu.ifsp.tela;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.modelo.Pessoa;

public class TelaRemover extends JFrame {

	private JPanel pnl;

	private JPanel pnlSearch;
	private JLabel lblSearch;
	private JTextField fldSearch;
	private JButton btnSearch;

	private JPanel pnlEdit;
	private JLabel lblName;
	private JLabel lblAge;
	private JLabel lblAdress;

	private JPanel pnlButton;
	private JButton btnSave;

	private String id;
	private String nome;
	private String idade;
	private String endereco;

	public TelaRemover() {
		createWindow();
		loadWindow();
	}

	private void createWindow() {
		pnl = new JPanel(new GridLayout(3, 1));

		pnlSearch = new JPanel();
		lblSearch = new JLabel("Nome");
		fldSearch = new JTextField(20);
		btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Pessoa> pessoa = new ArrayList<>();
				pessoa.addAll(new PessoaDAO().listarPorNome(fldSearch.getText()));

				String[] split = pessoa.toString().split(" - ");
				id = split[0].replace("[", "");

				nome = split[1];

				idade = split[2];
				String[] splitIdade = idade.split(" ");
				idade = splitIdade[0];

				endereco = split[3];
				String[] splitEndereco = endereco.split(": ");
				endereco = splitEndereco[1].replace("]", "");

				lblName.setText("Nome: " + nome);
				lblAge.setText("Idade: " + idade);
				lblAdress.setText("Endereço: " + endereco);
			}
		});

		pnlEdit = new JPanel(new GridLayout(3, 1, 10, 10));
		lblName = new JLabel("Nome: ");
		lblAge = new JLabel("Idade: ");
		lblAdress = new JLabel("Endereço: ");

		pnlButton = new JPanel();
		btnSave = new JButton("Remover");
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Pessoa pessoa = new Pessoa();
				pessoa.setId(Integer.parseInt(id));
				pessoa.setNome(nome);
				pessoa.setIdade(Integer.parseInt(idade));
				pessoa.setEndereco(endereco);

				new PessoaDAO().removerPessoa(pessoa);
				
				JOptionPane.showMessageDialog(null, nome + " foi removido.");
				dispose();
			}
		});

		addComponents();
	}

	private void addComponents() {
		pnlSearch.add(lblSearch);
		pnlSearch.add(fldSearch);
		pnlSearch.add(btnSearch);

		pnlEdit.add(lblName);
		pnlEdit.add(lblAge);
		pnlEdit.add(lblAdress);

		pnlButton.add(btnSave);

		pnl.add(pnlSearch);
		pnl.add(pnlEdit);
		pnl.add(pnlButton);

		add(pnl);
	}

	private void loadWindow() {
		setTitle("Remover pessoa");
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
