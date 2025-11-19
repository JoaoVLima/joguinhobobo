package joguinhobobo.entidade.ajudante;

public class AnaoFactory extends AjudanteFactory {

    @Override
    public Ajudante createAjudante() {
        return new ProxyAjudante(new Anao());
    }
}
