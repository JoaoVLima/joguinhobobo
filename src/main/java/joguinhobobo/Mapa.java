package joguinhobobo;

import joguinhobobo.ajudante.*;
import joguinhobobo.monstro.BichoPapaoFactory;
import joguinhobobo.monstro.CurupiraFactory;
import joguinhobobo.monstro.MonstroService;

import java.io.IOException;
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

    public void limparConsole() throws IOException, InterruptedException {
        new ProcessBuilder("clear").inheritIO().start().waitFor();  // FUNCIONOU, NAO MEXE MAIS (ou faz varios ifs pra varias condicoes de OS, etc)
    }

    public boolean encontraSaida(int x, int y) throws IOException, InterruptedException {
        imprimeMapa();
        Thread.sleep(100);
        limparConsole();
        if (matriz[y][x] == '=') {
            imprimeMapa();
            System.out.println("FIM DO JOGO, OBRIGADO POR JOGAR!!!");
            return true;
        }

        switch (matriz[y][x]) {
            case '?': // Bicho Papão
                BichoPapaoFactory bichoPapaoFactory = new BichoPapaoFactory();
                MonstroService bichoPapaoMonstroService = new MonstroService(bichoPapaoFactory);
                bichoPapaoMonstroService.batalhaService(heroi);
                break;
                // batalha
            case '*': // Curupira
                CurupiraFactory curupiraFactory = new CurupiraFactory();
                MonstroService curupiraMonstroService = new MonstroService(curupiraFactory);
                curupiraMonstroService.batalhaService(heroi);
                break;
                // batalha
            case '^': // Duende
                // recebe a oportunidade de 1 ajuda do duende (buff) e (debuff) do bicho
                DuendeFactory duendeFactory = new DuendeFactory();
                AjudanteService duendeAjudanteService = new AjudanteService(duendeFactory);
                heroi.receberAjudante(duendeAjudanteService);
                break;
            case '&': // Anão
                // recebe a oportunidade de 1 ajuda do duende (buff) e (debuff) do bicho
                AnaoFactory anaoFactory = new AnaoFactory();
                AjudanteService anaoAjudanteService = new AjudanteService(anaoFactory);
                heroi.receberAjudante(anaoAjudanteService);
                break;
            case 'e': // Espada
                // recebe buff de ataque
                Espada espada = new Espada();
                espada.aplicaBonusHeroi(heroi);
                break;
            case 'd': // Escudo
                // recebe buff de defesa
                Escudo escudo = new Escudo();
                escudo.aplicaBonusHeroi(heroi);
                break;
            case 'c': // Cura
                // recebe buff de vida
                Cura cura = new Cura();
                cura.aplicaBonusHeroi(heroi);
                break;
        }

        if (!heroi.estaVivo()){
            imprimeMapa();
            return true;
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