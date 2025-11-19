package joguinhobobo.entidade.monstro;

import joguinhobobo.entidade.Heroi;

public abstract class MonstroFactory {
    public void batalhaFactory(Heroi heroi) throws InterruptedException {
        Monstro monstroReal = createMonstro();
        Monstro monstro = new ProxyMonstro(monstroReal);
        monstro.batalha(heroi);
    }

    public abstract Monstro createMonstro();
}
