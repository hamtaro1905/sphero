/*
 * Copyright 2025 hamtaro. All Rights Reserved.
 */

package com.hamtaro.sphero.message;

import com.tridium.ndriver.comm.NMessage;
/**
 * SpheroMessage is super class for all sphero messages
 *
 * @author hamtaro on 21 May 2025
 */
public class SpheroMessage
        extends NMessage
        implements SpheroConst
{

    public SpheroMessage(int seq)
    {
        this.seq = seq;
    }

//  Override for outgoing messages
//  public boolean toOutputStream(OutputStream out)
//    throws Exception
//  {
//    // Use typed stream for more readable code.
//    TypedOutputStream to = (TypedOutputStream)out;
//    return false;
//  }

    protected boolean isAck() { return false; }

//   Override for incoming messages
//  public void fromInputStream(InputStream in)
//    throws Exception
//  {
//    // Use typed stream for more readable code.
//    TypedInputStream ti = TypedInputStream(in);
//  }

    //   Typical overrides
    public Object getTag() { return new Integer(seq); }
//  public boolean isResponse() { return false; }
//  public boolean isFragmentable() { return false; }
//  public int getResponseTimeOut() { return 2500; }

    public String toTraceString()
    {
        StringBuffer sb = new StringBuffer();
        toTraceString(sb);
        return sb.toString();
    }

    public void toTraceString(StringBuffer sb){}

    int seq = 0;


}
