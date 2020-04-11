package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.Jogador;
import main.Tabuleiro;

class TestTabuleiro {
	
	@Test
	void testTrueVertical() throws Exception  {		
		assertEquals(0, Tabuleiro.verticalHorizontal());		
	}
	
	@Test
	void testTrueHorizontal() throws Exception  {		
		assertEquals(1, Tabuleiro.verticalHorizontal());		
	}
	
	@Test
	void testFalseVertical() throws Exception{		
		assertNotEquals(1, Tabuleiro.verticalHorizontal());
	}
	
	@Test
	void testFalseHorizontal() throws Exception{		
		assertNotEquals(0, Tabuleiro.verticalHorizontal());
	}
	
	@Test
	void testFalsePosicaoDisponivel() {	
		String [][] tabuleiro = new String[10][10];
		Jogador player = new Jogador(5, true, false, tabuleiro);
		player.setTabuleiro("PA", 5, 5);
		assertFalse(Tabuleiro.posicaoDisponivel(player, 5, 5));
		boolean res = Tabuleiro.posicaoDisponivel(player, 5, 5);
		System.out.println("res= " + res);
		
	}
	
	@Test
	void testTruePosicaoDisponivel() {	
		String [][] tabuleiro = new String[10][10];
		Jogador player = new Jogador(5, true, false, tabuleiro);
		player.setTabuleiro("~", 5, 5);
		assertTrue(Tabuleiro.posicaoDisponivel(player, 5, 5));
		boolean res = Tabuleiro.posicaoDisponivel(player, 5, 5);
		System.out.println("res= " + res);
		
	}
	
	

}
