import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server extends UnicastRemoteObject implements StringOperation {
    
    protected Server() throws RemoteException {
        super();
    }

    @Override
    public String concat(String s1, String s2) throws RemoteException {
        return s1 + s2;
    }

    @Override
    public int length(String s) throws RemoteException {
        return s.length();
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("StringOperation", server);
            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
