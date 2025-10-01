package org.limadeveloper;

public class Anao implements Ajudante {
    @Override
    public String getNome() { return "Anao"; }

    @Override
    public String getDescricao() {
        return "Anão aumenta a vida do próximo monstro em 35%, mas em compensação, aumenta o ataque do herói em 85%.";
    }

    @Override
    public void aplicarEfeito(Heroi heroi, Monstro monstro) {
        heroi.setAtaque((int) (heroi.getAtaque() * 1.85));
        monstro.setVida((int) (monstro.getVida() * 1.35));
        System.out.println("O Anao ajudou! Ataque do herói agora: " + heroi.getAtaque());
        System.out.println("Vida do monstro reduzida: " + monstro.getVida());
    }
}
