/*
 * Copyright 2025 hamtaro. All Rights Reserved.
 */

package com.hamtaro.sphero;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.util.Lexicon;

import com.tridium.ndriver.BNNetwork;
import com.tridium.ndriver.comm.*;
import com.tridium.ndriver.datatypes.*;
import com.tridium.ndriver.discover.*;
import com.tridium.ndriver.poll.*;

import com.hamtaro.sphero.comm.BSpheroSerialCommConfig;

/**
 * BSpheroNetwork models a network of devices
 *
 * @author hamtaro on 21 May 2025
 */
@NiagaraType
@NiagaraProperty(
  name = "pollScheduler",
  type = "BNPollScheduler",
  defaultValue = "new BNPollScheduler()"
)
@NiagaraProperty(
  name = "serialConfig",
  type = "BSpheroSerialCommConfig",
  defaultValue = "new BSpheroSerialCommConfig()"
)
public class BSpheroNetwork
  extends BNNetwork
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.hamtaro.sphero.BSpheroNetwork(4008565741)1.0$ @*/
/* Generated Wed May 21 10:49:52 ICT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "pollScheduler"

  /**
   * Slot for the {@code pollScheduler} property.
   * @see #getPollScheduler
   * @see #setPollScheduler
   */
  public static final Property pollScheduler = newProperty(0, new BNPollScheduler(), null);

  /**
   * Get the {@code pollScheduler} property.
   * @see #pollScheduler
   */
  public BNPollScheduler getPollScheduler() { return (BNPollScheduler)get(pollScheduler); }

  /**
   * Set the {@code pollScheduler} property.
   * @see #pollScheduler
   */
  public void setPollScheduler(BNPollScheduler v) { set(pollScheduler, v, null); }

  //endregion Property "pollScheduler"

  //region Property "serialConfig"

  /**
   * Slot for the {@code serialConfig} property.
   * @see #getSerialConfig
   * @see #setSerialConfig
   */
  public static final Property serialConfig = newProperty(0, new BSpheroSerialCommConfig(), null);

  /**
   * Get the {@code serialConfig} property.
   * @see #serialConfig
   */
  public BSpheroSerialCommConfig getSerialConfig() { return (BSpheroSerialCommConfig)get(serialConfig); }

  /**
   * Set the {@code serialConfig} property.
   * @see #serialConfig
   */
  public void setSerialConfig(BSpheroSerialCommConfig v) { set(serialConfig, v, null); }

  //endregion Property "serialConfig"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroNetwork.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  /**
   * Specify name for network resources.
   */
  public String getNetworkName()
  {
    return "SpheroNetwork";
  }

  /**
   * return device folder type
   */
  @Override
  public Type getDeviceFolderType()
  {
    return BSpheroDeviceFolder.TYPE;
  }

  /**
   * return device type
   */
  @Override
  public Type getDeviceType()
  {
    return BSpheroDevice.TYPE;
  }

  /* TODO - Add license check if needed
  @Override
  public final Feature getLicenseFeature()
  {
    return Sys.getLicenseManager().getFeature("?? vendor", "?? feature");
  }
  */

  @Override
  public void changed(Property p, Context cx)
  {
    super.changed(p, cx);
    if (!isRunning())
    {
      return;
    }

    if (p == status)
    {
      // Give any comms opportunity to respond to status changes
      getSerialConfig().statusUpdate();
    }
  }
////////////////////////////////////////////////////////////////
//Utilities
////////////////////////////////////////////////////////////////




  /**
   * Access the serial comm stack
   */
  public NComm scomm()
  {
    return (NComm) getSerialConfig().comm();
  }

  public static Lexicon LEX = Lexicon.make(BSpheroNetwork.class);
}
