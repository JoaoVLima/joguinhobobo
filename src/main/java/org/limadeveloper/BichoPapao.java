package org.limadeveloper;

public class BichoPapao extends Entidade implements Monstro {
    public BichoPapao(int ataque, int defesa, int vida) {
        super(ataque, defesa, vida);
    }

    @Override
    public void aplicarHabilidade() {
        System.out.println("👹 Bicho Papão assusta o herói e reduz sua coragem!");
    }

    @Override
    public String getDescricao() {
        return "Bicho Papão";
    }
}