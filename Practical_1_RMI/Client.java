import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            StringOperation stub = (StringOperation) registry.lookup("StringOperation");
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter first string:");
            String s1 = sc.nextLine();
            System.out.println("Enter second string:");
            String s2 = sc.nextLine();
            
            System.out.println("Concatenated String: " + stub.concat(s1, s2));
            System.out.println("Length of first string: " + stub.length(s1));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
