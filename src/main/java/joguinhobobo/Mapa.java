package joguinhobobo;

import joguinhobobo.colorido.*;
import joguinhobobo.entidade.Heroi;
import joguinhobobo.entidade.ajudante.*;
import joguinhobobo.item.*;
import joguinhobobo.entidade.monstro.*;

import java.io.IOException;
import java.util.Scanner;

public class Mapa {
    private Char[][] matriz;
    private final int numeroLinhas;
    private final int numeroColunas;
    private Heroi heroi;
    private BichoPapaoFactory bichoPapaoFactory;
    private CurupiraFactory curupiraFactory;
    private DuendeFactory duendeFactory;
    private AnaoFactory anaoFactory;
    private EspadaFactory espadaFactory;
    private EscudoFactory escudoFactory;
    private CuraFactory curaFactory;

    public Mapa(String nomeArquivo, int linhas, int colunas) {
        this.numeroLinhas = linhas;
        this.numeroColunas = colunas;
        alocaMatriz();
        lerArquivo(nomeArquivo);
        this.bichoPapaoFactory = new BichoPapaoFactory();
        this.curupiraFactory = new CurupiraFactory();
        this.duendeFactory = new DuendeFactory();
        this.anaoFactory = new AnaoFactory();
        this.espadaFactory = new EspadaFactory();
        this.escudoFactory = new EscudoFactory();
        this.curaFactory = new CuraFactory();
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
        try {
            String osName = System.getProperty("os.name").toLowerCase();

            if (osName.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // nao funciona
            } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } else {
                System.out.println("Unknown operating system: " + osName);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean encontraSaida(int x, int y) throws IOException, InterruptedException {
        imprimeMapa();
        heroi.andando();
        Thread.sleep(100);
        limparConsole();
        if (matriz[y][x].getChar() == '=') {
            imprimeMapa();
            heroi.saiuDoLabirinto();
            System.out.println("FIM DO JOGO, OBRIGADO POR JOGAR!!!");
            return true;
        }

        switch (matriz[y][x].getChar()) {
            case '?': // Bicho Papão
                MonstroService bichoPapaoMonstroService = new MonstroService(this.bichoPapaoFactory);
                bichoPapaoMonstroService.batalhaService(heroi);
                break;
                // batalha
            case '*': // Curupira
                MonstroService curupiraMonstroService = new MonstroService(this.curupiraFactory);
                curupiraMonstroService.batalhaService(heroi);
                break;
                // batalha
            case '^': // Duende
                // recebe a oportunidade de 1 ajuda do duende (buff) e (debuff) do bicho
                AjudanteService duendeService = new AjudanteService(this.duendeFactory);
                heroi.receberAjudante(duendeService);
                break;
            case '&': // Anão
                // recebe a oportunidade de 1 ajuda do duende (buff) e (debuff) do bicho
                AjudanteService anaoService = new AjudanteService(this.anaoFactory);
                heroi.receberAjudante(anaoService);
                break;
            case 'e': // Espada
                // recebe buff de ataque
                ItemService espadaItemService = new ItemService(this.espadaFactory);
                espadaItemService.adicionarAoHeroiService(heroi);
                break;
            case 'd': // Escudo
                // recebe buff de defesa
                ItemService escudoItemService = new ItemService(this.escudoFactory);
                escudoItemService.adicionarAoHeroiService(heroi);
                break;
            case 'c': // Cura
                // recebe buff de vida
                ItemService curaItemService = new ItemService(this.curaFactory);
                curaItemService.adicionarAoHeroiService(heroi);
                break;
        }

        if (!heroi.estaVivo()){
            imprimeMapa();
            heroi.andando();
            return true;
        }

        // direita
        // baixo
        // esquerda
        // cima

        char direita = matriz[y][x+1].getChar();
        char baixo = matriz[y+1][x].getChar();
        char esquerda = matriz[y][x-1].getChar();
        char cima = matriz[y-1][x].getChar();

        if (direita != '#' && direita != '8') {
            // direita ta livre
            matriz[y][x] = new Char('8', Cor.CYAN);
            return encontraSaida(x+1, y);
        }
        if  (baixo != '#' && baixo != '8') {
            // baixo ta livre
            matriz[y][x] = new Char('8', Cor.CYAN);
            return encontraSaida(x, y+1);

        }
        if (esquerda != '#' && esquerda != '8') {
            // esquerda ta livre
            matriz[y][x] = new Char('8', Cor.CYAN);
            return encontraSaida(x-1, y);

        }
        if (cima != '#' && cima != '8') {
            // cima ta livre
            matriz[y][x] = new Char('8', Cor.CYAN);
            return encontraSaida(x, y-1);

        }

        return false;

    }



    private void alocaMatriz() {
        matriz = new Char[numeroLinhas][numeroColunas];
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
                    char caracter = linhaTexto.charAt(coluna);
                    Char caracter_colorido = switch (caracter) {
                        case '?' -> // Bicho Papão
                                new Char(caracter, Cor.RED);
                        case '*' -> // Curupira
                                new Char(caracter, Cor.RED);
                        case '^' -> // Duende
                                new Char(caracter, Cor.YELLOW);
                        case '&' -> // Anão
                                new Char(caracter, Cor.YELLOW);
                        case 'e' -> // Espada
                                new Char(caracter, Cor.MAGENTA);
                        case 'd' -> // Escudo
                                new Char(caracter, Cor.BLUE);
                        case 'c' -> // Cura
                                new Char(caracter, Cor.GREEN);
                        case '=' -> // Fim
                                new Char(caracter, Cor.GREEN);
                        default -> new Char(caracter, Cor.WHITE);
                    };
                    matriz[linha][coluna] = caracter_colorido;
                }
                linha++;
            }
        } catch (Exception e) {
            System.err.println("Mapa não encontrado: " + e.getMessage());
        }
    }
}