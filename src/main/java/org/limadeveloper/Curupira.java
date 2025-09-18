package org.limadeveloper;

public class Curupira extends Entidade implements Monstro {
    public Curupira(int ataque, int defesa, int vida) {
        super(ataque, defesa, vida);
    }

    @Override
    public void aplicarHabilidade() {}
    @Override
    public String getDescricao() { return "Curupira"; }
}