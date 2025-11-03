package joguinhobobo;

import joguinhobobo.ajudante.Ajudante;
import joguinhobobo.ajudante.AjudanteService;
import joguinhobobo.monstro.Monstro;

import java.util.Scanner;

public class Heroi extends Entidade {
    private AjudanteService ajudante;

    public Heroi(int ataque, int defesa, int vida) {
        super(ataque, defesa, vida);
    }

    // Todo: mao esquerda e mao direita, salvar as armas e escudos

    public void receberAjudante(AjudanteService ajudante) {
        System.out.println(ajudante.getNomeService() + " apareceu: " + ajudante.getDescricaoService() + "Aceita? (s ou n)");
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Read the entire line of input as a string
        String option = scanner.nextLine();
        // Close the scanner
        // scanner.close();

        if  (option.equals("s")) {
            this.ajudante = ajudante;
        }

    }

    public void aplicarAjudante(Monstro monstro) throws InterruptedException {
        if (ajudante != null) {
            ajudante.aplicarEfeitoService(this, monstro);
            System.out.println(ajudante.getNomeService() + " foi embora.");
            ajudante = null;
        }
    }
}