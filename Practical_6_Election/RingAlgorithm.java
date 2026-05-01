import java.util.Scanner;

public class RingAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        
        int[] pro = new int[n];
        int[] sta = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("For process " + i + ":");
            System.out.print("Status (1 for active, 0 for inactive): ");
            sta[i] = sc.nextInt();
            pro[i] = i;
        }
        
        System.out.print("Which process will initiate election? ");
        int init = sc.nextInt();
        
        int temp = init;
        int[] active = new int[n];
        int k = 0;
        
        System.out.println("Election message passed:");
        while (true) {
            int next = (temp + 1) % n;
            if (next == init) {
                break;
            }
            if (sta[next] == 1) {
                System.out.println("Process " + temp + " passes message to " + next);
                active[k++] = pro[next];
                temp = next;
            } else {
                temp = next;
            }
        }
        
        int max = active[0];
        for (int i = 1; i < k; i++) {
            if (active[i] > max) {
                max = active[i];
            }
        }
        
        System.out.println("Process " + max + " becomes the coordinator.");
    }
}
