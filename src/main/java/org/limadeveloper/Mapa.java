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

    public void setHeroi(Heroi heroi){
        this.heroi = heroi;
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
        if (matriz[y][x] == '=') {
            imprimeMapa();
            return true;
        }


        switch (matriz[y][x]) {
            case '?': // Bicho Papão
                BichoPapao bichoPapao = new BichoPapao(10,10,10);
                bichoPapao.batalha(heroi);
                // batalha
            case '*': // Curupira
                Curupira curupira = new Curupira(10,10,10);
                // batalha
            case '^': // Duende
                // recebe a oportunidade de 1 ajuda do duende (buff) e (debuff) do bicho
                Duende duende = new Duende();
                heroi.receberAjudante(duende);
            case '&': // Anão
                // recebe a oportunidade de 1 ajuda do duende (buff) e (debuff) do bicho
                Anao anao = new Anao();
                heroi.receberAjudante(anao);
            case 'e': // Espada
                // recebe buff de ataque
                Espada espada = new Espada();
                espada.aplicaBonusHeroi(heroi);
            case 'd': // Escudo
                // recebe buff de defesa
                Escudo escudo = new Escudo();
                escudo.aplicaBonusHeroi(heroi);
            case 'c': // Cura
                // recebe buff de vida
                Cura cura = new Cura();
                cura.aplicaBonusHeroi(heroi);
        }

        // direita
        // baixo
        // esquerda
        // cima

        char direita = matriz[y][x+1];
        char baixo = matriz[y+1][x];
        char esquerda = matriz[y][x-1];
        char cima = matriz[y-1][x];

        if (direita != '#' && direita != '8') {
            // direita ta livre
            matriz[y][x] = '8';
            return encontraSaida(x+1, y);
        }
        if  (baixo != '#' && baixo != '8') {
            // baixo ta livre
            matriz[y][x] = '8';
            return encontraSaida(x, y+1);

        }
        if (esquerda != '#' && esquerda != '8') {
            // esquerda ta livre
            matriz[y][x] = '8';
            return encontraSaida(x-1, y);

        }
        if (cima != '#' && cima != '8') {
            // cima ta livre
            matriz[y][x] = '8';
            return encontraSaida(x, y-1);

        }

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