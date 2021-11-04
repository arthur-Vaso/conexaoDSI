package br.edu.ifsp.principal;

import br.edu.ifsp.controlador.InserePessoaController;
import br.edu.ifsp.tela.TelaPessoa;
//import br.edu.ifsp.tela.TelaPrincipal;

public class ExecutarProjeto {

	public static void main(String[] args) {
		
		//TelaPrincipal telaPrincipal = new TelaPrincipal();
		TelaPessoa telaPessoa = new TelaPessoa("Formulario Pessoa");
		InserePessoaController controller = new InserePessoaController(telaPessoa);
		telaPessoa.setVisible(true);
	}
}
