package org.limadeveloper;

public class Mapa {
    private char[][] matriz;
    private int numeroLinhas;
    private int numeroColunas;
    private Heroi heroi;

    public Mapa(String nomeArquivo, int linhas, int colunas) {
        this.numeroLinhas = linhas;
        this.numeroColunas = colunas;
        alocaMatriz();
        lerArquivo(nomeArquivo);
    }

    public void imprimeMapa(int x, int y) {

    }

    public boolean encontraSaida(int x, int y) {
        return false;
    }

    private void alocaMatriz() {
        matriz = new char[numeroLinhas][numeroColunas];
    }

    public void lerArquivo(String nomeArquivo){

    }
}
