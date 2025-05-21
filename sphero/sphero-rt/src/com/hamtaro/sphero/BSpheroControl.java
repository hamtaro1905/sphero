package com.hamtaro.sphero;

import com.tridium.ndriver.BNNetwork;
import com.tridium.ndriver.comm.NComm;
import com.hamtaro.sphero.datatypes.BRollParameters;
import com.hamtaro.sphero.message.Roll;

import javax.baja.sys.*;
import javax.baja.units.UnitDatabase;

public class BSpheroControl
    extends BComponent {
  /*-
  class BSpheroControl
  {
    properties
    {
      enable : boolean
        default {[ false ]}
        flags { transient }

      speed : int
        default {[ 0 ]}
        slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("meters per minute"), 1, 0, 255) ]}

      heading : int
        default {[ 0 ]}
        slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("degrees angular"), 1, 0, 359)]}

      offset : int
        default {[ 0 ]}
        slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("degrees angular"), 1, 0, 359)]}
    }
    actions
    {
      startSphero()
      stopSphero()
      roll( param :  BRollParameters )
         default {[ new BRollParameters() ]}
    }
    topics
    {

    }
  }
  -*/
    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ $com.tridium.sphero.BSpheroControl(2985735872)1.0$ @*/
    /* Generated Fri Apr 04 16:25:40 EDT 2014 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "enable"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the <code>enable</code> property.
     * @see BSpheroControl#getEnable
     * @see BSpheroControl#setEnable
     */
    public static final Property enable = newProperty(Flags.TRANSIENT, false,null);

    /**
     * Get the <code>enable</code> property.
     * @see BSpheroControl#enable
     */
    public boolean getEnable() { return getBoolean(enable); }

    /**
     * Set the <code>enable</code> property.
     * @see BSpheroControl#enable
     */
    public void setEnable(boolean v) { setBoolean(enable,v,null); }

////////////////////////////////////////////////////////////////
// Property "speed"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the <code>speed</code> property.
     * @see BSpheroControl#getSpeed
     * @see BSpheroControl#setSpeed
     */
    public static final Property speed = newProperty(0, 0, BFacets.makeNumeric(UnitDatabase.getUnit("meters per minute"), 1, 0, 255));

    /**
     * Get the <code>speed</code> property.
     * @see BSpheroControl#speed
     */
    public int getSpeed() { return getInt(speed); }

    /**
     * Set the <code>speed</code> property.
     * @see BSpheroControl#speed
     */
    public void setSpeed(int v) { setInt(speed,v,null); }

////////////////////////////////////////////////////////////////
// Property "heading"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the <code>heading</code> property.
     * @see BSpheroControl#getHeading
     * @see BSpheroControl#setHeading
     */
    public static final Property heading = newProperty(0, 0,BFacets.makeNumeric(UnitDatabase.getUnit("degrees angular"), 1, 0, 359));

    /**
     * Get the <code>heading</code> property.
     * @see BSpheroControl#heading
     */
    public int getHeading() { return getInt(heading); }

    /**
     * Set the <code>heading</code> property.
     * @see BSpheroControl#heading
     */
    public void setHeading(int v) { setInt(heading,v,null); }

////////////////////////////////////////////////////////////////
// Property "offset"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the <code>offset</code> property.
     * @see BSpheroControl#getOffset
     * @see BSpheroControl#setOffset
     */
    public static final Property offset = newProperty(0, 0,BFacets.makeNumeric(UnitDatabase.getUnit("degrees angular"), 1, 0, 359));

    /**
     * Get the <code>offset</code> property.
     * @see BSpheroControl#offset
     */
    public int getOffset() { return getInt(offset); }

    /**
     * Set the <code>offset</code> property.
     * @see BSpheroControl#offset
     */
    public void setOffset(int v) { setInt(offset,v,null); }

////////////////////////////////////////////////////////////////
// Action "startSphero"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the <code>startSphero</code> action.
     * @see BSpheroControl#startSphero()
     */
    public static final Action startSphero = newAction(0,null);

    /**
     * Invoke the <code>startSphero</code> action.
     * @see BSpheroControl#startSphero
     */
    public void startSphero() { invoke(startSphero,null,null); }

////////////////////////////////////////////////////////////////
// Action "stopSphero"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the <code>stopSphero</code> action.
     * @see BSpheroControl#stopSphero()
     */
    public static final Action stopSphero = newAction(0,null);

    /**
     * Invoke the <code>stopSphero</code> action.
     * @see BSpheroControl#stopSphero
     */
    public void stopSphero() { invoke(stopSphero,null,null); }

////////////////////////////////////////////////////////////////
// Action "roll"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the <code>roll</code> action.
     * @see BSpheroControl#roll
     */
    public static final Action roll = newAction(0,new com.hamtaro.sphero.datatypes.BRollParameters(),null);

    /**
     * Invoke the <code>roll</code> action.
     * @see BSpheroControl#roll
     */
    public void roll(com.hamtaro.sphero.datatypes.BRollParameters param) { invoke(roll,param,null); }

////////////////////////////////////////////////////////////////
// Type
    ////////////////////////////////////////////////////////////////

    public Type getType() { return TYPE; }
    public static final Type TYPE = Sys.loadType(BSpheroControl.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public boolean isParentLegal(BComponent parent)
    {
        return parent instanceof BSpheroNetwork;
    }

    public void started()
            throws Exception
    {
        super.started();
        updtThread = new Thread(updater, "Sphero.updater");
        updtThread.start();
    }

    public void stopped()
            throws Exception
    {
        super.stopped();
        updater.done = true;
        updtThread.interrupt();
    }

    public void changed(Property property, Context context)
    {
        super.changed(property, context);
        if(!isRunning()) return;

        if(BNNetwork.noWrite.equals(context)) { System.out.println("BNNetwork.noWrite"); return;  }
        updater.update();
    }

    public void doStopSphero()
    {
        setEnable(false);
        doStop();
    }

    public void doStartSphero()
    {
        setEnable(true);
        updater.update();
    }

    public void doRoll(com.hamtaro.sphero.datatypes.BRollParameters rp)
    {
        try
        {
            setInt(speed, rp.getSpeed(), BNNetwork.noWrite);
            setInt(heading, rp.getHeading(), BNNetwork.noWrite);
            updater.update();
        }
        catch(Exception e)
        {
            System.out.println("roll failed ");
        }

    }

    private void doStop()
    {
        try
        {
            Roll msg = new Roll(0, getHeading(), 1);
            scomm().sendRequest(msg);
        }
        catch(Exception e)
        {
            System.out.println("roll failed ");
        }
    }

    private class Updater
            implements Runnable
    {
        public void run()
        {
            while(!done)
            {
                synchronized(sync)
                {
                    if(!updt) try {  sync.wait(); } catch(Exception e) {}
                }
                if(done) return;
                updt = false;
                try
                {
                    Roll msg = new Roll(getSpeed(),getHeading(), 1);
                    scomm().sendRequest(msg);
                }
                catch(Exception e)
                {
                    System.out.println("roll failed ");
                }
            }
        }

        void update()
        {
            if(!getEnable()) return;
            synchronized(sync)
            {
                updt = true;
                sync.notify();
            }
        }

        boolean done = false;
        boolean updt = false;
        Object  sync = new Object();

    }

    private NComm scomm() { return ((BSpheroNetwork)getParent()).scomm(); }

    Thread updtThread;
    Updater updater = new Updater();

}
