package org.limadeveloper;

public class Heroi extends Entidade {
    private Item maoDireita;
    private Item maoEsquerda;
    private Ajudante ajudante;

    public Heroi(int ataque, int defesa, int vida) {
        super(ataque, defesa, vida);
    }

    public void setMaoEsquerda(Item item) { this.maoEsquerda = item; }
    public void setMaoDireita(Item item) { this.maoDireita = item; }
    public Item getMaoDireita() { return maoDireita; }
    public Item getMaoEsquerda() { return maoEsquerda; }
}