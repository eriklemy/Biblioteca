package Item;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Erick Lemmy dos Santos Oliveira 
 * @version 1.0
 * Abstração de uma biblioteca na qual tem como atributo seu nome e uma Lista de itens estes que por sua vez podem ser Livros, Jogos ou Filmes
 */
public class Biblioteca implements Serializable{
	private String nomeBib;
	private ArrayList<Item> alItem;

	/**
	 * @param nomeBib é o nome da biblioteca 
	 */
	public Biblioteca(String nomeBib) {
		this.setNomeBib(nomeBib);
		this.alItem = new ArrayList<Item>(); 
	}

	/**
	 * @return devolve o nome da Biblioteca
	 */
	public String getNomeBib() {
		return nomeBib;
	}

	/**
	 * @param nomeBib é o nome da Biblioteca a ser definido
	 */
	public void setNomeBib(String nomeBib) {
		this.nomeBib = nomeBib;
	}

	/**
	 * @return devolve todos os itens presentes dentro do ArrayList de itens
	 */
	public ArrayList<Item> getAlItem() {
		return alItem;
	}

	/**
	 * @param alItem é o novo item a ser adicionado ao arrayList de itens
	 */
	public void addAlItem(Item alItem) {
		this.alItem.add(alItem);
	}
    
	/**
	 * @param alItem é o novo ArrayList a ser adicionado 
	 */
	public void addAlItem(ArrayList<Item> alItem) {
		this.alItem = alItem;
	}

	/**
	 * @return devolve tamanho do arrayList de Item
	 */
	public int size() {
		return this.alItem.size();
	}
	
	@Override
	public String toString() {
		String str;
		str = nomeBib  + " possui os items do tipo ";
		str += alItem + " armazenados";
		return str;
	}
}
