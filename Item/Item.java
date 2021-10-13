package Item;
import java.io.Serializable;

/**
 * @author Erick Lemmy dos Santos Oliveira 
 * @version 1.0
 * Classe abstrata pai de Livro, Filme e Jogo serve como base para a biblioteca pois suas classes filhas compõem a lista de itens presentes no sistema
 * tem como parametros o idItem autogerado pela quantidade de itens ja presentes na biblioteca, o tituloItem que representa o titulo do Item e 
 * o dispItem que representa o estado no sistema apartir da classe Enumerada, alem de possui a interface Comparable para realização de ordenação natural
 */
public abstract class Item implements Comparable<Item>, Serializable {
	private int IdItem;
	private String tituloItem;
	private Disponibilidade dispItem;
	
	/**
	 * Construtor default apenas para iniciar
	 */
	public Item(){
	}

	/**
	 * Sobrecarga do construtor  
	 * @param idItem é o id que o Item irá receber de acordo com a quantidade de itens na lista
     * @param tituloItem recebe e indica o titulo do Item (tem relação com o tipo de objeto que sera (Jogo, Livro, Filme))
     * @param dispItem indica o estado no sistema do item. Ex: EMPRESTADO ou DISPONIVEL
	 */
	public Item(int idItem, String tituloItem, Disponibilidade dispItem) {
		this.IdItem = idItem;
		this.tituloItem = tituloItem;
		this.dispItem = dispItem;
	}

	/**
	 * @return devolve o id do Item
	 */
	public int getIdItem() {
		return IdItem;
	}

	/**
	 * @param idItem é o id do Item a ser definido
	 */
	public void setIdItem(int idItem) {
		this.IdItem = idItem;
	}

	/**
	 * @return devolve o titulo do Item
	 */
	public String getTituloItem() {
		return tituloItem;
	}
	
	/**
	 * @param tituloItem é o titulo do Item a ser definido
	 */
	public void setTituloItem(String tituloItem) {
		this.tituloItem = tituloItem;
	}
	
	/**
	 * @param dispItem é a disponibilidade do item a ser definida
	 */
	public void setDispItem(Disponibilidade dispItem) {
		this.dispItem = dispItem;
	}
	
	/**
	 * @return devolve a disponibilidade atual do Item
	 */
	public Disponibilidade getDispItem() {
		return dispItem;
	}

	@Override
	public int compareTo(Item item) {
		return getTituloItem().compareToIgnoreCase(item.getTituloItem());
	}
}
