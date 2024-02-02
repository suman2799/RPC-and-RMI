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
