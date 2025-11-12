package joguinhobobo.item;

public class EscudoFactory extends ItemFactory {

    @Override
    public Item createItem() {
        return new Escudo();
    }
}
