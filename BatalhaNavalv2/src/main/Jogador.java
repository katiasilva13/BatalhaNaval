package main;

public class Jogador {	
		
	public Jogador() {
	}

	public Jogador(int qtdNavios, boolean emTurno, boolean venceu, String[][] tabuleiro) {
		this.qtdNavios = qtdNavios;
		this.emTurno = emTurno;
		this.venceu = venceu;
		this.tabuleiro = zeraTabuleiro(tabuleiro);
	}

	public int qtdNavios = 5;
	
	public boolean emTurno;
	
	public boolean venceu = false;
	
	public String tabuleiro[][];

	public int getQtdNavios() {
		return qtdNavios;
	}

	public void setQtdNavios(int qtdNavios) {
		this.qtdNavios = qtdNavios;
	}

	public boolean isEmTurno() {
		return emTurno;
	}

	public void setEmTurno(boolean emTurno) {
		this.emTurno = emTurno;
	}

	public boolean isVenceu() {
		return venceu;
	}

	public void setVenceu(boolean venceu) {
		this.venceu = venceu;
	}

	public String[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(String tabuleiro, int linha, int coluna) {
		this.tabuleiro[linha][coluna] = tabuleiro;
	}
	
	public static String[][] zeraTabuleiro(String tabuleiro[][]){
        for(int linha=0; linha<10; linha++){
                for(int coluna=0; coluna<8;coluna++){
               	 tabuleiro[linha][coluna] = "~";
                 }
         }
        return tabuleiro;
   }

	
	
}
