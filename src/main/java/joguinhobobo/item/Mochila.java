package joguinhobobo.item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Mochila implements Iterable<Item> {

    private final List<Item> itens = new ArrayList<>();

    public void adicionar(Item item) { itens.add(item); }
    public boolean remover(Item item) { return itens.remove(item); }
    public int tamanho() { return itens.size(); }
    public boolean isVazia() { return itens.isEmpty(); }

    public void imprimirConteudo() {
        System.out.println("=== Mochila (" + itens.size() + " itens) ===");
        if (itens.isEmpty()) {
            System.out.println("(vazia)");
            return;
        }
        for (Item it : itens) {
            System.out.println("- " + it.getTipo());
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return itens.iterator();
    }

    public Iterable<Item> somente(Class<? extends Item> tipo) {
        return () -> new Iterator<Item>() {
            private final Iterator<Item> base = itens.iterator();
            private Item prox;

            @Override
            public boolean hasNext() {
                while (prox == null && base.hasNext()) {
                    Item x = base.next();
                    if (tipo.isInstance(x)) prox = x;
                }
                return prox != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item out = prox;
                prox = null;
                return out;
            }
        };
    }
}
