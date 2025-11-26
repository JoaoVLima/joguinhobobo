package joguinhobobo.item;

import joguinhobobo.entidade.Heroi;

public abstract class ItemFactory {
    public void adicionarAoHeroiFactory(Heroi heroi) throws InterruptedException {
        Item real = createItem();        // item original (Espada, Escudo, Cura, etc.)
        Item item = new ProxyItem(real);
        item.adicionarAoHeroi(heroi);
    }

    public abstract Item createItem();
}

