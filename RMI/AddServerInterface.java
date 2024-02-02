// Define a remote interface
import java.rmi.*;

public interface AddServerInterface extends Remote {
	public abstract int sum(int a, int b) throws RemoteException;
}
