/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.2.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package enet;

public final class ENetSocketWait {
  public final static ENetSocketWait ENET_SOCKET_WAIT_NONE = new ENetSocketWait("ENET_SOCKET_WAIT_NONE", enetJNI.ENET_SOCKET_WAIT_NONE_get());
  public final static ENetSocketWait ENET_SOCKET_WAIT_SEND = new ENetSocketWait("ENET_SOCKET_WAIT_SEND", enetJNI.ENET_SOCKET_WAIT_SEND_get());
  public final static ENetSocketWait ENET_SOCKET_WAIT_RECEIVE = new ENetSocketWait("ENET_SOCKET_WAIT_RECEIVE", enetJNI.ENET_SOCKET_WAIT_RECEIVE_get());
  public final static ENetSocketWait ENET_SOCKET_WAIT_INTERRUPT = new ENetSocketWait("ENET_SOCKET_WAIT_INTERRUPT", enetJNI.ENET_SOCKET_WAIT_INTERRUPT_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static ENetSocketWait swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + ENetSocketWait.class + " with value " + swigValue);
  }

  private ENetSocketWait(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private ENetSocketWait(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private ENetSocketWait(String swigName, ENetSocketWait swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static ENetSocketWait[] swigValues = { ENET_SOCKET_WAIT_NONE, ENET_SOCKET_WAIT_SEND, ENET_SOCKET_WAIT_RECEIVE, ENET_SOCKET_WAIT_INTERRUPT };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

