package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.BatalhaNaval;
import main.Jogador;

class TestBatalhaNaval {
	
	@Test
	void testTrueImprimeTabuleiro() {	
		String [][] tabuleiro = new String[10][10];
		Jogador player = new Jogador(5, true, false, tabuleiro);
		BatalhaNaval.imprimeTabuleiro(player.getTabuleiroInteiro());
	}
	
	@Test
	void testTrueImprimeMatriz() {	
		String [][] tabuleiro = new String[10][10];
		tabuleiro = BatalhaNaval.inicilizaMatriz(tabuleiro);
		BatalhaNaval.imprimeTabuleiro(tabuleiro);
	}
	
	@Test
	void testTrueSubmarinoComparaTabuleiro() {	
		String [][] tabuleiro = new String[10][10];
		Jogador player = new Jogador(5, true, false, tabuleiro);
		tabuleiro = BatalhaNaval.inicilizaMatriz(tabuleiro);
		player.setTabuleiro("S", 3, 2);
		int qtdSubmarino = player.getSubmarino();
		BatalhaNaval.comparaTabuleiro(player, tabuleiro, 3, 2);
		assertEquals(qtdSubmarino--, player.getSubmarino());
	}
	
	@Test
	void testTrueMenosNavio() {	
		String [][] tabuleiro = new String[10][10];
		Jogador player = new Jogador(5, true, false, tabuleiro);
		int qtdNavio = player.getQtdNavios();
		BatalhaNaval.checaNavios(player, "S");
		assertEquals(qtdNavio--, player.getQtdNavios());
	}
	
	@Test
	void testFalseMenosNavio() {	
		String [][] tabuleiro = new String[10][10];
		Jogador player = new Jogador(5, true, false, tabuleiro);
		int qtdNavio = player.getQtdNavios();
		BatalhaNaval.checaNavios(player, "~");
		assertEquals(qtdNavio, player.getQtdNavios());
	}
	
	@Test
	void testTrueContinuar() throws Exception {	
		assertEquals(1, BatalhaNaval.checkContinuar());
	}
	
	@Test
	void testFalseContinuar() throws Exception {	
		assertNotEquals(1, BatalhaNaval.checkContinuar());
	}
	
	
}
