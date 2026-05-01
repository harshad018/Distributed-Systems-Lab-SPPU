import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringOperation extends Remote {
    String concat(String s1, String s2) throws RemoteException;
    int length(String s) throws RemoteException;
}
