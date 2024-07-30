import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;
import java.util.Scanner;

/**
 * Uncle Scrooge path
 * @author Jason Sun
 * @version 1.0
 * May 2022
 */
public class UncleScroogePath{
    public static void main(String[] args){
        Basement basement = new Basement();
        Scanner keyboard = new Scanner(System.in);
        
        // User decides total number of moves and delay time between each move
        System.out.println("Enter the total number of moves: ");
        int moves = keyboard.nextInt();
        System.out.println("Enter the delay time in between each move (milliseconds): ");
        int delayTime = keyboard.nextInt();
        
        for (int move=1; move<moves; move++){
            basement.update();
            System.out.println("move: "+move+"\n"+basement);
            try {TimeUnit.MILLISECONDS.sleep(delayTime);} catch (InterruptedException e){}
        }
    }
}