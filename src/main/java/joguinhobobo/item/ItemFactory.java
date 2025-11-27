package joguinhobobo.item;

import joguinhobobo.entidade.Heroi;

public abstract class ItemFactory {
    public void adicionarAoHeroiFactory(Heroi heroi) throws InterruptedException {
        Item item = createItem();        // item original (Espada, Escudo, Cura, etc.)
        item.adicionarAoHeroi(heroi);
    }

    public abstract Item createItem();
}

