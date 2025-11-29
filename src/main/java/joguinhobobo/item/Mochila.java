package joguinhobobo.item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mochila {

    private List<Item> itens = new ArrayList<>();

    public void adicionar(Item item) { itens.add(item); }
    public boolean remover(Item item) { return itens.remove(item); }
    public void limpar() { itens.clear(); }
    public int tamanho() { return itens.size(); }
    public boolean isVazia() { return itens.isEmpty(); }

    public void imprimirConteudo() {
        System.out.println("=== Mochila (" + tamanho() + " itens) ===");
        if (isVazia()) {
            System.out.println("(vazia)");
            return;
        }
        Iterador iter = new Iterador(itens);

        while(iter.hasNext()) {
            Item item = iter.next();
            System.out.println("- " + item.getTipo());
        }
    }

    public Iterador iterador() { return new Iterador(itens); }

}
