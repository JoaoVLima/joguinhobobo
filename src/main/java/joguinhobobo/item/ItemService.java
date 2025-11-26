package joguinhobobo.item;

import joguinhobobo.entidade.Heroi;

public class ItemService {
    private final ItemFactory factory;

    public ItemService(ItemFactory factory) {
        this.factory = factory;
    }

    public void adicionarAoHeroiService(Heroi heroi) throws InterruptedException {
        this.factory.adicionarAoHeroiFactory(heroi);
    }
}
