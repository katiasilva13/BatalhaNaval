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
	

	//max = 5
	public int qtdNavios;
	
	//max = 4
	public int encouracado;
	
	//max = 2
	public int barcoPatrulha;
	
	//max = 5
	public int portaAviao;
	
	//max = 3
	public int destroyer;
	
	//max = 3
	public int submarino;
	

	public int getEncouracado() {
		return encouracado;
	}

	public void setEncouracado(int encouracado) {
		this.encouracado = encouracado;
	}

	public int getBarcoPatrulha() {
		return barcoPatrulha;
	}

	public void setBarcoPatrulha(int barcoPatrulha) {
		this.barcoPatrulha = barcoPatrulha;
	}

	public int getPortaAviao() {
		return portaAviao;
	}

	public void setPortaAviao(int portaAviao) {
		this.portaAviao = portaAviao;
	}

	public int getDestroyer() {
		return destroyer;
	}

	public void setDestroyer(int destroyer) {
		this.destroyer = destroyer;
	}

	public int getSubmarino() {
		return submarino;
	}

	public void setSubmarino(int submarino) {
		this.submarino = submarino;
	}
	public boolean emTurno;

	public boolean venceu = false;

	public String[][] tabuleiro;
	
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

	public String getTabuleiro(int linha, int coluna) {
		String posicao = this.tabuleiro[linha][coluna];
		return posicao;
	}

	

	public static String[][] zeraTabuleiro(String tabuleiro[][]) {
		for (int linha = 0; linha < 10; linha++) {
			for (int coluna = 0; coluna < 10; coluna++) {
				tabuleiro[linha][coluna] = "~";
			}
		}
		return tabuleiro;
	}
	
	public void setTabuleiro(String tabuleiro, int linha, int coluna) {
		this.tabuleiro[linha][coluna] = tabuleiro;			
	}

	public String[][] getTabuleiroInteiro() {
		String [][]tabuleiroJogador= new String[10][10];
		for (int linha = 0; linha < 10; linha++) {
			for (int coluna = 0; coluna < 10; coluna++) {
				tabuleiroJogador[linha][coluna] = this.tabuleiro[linha][coluna];
			}
		}
		return tabuleiroJogador;
	}



}
