package com.buildingt;
import com.buildingt.Container.ChamberFrame;
import com.buildingt.Particle.EmptyParticle;
import com.buildingt.Particle.LeftParticle;
import com.buildingt.Particle.BaseParticle;
import com.buildingt.Particle.RightParticle;
import com.buildingt.Particle.XParticle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChamberAnimation
{
    public static void main(String[] args)
    {
        String inputFrame = "X   < >  "; // simple default input
        if (args.length > 0 && args[0] != null)
        {
            inputFrame = args[0];
        }

        List<String> outputFrames = produceAnimation(inputFrame);
        for (String frame : outputFrames)
        {
            System.out.println(frame);
        }
    }

    /**
     * given an input string, produce a sequence of animation frames modelling the
     * movement of the represented particles.
     * @param inputFrame
     * @return
     */
    public static List<String> produceAnimation(String inputFrame)
    {
        ArrayList<BaseParticle> inputFrameAsParticles = convertInputFrameToParticles(inputFrame);
        ChamberFrame startingChamber = new ChamberFrame().setParticles(inputFrameAsParticles);
        List<String> outputFrames = modelChamber(startingChamber);
        return outputFrames;
    }

    private static ArrayList<BaseParticle> convertInputFrameToParticles(String frame)
    {
        ArrayList<BaseParticle> convertedFrame = new ArrayList<BaseParticle>(frame.length());
        for (char element : frame.toCharArray())
        {
            switch(element)
            {
                case '<':
                    convertedFrame.add(new LeftParticle());
                    break;
                case '>':
                    convertedFrame.add(new RightParticle());
                    break;
                case 'X':
                    convertedFrame.add(new XParticle());
                    break;
                default:
                    convertedFrame.add(new EmptyParticle());
            }
        }
        return convertedFrame;
    }

    public static List<String> modelChamber(ChamberFrame inputFrame) throws IllegalArgumentException
    {
        if (inputFrame == null)
        {
            throw new IllegalArgumentException("Needs a non-null chamber");
        }
        List<ChamberFrame> outputFrames = new ArrayList<ChamberFrame>();
        outputFrames.add(inputFrame);
        ChamberFrame nextOutputFrame = inputFrame;
        while (!nextOutputFrame.isEmpty())
        {
            nextOutputFrame = animateFrame(nextOutputFrame);
            outputFrames.add(nextOutputFrame);
        }
        List<String> outputStrings = showOutputFrames(outputFrames);
        return outputStrings;
    }

    private static ChamberFrame animateFrame(ChamberFrame frame)
    {
        BaseParticle[] inputFrameElements = frame.getParticles().toArray(new BaseParticle[frame.getParticles().size()]);
        BaseParticle[] outputParticles = initializeEmptyParticleSet(inputFrameElements.length);

        for (int i = 0; i < inputFrameElements.length; i++)
        {
            switch (inputFrameElements[i].getRepresentation())
            {
                case '<':
                    if (i > 0)
                    {
                        outputParticles[i-1] = new LeftParticle();
                    }
                    break;
                case '>':
                    if (i < outputParticles.length - 1)
                    {
                        outputParticles[i+1] = new RightParticle();
                    }
                    break;
                case 'X':
                    // GROT - there's a bug in handling the overlap of multiple X particles.
                    // this isn't yet taking advantage of the decay properties of the particle.
                    if (i > 0) // this is the same logic as in the previous cases, find a way to combine this.
                    {
                        outputParticles[i-1] = new LeftParticle();
                    }
                    if (i < outputParticles.length - 2)
                    {
                        outputParticles[i+1] = new RightParticle();
                    }
                    break;
            }
        }
        frame = new ChamberFrame().setParticles(new ArrayList(Arrays.asList(outputParticles)));
        return frame;
    }

    private static BaseParticle[] initializeEmptyParticleSet(int length)
    {
        BaseParticle[] outputParticles = new BaseParticle[length];
        Arrays.fill(outputParticles, new EmptyParticle()); // fill it with spaces;
        return outputParticles;
    }

    private static List<String> showOutputFrames(List<ChamberFrame> outputFrames)
    {
        List<String> outputStrings = new ArrayList<String>();
        for (ChamberFrame frame : outputFrames)
        {
            outputStrings.add("\"" + frame.toString() + "\"");
        }
        return outputStrings;
    }
}
