package main;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		System.out.println("Teste");
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TelaJogo tela = new TelaJogo();
				tela.setVisible(true);
			}
		});
		

	}

}
