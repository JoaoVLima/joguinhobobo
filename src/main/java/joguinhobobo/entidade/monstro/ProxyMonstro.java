package joguinhobobo.entidade.monstro;

import joguinhobobo.entidade.Heroi;
import joguinhobobo.log.Log;


public class ProxyMonstro implements Monstro {

    private final Monstro real;

    public ProxyMonstro(Monstro real) {
        this.real = real;
    }


    @Override
    public void batalha(Heroi heroi) throws InterruptedException {

        Log.append("Herói vai batalhar contra " + real.getDescricao());

        real.batalha(heroi);

        if (!heroi.estaVivo()) {
            Log.append("Herói foi derrotado pelo " + real.getDescricao());
        } else {
            Log.append("Herói derrotou o " + real.getDescricao());
        }
    }

    @Override
    public void aplicarHabilidade() {
        real.aplicarHabilidade();
    }

    @Override
    public String getDescricao() {
        return real.getDescricao();
    }

    @Override
    public int getVida() {
        return real.getVida();
    }

    @Override
    public void setVida(int vida) {
        real.setVida(vida);
    }

    @Override
    public int getAtaque() {
        return real.getAtaque();
    }

    @Override
    public int getDefesa() {
        return real.getDefesa();
    }
}