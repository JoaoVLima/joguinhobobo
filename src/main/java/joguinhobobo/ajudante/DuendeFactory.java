package joguinhobobo.ajudante;

public class DuendeFactory extends AjudanteFactory {
    @Override
    public Ajudante createAjudante() {
        return new Duende();
    }
}
