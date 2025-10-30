package org.limadeveloper.monstro;

public class CurupiraFactory extends MonstroFactory{

    @Override
    public Monstro createMonstro() {
        return new Curupira(6,10,30);
    }
}
