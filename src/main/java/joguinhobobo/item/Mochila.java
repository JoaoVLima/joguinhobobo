package joguinhobobo.item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Mochila {

    private List<Item> itens = new ArrayList<>();

    public void adicionar(Item item) { itens.add(item); }
    public boolean remover(Item item) { return itens.remove(item); }
    public int tamanho() { return itens.size(); }
    public boolean isVazia() { return itens.isEmpty(); }

    public void imprimirConteudo() {
        System.out.println("=== Mochila (" + tamanho() + " itens) ===");
        if (isVazia()) {
            System.out.println("(vazia)");
            return;
        }
        Iterator<Item> iter = itens.iterator();

        while(iter.hasNext()) {
            Item item = iter.next();
            System.out.println("- " + item.getTipo());
        }
    }

}
