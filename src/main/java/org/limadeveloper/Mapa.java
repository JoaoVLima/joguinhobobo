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

    public void imprimeMapa() {
        for (int i = 0; i < numeroLinhas; i++) {
            for (int j = 0; j < numeroColunas; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }

    public boolean encontraSaida(int x, int y) {
        return false;
    }

    private void alocaMatriz() {
        matriz = new char[numeroLinhas][numeroColunas];
    }

    public void lerArquivo(String nomeArquivo) {
        // Scanner para ler o arquivo
        try (Scanner scanner = new Scanner(getClass().getClassLoader().getResourceAsStream(nomeArquivo))) {
            int linha = 0; // y
            // verifica se tem a proxima linha
            while (scanner.hasNextLine() && linha < numeroLinhas) {
                String linhaTexto = scanner.nextLine(); // armazena a linha em uma string
                // percore pelos caracteres da string
                for (int coluna = 0; coluna < numeroColunas && coluna < linhaTexto.length(); coluna++) {
                    // insere na matrix usando a funcao charAt() na linha
                    matriz[linha][coluna] = linhaTexto.charAt(coluna);
                }
                linha++;
            }
        } catch (Exception e) {
            System.err.println("Mapa não encontrado: " + e.getMessage());
        }
    }
}