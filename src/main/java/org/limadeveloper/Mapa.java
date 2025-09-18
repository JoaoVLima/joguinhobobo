package org.limadeveloper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        try (Scanner scanner = new Scanner(new File(nomeArquivo))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.next()); // Reads token by token
            }
        } catch (FileNotFoundException e) {
            System.err.println("Mapa não encontrada " + e.getMessage());
        }
    }
}
