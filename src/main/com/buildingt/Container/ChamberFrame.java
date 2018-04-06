package com.buildingt.Container;
import com.buildingt.Particle.BaseParticle;

import java.util.ArrayList;

// future enhancements would be extending a chamber to be N dimensional, have varying movement properties, etc.
public class ChamberFrame
{
    private ArrayList<BaseParticle> particles;

    public ArrayList<BaseParticle> getParticles()
    {
        return particles;
    }

    public ChamberFrame setParticles(ArrayList<BaseParticle> particles)
    {
        this.particles = particles;
        return this;
    }

    public boolean isEmpty()
    {
        for (BaseParticle particle : this.getParticles())
        {
            if (!particle.isEmpty())
            {
                return false;
            }
        }
        return true;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for (BaseParticle particle : particles)
        {
            builder.append(particle.getRepresentation());
        }
        return builder.toString();
    }
}
