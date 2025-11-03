package joguinhobobo;

import joguinhobobo.ajudante.AjudanteService;
import joguinhobobo.monstro.Monstro;

import java.util.Scanner;

public class Heroi extends Entidade {
    private AjudanteService ajudante;
    private Item mao_esquerda;
    private Item mao_direita;

    public Heroi(int ataque, int defesa, int vida) {
        super(ataque, defesa, vida);
    }

    public Item getMao_direita() {
        return mao_direita;
    }

    public Item getMao_esquerda() {
        return mao_esquerda;
    }

    public void pegarItem(Item item){
        System.out.println(item.getTipo() + " encontrado: ");
        item.imprimeDescricao();
        System.out.println("Aceita? (s ou n)");
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Read the entire line of input as a string
        String option = scanner.nextLine();
        // Close the scanner
        // scanner.close();

        if  (option.equals("n")) {
            return;
        }

        if (this.mao_esquerda == null) {
            this.mao_esquerda = item;
        }
        else if (this.mao_direita == null) {
            this.mao_direita = item;
        }
        else{
            System.out.println("Foi sair sem mochila né, dá nisso!");
            System.out.println("Agora escolhe algum item pra tirar:");
            System.out.printf("1 - %s%n2 - %s%n3 - Ignorar%n", this.mao_esquerda, this.mao_direita);
            option = scanner.nextLine();
            if (option.equals("1")) {
                this.mao_esquerda = item;
            }else if (option.equals("2")) {
                this.mao_esquerda = item;
            }

        }
    }

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