package joguinhobobo.ajudante;

import joguinhobobo.Heroi;
import joguinhobobo.monstro.Monstro;

public interface Ajudante {
    String getNome();

    String getDescricao();

    void aplicarEfeito(Heroi heroi, Monstro monstro);
}