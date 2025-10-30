package joguinhobobo.monstro;

import joguinhobobo.Heroi;

import java.util.Random;

public interface Monstro {
    default void batalha(Heroi heroi) throws InterruptedException {
        heroi.aplicarAjudante(this);
        System.out.println("Iniciando batalha contra " + getDescricao());
        aplicarHabilidade();
        Random random = new Random(); // Create a Random object
        boolean randomBool = random.nextBoolean();

        while (heroi.estaVivo() && getVida() > 0) {
            System.out.println("Vida do " + getDescricao() + ": " + getVida());
            System.out.println("Herói ataca!");
            randomBool = random.nextBoolean();
            if (randomBool) {
                System.out.println(getDescricao() + " se prepara para o ataque!");
                setVida(getVida() - Math.max(0, heroi.getAtaque() - getDefesa()));
            }else{
                setVida(getVida() - Math.max(0, heroi.getAtaque()));
            }

            System.out.println("Vida do " + getDescricao() + ": " + getVida());

            if (getVida() <= 0) break;
            Thread.sleep(500);


            System.out.println("Vida do heroi: " + heroi.getVida());
            System.out.println(getDescricao() + " ataca!");
            randomBool = random.nextBoolean();
            if (randomBool) {
                System.out.println("heroi se prepara para o ataque!");
                heroi.setVida(heroi.getVida() - Math.max(0, getAtaque() - heroi.getDefesa()));
            }else{
                heroi.setVida(heroi.getVida() - Math.max(0, getAtaque()));
            }

            System.out.println("Vida do herói: " + heroi.getVida());
        }

        if (!heroi.estaVivo()) {
            System.out.println("O herói morreu...");
            Thread.sleep(5000);
        } else {
            System.out.println("O herói derrotou " + getDescricao());
            Thread.sleep(5000);
        }
    }

    void aplicarHabilidade();
    String getDescricao();
    int getVida();
    void setVida(int vida);
    int getAtaque();
    int getDefesa();
}