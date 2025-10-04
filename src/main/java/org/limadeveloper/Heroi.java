package org.limadeveloper;

import java.util.Scanner;

public class Heroi extends Entidade {
    private Ajudante ajudante;

    public Heroi(int ataque, int defesa, int vida) {
        super(ataque, defesa, vida);
    }

    public void receberAjudante(Ajudante ajudante) {
        System.out.println(ajudante.getNome() + " apareceu: " + ajudante.getDescricao() + "Aceita? (s ou n)");
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Read the entire line of input as a string
        String option = scanner.nextLine();
        // Close the scanner
        scanner.close();

        if  (option.equals("s")) {
            this.ajudante = ajudante;
        }

    }

    public void aplicarAjudante(Monstro monstro) {
        if (ajudante != null) {
            ajudante.aplicarEfeito(this, monstro);
            System.out.println(ajudante.getNome() + " foi embora.");
            ajudante = null;
        }
    }
}