package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Jogador;

class TestJogador {

	@Test
	void testTrueJogadorTabuleiroZerado() {	
		String [][] tabuleiro = new String[10][10];
		Jogador player = new Jogador(5, true, false, tabuleiro);
		tabuleiro = Jogador.zeraTabuleiro(tabuleiro);
		assertArrayEquals(tabuleiro, player.getTabuleiroInteiro());
	}

	
}
