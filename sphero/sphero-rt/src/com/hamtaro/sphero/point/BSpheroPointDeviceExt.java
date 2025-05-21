/*
 * Copyright 2025 hamtaro. All Rights Reserved.
 */

package com.hamtaro.sphero.point;

import com.tridium.ndriver.util.AgentInfoUtil;
import com.hamtaro.sphero.BSpheroDevice;
import com.hamtaro.sphero.BSpheroNetwork;

import javax.baja.agent.AgentList;
import javax.baja.driver.point.BPointDeviceExt;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * BSpheroPointDeviceExt is a container for sphero proxy points.
 *
 * @author hamtaro on 21 May 2025
 */
@NiagaraType
public class BSpheroPointDeviceExt

        extends BPointDeviceExt {



  /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
  /*@ $com.tridium.sphero.point.BSpheroPointDeviceExt(2979906276)1.0$ @*/
  /* Generated Thu Apr 28 17:23:32 EDT 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type

  /// /////////////////////////////////////////////////////////////

  @Override
  public Type getType() {
    return TYPE;
  }

  public static final Type TYPE = Sys.loadType(BSpheroPointDeviceExt.class);

  /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  /**
   * Adds BNPointManager and renames.
   *
   * @see NAgentInfo.getAgentsHelp
   */
  public AgentList getAgents(Context cx) {
    AgentList agents = super.getAgents(cx);
    agents.add("ndriver:NPointManager");

    return AgentInfoUtil.getAgentsHelp(
            agents,
            getType().getTypeInfo().getModuleName(),
            "driver:PointManager",
            "PointManager",
            "Point Manager");
  }


////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BSpheroNetwork.
   *
   * @return network as a BSpheroNetwork.
   */
  public final BSpheroNetwork getSpheroNetwork() {
    return (BSpheroNetwork) getNetwork();
  }

  /**
   * Get the device cast to a BSpheroDevice.
   *
   * @return device as a BSpheroDevice.
   */
  public final BSpheroDevice getSpheroDevice() {
    return (BSpheroDevice) getDevice();
  }

////////////////////////////////////////////////////////////////
// PointDeviceExt
////////////////////////////////////////////////////////////////

  /**
   * @return the Device type.
   */
  public Type getDeviceType() {
    return BSpheroDevice.TYPE;
  }

  /**
   * @return the PointFolder type.
   */
  public Type getPointFolderType() {
    return BSpheroPointFolder.TYPE;
  }

  /**
   * @return the ProxyExt type.
   */
  public Type getProxyExtType() {
    return BSpheroProxyExt.TYPE;
  }
}


