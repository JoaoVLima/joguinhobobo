package org.limadeveloper;

public class BichoPapao extends Entidade implements Monstro {
    public BichoPapao(int ataque, int defesa, int vida) {
        super(ataque, defesa, vida);
    }

    @Override
    public void aplicarHabilidade() {
        System.out.println("Bicho Papão fica furioso e ganha um bonus de 15% de dano!");
        setAtaque((int) (getAtaque()*1.15));
    }

    @Override
    public String getDescricao() {
        return "Bicho Papão";
    }
}