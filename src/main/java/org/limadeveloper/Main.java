package org.limadeveloper;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Heroi heroi = new Heroi(5,10,30);
        Mapa mapa = new Mapa("mapa.txt", 17, 21);
        mapa.setHeroi(heroi);
        mapa.imprimeMapa();
        mapa.encontraSaida(1,1);
    }
}