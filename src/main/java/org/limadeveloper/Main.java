package org.limadeveloper;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        Mapa mapa = new Mapa("mapa.txt", 17, 21);
        mapa.imprimeMapa();
        mapa.encontraSaida(1,1);
    }
}