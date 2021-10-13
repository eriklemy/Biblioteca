package Item;

/**
 * @author Erick Lemmy dos Santos Oliveira 
 * @version 1.0
 * A classe representa a abstração de um livro este que por sua vez é um item armazenado no sistema e recebe como atributo o nome do autor, quantidade de paginas 
 * alem do titulo e id do Item tambem autogerado pela quantidade de itens armazenados no sistema 
 * Portanto há uma relação de herança entre Livro e Item na qual o Livro é filho de Item
 */
public class Livro extends Item {
	private String autorLivro;
	private int totPagLivro;
	
	/**
	 * Construtor default da classe apenas para instanciação, não há parametros e atributos
	 */
	public Livro() {
	}
	
	/**
	 * sobrecarga do construtor com passagem de parametros 
	 * @param autorLivro recebe o nome do autor 
	 * @param totPagLivro recebe a quantidade de paginas que o livro possui
	 */
	public Livro(String autorLivro, int totPagLivro) {
		this.autorLivro = autorLivro;
		this.totPagLivro = totPagLivro;
	}

	/**
	 * Sobrecargar do construtor com parametros extras provenientes da Herança com a classe Item
	 * para instanciação direta de todos os atributos que definem o objeto
	 * @param autorLivro recebe o nome do autor 
	 * @param totPagLivro recebe a quantidade de paginas que o livro possui
	 * @param idItem é o id que o item irá receber de acordo com a quantidade de itens na lista 
	 * @param tituloItem define o titulo do livro
	 * @param dispItem define a disponibilidade do item de acordo com a classe Enumerada
	 */
	public Livro(String autorLivro, int totPagLivro, int idItem, String tituloItem, Disponibilidade dispItem) {
		super(idItem, tituloItem, dispItem);
		this.setAutorLivro(autorLivro);
		this.setTotPagLivro(totPagLivro);
	}

	/**
	 * @return devolve o nome do Autor do Livro
	 */
	public String getAutorLivro() {
		return autorLivro;
	}

	/**
	 * @param autorLivro é o nome do Autor a ser definido para o Livro
	 * 
	 */
	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}
	
	/**
	 * @return devolve o numero total de paginas
	 */
	public int getTotPagLivro() {
		return totPagLivro;
	}

	/**
	 * @param totPagLivro é o numero total de paginas a ser definido para o Livro
	 * 
	 */
	public void setTotPagLivro(int totPagLivro) {
		this.totPagLivro = totPagLivro;
	}

	@Override
	public String toString() {
		return "Livro";
	}
}
