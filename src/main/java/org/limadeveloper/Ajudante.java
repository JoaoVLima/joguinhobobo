package org.limadeveloper;

public interface Ajudante {
    void AcaoMonstro(Monstro monstro);
    void AcaoHeroi(Heroi heroi);
    void cumprimentar();
    String getTipo();
    default void ofereceAjuda(Heroi heroi) {}
}