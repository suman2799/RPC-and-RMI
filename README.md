# RPC Implementation in SUN ONC/RPC, Java RMI, Java RMI-IIOP and CORBA Programming

Implementation of various RPC techniques have been shown here with execution time comparision with different no. of request generation ranging from _1_ to _n_.

## Demonstration

https://github.com/suman2799/RPC-and-RMI/assets/87803503/18df7d21-b369-48a8-9c42-4a13490d916b


# SUN ONC/RPC Implementation

These are implementation files of SUN RPC. The RPC calls a procedure _add(int i, int j)_ implemented in a server file _add_server.c_ from a client file _add_client.c_. Client can request from _1_ to _n_ no. of packets to the server.

## Installing

* Copy the files to local directory.
* To run the files see **Commands** tab.
* To generate your own RPC stubs and files see **RPC Complilation** tab.

## RPC Compilation

* Make an empty directory.
* Copy _add.x_ file to the directory. This is the RPC IDL file which will generate the stub objects.
* To make a custom function follow the stucture of _add.x_ file.
* _rpcgen -a -C add.x_ # Complie the files
* You can see a _Makefile.add_ will be generated, open that file in editor and find these two lines :
  * CFLAGS += -g
  * LDLIBS += -lnsl
* Replace them with these lines:
    * CFLAGS += -g -I/usr/include/tirpc
    * LDLIBS += -lnsl -ltirpc
* _make -f Makefile.add_ # Generate executable files
* Now, we need to write the server side and client side codes.
* Copy the _add_client.c_ and _add_server.c_ file from this repo and replace with ypur generated files or edit you can edit your client and server files to create custom function.
* Complie again using _make -f Makefile.add_
* All the necessary files have been created.

## Commands

* Run the server in a new terminal:
    * _./add_server_
* Run the client in a new terminal:
    * Usage: _./add_client <server_host> <number_1> <number_2> packets_
    * Eg: _./add_client localhost 12 28 5_
 
## Sources

* https://www.youtube.com/watch?v=HbBxO5RXNhU


# Java RMI Implementation

These are implementation files of Java RMI. The RMI calls a procedure _add(int i, int j)_ implemented in a server file _AddServer.java_ from a client file _Client.java_. Client can request from _1_ to _n_ no. of packets to the server.

## Installing

* Copy the files to local directory.
* To run the files see **Commands** tab.
* To create custom RMI functions refer to **RMI Custom Functions**.
* RMI is supported from JDK 1.1 onwards.

## RMI Custom Functions

* Make an empty directory.
* We need to write the server side and client side codes.
* Create an _Adder.java_ file [Where the procedure will be written], an _AddServer.java_ file [Which will act as a server], an interface _AddServerInterface.java_ and finally the _Client.java_ file [Where the server procedure will be called from].
* For help refer to the **Source** tab.
* Complie using _javac *.java_.
* All the necessary files have been created.

## Commands

* Run the RMI registry which is like a NameService:
    * _rmiregistry_
* Run the server in a new terminal:
    * _java AddServer_
* Run the client in a new terminal:
    * Usage: _java Client <server_host> <number_1> <number_2> <packets>_
    * Eg: _java Client 127.0.0.1 23 37 5_
 
## Source

* https://www.youtube.com/watch?v=tKW4tHDBYsA&list=PLp6c3tqokHOv7zHS9rlk1N1udw7M02w-4&index=4


# Java RMI-IIOP

These are implementation files of Java RMI-IIOP heterogeneous programming. The server calls a procedure _add(int i, int j)_ implemented in a server file _AddServer.java_ from a client file _AddClient.java_. Client can request from _1_ to _n_ no. of packets to the server.

## Installing

* Copy the files to local directory.
* To run the files see **Commands** tab.
* To create custom RMI-IIOP functions refer to **RMI-IIOP Custom Functions** tab.
* Note: RMI-IIOP has been deprecated as of Java 13 and removed as of Java 15. Use older java versions to use this.
* Java version: **openjdk version "1.8.0_392"**.

## RMI-IIOP Custom Functions

* Make an empty directory.
* We need to write the server side and client side codes.
* Create an _AddServer.java_ file [Which will act as a server], an _AddImpl.java_ [Where the procedure will be implemented], an _AddIntf.java_ interface file and finally the _AddClient.java_ file [Where the server procedure will be called from].
* Complie using _javac *.java_.
* _rmic -iiop AddImpl_ # Generate Proxy (stub) & Skeleton (tie)
* All the necessary files have been created.
* For help refer to the **Source** tab.

## Commands

* Run the CORBA Naming Service in a new terminal:
    * _tnameserv -ORBInitialPort 20900_
    * Different port can be used, default port is 900.
* Run the server in a new terminal:
    * _java AddServer_
* Run the client in a new terminal:
    * Usage: _java AddClient <number_1> <number_2> packets_
    * Eg: _java AddClient 10 30 5_

## Sources

* RMI-IIOP Programming: https://docs.oracle.com/javase/8/docs/technotes/guides/rmi-iiop/tutorial.html


# CORBA Java-Python Implementation

These are implementation files of CORBA heterogeneous programming. **Java Server** and **Python Client** is used. The Java server calls a procedure _add(int i, int j)_ implemented in a java server file _AdderServer.java_ from a Python client file _AdderClient.py_. Client can request from _1_ to _n_ no. of packets to the server.

## Installing

* Copy the files to local directory.
* To run the files see **Commands** tab.
* To create custom CORBA functions refer to **CORBA Custom Functions** tab.
* omniORB 4.3.2 and omniORBpy 4.3.2 are used [See **Sources**].
* For omniORB and omniORBpy CORBA libraries installation refer to **omniORB Installation** tab.
* Java version: **openjdk version "1.8.0_392"**.
* Python version: **Python 3.10.12**.
* omniORB version: **omniORB 4.3.2 and omniORBpy 4.3.2**.

## CORBA Custom Functions

* Make an empty directory.
* Copy _Adder.idl_ file to the directory. This is the IDL file which will generate the stub objects.
* To make a custom function follow the stucture of _Adder.idl_ file.
* _idlj -fall -pkgPrefix Math math_ Adder.idl_ # Generate idlj package files
* _javac math_/Math/*.java_ # Compile idlj package files
* _omniidl -bpython Adder.idl_ # Generate Python Stubs
* Now, we need to write the server side and client side codes.
* Create an _Adder.idl_ file [This will generate stubs], an _AdderServer.java_ file [Which will act as a server], an _AdderImpl.java_ [Where the procedure will be implemented] and finally the _AdderClient.py_ file [Where the server procedure will be called from].
* For help refer to the **Source** tab.
* Complie using _javac *.java_.
* All the necessary files have been created.

## omniORB Installation

* Download the libraries from [here](https://omniorb.sourceforge.io/index.html).
* Unzip both files using:
    * _tar xjvf ~/Downloads/omniORB-4.3.2.tar.bz2_ 
    * _tar xjvf ~/Downloads/omniORBpy-4.3.2.tar.bz2_
* Goto path of unzipped files:
    * _cd omniORB-4.3.2/_
* We need to configure the installation directories, use the following:
    * _./configure --help_
    * _PYTHON=/usr/bin/python3 ./configure -C_
* Make commands:
    * _make -j_
    * _make install_
* Check if installation is correct:
    * _which omniidl_
* Run command:
    * _omniidl -u_ 
* Goto path of the other libraries:
    * _cd ../omniORBpy-4.3.2/_
* We need to configure the installation directories, use the following:
    * _./configure --help_
    * _PYTHON=/usr/bin/python3 ./configure -C_
* Make commands:
    * _make -j_
    * _make install_
* Run command:
    * _omniidl -u -bpython_
* For further help refer to **Sources**.

## Commands

* Run the CORBA Naming Service:
    * _orbd -ORBInitialPort 2500_
    * Different port can be used, default port is 1049.
* Run the server in a new terminal:
    * _java AdderServer -ORBInitialPort 2500_
* Run the client in a new terminal:
    * Usage: _python3 AdderClient.py <number_1> <number_2> packets -ORBInitRef NameService=corbaname::localhost:2500/NameService_
    * Eg: _python3 AdderClient.py 15 30 5 -ORBInitRef NameService=corbaname::localhost:2500/NameService_

## Sources

* CORBA Libraries: https://omniorb.sourceforge.io/index.html
* CORBA Programming: https://www.oracle.com/technical-resources/articles/javase/corba.html
* omniORB Installation: https://github.com/orgs/Homebrew/discussions/2516
