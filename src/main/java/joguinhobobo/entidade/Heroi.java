package joguinhobobo.entidade;

import joguinhobobo.entidade.ajudante.AjudanteService;
import joguinhobobo.item.Item;
import joguinhobobo.entidade.monstro.Monstro;
import joguinhobobo.item.Mochila;

import java.util.Iterator;
import java.util.Scanner;

public class Heroi extends Entidade {
    private AjudanteService ajudante;
    private Item mao_esquerda;
    private Item mao_direita;
    private Mochila mochila;

    public Heroi(int ataque, int defesa, int vida) {
        super(ataque, defesa, vida);
        this.mochila = new Mochila();
    }

    public Item getMao_direita() {
        return mao_direita;
    }

    public Item getMao_esquerda() {
        return mao_esquerda;
    }

    public void imprimirStatusEItens(String titulo) {
        System.out.println();
        System.out.println("=== " + titulo + " ===");
        System.out.println("Ataque: " + getAtaque() + " | Defesa: " + getDefesa() + " | Vida: " + getVida());
        System.out.println("Mao Esquerda: " + getMao_esquerda() + " | Mao Direita: " + getMao_direita());
        getMochila().imprimirConteudo();
        System.out.println("=========================");
        System.out.println();
    }

    public void pegarItem(joguinhobobo.item.Item item){
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
            mochila.adicionar(item);
            imprimirStatusEItens("Coletou item: " + item.getTipo());
        }
    }

    public void aplicarItems(){
        getMao_esquerda().aplicaBonusHeroi(this);
        getMao_direita().aplicaBonusHeroi(this);
        Mochila mochila = getMochila();
        Iterator<Item> iter = mochila.iterator();
        while(iter.hasNext()){
            Item item = iter.next();
            item.aplicaBonusHeroi(this);
        };
    }

    public Mochila getMochila() {
        return mochila;
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

    public void andando() { imprimirStatusEItens("Andando"); }
    public void fimDeLuta() { imprimirStatusEItens("Fim da Luta"); }
    public void saiuDoLabirinto() { imprimirStatusEItens("Saiu do Labirinto"); }
    public void morreu() { imprimirStatusEItens("Morreu"); }

}