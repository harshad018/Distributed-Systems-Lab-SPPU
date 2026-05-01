import java.util.Scanner;

public class BullyAlgorithm {
    static int n;
    static int[] pro;
    static int[] sta;
    static int co;

    public static void elect(int ele) {
        ele = ele - 1;
        co = ele + 1;
        for (int i = 0; i < n; i++) {
            if (pro[ele] < pro[i]) {
                System.out.println("Election message is sent from " + (ele + 1) + " to " + (i + 1));
                if (sta[i] == 1)
                    elect(i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        n = sc.nextInt();
        
        pro = new int[n];
        sta = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("For process " + (i + 1) + ":");
            System.out.print("Status (1 for active, 0 for inactive): ");
            sta[i] = sc.nextInt();
            System.out.print("Priority: ");
            pro[i] = sc.nextInt();
        }
        
        System.out.print("Which process will initiate election? ");
        int ele = sc.nextInt();
        
        elect(ele);
        System.out.println("Final coordinator is " + co);
    }
}
