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
