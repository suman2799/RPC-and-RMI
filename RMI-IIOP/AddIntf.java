import java.rmi.*;

public interface AddIntf extends Remote {
	public int add(int i, int j) throws RemoteException;
}
