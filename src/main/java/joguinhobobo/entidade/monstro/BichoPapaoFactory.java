package joguinhobobo.entidade.monstro;

public class BichoPapaoFactory extends MonstroFactory{

    @Override
    public Monstro createMonstro() {
        return new BichoPapao(7,6,40);
    }
}
