package joguinhobobo.item;

import joguinhobobo.entidade.Heroi;
import joguinhobobo.log.Log;


public class ProxyItem extends Item {

    private final Item real;

    public ProxyItem(Item real) {
        super(real.bonus);
        this.real = real;
    }

    @Override
    public void aplicaBonusHeroi(Heroi heroi) {
        Log.append("Herói usou  " + real.getTipo());
        real.aplicaBonusHeroi(heroi);
    }

    @Override
    public void retiraBonusHeroi(Heroi heroi) {
        real.retiraBonusHeroi(heroi);
    }

    @Override
    public void imprimeDescricao() {
        real.imprimeDescricao();
    }

    @Override
    public String getTipo() {
        return real.getTipo();
    }


    @Override
    public void juntar(Heroi heroi) {
        Log.append("Herói encontrou um " + real.getTipo());
        real.juntar(heroi);
    }
}


