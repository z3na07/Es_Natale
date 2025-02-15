package util;

import reindeer.ReindeerTeam;

/**
 * Classe di utilità per la gestione dei log relativi alle consegne dei regali e ai cambi di renne.
 * <p>
 * Questa classe fornisce metodi per tenere traccia del numero di cambi di renne
 * e generare un registro delle attività.
 * </p>
 */
public class Logger {
    private static long giftDelivered;
    private static int reindeerSwitch;
    private static ReindeerTeam reindeerTeam;
    private static TimezoneManager timezoneManager;
    private static String logString;

    public static void setReindeerTeam(ReindeerTeam reindeerTeam) {
        Logger.reindeerTeam = reindeerTeam;
    }

    public static void setTimezoneManager(TimezoneManager timezoneManager) {
        Logger.timezoneManager = timezoneManager;
    }

    /* =========================================
    *               GIFT DELIVER
    * ========================================= */

    public static void logGiftDelivered() {
        logString += String.format("[] - A has been delivered!");
    }

    public static void setGiftDelivered(long n) {
        giftDelivered = n;
    }

    public static void setGiftDelivered(int n) {
        giftDelivered = n;
    }

    public static void incrementGiftDeliverd() {
        incrementGiftDeliverd(1);
    }

    public static void incrementGiftDeliverd(long increment) {
        giftDelivered += increment;
    }

    /* =========================================
     *             REINDEER SWITCH
     * ========================================= */

    /**
     * Aggiunge un cambio di renne incrementando il contatore di 1.
     */
    public static void incrementReindeerSwitch() {
        incrementReindeerSwitch(1);
    }

    /**
     * Aggiunge un numero specifico di cambi di renne.
     *
     * @param increment il numero di cambi di renne da aggiungere
     */
    public static void incrementReindeerSwitch(int increment) {
        reindeerSwitch += increment;
    }

    /**
     * Imposta il numero di cambi di renne a un valore specifico.
     *
     * @param n il nuovo valore del contatore di cambi di renne
     */
    public static void setReindeerSwitch(int n) {
        reindeerSwitch = n;
    }

    private static String logStopProcess() {
        return String.format("STOP PROCESS\n\tFuso orario corrente: %s\n\tFuso orario successivo: %s\n\tFusi orari passati: %s\n",
                timezoneManager.getCurrentTimezoneString(), TimezoneManager.getTimezoneString(timezoneManager.getCurrentTimezoneInteger()+1), timezoneManager.getTimezonePassed());
    }

    private static String logSanta() {
        return String.format("SANTA CLAUS\n\tNumero regali consegnati: %d\n",
                giftDelivered);
    }

    private static String logRudolph() {
        return String.format("RUDOLPH:\n\tCambi di renne effetuati: %d\n\tSquadra attiva di renne: %s\n\tSquadra in riposo di renne: %s\n",
                reindeerSwitch, reindeerTeam.getActiveTeam(), reindeerTeam.getRestingTeam());
    }

    /**
     * Genera un registro delle attività, riportando il numero di regali consegnati
     * e i cambi di renne effettuati.
     *
     * @return una stringa contenente il resoconto delle attività
     */
    public static String log() {
        return logStopProcess() + logSanta() + logRudolph();
    }
}
