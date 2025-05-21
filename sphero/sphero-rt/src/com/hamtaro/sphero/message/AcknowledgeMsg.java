package com.hamtaro.sphero.message;

public class AcknowledgeMsg
        extends SpheroMessage
{

    /**
     *
     */
    public AcknowledgeMsg(int seq)
    {
        super(seq);
    }

    protected boolean isAck() { return true; }

}
