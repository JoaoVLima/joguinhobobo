package joguinhobobo.item;

import joguinhobobo.entidade.Heroi;

public abstract class Item {
    protected EnumBonusItem bonus;

    public Item(EnumBonusItem bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus.getValor();
    }

    public abstract void aplicaBonusHeroi(Heroi heroi);
    public abstract void retiraBonusHeroi(Heroi heroi);
    public abstract void imprimeDescricao();
    public abstract String getTipo();

    public void juntar(Heroi heroi) {
        heroi.pegarItem(this);
    }

    public String toString() {
        return getTipo();
    }
}