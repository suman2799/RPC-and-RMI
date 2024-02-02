// Create AddServer and host RMI service

import java.rmi.*;
import java.rmi.registry.*;

public class AddServer {
	public static void main(String args[]) {
		try {
			AddServerInterface addService = new Adder();
			Naming.rebind("AddService", addService);
		} catch (Exception e) { 
			System.out.println(e);
		}
	}
}
