package joguinhobobo.ajudante;

import joguinhobobo.Heroi;
import joguinhobobo.monstro.Monstro;

public abstract class AjudanteFactory {
    public String getNomeFactory(){
        Ajudante ajudante = createAjudante(); // nao gosto de ficar criando objeto toda hora
        return ajudante.getNome();
    }

    public String getDescricaoFactory(){
        Ajudante ajudante = createAjudante(); // nao gosto de ficar criando objeto toda hora
        return ajudante.getDescricao();
    }

    public void aplicarEfeitoFactory(Heroi heroi, Monstro monstro) throws InterruptedException {
        Ajudante ajudante = createAjudante();
        ajudante.aplicarEfeito(heroi, monstro);
    }

    public abstract Ajudante createAjudante();
}
