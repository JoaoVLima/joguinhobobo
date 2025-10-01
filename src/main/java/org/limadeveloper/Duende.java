package org.limadeveloper;

public class Duende implements Ajudante {
    @Override
    public String getNome() { return "Duende"; }

    @Override
    public String getDescricao() {
        return "Diminui 10% da vida do herói, mas enfraquece o próximo monstro em 50%.";
    }

    @Override
    public void aplicarEfeito(Heroi heroi, Monstro monstro) {
        heroi.setVida((int) (heroi.getVida() * 0.9));
        monstro.setVida((int) (monstro.getVida() * 0.5));
        System.out.println("O Duende ajudou! Vida do herói agora: " + heroi.getVida());
        System.out.println("Vida do monstro reduzida: " + monstro.getVida());
    }
}
