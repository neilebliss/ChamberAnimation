package com.buildingt.Particle;
public class RightParticle extends BaseParticle
{

    public RightParticle()
    {
        this.setMoveDirection(Direction.RIGHT);
        this.setMoveRate(1);
        this.setRepresentation('>');
    }
}
