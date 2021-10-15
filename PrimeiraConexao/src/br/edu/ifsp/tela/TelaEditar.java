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

public class TelaEditar extends JFrame{

	private JPanel pnl;
	
	private JPanel pnlSearch;
	private JLabel lblSearch;
	private JTextField fldSearch;
	private JButton btnSearch;
	
	private JPanel pnlEdit;
	private JPanel pnlName;
	private JLabel lblName;
	private JTextField fldName;
	private JPanel pnlAge;
	private JLabel lblAge;
	private JTextField fldAge;
	private JPanel pnlAdress;
	private JLabel lblAdress;
	private JTextField fldAdress;
	
	private JPanel pnlButton;
	private JButton btnSave;

	private String id;

	public TelaEditar() {
		createWindow();
		loadWindow();
	}
	
	private void createWindow() {
		pnl = new JPanel(new GridLayout(3, 1));
		
		pnlSearch = new JPanel();
		lblSearch =new JLabel("Nome");
		fldSearch = new JTextField(20);
		btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Pessoa> pessoa = new ArrayList<>();
				pessoa.addAll(new PessoaDAO().listarPorNome(fldSearch.getText()));
								
				String [] split = pessoa.toString().split(" - ");
				id = split[0].replace("[", "");
				
				String nome = split[1];
				
				String idade = split[2];
				String [] splitIdade = idade.split(" ");
				idade = splitIdade[0];
				
				String endereco = split[3];
				String [] splitEndereco = endereco.split(": ");
				endereco = splitEndereco[1].replace("]", "");
				
				fldName.setText(nome);
				fldAge.setText(idade);
				fldAdress.setText(endereco);
			}
		});
		
		pnlEdit = new JPanel(new GridLayout(3, 2));
		pnlName = new JPanel();
		lblName = new JLabel("Nome");
		fldName = new JTextField(20);
		pnlAge = new JPanel();
		lblAge = new JLabel("Idade");
		fldAge = new JTextField(20);
		pnlAdress = new JPanel();
		lblAdress = new JLabel("Endereço");
		fldAdress = new JTextField(20);
		
		pnlButton = new JPanel();
		btnSave = new JButton("Salvar");
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Pessoa pessoa = new Pessoa();
				//pessoa.setId(id);
				pessoa.setId(Integer.parseInt(id));
				pessoa.setNome(fldName.getText());
				pessoa.setIdade(Integer.parseInt(fldAge.getText()));
				pessoa.setEndereco(fldAdress.getText());

				new PessoaDAO().editarPessoa(pessoa);
				
				JOptionPane.showMessageDialog(null, fldName.getText() + " foi alterado.");
				dispose();
			}
		});
		
		addComponents();
	}
	
	private void addComponents() {		
		pnlSearch.add(lblSearch);
		pnlSearch.add(fldSearch);
		pnlSearch.add(btnSearch);
		
		pnlName.add(lblName);
		pnlName.add(fldName);
		
		
		pnlAge.add(lblAge);
		pnlAge.add(fldAge);
		
		pnlAdress.add(lblAdress);
		pnlAdress.add(fldAdress);
		
		pnlEdit.add(pnlName);
		pnlEdit.add(pnlAge);
		pnlEdit.add(pnlAdress);
		
		pnlButton.add(btnSave);

		pnl.add(pnlSearch);
		pnl.add(pnlEdit);
		pnl.add(pnlButton);
		
		add(pnl);
	}

	private void loadWindow() {
		setTitle("Editar pessoa");
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
