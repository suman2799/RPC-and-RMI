# SUN RPC Implementation

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
 
## Source

* https://www.youtube.com/watch?v=HbBxO5RXNhU
