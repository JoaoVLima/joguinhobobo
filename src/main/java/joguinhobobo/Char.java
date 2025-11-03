package joguinhobobo;

public class Char{
    private final char caracter;
    private final Cor cor;

    public Char(char caracter, Cor cor){
        this.caracter = caracter;
        this.cor = cor;
    }

    public char getChar() {
        return caracter;
    }

    @Override
    public String toString() {
        return cor.getAnsiCode() + caracter + Cor.RESET.getAnsiCode();
    }
}
