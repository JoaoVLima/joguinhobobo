package joguinhobobo.item;

import java.util.Iterator;
import java.util.List;

public class Iterador implements Iterator<Item> {
    List<Item> lista;
    int indice = -1;

    public Iterador(List<Item> lista) {
        this.lista = lista;
    }


    @Override
    public boolean hasNext() {
        return lista.size() > indice+1;
    }

    @Override
    public Item next() {
        return lista.get(++indice);
    }

}
