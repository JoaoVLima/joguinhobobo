package joguinhobobo.ajudante;

import joguinhobobo.Heroi;
import joguinhobobo.monstro.Monstro;

public class AjudanteService {
    private final AjudanteFactory factory;

    public AjudanteService(AjudanteFactory factory) {
        this.factory = factory;
    }

    public String getNomeService() {
        return this.factory.getNomeFactory();
    }

    public String getDescricaoService() {
        return this.factory.getDescricaoFactory();
    }

    public void aplicarEfeitoService(Heroi heroi, Monstro monstro) throws InterruptedException {
        this.factory.aplicarEfeitoFactory(heroi, monstro);
    }
}
