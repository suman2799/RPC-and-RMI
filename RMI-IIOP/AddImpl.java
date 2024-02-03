import java.rmi.RemoteException;
import javax.rmi.*;

public class AddImpl extends PortableRemoteObject implements AddIntf {
    public AddImpl() throws RemoteException {
        super(); // Call the constructor of the parent class
    }

    public int add(int i, int j) throws RemoteException {
    // Print a message every time the sum method is invoked
        System.out.println("add(" + i + ", " + j + ") is called");
        return i + j;
    }
}

