package com.buildingt.Particle;
import java.util.ArrayList;
import java.util.List;

public class XParticle extends BaseParticle
{
    public XParticle()
    {
        this.setRepresentation('X');
        this.setMoveDirection(Direction.LEFT_AND_RIGHT);
        this.setMoveRate(1);
        this.setDecayInterval(1);
        List<BaseParticle> decayList = new ArrayList<BaseParticle>();
        decayList.add(new LeftParticle());
        decayList.add(new EmptyParticle());
        decayList.add(new RightParticle());
        this.setDecaysInto(decayList);
    }
}
