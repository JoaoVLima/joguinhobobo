package org.limadeveloper;

public class Entidade {
    protected int ataque;
    protected int defesa;
    protected int vida;

    public Entidade(int ataque, int defesa, int vida) {
        this.ataque = ataque;
        this.defesa = defesa;
        this.vida = vida;
    }

    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }

    public int getDefesa() { return defesa; }
    public void setDefesa(int defesa) { this.defesa = defesa; }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }

    public boolean estaVivo() {
        return vida > 0;
    }
}