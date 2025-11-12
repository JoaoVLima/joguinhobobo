package joguinhobobo.item;

import joguinhobobo.entidade.Heroi;

public abstract class ItemFactory {
    public void juntarFactory(Heroi heroi) throws InterruptedException {
        Item item = createItem();
        item.juntar(heroi);
    }

    public abstract Item createItem();
}

