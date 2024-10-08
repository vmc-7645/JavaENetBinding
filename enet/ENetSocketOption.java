/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.2.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package enet;

public final class ENetSocketOption {
  public final static ENetSocketOption ENET_SOCKOPT_NONBLOCK = new ENetSocketOption("ENET_SOCKOPT_NONBLOCK", enetJNI.ENET_SOCKOPT_NONBLOCK_get());
  public final static ENetSocketOption ENET_SOCKOPT_BROADCAST = new ENetSocketOption("ENET_SOCKOPT_BROADCAST", enetJNI.ENET_SOCKOPT_BROADCAST_get());
  public final static ENetSocketOption ENET_SOCKOPT_RCVBUF = new ENetSocketOption("ENET_SOCKOPT_RCVBUF", enetJNI.ENET_SOCKOPT_RCVBUF_get());
  public final static ENetSocketOption ENET_SOCKOPT_SNDBUF = new ENetSocketOption("ENET_SOCKOPT_SNDBUF", enetJNI.ENET_SOCKOPT_SNDBUF_get());
  public final static ENetSocketOption ENET_SOCKOPT_REUSEADDR = new ENetSocketOption("ENET_SOCKOPT_REUSEADDR", enetJNI.ENET_SOCKOPT_REUSEADDR_get());
  public final static ENetSocketOption ENET_SOCKOPT_RCVTIMEO = new ENetSocketOption("ENET_SOCKOPT_RCVTIMEO", enetJNI.ENET_SOCKOPT_RCVTIMEO_get());
  public final static ENetSocketOption ENET_SOCKOPT_SNDTIMEO = new ENetSocketOption("ENET_SOCKOPT_SNDTIMEO", enetJNI.ENET_SOCKOPT_SNDTIMEO_get());
  public final static ENetSocketOption ENET_SOCKOPT_ERROR = new ENetSocketOption("ENET_SOCKOPT_ERROR", enetJNI.ENET_SOCKOPT_ERROR_get());
  public final static ENetSocketOption ENET_SOCKOPT_NODELAY = new ENetSocketOption("ENET_SOCKOPT_NODELAY", enetJNI.ENET_SOCKOPT_NODELAY_get());
  public final static ENetSocketOption ENET_SOCKOPT_TTL = new ENetSocketOption("ENET_SOCKOPT_TTL", enetJNI.ENET_SOCKOPT_TTL_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static ENetSocketOption swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + ENetSocketOption.class + " with value " + swigValue);
  }

  private ENetSocketOption(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private ENetSocketOption(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private ENetSocketOption(String swigName, ENetSocketOption swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static ENetSocketOption[] swigValues = { ENET_SOCKOPT_NONBLOCK, ENET_SOCKOPT_BROADCAST, ENET_SOCKOPT_RCVBUF, ENET_SOCKOPT_SNDBUF, ENET_SOCKOPT_REUSEADDR, ENET_SOCKOPT_RCVTIMEO, ENET_SOCKOPT_SNDTIMEO, ENET_SOCKOPT_ERROR, ENET_SOCKOPT_NODELAY, ENET_SOCKOPT_TTL };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

