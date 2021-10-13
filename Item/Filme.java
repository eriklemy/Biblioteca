package Item;

/**
 * @author Erick Lemmy dos Santos Oliveira 
 * @version 1.0
 * A classe representa a abstração de um Filme este que por sua vez é um item armazenado no sistema 
 * e recebe como atributo o genero, duração (em minutos), Alem do titulo e id do Item tambem autogerado pela quantidade de itens armazenados no sistema 
 * Portanto há uma relação de herança entre Livro e Item na qual o jOGO é filho de Item
 */
public class Filme extends Item {
    private int duracao;
    private String genero;
    
    /**
     * Construtor padrão da classe Filme 
     * @param duracao recebe e indica a duração do filme em minutos
     * @param genero recebe e indica o genero do filme
     */
    public Filme(int duracao, String genero) {
        this.duracao = duracao;
        this.genero = genero;
    }

    /**
     * Sobrecarga do Construtor da classe Filme 
     * @param duracao recebe e indica a duração do filme em minutos
     * @param genero recebe e indica o genero do filme
     * @param idItem é o id que o Filme irá receber de acordo com a quantidade de itens na lista
     * @param tituloItem recebe e indica o titulo do Filme (provem de herança da classe Item)
     * @param dispItem indica o estado no sistema do item. Ex: EMPRESTADO ou DISPONIVEL
     */
    public Filme(int duracao, String genero, int idItem, String tituloItem, Disponibilidade dispItem) {
        super(idItem, tituloItem, dispItem);
        this.setDuracao(duracao);
        this.setGenero(genero);
    }

    /**
     * @return devolve a duração do Filme em minutos
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * @param duracao é o tempo de filme a ser definido em minutos
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * @return devolve o genero do filme
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero é o genero a ser definiido
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
	public String toString() {
		return "Filme";
	}
}
