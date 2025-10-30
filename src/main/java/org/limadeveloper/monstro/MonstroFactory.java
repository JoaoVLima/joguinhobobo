package org.limadeveloper.monstro;

import org.limadeveloper.Heroi;

public abstract class MonstroFactory {
    public void batalhaFactory(Heroi heroi) throws InterruptedException {
        Monstro monstro = createMonstro();
        monstro.batalha(heroi);
    }

    public abstract Monstro createMonstro();
}
