package com.buildingt.Particle;
import java.util.List;

public class BaseParticle
{
    public enum Direction
    { LEFT , RIGHT, LEFT_AND_RIGHT }

    private char representation;
    private int moveRate;
    private Direction moveDirection;
    private int decayInterval;
    private List<BaseParticle> decaysInto; // this should really be a function that gets set describing the decay behavior of this Particle.

    public char getRepresentation()
    {
        return representation;
    }

    public BaseParticle setRepresentation(char representation)
    {
        this.representation = representation;
        return this;
    }

    public int getMoveRate()
    {
        return moveRate;
    }

    public BaseParticle setMoveRate(int moveRate)
    {
        this.moveRate = moveRate;
        return this;
    }

    public Direction getMoveDirection()
    {
        return moveDirection;
    }

    public BaseParticle setMoveDirection(Direction moveDirection)
    {
        this.moveDirection = moveDirection;
        return this;
    }

    public int getDecayInterval()
    {
        return decayInterval;
    }

    public BaseParticle setDecayInterval(int decayInterval)
    {
        this.decayInterval = decayInterval;
        return this;
    }

    public List<BaseParticle> getDecaysInto()
    {
        return decaysInto;
    }

    public BaseParticle setDecaysInto(List<BaseParticle> decaysInto)
    {
        this.decaysInto = decaysInto;
        return this;
    }

    public boolean isEmpty()
    {
        return this.representation == ' ';
    }

}
