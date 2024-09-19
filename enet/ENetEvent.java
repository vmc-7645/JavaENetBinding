/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.2.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package enet;

public class ENetEvent {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ENetEvent(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ENetEvent obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(ENetEvent obj) {
    long ptr = 0;
    if (obj != null) {
      if (!obj.swigCMemOwn)
        throw new RuntimeException("Cannot release ownership as memory is not owned");
      ptr = obj.swigCPtr;
      obj.swigCMemOwn = false;
      obj.delete();
    }
    return ptr;
  }

  @SuppressWarnings({"deprecation", "removal"})
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        enetJNI.delete_ENetEvent(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setType(ENetEventType value) {
    enetJNI.ENetEvent_type_set(swigCPtr, this, value.swigValue());
  }

  public ENetEventType getType() {
    return ENetEventType.swigToEnum(enetJNI.ENetEvent_type_get(swigCPtr, this));
  }

  public void setPeer(ENetPeer value) {
    enetJNI.ENetEvent_peer_set(swigCPtr, this, ENetPeer.getCPtr(value), value);
  }

  public ENetPeer getPeer() {
    long cPtr = enetJNI.ENetEvent_peer_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ENetPeer(cPtr, false);
  }

  public void setChannelID(long value) {
    enetJNI.ENetEvent_channelID_set(swigCPtr, this, value);
  }

  public long getChannelID() {
    return enetJNI.ENetEvent_channelID_get(swigCPtr, this);
  }

  public void setData(long value) {
    enetJNI.ENetEvent_data_set(swigCPtr, this, value);
  }

  public long getData() {
    return enetJNI.ENetEvent_data_get(swigCPtr, this);
  }

  public void setPacket(ENetPacket value) {
    enetJNI.ENetEvent_packet_set(swigCPtr, this, ENetPacket.getCPtr(value), value);
  }

  public ENetPacket getPacket() {
    long cPtr = enetJNI.ENetEvent_packet_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ENetPacket(cPtr, false);
  }

  public ENetEvent() {
    this(enetJNI.new_ENetEvent(), true);
  }

}
