import java.util.Scanner;

public class TokenRing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();
        
        System.out.println("Ring formed with " + n + " nodes.");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println("0");
        
        int token = 0;
        System.out.print("Enter sender node: ");
        int sender = sc.nextInt();
        System.out.print("Enter receiver node: ");
        int receiver = sc.nextInt();
        System.out.print("Enter data to send: ");
        String data = sc.next();
        
        System.out.println("Token passing:");
        for (int i = token; i != sender; i = (i + 1) % n) {
            System.out.print(" " + i + " ->");
        }
        System.out.println(" " + sender);
        System.out.println("Sender " + sender + " sending data: " + data);
        
        for (int i = sender; i != receiver; i = (i + 1) % n) {
            System.out.println("Data " + data + " forwarded by " + i);
        }
        System.out.println("Receiver " + receiver + " received data: " + data);
        
        token = sender;
        System.out.println("Token is now with node " + token);
    }
}
