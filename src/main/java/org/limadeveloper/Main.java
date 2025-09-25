package org.limadeveloper;

public class Main {
    public static void main(String[] args) {
        Heroi heroi = new Heroi(10,10,10);
        Mapa mapa = new Mapa("mapa.txt", 17, 21);
        mapa.setHeroi(heroi);
        mapa.imprimeMapa();
        mapa.encontraSaida(1,1);
    }
}