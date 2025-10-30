package org.limadeveloper;

public class MonstroService {
    private final MonstroFactory fatory;

    public MonstroService(MonstroFactory fatory) {
        this.fatory = fatory;
    }

    public void batalhaService(Heroi heroi) throws InterruptedException {
        this.fatory.batalhaFactory(heroi);
    }
}
