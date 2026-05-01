import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BerkeleyAlgorithm {
    public static void berkeleyAlgorithm(String serverTime, String time1, String time2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        long sTime = sdf.parse(serverTime).getTime();
        long t1 = sdf.parse(time1).getTime();
        long t2 = sdf.parse(time2).getTime();
        
        long diff1 = t1 - sTime;
        long diff2 = t2 - sTime;
        
        long avgDiff = (diff1 + diff2 + 0) / 3;
        
        long syncTime = sTime + avgDiff;
        
        System.out.println("Server Time: " + sdf.format(new Date(sTime)));
        System.out.println("Client 1 Time: " + sdf.format(new Date(t1)));
        System.out.println("Client 2 Time: " + sdf.format(new Date(t2)));
        System.out.println("Synchronized Time: " + sdf.format(new Date(syncTime)));
    }

    public static void main(String[] args) {
        try {
            berkeleyAlgorithm("10:30", "10:25", "10:35");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
