# CORBA Java-Python Implementation

These are implementation files of CORBA heterogeneous programming. **Java Server** and **Python Client** is used. The Java server calls a procedure _add(int i, int j)_ implemented in a java server file _AdderServer.java_ from a Python client file _AdderClient.py_. Client can request from _1_ to _n_ no. of packets to the server.

## Installing

* Copy the files to local directory.
* To run the files see **Commands** tab.
* To create custom CORBA functions refer to **CORBA Custom Functions**.
* omniORB 4.3.2 and omniORBpy 4.3.2 are used [See **Sources**].

## CORBA Custom Functions

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
