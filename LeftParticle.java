package com.buildingt.Particle;
public class LeftParticle extends BaseParticle
{
    public LeftParticle()
    {
        this.setRepresentation('<');
        this.setMoveDirection(Direction.LEFT);
        this.setMoveRate(1);
    }

}
