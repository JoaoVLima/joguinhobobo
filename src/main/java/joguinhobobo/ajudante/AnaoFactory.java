package joguinhobobo.ajudante;

public class AnaoFactory extends AjudanteFactory {

    @Override
    public Ajudante createAjudante() {
        return new Anao();
    }
}
