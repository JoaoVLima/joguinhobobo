package org.limadeveloper;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        Mapa mapa = new Mapa("mapa.txt", 20, 20);
        mapa.imprimeMapa(0, 0);
    }
}