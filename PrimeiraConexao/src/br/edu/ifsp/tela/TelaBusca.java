package br.edu.ifsp.tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.ifsp.dao.PessoaDAO;

public class TelaBusca extends JFrame{

	private JPanel pnl;
	private JLabel lbl;
	private JTextField fld;
	private JButton btn;
	
	public TelaBusca() {
		createWindow();
		loadWindow();
	}
	
	private void createWindow() {
		pnl = new JPanel();
		
		lbl = new JLabel("Nome:");
		fld = new JTextField(20);
		
		btn = new JButton("Buscar");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaLista telaLista = new TelaLista(fld.getText());
				
				dispose();
			}
		});
		
		addComponents();
	}
	
	private void addComponents() {		
		pnl.add(lbl);
		pnl.add(fld);
		
		pnl.add(btn);
		
		add(pnl);
	}

	private void loadWindow() {
		setTitle("Buscar por nome");
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
