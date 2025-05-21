/*
 * Copyright 2025 hamtaro. All Rights Reserved.
 */

package com.hamtaro.sphero.point;

import com.tridium.driver.util.DrUtil;
import com.hamtaro.sphero.BSpheroDevice;
import com.hamtaro.sphero.BSpheroNetwork;

import javax.baja.driver.point.BProxyExt;
import javax.baja.driver.point.BReadWriteMode;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatusBoolean;
import javax.baja.status.BStatusEnum;
import javax.baja.status.BStatusNumeric;
import javax.baja.status.BStatusString;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * BSpheroProxyExt
 *
 * @author hamtaro on 21 May 2025
 */
@NiagaraType
public class BSpheroProxyExt
        extends BProxyExt
{

  // Override ProxyExt default status to clear stale state.
  // public static final Property status = newProperty(Flags.READONLY|Flags.TRANSIENT, BStatus.ok, null);


  /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
  /*@ $com.tridium.sphero.point.BSpheroProxyExt(2979906276)1.0$ @*/
  /* Generated Thu Apr 28 17:23:32 EDT 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
  ////////////////////////////////////////////////////////////////

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroProxyExt.class);

  /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/



////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BSpheroNetwork.
   */
  public final BSpheroNetwork getSpheroNetwork()
  {
    return (BSpheroNetwork)getNetwork();
  }

  /**
   * Get the device cast to a BSpheroDevice.
   */
  public final BSpheroDevice getBSpheroDevice()
  {
    return (BSpheroDevice)DrUtil.getParent(this, BSpheroDevice.TYPE);
  }

  /**
   * Get the point device ext cast to a BSpheroPointDeviceExt.
   */
  public final BSpheroPointDeviceExt getSpheroPointDeviceExt()
  {
    return (BSpheroPointDeviceExt)getDeviceExt();
  }

  ////////////////////////////////////////////////////////////////
// ProxyExt
  ////////////////////////////////////////////////////////////////
  public void readSubscribed(Context cx)
          throws Exception
  {
    // TODO
  }

  public void readUnsubscribed(Context cx)
          throws Exception
  {
    // TODO
  }

  public boolean write(Context cx)
          throws Exception
  {
    // TODO
    return false;
  }

  /**
   * Return the device type.
   */
  public Type getDeviceExtType()
  {
    return BSpheroPointDeviceExt.TYPE;
  }

  /**
   * Return the read/write mode of this proxy.
   */
  public BReadWriteMode getMode()
  {
    // TODO
    return BReadWriteMode.readonly;
  }

  public boolean isBoolean()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusBoolean;
  }

  public boolean isNumeric()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusNumeric;
  }

  public boolean isString()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusString;
  }

  public boolean isEnum()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusEnum;
  }

}
