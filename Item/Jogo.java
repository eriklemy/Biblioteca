package Item;

/**
 * @author Erick Lemmy dos Santos Oliveira 
 * @version 1.0
 * A classe representa a abstração de um Jogo este que por sua vez é um item armazenado no sistema 
 * e recebe como atributo o genero, plataforma (Console/PC/Mobile/Ambos), o tipo de midia (Fisica/Digital/Ambos) 
 * alem do titulo e id do Item tambem autogerado pela quantidade de itens armazenados no sistema 
 * Portanto há uma relação de herança entre Livro e Item na qual o jOGO é filho de Item
 */
public class Jogo extends Item {
	private String genero;
	private String plataforma;
	private String midia;
	
	public Jogo(String genero, String plataforma, String midia) {
		this.setPlataforma(plataforma);
		this.genero = genero;
		this.midia = midia;
    }

	/**
	 * @param nome
	 * @param genero
	 */
	public Jogo(String genero, String plataforma, String midia, int idItem, String tituloItem, Disponibilidade dispItem) {
		super(idItem, tituloItem, dispItem);
		this.setPlataforma(plataforma);
		this.genero = genero;
		this.midia = midia;
	}

    /**
	 * @return devolve o genero do Jogo
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero é o genero a ser definido para o Jogo
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return devolve a plataforma de uso sendo ela PC ou CONSOLE
	 */
	public String getPlataforma() {
		return plataforma;
	}

	/**
	 * @param plataforma é o meio em que se é jogado a ser definido (PC ou Console)
	 */
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	/**
	 * @return devolve the midia
	 */
	public String getMidia() {
		return midia;
	}

	/**
	 * @param midia the midia to set
	 */
	public void setMidia(String midia) {
		this.midia = midia;
	}

	@Override
	public String toString() {
		return "Jogo";
	}
}
