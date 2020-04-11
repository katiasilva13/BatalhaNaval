package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaJogo extends JFrame implements ActionListener {
	
	private static Jogo jogo = new Jogo();
	private static String tabuleiro[][];
	private static Jogador jogador1;
	private static Jogador jogador2;
	
	
	private static final long serialVersionUID = 1L;

	// Adicionando os Painéis
	JPanel grid = new JPanel();
	JPanel jContentPane = new JPanel();
	Container cp;

	// Adicionando os Botões
	JButton[][] Botoes = new JButton[10][10];
	JButton novo = new JButton("Novo Jogo");
	JButton voltar = new JButton("Voltar");

	// Adicionando as Labels
	private JLabel BatalhaNaval = new JLabel("Batalha Naval");
	JLabel navios = new JLabel("Navios");
	JLabel contNavios = new JLabel("");
	int contadorNavio = 5;

	// Vetor que fica por trás dos Botões e guarda água ou navios
	String vetor[][] = new String[10][10];

	// Instanciando classe jogo que preenche o vetor e distribui os navios
//	Jogo jogo = new Jogo();

	public TelaJogo() {

		// Titulo da janela
		setTitle("Batalha Naval");
		// Define o tamanho da janela. Pode ser usado o janela.pack() para auto ajuste
		setSize(598, 415);
		// Centraliza a janela. Pode ser usado o janela.setLocation() para colocar onde
		// quiser
		setLocationRelativeTo(null);
		// Configura o maximizar e fixa o tamanho da janela
		setResizable(false);
		// Configura o fechamento da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Configura o Container
		setContentPane(jContentPane);
		cp = getContentPane();
		cp.setLayout(null);

		// Configura o Grid de Botões
		grid.setBounds(3, 58, 488, 317);
		grid.setLayout(new GridLayout(10, 10, 2, 2));

		// Adiciona os Botões no Grid
		for (int linha = 0; linha < 10; linha++) {
			for (int coluna = 0; coluna < 10; coluna++) {
				Botoes[linha][coluna] = new JButton("");
				Botoes[linha][coluna].addActionListener(this);
				Botoes[linha][coluna].setFocusable(false);
				grid.add(Botoes[linha][coluna]);
			}
		}

		// Botão Novo Jogo
		novo.setBounds(7, 14, 96, 35);
		novo.setFocusable(false);
		novo.addActionListener(this);

		// Label Navios 
		navios.setFont(new Font("Roboto", Font.PLAIN, 15));
		navios.setBounds(352, 6, 120, 18);

		// Contador Navios
		contNavios.setFont(new Font("Roboto", Font.BOLD, 18));
		contNavios.setBounds(362, 21, 20, 26);
		contNavios.setText("" + contadorNavio);

		// Adicionando os elementos no Container
		cp.add(grid);
		cp.add(novo);
		cp.add(voltar);
		cp.add(navios);
		cp.add(contNavios);
		
		JRadioButton rdbtnJogador1 = new JRadioButton("Jogador 1");
		rdbtnJogador1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnJogador1.setSelected(true);
		rdbtnJogador1.setBounds(172, 4, 109, 23);
		jContentPane.add(rdbtnJogador1);
		
		JRadioButton rdbtnJogador2 = new JRadioButton("Jogador 2");
		rdbtnJogador2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnJogador2.setSelected(false);
		rdbtnJogador2.setBounds(172, 28, 109, 23);
		jContentPane.add(rdbtnJogador2);
		
		JTextPane txtpnSelecione = new JTextPane();
		txtpnSelecione.setText("Selecione blocos (vertical ou horizontal) para:\r\n\r\n5: porta-avi\u00E3o\r\n4: encouracado\r\n3: submarino\r\n3: destroyer\r\n2: barco de patrulha");
		txtpnSelecione.setBounds(504, 28, 88, 155);
		jContentPane.add(txtpnSelecione);

		// Centralizando a tela quando iniciada
		setLocationRelativeTo(null);

		// Chamando o método que inicia o jogo e distribui os navios
	//	jogo.iniciarJogo(vetor);
//		
//		String tabuleiro[][] = new String[10][10];
		
		tabuleiro = new String[10][10];
		
		jogador1 = new Jogador(
			5,
			true,
			false,
			tabuleiro);
			
		jogador2 = new Jogador(
			5,
			false,
			false,
			tabuleiro);
				
		JOptionPane.showMessageDialog(null, "Selecione 5 blocos consecutivos (vertical OU horizontal) para colocar seu porta-aviões");
		
		
//		Jogador jogador1 = new Jogador(
//				5,
//				true,
//				false,
//				tabuleiro);
//		
//		Jogador jogador2 = new Jogador(
//				5,
//				false,
//				false,
//				tabuleiro);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		// Função dos Botões do Tabuleiro
		for (int linha = 0; linha < 10; linha++) {
			for (int coluna = 0; coluna < 10; coluna++) {

	//TODO pegar a posição dos navios estipuladas pelos players
				// Quando um Botão é clicado
				if (e.getSource() == Botoes[linha][coluna]) {
					
						for(int pa = 0; pa < 5; pa++) {
						jogador1.setTabuleiro("PA",linha, coluna);
					}
							
					
					}
					
//				if (e.getSource() == Botoes[linha][coluna]) {	
//					
//					if (vetor[linha][coluna] == "~") {
//						Botoes[linha][coluna].setEnabled(false);
//					}					
//					else if (vetor[linha][coluna] != "~") {
////TODO adaptar
//						// Configura a imagem de navio destruído
//						Botoes[linha][coluna].setLabel("X");
//						
//						contNavios.setText("" + --contadorNavio);
//
//					}
//				}
				
			}
		}

		// Função do Botão Novo Jogo
		if (e.getSource() == novo) {
			// Fecha a janela
			this.dispose();

			// Cria um novo tabuleiro e seta a visibilidade
			TelaJogo tela = new TelaJogo();
			tela.setVisible(true);

			// Mostra mensagem de Jogo Reiniciado
			JOptionPane.showMessageDialog(this, "Jogo reiniciado!", "Novo Jogo", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}