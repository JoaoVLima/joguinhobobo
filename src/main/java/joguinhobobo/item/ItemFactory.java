package joguinhobobo.item;

import joguinhobobo.entidade.Heroi;
import joguinhobobo.log.ProxyLog;

public abstract class ItemFactory {
    public void adicionarAoHeroiFactory(Heroi heroi) throws InterruptedException {
        Item item = createItem();        // item original (Espada, Escudo, Cura, etc.)
        ProxyLog.append(String.format("heroi encontrou %s", item.getTipo()));
        item.adicionarAoHeroi(heroi);
    }

    public abstract Item createItem();
}

