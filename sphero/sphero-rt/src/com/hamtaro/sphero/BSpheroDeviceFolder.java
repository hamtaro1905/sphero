/*
 * Copyright 2025 hamtaro. All Rights Reserved.
 */

package com.hamtaro.sphero;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.tridium.ndriver.BNDeviceFolder;

/**
 * BSpheroDeviceFolder is a folder for BSpheroDevice.
 *
 * @author hamtaro on 21 May 2025
 */
@NiagaraType
public class BSpheroDeviceFolder
  extends BNDeviceFolder
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.hamtaro.sphero.BSpheroDeviceFolder(2979906276)1.0$ @*/
/* Generated Wed May 21 10:49:52 ICT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroDeviceFolder.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
////////////////////////////////////////////////////////////////
// Access
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

  /**
   * @return true if parent is BSpheroNetwork or BSpheroDeviceFolder.
   */
  public boolean isParentLegal(BComponent parent)
  {
    return parent instanceof BSpheroNetwork ||
           parent instanceof BSpheroDeviceFolder;
  }
}
