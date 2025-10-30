package joguinhobobo.monstro;

import joguinhobobo.Heroi;

public class MonstroService {
    private final MonstroFactory factory;

    public MonstroService(MonstroFactory factory) {
        this.factory = factory;
    }

    public void batalhaService(Heroi heroi) throws InterruptedException {
        this.factory.batalhaFactory(heroi);
    }
}
