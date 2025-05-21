package com.hamtaro.sphero.message;

import com.tridium.ndriver.io.TypedInputStream;

public class ResponseMsg
        extends SpheroMessage
{

    /**
     *
     */
    public ResponseMsg(int mrsp, int seq, int dlen, TypedInputStream ti)
    {
        super(seq);
        this.mrsp = mrsp;
        dataFromInput(dlen, ti);
    }

    public void dataFromInput(int dlen, TypedInputStream ti)
    {

    }

    public boolean isResponse() { return true; }

    int mrsp = 0;

}
