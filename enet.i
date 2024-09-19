%module enet

%{
#define SWIG_FILE_WITH_INIT
#include "enet/enet.h"
%}

%include "stdint.i"
%include "arrays_java.i"

// Define macros for SWIG parser (not copied into the generated code)
%define ENET_API
%enddef

%define ENET_CALLBACK
%enddef

// Map enet_uint8 to Java's 'int' type
%apply unsigned int { enet_uint8 };

// Map enet_uint16 to Java's 'int' type
%apply unsigned int { enet_uint16 };

// Map enet_uint32 to Java's 'int' type
%apply unsigned int { enet_uint32 };

// Map enet_uint8 * data in ENetPacket to byte[]
%typemap(jtype) enet_uint8 *ENetPacket::data "byte[]"
%typemap(jstype) enet_uint8 *ENetPacket::data "byte[]"
%typemap(jni) enet_uint8 *ENetPacket::data "jbyteArray"
%typemap(memberin) enet_uint8 *ENetPacket::data {
  // Not needed since we won't set data from Java
}
%typemap(memberout) enet_uint8 *ENetPacket::data {
  if ($1 && $self->dataLength > 0) {
    $result = (*jenv)->NewByteArray(jenv, (jsize)$self->dataLength);
    (*jenv)->SetByteArrayRegion(jenv, $result, 0, (jsize)$self->dataLength, (jbyte *)$1);
  } else {
    $result = NULL;
  }
}

%include "enet/enet.h"
