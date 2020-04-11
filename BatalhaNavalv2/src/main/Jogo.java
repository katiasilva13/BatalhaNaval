package main;

public class Jogo {
	
	public static boolean posicaoDisponivel(String[][] tabuleiro, int linha, int coluna){	
		if (tabuleiro[linha][coluna].equalsIgnoreCase("~"))
			 return true;
		else
			return false;
	}
	
	public static String[][] popularTabuleiro(Jogador jogador, int linha, int coluna){
		
		jogador.getTabuleiro();
        posicaoDisponivel(jogador.tabuleiro, linha, coluna);
    
		
		return jogador.tabuleiro;
	}


}
