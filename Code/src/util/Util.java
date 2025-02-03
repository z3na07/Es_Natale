package util;

import java.util.Scanner;

public class Util {

    public static void stopProcess(Scanner scanner, SantaClaus santaClaus, GiftManager giftManager) {
        // Reset gift until stop
        giftManager.resetGiftUntilStop();

        // Switch reindeer
        santaClaus.switchTeam();

        // Log information
        System.out.println(Logger.log());

        // Ask to continue
        System.out.println("Premere invio per continuare");
        scanner.nextLine();
    }
}
