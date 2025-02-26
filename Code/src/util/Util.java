package util;

import java.util.Scanner;

/**
 * in this class we have the method that stops the program and show all the stats  
 */
public class Util {

    /**
    * This method stop the process of the program and sit shows all the  presents that we delivered and it changes the team of reindeers 
    * 
    * @param scanner is the Scanner so we can read from keyboard
    * @param santaClaus is the Santa claus object, so without this the program can't run
    * @param giftManager is the manager of all the gift that we delivered all over the world
    * @param resetGiftUntilStop it a boolean variable that says id we have tio stop becuase we delivered all the presents
    */
    public static void stopProcess(Scanner scanner, SantaClaus santaClaus, GiftManager giftManager, boolean resetGiftUntilStop) {
        // Reset gift until stop
        if (resetGiftUntilStop) {
            giftManager.resetGiftUntilStop();
        }

        // Switch reindeer
        santaClaus.switchTeam();

        // Log information
        System.out.println(Logger.log());

        // Ask to continue
        System.out.println(">>> Premere invio per continuare");
        scanner.nextLine();
    }
}
