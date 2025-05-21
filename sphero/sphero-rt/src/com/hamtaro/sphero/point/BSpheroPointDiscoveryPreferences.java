/*
 * Copyright 2025 hamtaro. All Rights Reserved.
 */

package com.hamtaro.sphero.point;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.tridium.ndriver.discover.BNDiscoveryPreferences;

/**
 * BSpheroPointDiscoveryPreferences controls the type of discovery leafs using during
 * point discovery for sphero
 *
 * @author hamtaro on 21 May 2025
 */
@NiagaraType
public class BSpheroPointDiscoveryPreferences
  extends BNDiscoveryPreferences
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.hamtaro.sphero.point.BSpheroPointDiscoveryPreferences(2979906276)1.0$ @*/
/* Generated Wed May 21 10:49:52 ICT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroPointDiscoveryPreferences.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public BSpheroPointDiscoveryPreferences()
  {
  }

  public Type getDiscoveryLeafType()
  {
    return BSpheroPointDiscoveryLeaf.TYPE;
  }
}
