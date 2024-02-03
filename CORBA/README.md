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
