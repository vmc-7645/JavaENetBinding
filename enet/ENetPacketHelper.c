/**
 @file ENetPacketHelper.c
 @brief Helps conversion ofpacket to bytes
*/
#include <jni.h>
#include "enet/enet.h"
#include "enet_ENetPacketHelper.h"

JNIEXPORT jbyteArray JNICALL Java_enet_ENetPacketHelper_getPacketData(JNIEnv *env, jclass cls, jobject packetObj, jint length) {
    // Get the pointer to the ENetPacket struct from the Java object
    jclass packetClass = (*env)->GetObjectClass(env, packetObj);
    jfieldID swigCPtrField = (*env)->GetFieldID(env, packetClass, "swigCPtr", "J");
    jlong swigCPtr = (*env)->GetLongField(env, packetObj, swigCPtrField);
    ENetPacket *packet = (ENetPacket *) swigCPtr;

    // Create a new byte array in Java
    jbyteArray byteArray = (*env)->NewByteArray(env, length);

    // Copy the data from the packet to the byte array
    (*env)->SetByteArrayRegion(env, byteArray, 0, length, (jbyte *)packet->data);

    // Return the byte array
    return byteArray;
}
JNIEXPORT void JNICALL Java_enet_ENetPacketHelper_setPacketData(JNIEnv *env, jclass cls, jobject packetObj, jbyteArray byteArray, jint length) {
    // Get the pointer to the ENetPacket struct from the Java object
    jclass packetClass = (*env)->GetObjectClass(env, packetObj);
    jfieldID swigCPtrField = (*env)->GetFieldID(env, packetClass, "swigCPtr", "J");
    jlong swigCPtr = (*env)->GetLongField(env, packetObj, swigCPtrField);
    ENetPacket *packet = (ENetPacket *) swigCPtr;

    // Get the byte array data from Java
    jbyte *data = (*env)->GetByteArrayElements(env, byteArray, NULL);

    // Allocate space in the packet if needed, and copy the data to the packet
    if (packet->data != NULL) {
        free(packet->data);
    }
    packet->data = (uint8_t *) malloc(length);
    memcpy(packet->data, data, length);
    packet->dataLength = length;

    // Release the byte array
    (*env)->ReleaseByteArrayElements(env, byteArray, data, 0);
}