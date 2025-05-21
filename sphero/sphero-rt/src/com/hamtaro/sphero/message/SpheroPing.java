package com.hamtaro.sphero.message;

public class SpheroPing
        extends CommandMsg
{

    /**
     *
     */
    public SpheroPing()
    {
        super(DEVICE_ID_CORE, MSG_ID_PING);
    }

    protected int getDataLength() { return 0; }

}
