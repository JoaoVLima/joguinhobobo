package joguinhobobo.item;

public class EspadaFactory extends ItemFactory {

    @Override
    public Item createItem() {
        return new Espada();
    }
}
