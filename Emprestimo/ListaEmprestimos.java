package Emprestimo;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Erick Lemmy dos Santos Oliveira 
 * @version 1.0
 * Classe que funciona como gerenciador de Emprestimos, tem como atributo uma lista de Objetos do tipo emprestimo
 */
public class ListaEmprestimos implements Serializable {
	private ArrayList<Emprestimo> alEmprestimos;

	/**
	 * Construtor default para inicialização da lista de Emprestimos
	 */
	public ListaEmprestimos() {
		this.alEmprestimos = new ArrayList<Emprestimo>();
    }

    /**
	 * @return todos os itens emprestados
	 */
	public ArrayList<Emprestimo> getAlEmprestimos() {
		return alEmprestimos;
	}

	/**
	 * @param alEmprestimos adiciona um novo item a lista de emprestimos
	 */
	public void addAlEmprestimos(Emprestimo alEmprestimos) {
		this.alEmprestimos.add(alEmprestimos);
	}
	
	/**
	 * @param alEmprestimos adiciona um novo item a lista de emprestimos
	 */
	public void addAlEmprestimos(ArrayList<Emprestimo> alEmprestimos) {
		this.alEmprestimos = alEmprestimos;
    }
	/**
	 * @return tamanho do arrayList de Emprestimos
	 */
	public int size() {
		return this.alEmprestimos.size();
	}   
}
