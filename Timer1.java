import java.util.Timer;
import java.util.TimerTask;

public class Timer1 {
    Timer timer;
    public Timer1() {
      timer = null;
    }
    public Timer1 (int s) {
        timer = new Timer();
        timer.schedule(new RemindTask(), s*30000);
	}

    class RemindTask extends TimerTask {
      int x;  
      public void run() {
            System.out.println("\nYour suggested time is up! We recommend that you finish soon. Please continue writing your input if you need to do so..."); // showing message here 
        x = 0;
            timer.cancel(); // Terminate the timer thread
        }
      public int getX() {
        return x;
      }
    }

}
