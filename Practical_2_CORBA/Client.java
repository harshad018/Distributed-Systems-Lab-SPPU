import CalculatorApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            Calculator calcImpl = CalculatorHelper.narrow(ncRef.resolve_str("Calculator"));

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter two numbers:");
            float a = sc.nextFloat();
            float b = sc.nextFloat();

            System.out.println("Addition: " + calcImpl.add(a, b));
            System.out.println("Subtraction: " + calcImpl.subtract(a, b));
            System.out.println("Multiplication: " + calcImpl.multiply(a, b));
            System.out.println("Division: " + calcImpl.divide(a, b));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
