package org.limadeveloper;

public class CurupiraFactory extends MonstroFactory{

    @Override
    public Monstro createMonstro() {
        return new Curupira(6,10,30);
    }
}
