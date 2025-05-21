package com.hamtaro.sphero.message;

import com.tridium.ndriver.io.TypedOutputStream;

public class Roll
        extends CommandMsg
{

    /**   */
    public Roll(int speed, int heading, int state)
    {
        super(DEVICE_ID_SPHERO, MSG_ID_ROLL);
        this.speed = speed;
        this.heading = heading;
        this.state = state;
    }

    protected void dataOut(TypedOutputStream to)
    {
        to.writeUnsigned8(speed);
        to.writeUnsigned16(heading);
        to.writeUnsigned8(state);
    }


    /* */
    protected int getDataLength()
    {
        return 4;
    }

    int speed   ;
    int heading ;
    int state   = 1 ;

}