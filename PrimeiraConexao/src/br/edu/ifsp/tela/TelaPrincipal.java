package br.edu.ifsp.tela;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import br.edu.ifsp.dao.PessoaDAO;

public class TelaPrincipal extends JFrame {

	private JPanel pnl;

	private JPanel pnlInfo;
	private JLabel lblInfo;

	private JPanel pnlButtons;
	private JButton btnAdd;
	private JButton btnList;
	private JButton btnFindName;
	private JButton btnEdit;
	private JButton btnDelete;

	public TelaPrincipal() {
		createWindow();
		loadWindow();
	}

	private void createWindow() {
		pnl = new JPanel(new GridLayout(2, 1));

		pnlInfo = new JPanel();
		lblInfo = new JLabel("Selecione a opção que deseja executar.");

		pnlButtons = new JPanel(new GridLayout(1, 5));
		btnAdd = new JButton("Adicionar");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaPessoa telaPessoa = new TelaPessoa("Formulario Pessoa");
			}
		});
		btnList = new JButton("Listar");
		btnList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaLista telaLista = new TelaLista();
			}
		});
		btnFindName = new JButton("Pesquisar");
		btnFindName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaBusca telaBusca = new TelaBusca();
			}
		});
		btnEdit = new JButton("Editar");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaEditar telaEditar = new TelaEditar();
			}
		});

		btnDelete = new JButton("Excluir");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaRemover telaRemover = new TelaRemover();
			}
		});

		addComponents();
	}

	private void addComponents() {
		pnlInfo.add(lblInfo);

		pnlButtons.add(btnAdd);
		pnlButtons.add(btnList);
		pnlButtons.add(btnFindName);
		pnlButtons.add(btnEdit);
		pnlButtons.add(btnDelete);

		pnl.add(pnlInfo);
		pnl.add(pnlButtons);

		add(pnl);

	}

	private void loadWindow() {
		setTitle("Inicio");
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				
				new PessoaDAO().fecharConexao();
				
				System.exit(0);
			}
		});
	}
}
