package joguinhobobo.item;

import joguinhobobo.entidade.Heroi;

public class ItemService {
    private final ItemFactory factory;

    public ItemService(ItemFactory factory) {
        this.factory = factory;
    }

    public void juntarService(Heroi heroi) throws InterruptedException {
        this.factory.juntarFactory(heroi);
    }
}
