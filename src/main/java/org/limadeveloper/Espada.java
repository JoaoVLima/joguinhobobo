package org.limadeveloper;

public class Espada extends Item {
    public Espada() {
        super(EnumBonusItem.BONUS_ESPADA);
    }

    @Override
    public void aplicaBonusHeroi(Heroi heroi) {}
    @Override
    public void retiraBonusHeroi(Heroi heroi) {}
    @Override
    public void imprimeDescricao() {}
    @Override
    public String getTipo() { return "Espada"; }
    @Override
    public void juntar(Heroi heroi) {}
}