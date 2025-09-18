package org.limadeveloper;

public class Escudo extends Item {
    public Escudo() {
        super(EnumBonusItem.BONUS_ESCUDO);
    }

    @Override
    public void aplicaBonusHeroi(Heroi heroi) {}
    @Override
    public void retiraBonusHeroi(Heroi heroi) {}
    @Override
    public void imprimeDescricao() {}
    @Override
    public String getTipo() { return "Escudo"; }
    @Override
    public void juntar(Heroi heroi) {}
}