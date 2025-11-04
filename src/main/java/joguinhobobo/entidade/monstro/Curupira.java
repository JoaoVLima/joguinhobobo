package joguinhobobo.entidade.monstro;

import joguinhobobo.entidade.Entidade;

public class Curupira extends Entidade implements Monstro {
    public Curupira(int ataque, int defesa, int vida) {
        super(ataque, defesa, vida);
    }

    @Override
    public void aplicarHabilidade() {
        System.out.println("Curupira confunde o herói e o faz perder o caminho!");
        System.out.println("Curupira ganha mais 10% de defesa.");
        setDefesa((int) (getDefesa()*1.10));
    }

    @Override
    public String getDescricao() {
        return "Curupira";
    }
}