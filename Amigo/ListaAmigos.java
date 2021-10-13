package Amigo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Erick Lemmy dos Santos Oliveira
 * @version 1.0
 * A classe tem como atributo um ArrayList que armazena objetos do tipo Amigo
 */
public class ListaAmigos implements Serializable {
	private ArrayList<Amigo> alAmigos;

	/**
	 * Construtor default que inicializa o arrayList não possui passagem de
	 * parametro Entretanto tem o atributo da classe para inicialização do Array ao
	 * ser efetuada a instanciação de uma Lista
	 * 
	 * @param alAmigos inicializa o Array
	 */
	public ListaAmigos() {
		this.alAmigos = new ArrayList<Amigo>();
	}

	/**
	 * @return devolve o numero de amigos presentes na Lista
	 */
	public ArrayList<Amigo> getAlAmigos() {
		return alAmigos;
	}

	/**
	 * @param alAmigos é o novo Amigo a ser adicionado ao ArrayList de amigos
	 */
	public void addAlAmigos(Amigo alAmigos) {
		this.alAmigos.add(alAmigos);
	}

	/**
	 * @param alAmigos é a novo amigo a ser Adicionado a lista
	 */
	public void addAlAmigos(ArrayList<Amigo> alAmigos) {
		this.alAmigos = alAmigos;
	}

	/**
	 * @return devolve tamanho do arrayList de Amigos
	 */
	public int size() {
		return this.alAmigos.size();
	}

	@Override
	public String toString() {
		return "o numero total de amigos que tenho é " + size();
	}
}
