package main;

public class Navio {
	
	public Navio() {
	}

	public Navio(String nomeNavio, int tamanhoNavio, String[][] posicao) {
		this.nomeNavio = nomeNavio;
		this.tamanhoNavio = tamanhoNavio;
		this.posicao = posicao;
	}

	public String nomeNavio;

	public int tamanhoNavio = 3;

	public String posicao[][];

	public String[][] getPosicao() {
		return posicao;
	}

	public void setPosicao(String[][] posicao) {
		this.posicao = posicao;
	}

	public String getNomeNavio() {
		return nomeNavio;
	}

	public int getTamanhoNavio() {
		return tamanhoNavio;
	}

	public void setNomeNavio(String nomeNavio) {
		this.nomeNavio = nomeNavio;
	}

	public void setTamanhoNavio(int tamanhoNavio) {
		this.tamanhoNavio = tamanhoNavio;
	}
}
