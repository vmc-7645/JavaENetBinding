# Java ENet Binding

A Swig binding of [ENet](http://enet.bespin.org/) for Java (& Processing) 

## Tutorial

Ensure you already have the ENet package installed.

Download and install Swig. To install, after downloading, go to `./swig-VERSION/Doc/Manual/Preface.html` and view it in your websbrowser. From here follow the installation instructions.

For Swig-4.2.1, these instructions are as follows:

>You must use GNU make to build and install SWIG.
>
>PCRE2 needs to be installed on your system to build SWIG, in particular pcre2-config must be available. If you have PCRE2 headers and libraries but not pcre2-config itself or, alternatively, wish to override the compiler or linker flags returned by pcre2-config, you may set PCRE2_LIBS and PCRE2_CFLAGS variables to be used instead. And if you don't have PCRE2 at all, the configure script will provide instructions for obtaining it.

Get PCER2 by going here and downloading the .tar.gz file then extracting it: https://github.com/PCRE2Project/pcre2/releases

Now, before installing PCER2 you may also need `bzlib`, so check by running `sudo yum whatprovides */bzlib.h`. If it does not exist run `sudo apt install libbz2-dev`

Also install `sudo apt-get install libreadline-dev`

Once you have it extracted follow the instructions [here](https://www.linuxfromscratch.org/blfs/view/systemd/general/pcre2.html) to install it. For version 2.10.44 this should simply be the following (done its respective extracted root folder):

```
./configure --prefix=/usr                       \
            --docdir=/usr/share/doc/pcre2-10.44 \
            --enable-unicode                    \
            --enable-jit                        \
            --enable-pcre2-16                   \
            --enable-pcre2-32                   \
            --enable-pcre2grep-libz             \
            --enable-pcre2grep-libbz2           \
            --enable-pcre2test-libreadline      \
            --disable-static                    &&
make
```

And run `sudo make install` to finish the install for pcre2.

Now you can install Swig (done its respective extracted root folder):

```
./configure
make
```
And finally run `sudo make install` to finish the install for Swig.

To ensure it installed, check with the following command:

```
make -k check
```

Now that you have Swig and Enet properly installed, take note of Enets location, usually one of the following:

- `/usr/include/enet/enet.h`
- `/usr/local/include/enet/enet.h`

Requirements

```
sudo apt-get update
sudo apt-get install default-jdk
sudo apt-get install libenet-dev
```

From here we can develop the Swig command, below is what it turned out to be for myself, but it could be different for you.

```
swig -java -package enet -outdir ./enet -I/usr/include -c++ enet.i
```

Alternatively, use the included enet implementation

```
swig -java -package enet -outdir ./enet -c++ enet.i
```

Now, once you run this, a generated `enet_wrap.cxx` should have been generated.

Compile this wrapper file.

Generic

```
g++ -fPIC -c enet_wrap.cxx \
    -I/path/to/jdk/include \
    -I/path/to/jdk/include/linux \
    -I/usr/include/enet
```

An example

```
g++ -fPIC -c enet_wrap.cxx \
    -I/usr/lib/jvm/java-11-openjdk-amd64/include \
    -I/usr/lib/jvm/java-11-openjdk-amd64/include/linux \
    -I/usr/include/enet
```

Link to shared library

```
g++ -shared enet_wrap.o -o libenetjni.so -lenet
```

<!-- Install libenet system-wide

```
sudo cp /path/to/libenet.so /usr/local/lib/
sudo ldconfig
```

```
sudo cp ./libenetjni.so /usr/local/lib/
sudo ldconfig
``` -->

Now that we have this, we must compile into a JAR

```
javac -source 1.8 -target 1.8 -d bin ./enet/*.java ./enet/enetJNI.java
jar cf ENet.jar -C bin .
```

From here all you have to do is place the `libenetjni.so` & `ENet.jar` files into the `code/` directory.

Load the package into your project manually via `System.loadLibrary("enetjni");` and access normally.


<!-- FMS : where I'll probably be doing most of my work-->