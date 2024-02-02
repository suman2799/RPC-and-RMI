// Implementation of remote interface

import java.rmi.*;
import java.rmi.server.*;

public class Adder extends UnicastRemoteObject implements AddServerInterface {
	Adder() throws RemoteException {
		super();
	}

	public int sum(int a, int b) {
		// Print a message every time the sum method is invoked
        	System.out.println("sum(" + a + ", " + b + ") is called");
		return a + b;
	}
}
