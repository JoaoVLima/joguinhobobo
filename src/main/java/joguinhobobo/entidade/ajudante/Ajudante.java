package joguinhobobo.entidade.ajudante;

import joguinhobobo.entidade.Heroi;
import joguinhobobo.entidade.monstro.Monstro;

public interface Ajudante {
    String getNome();

    String getDescricao();

    void aplicarEfeito(Heroi heroi, Monstro monstro) throws InterruptedException;
}