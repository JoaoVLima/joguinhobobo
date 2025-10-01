package org.limadeveloper;

public interface Monstro {
    default void batalha(Heroi heroi) {
        System.out.println("⚔️ Iniciando batalha contra " + getDescricao());
        aplicarHabilidade();

        while (heroi.estaVivo() && getVida() > 0) {
            setVida(getVida() - Math.max(0, heroi.getAtaque() - getDefesa()));
            System.out.println("Herói ataca! Vida do " + getDescricao() + ": " + getVida());

            if (getVida() <= 0) break;

            heroi.setVida(heroi.getVida() - Math.max(0, getAtaque() - heroi.getDefesa()));
            System.out.println(getDescricao() + " ataca! Vida do herói: " + heroi.getVida());
        }

        if (!heroi.estaVivo()) {
            System.out.println("O herói morreu...");
        } else {
            System.out.println("O herói derrotou " + getDescricao());
        }
    }

    void aplicarHabilidade();
    String getDescricao();
    int getVida();
    void setVida(int vida);
    int getAtaque();
    int getDefesa();
}