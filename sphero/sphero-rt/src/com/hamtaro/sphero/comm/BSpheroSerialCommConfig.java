/*
 * Copyright 2025 hamtaro. All Rights Reserved.
 */

package com.hamtaro.sphero.comm;

import com.tridium.ndriver.comm.IMessageFactory;
import com.tridium.ndriver.comm.LinkMessage;
import com.tridium.ndriver.comm.NLinkMessageFactory;
import com.tridium.ndriver.datatypes.BSerialCommConfig;
import com.hamtaro.sphero.message.SpheroMessageFactory;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * BSpheroSerialCommConfig Handles the serial communication for the driver.
 *
 * @author hamtaro on 21 May 2025
 */
@NiagaraType
public class BSpheroSerialCommConfig
  extends BSerialCommConfig
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.hamtaro.sphero.comm.BSpheroSerialCommConfig(2979906276)1.0$ @*/
/* Generated Wed May 21 10:49:52 ICT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroSerialCommConfig.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  /**
   * Empty constructor
   */
  public BSpheroSerialCommConfig()
  {
  }

//  /** Override to configure the maximum number of request messages that can
//   *  be outstanding at the same time.  Default implementation returns 32. */
//  public int getMaxOutstandingTransactions() { return 1; }

  /**
   * Provide custom LinkMessage factory.
   */
  protected NLinkMessageFactory makeLinkMessageFactory()
  {
    // link message factory must create
    return new NLinkMessageFactory(1024)
    {
      protected LinkMessage createLinkMessage()
      {
        return new SpheroLinkMessage(1024);
      }
    };
  }

  /**
   * Provide custom Message factory.
   */
  protected IMessageFactory makeMessageFactory()
  {
    return new SpheroMessageFactory();
  }
}
