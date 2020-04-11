package main;

import java.io.*;

public class BatalhaNaval {
	private static String tabuleiroJogador1[][];
	private static String tabuleiroJogador2[][];
	private static Jogador jogador1;
	private static Jogador jogador2;

	public static int lerLinha() {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int linha = 0;
		try {
			System.out.println("Informe a linha ");
			linha = Integer.parseInt(entrada.readLine());
			if (linha >= 0 && linha < 10) {
				return (linha);
			} else {
				System.out.println("Linha inválida! Tente novamente.");
				return (lerLinha());
			}
		} catch (Exception e) {
			System.out.println("Linha inválida! Tente novamente.");
			return (lerLinha());
		}
	}

	public static int lerColuna() {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int coluna = 0;
		try {
			System.out.println("Informe a coluna ");
			coluna = Integer.parseInt(entrada.readLine());
			if (coluna >= 0 && coluna < 10) {
				return (coluna);
			} else {
				System.out.println("Coluna inválida! Tente novamente.");
				return (lerColuna());
			}
		} catch (Exception e) {
			System.out.println("Coluna inválida! Tente novamente.");
			return (lerColuna());
		}

	}

	public static String[][] inicilizaMatriz(String[][] tabuleiro) {
		for (int linha = 0; linha < 10; linha++) {
			for (int coluna = 0; coluna < 10; coluna++) {
				tabuleiro[linha][coluna] = "~";
			}
		}
		return tabuleiro;
	}

	public static void imprimeTabuleiro(String[][] tabuleiro) {
		System.out.println("    0   1   2   3   4   5   6   7   8   9");
		System.out.println("  _________________________________________");
		for (int linha = 0; linha < 10; linha++) {
			System.out.print(linha + " ");
			for (int coluna = 0; coluna < 10; coluna++) {
				System.out.print("| " + tabuleiro[linha][coluna] + " ");
			}
			System.out.println("|");
			System.out.println("  _________________________________________");
		}
	}

	public static Jogador comparaTabuleiro(Jogador jogador, String[][] tabuleiroJogador, int linha, int coluna) {
		String escolha = jogador.tabuleiro[linha][coluna];
		System.out.println(escolha);
		int embarcacao = 0;

		if (tabuleiroJogador[linha][coluna] == "~") {
			switch (escolha) {
			case "~":
				System.out.println("Você atirou na água. Tente novamente.");
				tabuleiroJogador[linha][coluna] = "X";
				imprimeTabuleiro(tabuleiroJogador);
				break;
			case "S":
				System.out.println("Submarino atingido!");
				tabuleiroJogador[linha][coluna] = "S";
				embarcacao = jogador.getSubmarino();
				jogador.setSubmarino(embarcacao--);
				jogador = checaNavios(jogador, escolha);
				imprimeTabuleiro(tabuleiroJogador);
				break;
			case "D":
				System.out.println("Distroyer atingido!");
				tabuleiroJogador[linha][coluna] = "D";
				embarcacao = jogador.getDestroyer();
				jogador.setDestroyer(embarcacao--);
				jogador = checaNavios(jogador, escolha);
				imprimeTabuleiro(tabuleiroJogador);
				break;
			case "E":
				System.out.println("Encouraçado atingido!");
				tabuleiroJogador[linha][coluna] = "E";
				embarcacao = jogador.getEncouracado();
				jogador.setEncouracado(embarcacao--);
				jogador = checaNavios(jogador, escolha);
				imprimeTabuleiro(tabuleiroJogador);
				break;
			case "BP":
				System.out.println("Barco de patrula atingido!");
				tabuleiroJogador[linha][coluna] = "BP";
				embarcacao = jogador.getBarcoPatrulha();
				jogador.setBarcoPatrulha(embarcacao--);
				jogador = checaNavios(jogador, escolha);
				imprimeTabuleiro(tabuleiroJogador);
				break;
			case "PA":
				System.out.println("Porta-aviões atingido!");
				tabuleiroJogador[linha][coluna] = "PA";
				embarcacao = jogador.getPortaAviao();
				jogador.setPortaAviao(embarcacao--);
				jogador = checaNavios(jogador, escolha);
				imprimeTabuleiro(tabuleiroJogador);
				break;
			}
		}
		jogador.setEmTurno(false);
		return jogador;
	}

	public static Jogador checaNavios(Jogador jogador, String escolha) {
		int navios = jogador.getQtdNavios();
		switch (escolha) {
		case "BP":
			if (jogador.getBarcoPatrulha() == 0) {
				jogador.setQtdNavios(navios--);
				System.out.println("Barco de patrulha afundado!");
			}
			break;
		case "E":
			if (jogador.getEncouracado() == 0) {
				jogador.setQtdNavios(navios--);
				System.out.println("Encouraçado afundado!");
			}
			break;
		case "PA":
			if (jogador.getPortaAviao() == 0) {
				jogador.setQtdNavios(navios--);
				System.out.println("Porta-aviões afundado!");
			}
			break;
		case "D":
			if (jogador.getDestroyer() == 0) {
				jogador.setQtdNavios(navios--);
				System.out.println("Destroyer afundado!");
			}
			break;
		case "S":
			if (jogador.getSubmarino() == 0) {
				jogador.setQtdNavios(navios--);
				System.out.println("Submarino afundado!");
			}
			break;
		}

		return jogador;
	}

	public static void iniciarJogo(Jogador jogador1, Jogador jogador2, String tabuleiroJogador1[][],
			String tabuleiroJogador2[][]) {

		jogador1 = new Jogador(5, true, false, tabuleiroJogador1);
		tabuleiroJogador1 = inicilizaMatriz(tabuleiroJogador1);
		jogador2 = new Jogador(5, false, false, tabuleiroJogador2);
		tabuleiroJogador2 = inicilizaMatriz(tabuleiroJogador2);

		try {
			Tabuleiro.popularTabuleiro(jogador1);
			Tabuleiro.popularTabuleiro(jogador2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (jogador1.isVenceu() == false && jogador2.isVenceu() == false) {
			int linha = lerLinha();
			int coluna = lerColuna();

			if (jogador1.emTurno == true) {
				System.out.println("Turno - Jogador 1\n");				
				jogador2 = comparaTabuleiro(jogador2, tabuleiroJogador2, linha, coluna);
				if(jogador2.getQtdNavios()==0) {
					jogador1.setVenceu(true);
				}
				else System.out.println("Quantidade restante de navios do oponente: " 
				+ jogador2.getQtdNavios());
				jogador1.setEmTurno(false);
				jogador2.setEmTurno(true);
				
			} else if (jogador2.emTurno == true) {
				System.out.println("Turno - Jogador 2\n");
				jogador1 = comparaTabuleiro(jogador1, tabuleiroJogador1, linha, coluna);
				if(jogador1.getQtdNavios()==0) {
					jogador2.setVenceu(true);
				}
				else System.out.println("Quantidade restante de navios do oponente: " 
						+ jogador1.getQtdNavios());
				jogador2.setEmTurno(false);
				jogador1.setEmTurno(true);
			}
		}

		if (jogador1.isVenceu() == true) {
			System.out.println("Jogador 1 venceu! Parabéns!\nVeja como ficou o seu mapa:");
			imprimeTabuleiro(jogador1.getTabuleiroInteiro());
		} else {
			System.out.println("Jogador 2 venceu! Parabéns!\nVeja como ficou o seu mapa:");
			imprimeTabuleiro(jogador2.getTabuleiroInteiro());
		}

	}
	
	public static int checkContinuar() throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int continuar = 3;				
		try {			
			System.out.println("Jogar? \n 0 = Não; 1 = Sim");
			continuar = Integer.parseInt(entrada.readLine());
			
		} catch (RuntimeException e) {
			System.out.println("Valor inválido!");
		}
		
		if(continuar!=0 && continuar!=1) {			
			System.out.println("Valor inválido! Tente novamente.");
			checkContinuar();
		}
		return continuar;
					
	}

	public static void main(String[] args) throws Exception {
		
		tabuleiroJogador1 = new String[10][10];
		tabuleiroJogador2 = new String[10][10];
		
		int continuar = 1;
		while(continuar==1) {
			iniciarJogo(jogador1, jogador2, tabuleiroJogador1, tabuleiroJogador2);
			continuar = checkContinuar();
			
		}
		
	}



}