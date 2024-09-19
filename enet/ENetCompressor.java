/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.2.1
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package enet;

public class ENetCompressor {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ENetCompressor(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ENetCompressor obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(ENetCompressor obj) {
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
        enetJNI.delete_ENetCompressor(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setContext(SWIGTYPE_p_void value) {
    enetJNI.ENetCompressor_context_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getContext() {
    long cPtr = enetJNI.ENetCompressor_context_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void setCompress(SWIGTYPE_p_f_p_void_p_q_const__ENetBuffer_size_t_size_t_p_enet_uint8_size_t__size_t value) {
    enetJNI.ENetCompressor_compress_set(swigCPtr, this, SWIGTYPE_p_f_p_void_p_q_const__ENetBuffer_size_t_size_t_p_enet_uint8_size_t__size_t.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_void_p_q_const__ENetBuffer_size_t_size_t_p_enet_uint8_size_t__size_t getCompress() {
    long cPtr = enetJNI.ENetCompressor_compress_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_void_p_q_const__ENetBuffer_size_t_size_t_p_enet_uint8_size_t__size_t(cPtr, false);
  }

  public void setDecompress(SWIGTYPE_p_f_p_void_p_q_const__enet_uint8_size_t_p_enet_uint8_size_t__size_t value) {
    enetJNI.ENetCompressor_decompress_set(swigCPtr, this, SWIGTYPE_p_f_p_void_p_q_const__enet_uint8_size_t_p_enet_uint8_size_t__size_t.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_void_p_q_const__enet_uint8_size_t_p_enet_uint8_size_t__size_t getDecompress() {
    long cPtr = enetJNI.ENetCompressor_decompress_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_void_p_q_const__enet_uint8_size_t_p_enet_uint8_size_t__size_t(cPtr, false);
  }

  public void setDestroy(SWIGTYPE_p_f_p_void__void value) {
    enetJNI.ENetCompressor_destroy_set(swigCPtr, this, SWIGTYPE_p_f_p_void__void.getCPtr(value));
  }

  public SWIGTYPE_p_f_p_void__void getDestroy() {
    long cPtr = enetJNI.ENetCompressor_destroy_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_f_p_void__void(cPtr, false);
  }

  public ENetCompressor() {
    this(enetJNI.new_ENetCompressor(), true);
  }

}
