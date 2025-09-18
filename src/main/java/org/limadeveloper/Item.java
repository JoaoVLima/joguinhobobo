package org.limadeveloper;

public abstract class Item {
    protected EnumBonusItem bonus;
    protected Item maoDireita;
    protected Item maoEsquerda;

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
    public abstract void juntar(Heroi heroi);

    // Getters e setters para mãos
    public void setMaoDireita(Item item) {
        this.maoDireita = item;
    }

    public void setMaoEsquerda(Item item) {
        this.maoEsquerda = item;
    }

    public Item getMaoDireita() {
        return maoDireita;
    }

    public Item getMaoEsquerda() {
        return maoEsquerda;
    }
}