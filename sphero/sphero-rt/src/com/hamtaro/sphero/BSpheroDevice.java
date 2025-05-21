/*
 * Copyright 2025 hamtaro. All Rights Reserved.
 */

package com.hamtaro.sphero;

import javax.baja.driver.util.BPollFrequency;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatus;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.tridium.ndriver.BNDevice;
import com.tridium.ndriver.poll.BINPollable;
import com.tridium.ndriver.util.SfUtil;

import com.hamtaro.sphero.point.*;

/**
 * BSpheroDevice models a single device
 *
 * @author hamtaro on 21 May 2025
 */
@NiagaraType
@NiagaraProperty(
  name = "pollFrequency",
  type = "BPollFrequency",
  defaultValue = "BPollFrequency.normal"
)
// Add facet to include following in auto manager view
@NiagaraProperty(
  name = "status",
  type = "BStatus",
  defaultValue = "BStatus.ok",
  flags = Flags.TRANSIENT | Flags.READONLY | Flags.SUMMARY | Flags.DEFAULT_ON_CLONE,
  facets = @Facet("SfUtil.incl(SfUtil.MGR_EDIT_READONLY)"),
  override = true
)
@NiagaraProperty(
  name = "points",
  type = "BSpheroPointDeviceExt",
  defaultValue = "new BSpheroPointDeviceExt()"
)
public class BSpheroDevice
  extends BNDevice
  implements BINPollable
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.hamtaro.sphero.BSpheroDevice(373267011)1.0$ @*/
/* Generated Wed May 21 10:49:52 ICT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "pollFrequency"

  /**
   * Slot for the {@code pollFrequency} property.
   * @see #getPollFrequency
   * @see #setPollFrequency
   */
  public static final Property pollFrequency = newProperty(0, BPollFrequency.normal, null);

  /**
   * Get the {@code pollFrequency} property.
   * @see #pollFrequency
   */
  public BPollFrequency getPollFrequency() { return (BPollFrequency)get(pollFrequency); }

  /**
   * Set the {@code pollFrequency} property.
   * @see #pollFrequency
   */
  public void setPollFrequency(BPollFrequency v) { set(pollFrequency, v, null); }

  //endregion Property "pollFrequency"

  //region Property "status"

  /**
   * Slot for the {@code status} property.
   *  Add facet to include following in auto manager view
   * @see #getStatus
   * @see #setStatus
   */
  public static final Property status = newProperty(Flags.TRANSIENT | Flags.READONLY | Flags.SUMMARY | Flags.DEFAULT_ON_CLONE, BStatus.ok, SfUtil.incl(SfUtil.MGR_EDIT_READONLY));

  //endregion Property "status"

  //region Property "points"

  /**
   * Slot for the {@code points} property.
   * @see #getPoints
   * @see #setPoints
   */
  public static final Property points = newProperty(0, new BSpheroPointDeviceExt(), null);

  /**
   * Get the {@code points} property.
   * @see #points
   */
  public BSpheroPointDeviceExt getPoints() { return (BSpheroPointDeviceExt)get(points); }

  /**
   * Set the {@code points} property.
   * @see #points
   */
  public void setPoints(BSpheroPointDeviceExt v) { set(points, v, null); }

  //endregion Property "points"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroDevice.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
////////////////////////////////////////////////////////////////
// Overrides
////////////////////////////////////////////////////////////////

  /**
   * Returns the network type that the device runs on.
   *
   * @return Type object representing the network
   */
  @Override
  public Type getNetworkType()
  {
    return BSpheroNetwork.TYPE;
  }

  /**
   * Override started
   */
  @Override
  public void started()
    throws Exception
  {
    super.started();

    // register device with poll scheduler
    getSpheroNetwork().getPollScheduler().subscribe(this);
  }

  /**
   * Override stopped
   */
  @Override
  public void stopped()
    throws Exception
  {
    // unregister device with poll scheduler
    getSpheroNetwork().getPollScheduler().unsubscribe(this);
    super.stopped();
  }


////////////////////////////////////////////////////////////////
// Implementation
////////////////////////////////////////////////////////////////

  /**
   *
   */
  public void doPing()
  {
    // TODO - add ping implementation
    // if()
    pingOk();
    // else
    //  pingFail("not receiving response from device ");
  }


////////////////////////////////////////////////////////////////
// Polling support
////////////////////////////////////////////////////////////////

  /**
   * The poll() callback method called from BPollScheduler
   * when it is time to poll this object.
   */
  public void doPoll()
  {
    // TODO add poll support
  }

////////////////////////////////////////////////////////////////
// Utilities
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BSpheroNetwork.
   *
   * @return network as a BSpheroNetwork.
   */
  public final BSpheroNetwork getSpheroNetwork()
  {
    return (BSpheroNetwork) getNetwork();
  }
}
