package joguinhobobo.entidade.ajudante;

import joguinhobobo.entidade.Heroi;
import joguinhobobo.entidade.monstro.Monstro;
import joguinhobobo.log.ProxyLog;

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
        ProxyLog.append(String.format("%s está ajudando o heroi!", ajudante.getNome()));
        ajudante.aplicarEfeito(heroi, monstro);
    }

    public abstract Ajudante createAjudante();
}
