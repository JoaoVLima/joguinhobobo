package joguinhobobo.item;

import joguinhobobo.entidade.Heroi;

public class Cura extends Item {
    public Cura() {
        super(EnumBonusItem.BONUS_CURA);
    }

    @Override
    public void aplicaBonusHeroi(Heroi heroi) {
        heroi.setVida(heroi.getVida() + getBonus());
    }
    @Override
    public void retiraBonusHeroi(Heroi heroi) {}
    @Override
    public void imprimeDescricao() {}
    @Override
    public String getTipo() { return "Cura"; }
}