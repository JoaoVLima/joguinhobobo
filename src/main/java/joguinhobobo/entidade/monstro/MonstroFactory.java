package joguinhobobo.entidade.monstro;

import joguinhobobo.entidade.Heroi;
import joguinhobobo.log.ProxyLog;

import java.util.Locale;

public abstract class MonstroFactory {
    public void batalhaFactory(Heroi heroi) throws InterruptedException {
        Monstro monstro = createMonstro();
        ProxyLog.append(String.format("Batalha com %s", monstro.getDescricao()));
        monstro.batalha(heroi);
    }

    public abstract Monstro createMonstro();
}
