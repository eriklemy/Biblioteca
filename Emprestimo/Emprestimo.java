package Emprestimo;
import java.io.Serializable;
import java.time.LocalDate;

import Amigo.Amigo;
import Item.Item;

/**
 * @author Erick Lemmy dos Santos Oliveira 
 * @version 1.0
 * Classe que gerencia o que esta sendo emprestado, tem como atributos 
 * @idAmigo codigo que identifica quem emprestou um Item
 * @idItem codigo que identifica o Item emprestado por esse amigo
 * @dataEmprestimo a data em que o item foi emprestado pelo amigo 
 * @dataDevolucao a data em que este item foi devolvido pelo amigo
 * alem de item e amigo que são objetos da classe Item e Amigo respectivamente para facilitar na busca do Id
 */
public class Emprestimo implements Serializable{
	private int idAmigo;
	private int idItem;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	
	// para a equipe pensar nesta repetição, pois pode-se obter os objetos pelo IDs
	private Item item;
	private Amigo amigo;

	/**
	 * Construtor default
	 * @param idAmigocodigo que identifica quem emprestou um Item
     * @param idItem codigo que identifica o Item emprestado por esse amigo
	 * @param amigo objeto do tipo amigo
	 */
	public Emprestimo(int idAmigo, int idItem, Amigo amigo) {
		this.idAmigo = idAmigo;
		this.idItem = idItem;
		this.dataEmprestimo = LocalDate.now();
		this.dataDevolucao = null;
		this.item = null;
		this.amigo = amigo;
	}

	/**
	 * Sobrecarga do construtor
 	 * @param idAmigocodigo que identifica quem emprestou um Item
     * @param idItem codigo que identifica o Item emprestado por esse amigo
	 * @param amigo objeto do tipo amigo
	 * @param item objeto do tipo Item
	 */
	public Emprestimo(int idAmigo, int idItem, Amigo amigo, Item item) {
		this.idAmigo = idAmigo;
		this.idItem = idItem;
		this.dataEmprestimo = LocalDate.now();
		this.dataDevolucao = null;
		this.item = item;
		this.amigo = amigo;
	}
	
    /**
	 * @return devolve o id do amigo que emprestou algo
	 */
	public int getIdAmigo() {
		return idAmigo;
	}

	/**
	 * @param idAmigo é o id do amigo que ira emprestar algo
	 */
	public void setIdAmigo(int idAmigo) {
		this.idAmigo = idAmigo;
	}

	/**
	 * @return devolve o id do item emprestado
	 */
	public int getIdItem() {
		return idItem;
	}

	/**
	 * @param idItem é o id do Item emprestado que sera salvo 
	 */
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	/**
	 * @return devolve a data em que ocorreu o emprestimo de um item
	 */
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	/**
	 * @param dataEmprestimo é a data em que ocorre o emprestimo do item no caso no dia e instante em que ocorre
	 */
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo =  LocalDate.now();
	}

	/**
	 * @return devolve o dia em que ocorre a Devolução do item emprestado
	 */
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	/**
	 * @param dataDevolucao é a data de devolução a ser definida
	 */	
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	/**
	 * @return devolve o item Emprestado
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item é o item a ser definido para o emprestimo
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @return devolve o amigo que emprestou o item
	 */
	public Amigo getAmigo() {
		return amigo;
	}

	/**
	 * @param amigo é o amigo a ser definido como quem emprestou o item
	 */
	public void setAmigo(Amigo amigo) {
		this.amigo = amigo;
	}

	@Override
	public String toString () {
		String str = "Emprestimos";
		if(getDataDevolucao() == null){
			str = "Ainda não Devolvido!!";
		}
		return str;
	}
}
