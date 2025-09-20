package org.limadeveloper;

public class Heroi extends Entidade {
    private Ajudante ajudante;

    public Heroi(int ataque, int defesa, int vida) {
        super(ataque, defesa, vida);
    }

    public void receberAjudante(Ajudante ajudante) {
        System.out.println("🤝 " + ajudante.getNome() + " apareceu: " + ajudante.getDescricao());
        this.ajudante = ajudante;
    }

    public void aplicarAjudante(Monstro monstro) {
        if (ajudante != null) {
            ajudante.aplicarEfeito(this, monstro);
            System.out.println("❌ " + ajudante.getNome() + " foi embora.");
            ajudante = null;
        }
    }
}