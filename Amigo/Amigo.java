package Amigo;

import java.io.Serializable;

/**
 * @author Erick Lemmy dos Santos Oliveira
 * @version 1.0
 * A classe amigo cria um objeto e armazena o id autogerado apartir da quantidade de integrates ja presentes na lista de amigos e o nome do amigo 
 */
public class Amigo implements Serializable {
	private int idAmigo;
	private String nomeAmigo;

	/**
	 * Construtor default amigo a qual recebe como parametro
	 * @param nomeAmigo é o nome do amigo a ser definido para o objeto criado
	 */
	public Amigo(String nomeAmigo) {
		this.nomeAmigo = nomeAmigo;
	}

	/**
	 * Sobrecarga do construtor para permissão de passagem de dois parametros sendo
	 * eles
	 * @param idAmigo   é o id a ser atribuito ao amigo, este que por sua vez é
	 *                  incrementado de acordo com o tamanho da lista
	 * @param nomeAmigo é o nome do amigo a ser definido
	 */
	public Amigo(int idAmigo, String nomeAmigo) {
		this.idAmigo = idAmigo;
		this.nomeAmigo = nomeAmigo;
	}

	/**
	 * @return o idAmigo
	 */
	public int getIdAmigo() {
		return idAmigo;
	}

	/**
	 * @param idAmigo é o id do amigo a ser definido
	 */
	public void setIdAmigo(int idAmigo) {
		this.idAmigo = idAmigo;
	}

	/**
	 * @return é o nomeAmigo
	 */
	public String getNomeAmigo() {
		return nomeAmigo;
	}

	/**
	 * @param nomeAmigo é o nome do amigo a ser definido
	 */
	public void setNomeAmigo(String nomeAmigo) {
		this.nomeAmigo = nomeAmigo;
	}

	@Override
	public String toString() {
		return "O meu id é " + idAmigo + "e meu nome é " + nomeAmigo;
	}
}
