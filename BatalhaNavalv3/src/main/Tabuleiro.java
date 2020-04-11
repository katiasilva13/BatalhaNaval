package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Tabuleiro {
	
	public static boolean posicaoDisponivel(Jogador jogador, int linha, int coluna) {
		if (jogador.getTabuleiro(linha, coluna).equalsIgnoreCase("~")) {
			return true;
		}			
		else
			return false;
	}

	public static int verticalHorizontal() throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int posicao = 3;
		try {
			System.out.println(
				"Informe a posição da embarcação: \n 0 = Vertical; 1 = Horizontal "
							+ "(Cuidado com a quantidade espaço disponível!)");
			
			posicao = Integer.parseInt(entrada.readLine());
	System.out.println("posicao: " + posicao);		
			
		} catch (RuntimeException e) {
			System.out.println("Valor inválido!");
		}
		if(posicao!=0 && posicao!=1) {
			System.out.println("Valor inválido! Tente novamente.");
			verticalHorizontal();
		}
		return posicao;
	}
	
	public static Jogador setPortaAviao(Jogador jogador, int posicao, int linha, int coluna) throws Exception {
		
		int disponivel, i;
		switch (posicao) {
		// Vertical
		case 0:
			disponivel = 3;
			for (i = linha; i <= (linha + 4); i++) {
				if (posicaoDisponivel(jogador, i, coluna)) {
					disponivel = 0;
				} else {
					disponivel = 1;
				}
			}
			if (disponivel == 0) {
				for (i = linha; i <= (linha + 4); i++) {
					jogador.setTabuleiro("PA", i, coluna);
					jogador.setPortaAviao(5);
				}
			} else {
				System.out.println("Não há espaço o bastante! Tente novamente.");
				popularTabuleiro(jogador);
			}
			break;

		// Horizontal
		case 1:
			disponivel = 3;
			for (i = coluna; i <= (coluna + 4); i++) {		
				if (posicaoDisponivel(jogador, linha, i)) {
					disponivel = 0;
				} else {
					disponivel = 1;
				}
			}
			if (disponivel == 0) {
				for (i = coluna; i <= (coluna + 4); i++) {
					jogador.setTabuleiro("PA", linha, i);
					jogador.setPortaAviao(5);
				}
			} else {
				System.out.println("Não há espaço o bastante! Tente novamente.");
				popularTabuleiro(jogador);
			}

			break;

		default:
			System.out.println("Erro");
			break;
		}

		return jogador;
	}

	private static Jogador setSubmarino(Jogador jogador, int posicao, int linha, int coluna) throws Exception {

		int disponivel, i;
		switch (posicao) {
		// Vertical
		case 0:
			disponivel = 3;
			for (i = linha; i <= (linha + 2); i++) {
				if (posicaoDisponivel(jogador, i, coluna)) {
					disponivel = 0;
				} else {
					disponivel = 1;
				}
			}
			if (disponivel == 0) {
				for (i = linha; i <= (linha + 2); i++) {
					jogador.setTabuleiro("S", i, coluna);
					jogador.setSubmarino(3);
				}
			} else {
				System.out.println("Não há espaço o bastante! Tente novamente.");
				popularTabuleiro(jogador);
			}
			break;

		// Horizontal
		case 1:
			disponivel = 3;
			for (i = coluna; i <= (coluna + 2); i++) {		
				if (posicaoDisponivel(jogador, linha, i)) {
					disponivel = 0;
				} else {
					disponivel = 1;
				}
			}
			if (disponivel == 0) {
				for (i = coluna; i <= (coluna + 2); i++) {
					jogador.setTabuleiro("S", linha, i);
					jogador.setSubmarino(3);
				}
			} else {
				System.out.println("Não há espaço o bastante! Tente novamente.");
				popularTabuleiro(jogador);
			}

			break;

		default:
			System.out.println("Erro");
			break;
		}

		return jogador;
	}
	
	private static Jogador setDestroyer(Jogador jogador, int posicao, int linha, int coluna) throws Exception {
		int disponivel, i;
		switch (posicao) {
		// Vertical
		case 0:
			disponivel = 3;
			for (i = linha; i <= (linha + 2); i++) {
				if (posicaoDisponivel(jogador, i, coluna)) {
					disponivel = 0;
				} else {
					disponivel = 1;
				}
			}
			if (disponivel == 0) {
				for (i = linha; i <= (linha + 2); i++) {
					jogador.setTabuleiro("D", i, coluna);
					jogador.setDestroyer(3);
				}
			} else {
				System.out.println("Não há espaço o bastante! Tente novamente.");
				popularTabuleiro(jogador);
			}
			break;

		// Horizontal
		case 1:
			disponivel = 3;
			for (i = coluna; i <= (coluna + 2); i++) {		
				if (posicaoDisponivel(jogador, linha, i)) {
					disponivel = 0;
				} else {
					disponivel = 1;
				}
			}
			if (disponivel == 0) {
				for (i = coluna; i <= (coluna + 2); i++) {
					jogador.setTabuleiro("D", linha, i);
					jogador.setDestroyer(3);
				}
			} else {
				System.out.println("Não há espaço o bastante! Tente novamente.");
				popularTabuleiro(jogador);
			}

			break;

		default:
			System.out.println("Erro");
			break;
		}

		return jogador;
	}
	
	private static Jogador setBarcoPatrulha(Jogador jogador, int posicao, int linha, int coluna) throws Exception {
		int disponivel, i;
		switch (posicao) {
		// Vertical
		case 0:
			disponivel = 3;
			for (i = linha; i <= (linha + 1); i++) {
				if (posicaoDisponivel(jogador, i, coluna)) {
					disponivel = 0;
				} else {
					disponivel = 1;
				}
			}
			if (disponivel == 0) {
				for (i = linha; i <= (linha + 1); i++) {
					jogador.setTabuleiro("BP", i, coluna);
					jogador.setBarcoPatrulha(2);
				}
			} else {
				System.out.println("Não há espaço o bastante! Tente novamente.");
				popularTabuleiro(jogador);
			}
			break;

		// Horizontal
		case 1:
			disponivel = 3;
			for (i = coluna; i <= (coluna + 1); i++) {		
				if (posicaoDisponivel(jogador, linha, i)) {
					disponivel = 0;
				} else {
					disponivel = 1;
				}
			}
			if (disponivel == 0) {
				for (i = coluna; i <= (coluna + 1); i++) {
					jogador.setTabuleiro("BP", linha, i);
					jogador.setBarcoPatrulha(2);
				}
			} else {
				System.out.println("Não há espaço o bastante! Tente novamente.");
				popularTabuleiro(jogador);
			}

			break;

		default:
			System.out.println("Erro");
			break;
		}

		return jogador;
	}
	
	private static Jogador setEncouracado(Jogador jogador, int posicao, int linha, int coluna) throws Exception {
		int disponivel, i;
		switch (posicao) {
		// Vertical
		case 0:
			disponivel = 3;
			for (i = linha; i <= (linha + 3); i++) {
				if (posicaoDisponivel(jogador, i, coluna)) {
					disponivel = 0;
				} else {
					disponivel = 1;
				}
			}
			if (disponivel == 0) {
				for (i = linha; i <= (linha + 3); i++) {
					jogador.setTabuleiro("E", i, coluna);
					jogador.setEncouracado(4);
				}
			} else {
				System.out.println("Não há espaço o bastante! Tente novamente.");
				popularTabuleiro(jogador);
			}
			break;

		// Horizontal
		case 1:
			disponivel = 3;
			for (i = coluna; i <= (coluna + 3); i++) {		
				if (posicaoDisponivel(jogador, linha, i)) {
					disponivel = 0;
				} else {
					disponivel = 1;
				}
			}
			if (disponivel == 0) {
				for (i = coluna; i <= (coluna + 3); i++) {
					jogador.setTabuleiro("E", linha, i);
					jogador.setEncouracado(4);
				}
			} else {
				System.out.println("Não há espaço o bastante! Tente novamente.");
				popularTabuleiro(jogador);
			}

			break;

		default:
			System.out.println("Erro");
			break;
		}

		return jogador;

	}
	
	public static Jogador popularTabuleiro(Jogador jogador) throws Exception {
		int linha, coluna, posicao = 3;
		try {

			if (jogador.getPortaAviao() != 5) {
				posicao = verticalHorizontal();
				System.out.println("Escolha a posição inicial do Porta Avião (1x5 ou 5x1) no tabuleiro: ");
				linha = BatalhaNaval.lerLinha();
				coluna = BatalhaNaval.lerColuna();				
				jogador = setPortaAviao(jogador, posicao, linha, coluna);	
			}
			if (jogador.getSubmarino() != 3) {
				posicao = verticalHorizontal();
				System.out.println("Escolha a posição inicial do Submarino (1x3 ou 3x1) no tabuleiro: ");
				linha = BatalhaNaval.lerLinha();
				coluna = BatalhaNaval.lerColuna();				
				jogador = setSubmarino(jogador, posicao, linha, coluna);	
			}
			if (jogador.getDestroyer() != 3) {
				posicao = verticalHorizontal();
				System.out.println("Escolha a posição inicial do Destroyer (1x3 ou 3x1) no tabuleiro: ");
				linha = BatalhaNaval.lerLinha();
				coluna = BatalhaNaval.lerColuna();				
				jogador = setDestroyer(jogador, posicao, linha, coluna);	
			}
			
			if (jogador.getBarcoPatrulha() != 2) {
				posicao = verticalHorizontal();
				System.out.println("Escolha a posição inicial do Submarino (1x2 ou 2x1) no tabuleiro: ");
				linha = BatalhaNaval.lerLinha();
				coluna = BatalhaNaval.lerColuna();				
				jogador = setBarcoPatrulha(jogador, posicao, linha, coluna);	
			}
			if (jogador.getEncouracado() != 4) {
				posicao = verticalHorizontal();
				System.out.println("Escolha a posição inicial do Destroyer (1x4 ou 4x1) no tabuleiro: ");
				linha = BatalhaNaval.lerLinha();
				coluna = BatalhaNaval.lerColuna();				
				jogador = setEncouracado(jogador, posicao, linha, coluna);	
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return jogador;
	}




}
