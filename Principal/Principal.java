package Principal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Scanner;

import Amigo.*;
import Emprestimo.*;
import Item.*;

/**
 * @author Erick Lemmy dos Santos Oliveira
 * @version 1.0
 * Programação Orientada a Objetos (POO)
 * Controle de Biblioteca Pessoal
*/
public class Principal {
	public static void main(String[] args) {
		int opcao, chave;
		Scanner teclado = new Scanner(System.in);

		Biblioteca bib = new Biblioteca("Biblioteca Pessoal");
		ListaAmigos amigos = new ListaAmigos();
		ListaEmprestimos emprestimos = new ListaEmprestimos();
		lerData(bib, amigos, emprestimos);

		/* =============================== OBJETOS HARDCODE ======================================== 
		Item HP = new Livro("JK", 500,
		bib.size(), "Prisioneiro de Azkaban", Disponibilidade.DISPONIVEL);
		bib.addAlItem(HP);
		
		Item LOTR = new Filme(251, "Fantasia/Aventura",
		bib.size(),"O senhor dos Anéis - O Retorno do Rei",
		Disponibilidade.DISPONIVEL); bib.addAlItem(LOTR);
		
		Item warcraft = new Jogo("RPG", "PC", "fisica", bib.size(),
		"Warcraft III - The Frozen Throne", Disponibilidade.DISPONIVEL);
		bib.addAlItem(warcraft);
		
		Amigo Erick = new Amigo(amigos.size(), "Erick"); 
		amigos.addAlAmigos(Erick);
		
		Amigo Kenny = new Amigo(amigos.size(), "Kenny");
		amigos.addAlAmigos(Kenny);
		
		Amigo Alexandre = new Amigo(amigos.size(), "Alexandre");
		amigos.addAlAmigos(Alexandre);
		
		Emprestimo emp1 = new Emprestimo(Erick.getIdAmigo(), HP.getIdItem(), Erick, HP); 
		emp1.getItem().setDispItem(Disponibilidade.EMPRESTADO);
		emprestimos.addAlEmprestimos(emp1);
		
		Emprestimo emp2 = new Emprestimo(Kenny.getIdAmigo(), LOTR.getIdItem(), Kenny, LOTR); 
		emp2.getItem().setDispItem(Disponibilidade.EMPRESTADO);
		emprestimos.addAlEmprestimos(emp2);
		*/
		// ==============================================================================================
		do {
			System.out.println("\n=== Menu de opcoes ===\n");
			System.out.println("    <0> - Salvar e sair");
			System.out.println("    <1> - Cadastrar item");
			System.out.println("    <2> - Cadastrar amigo");
			System.out.println("    <3> - Emprestar");
			System.out.println("    <4> - Devolver");
			System.out.println("    <5> - Listar emprestimos atuais");
			System.out.println("    <6> - Listar historico de emprestimos");
			System.out.println("    <7> - Listar biblioteca");
			System.out.println("    <8> - Alterar estado");
			System.out.println("    <9> - Lista Items");
			System.out.println("    <10> - Listar Amigos");
			System.out.println("    <11> - Gravar");
			System.out.println("    <12> - Ler");

			System.out.print("\n    Opcao? ");
			opcao = teclado.nextInt();
			teclado.nextLine();

			switch (opcao) {
				case 0:
					salvarData(bib, amigos, emprestimos);
					System.exit(0);
				case 1:
					System.out.println("\n--- CADASTRO DE ITEM ---");
					System.out.println("\n--- Item que deseja cadastrar ---\n" + "<0> - Cancelar\n" + "<1> - Livro\n"
							+ "<2> - Jogo\n" + "<3> - Filme\n");
					int escolha = teclado.nextInt();

					Item item = cadastrarItem(bib, escolha);
					if (item != null) {
						item.setIdItem(bib.size());
						bib.addAlItem(item);
						System.out.println("Cadastrado com Sucesso!!");
					}
					break;
				case 2:
					Amigo amigo = cadastrarAmigo();
					amigo.setIdAmigo(amigos.size());
					amigos.addAlAmigos(amigo);
					System.out.println("Amigo Cadastrado com sucesso!!");
					break;
				case 3:
					System.out.println("\n--- EMPRESTIMO ---");
					listaItems(bib);
					listaAmigos(amigos);
					chave = perguntaId();

					System.out.println("    idAmigo: ");
					int idAmigo = teclado.nextInt();

					Emprestimo emprestado = emprestar(bib, idAmigo, chave, amigos);
					emprestimos.addAlEmprestimos(emprestado);
					break;
				case 4:
					chave = perguntaId();
					devolver(emprestimos, chave);
					break;
				case 5:
					listaEmprestimo(emprestimos);
					break;
				case 6:
					chave = perguntaId();
					listaHistorico(emprestimos, chave);
					break;
				case 7:
					Collections.sort(bib.getAlItem());
					listaBiblioteca(bib);
					break;
				case 8:
					chave = perguntaId();
					System.out.println("Alteração desejada: \n1- CONSULTALOCAL\n2- DANIFICADO\n3- EXTRAVIADO");
					int disp = teclado.nextInt();
					alteraEstado(bib, chave, disp);
					break;
				case 9:
					listaItems(bib);
					break;
				case 10:
					listaAmigos(amigos);
					break;
				case 11:
					salvarData(bib, amigos, emprestimos);
					break;
				case 12:
					lerData(bib, amigos, emprestimos);
					break;
				default:
					System.out.println("Opcao inexistente!");
					break;
			}
		} while (opcao != 0);
		teclado.close();
	}

	private static int perguntaId() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("    IdItem: ");
		int chave = teclado.nextInt();
		// teclado.close(); 
		return chave;
	}

	private static boolean checkName(Biblioteca bib, String nome){
		for(Item item : bib.getAlItem()){
			if(item.getTituloItem().toUpperCase().contains(nome.toUpperCase()) && item != null){
				System.out.println("Item ja cadastrado!!");
				return true;
			}
		}
		return false;
	}

	private static Item cadastrarItem(Biblioteca bib, int escolha) {
		Scanner teclado = new Scanner(System.in);
		Item item = new Livro();
		boolean achou = false;
		if (escolha == 0 || escolha > 3){
			System.out.println("Opcao inexistente!\nVoltando ao Menu....");
		} else {
			System.out.println("\n--- Titulo do Item ---");
			System.out.println("    titulo: ");
			String titulo = teclado.nextLine();
			achou = checkName(bib, titulo);
			if (escolha == 1 && achou != true) {
				System.out.println("\n--- Quantidade de Paginas ---");
				System.out.println("    Paginas: ");
				int totPagLivro = teclado.nextInt();

				System.out.println("\n--- Nome do Autor ---");
				System.out.println("    Autor: ");
				String autor = teclado.next();

				item = new Livro(autor, totPagLivro);
			} else if (escolha == 2 && achou != true) {
				System.out.println("\n--- Genero do Jogo ---");
				System.out.println("    genero: ");
				String genero = teclado.next();

				System.out.println("\n--- Plataforma do Jogo ---");
				System.out.println("    Console/PC/Ambos: ");
				String plataforma = teclado.next();

				System.out.println("\n--- Midia do Jogo ---");
				System.out.println("    Fisica/Digital/Ambos: ");
				String midia = teclado.next();

				item = new Jogo(genero, plataforma, midia);
			} else if (escolha == 3 && achou != true) {
				System.out.println("\n--- Genero do Filme ---");
				System.out.println("    genero: ");
				String genero = teclado.next();

				System.out.println("\n--- Duração do Filme ---");
				System.out.println("    duração em minutos: ");
				int duracao = teclado.nextInt();

				item = new Filme(duracao, genero);
			} 
			if (achou != true) {
				item.setTituloItem(titulo);
				item.setDispItem(Disponibilidade.DISPONIVEL);
				return item;
			}
		} 
		// teclado.close();
		return null;
	}

	private static Amigo cadastrarAmigo() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("\n--- Nome do Amigo ---");
		System.out.println("    Nome: ");
		String nome = teclado.nextLine();

		Amigo amigo = new Amigo(nome);
		// teclado.close();
		return amigo;
	}

	private static Emprestimo emprestar(Biblioteca bib, int idAmigo, int chave, ListaAmigos amigos) {
		Emprestimo emprestado = new Emprestimo(idAmigo, chave, amigos.getAlAmigos().get(idAmigo));
		Disponibilidade disp = busca(bib, chave).getDispItem();
		if ((disp == Disponibilidade.EMPRESTADO) || (disp == Disponibilidade.CONSULTALOCAL)) {
			System.out.println("Item " + disp);
			System.out.println("Emprestimo não realizado!!");
		} else {
			emprestado.setItem(busca(bib, chave));
			emprestado.getItem().setDispItem(Disponibilidade.EMPRESTADO);
			System.out.println("Emprestimo realizado!!");
		}
		return emprestado;
	}

	private static void devolver(ListaEmprestimos emp, int chave) {
		for (Emprestimo emprestimo : emp.getAlEmprestimos()) {
			if (emprestimo.getIdItem() == chave && emprestimo.getDataDevolucao() == null) {
				if (emprestimo.getItem().getDispItem() != Disponibilidade.CONSULTALOCAL
						&& emprestimo.getItem().getDispItem() != Disponibilidade.DISPONIVEL) {
					emprestimo.setDataDevolucao(LocalDate.now());
					emprestimo.getItem().setDispItem(Disponibilidade.DISPONIVEL);
					System.out.println("Devolução realizada com sucesso!!");
					System.out.println("No dia: " + emprestimo.getDataDevolucao());
					System.out.println("O item agora esta " + emprestimo.getItem().getDispItem());
				} else
					System.out.println("Devolução não realizada, o item esta " + emprestimo.getItem().getDispItem());
			}
		}
	}

	private static void listar(Emprestimo emprestados) {
		System.out.println("IdAmigo - " + emprestados.getIdAmigo());
		System.out.println("IdItem - " + emprestados.getIdItem());
		System.out.println("Nome - " + emprestados.getAmigo().getNomeAmigo());
		System.out.println("Data Emprestimo - " + emprestados.getDataEmprestimo());
		System.out.println("Data Devolucao - "
				+ ((emprestados.getDataDevolucao() == null) ? "Ainda não devolvido" : emprestados.getDataDevolucao()));
		System.out.println("Titulo - " + emprestados.getItem().getTituloItem() + "\n");
	}

	private static void listaEmprestimo(ListaEmprestimos emprestimos) {
		for (Emprestimo emprestados : emprestimos.getAlEmprestimos()) {
			if (emprestados.getItem().getDispItem() == Disponibilidade.EMPRESTADO) {
				listar(emprestados);
			}
		}
	}

	private static void listaHistorico(ListaEmprestimos emprestimos, int chave) {
		for (Emprestimo emprestados : emprestimos.getAlEmprestimos()) {
			if (emprestados.getIdItem() == chave && emprestados.getDataDevolucao() != null) {
				listar(emprestados);
			} else if (emprestados.getIdItem() == chave && emprestados.getDataDevolucao() == null) {
				listar(emprestados);
			}
		}
	}

	private static void listaBiblioteca(Biblioteca bib) {
		System.out.println("\n--- Objetos na Biblioteca ---");
		String[] titulo = { "|Disponibilidade", "|Nome" };
		System.out.printf("%s\t%-5s\n", titulo[0], titulo[1]);
		for (Item item : bib.getAlItem()) {
			System.out.printf("|%s\t\t|%-10s\n", item.getDispItem(), item.getTituloItem());
		}
	}

	private static Item busca(Biblioteca bib, int chave) {
		for (Item busca : bib.getAlItem()) {
			if (busca.getIdItem() == chave) {
				return busca;
			}
		}
		return null;
	}

	private static void alteraEstado(Biblioteca bib, int chave, int disp) {
		Disponibilidade disponibilidade = busca(bib, chave).getDispItem();
		Item it1 = busca(bib, chave);
		if (disp == 1) {
			if (disponibilidade != Disponibilidade.EMPRESTADO) {
				it1.setDispItem(Disponibilidade.CONSULTALOCAL);
			} else {
				System.out.println("Não é possivel alterar pois o item esta " + it1.getDispItem());
			}
		} else if (disp == 2) {
			it1.setDispItem(Disponibilidade.DANIFICADO);
		} else if (disp == 3) {
			it1.setDispItem(Disponibilidade.EXTRAVIADO);
		} else {
			System.out.println("Entrada invalida");
		}
	}

	private static void listaAmigos(ListaAmigos amigos) {
		System.out.println("\n--- Amigos ---");
		System.out.println("ID | Nome");
		for (Amigo amigo : amigos.getAlAmigos()) {
			System.out.println(" " + amigo.getIdAmigo() + " | " + amigo.getNomeAmigo());
		}
	}

	private static void listaItems(Biblioteca bib) {
		System.out.println("\n--- Item ---");
		String[] titulo = { "ID", "Tipo", "Disponibilidade", "Nome" };
		System.out.printf("%s\t|%-5s\t|%-7s\t|%-5s\n", titulo[0], titulo[1], titulo[2], titulo[3]);
		for (Item item : bib.getAlItem()) {
			System.out.printf(" %d\t|%-5s\t|%-7s\t\t|%-5s\n", item.getIdItem(), item, item.getDispItem(),
					item.getTituloItem());
		}
	}

	public static void salvarData(Biblioteca bib, ListaAmigos amigos, ListaEmprestimos emprestimos) {
		ObjectOutputStream saida = null;
		try {
			saida = new ObjectOutputStream(
					new FileOutputStream("C:\\Users\\Erick\\Desktop\\POO\\Aula\\BIBLIOTECA\\Data\\Data.txt"));
			saida.writeObject(bib);
			saida.writeObject(amigos);
			saida.writeObject(emprestimos);
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				if (saida != null) {
					saida.close();
				}
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
			}
		}
		System.out.println("Dados armazenados");
	}

	public static void lerData(Biblioteca bib, ListaAmigos amigos, ListaEmprestimos emprestimos) {
		ObjectInputStream entrada = null;
		Biblioteca bibTemporario = null;
		ListaAmigos listaTemporario = null;
		ListaEmprestimos emprestimosTemporario = null;
		try {
			entrada = new ObjectInputStream(
					new FileInputStream("C:\\Users\\Erick\\Desktop\\POO\\Aula\\BIBLIOTECA\\Data\\Data.txt"));
			bibTemporario = (Biblioteca) entrada.readObject();
			listaTemporario = (ListaAmigos) entrada.readObject();
			emprestimosTemporario = (ListaEmprestimos) entrada.readObject();
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		} catch (ClassNotFoundException e2) {
			System.out.println(e2.getMessage());
		} finally {
			try {
				if (entrada != null) {
					entrada.close();
					bib.addAlItem(bibTemporario.getAlItem());
					bib.setNomeBib(bibTemporario.getNomeBib());
					amigos.addAlAmigos(listaTemporario.getAlAmigos());
					emprestimos.addAlEmprestimos(emprestimosTemporario.getAlEmprestimos());
					System.out.println("Dados foram carregados");
				}
			} catch (IOException e3) {
				System.out.println(e3.getMessage());
			}
		}
	}
}
