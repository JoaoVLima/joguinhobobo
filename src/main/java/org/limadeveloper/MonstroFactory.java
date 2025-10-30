package org.limadeveloper;

public abstract class MonstroFactory {
    public void batalhaFactory(Heroi heroi) throws InterruptedException {
        Monstro monstro = createMonstro();
        monstro.batalha(heroi);
    }

    public abstract Monstro createMonstro();
}
