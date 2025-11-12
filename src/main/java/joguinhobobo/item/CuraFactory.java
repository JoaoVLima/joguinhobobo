package joguinhobobo.item;

public class CuraFactory extends ItemFactory {

    @Override
    public Item createItem() {
        return new Cura();
    }
}
