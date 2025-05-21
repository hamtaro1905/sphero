package com.hamtaro.sphero.message;

import com.tridium.ndriver.io.TypedInputStream;

public class AsynchronousMsg
        extends SpheroMessage
{

    /**
     *
     */
    public AsynchronousMsg(int dlen, TypedInputStream ti)
    {
        super(0);
        dataFromInput(dlen, ti);
    }

    public void dataFromInput(int dlen, TypedInputStream ti)
    {

    }

}
