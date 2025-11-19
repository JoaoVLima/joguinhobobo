package joguinhobobo.entidade.ajudante;

import joguinhobobo.entidade.Heroi;
import joguinhobobo.entidade.monstro.Monstro;
import joguinhobobo.log.Log;


public class ProxyAjudanteService extends AjudanteService {
    
    private final AjudanteService real;

    public ProxyAjudanteService(AjudanteService real) {
        super(null);
        this.real = real;
    }

    @Override
    public String getNomeService() {
        String nome = real.getNomeService();
        Log.append("Herói se aproximou de um " + nome);
        return nome;
    }

    @Override
    public String getDescricaoService() {
        return real.getDescricaoService();
    }

    @Override
    public void aplicarEfeitoService(Heroi heroi, Monstro monstro) throws InterruptedException {
        real.aplicarEfeitoService(heroi, monstro);
    }
}