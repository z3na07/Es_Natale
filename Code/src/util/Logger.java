package util;

/**
 * Classe di utilità per la gestione dei log relativi alle consegne dei regali e ai cambi di renne.
 * <p>
 * Questa classe fornisce metodi per tenere traccia del numero di cambi di renne
 * e generare un registro delle attività.
 * </p>
 */
public class Logger {
    private static String gift;
    private static String reindeerMessage;
    private static int reindeerSwitch;

    /**
     * Aggiunge un cambio di renne incrementando il contatore di 1.
     */
    public static void addReindeerSwitch() {
        addReindeerSwitch(1);
    }

    /**
     * Aggiunge un numero specifico di cambi di renne.
     *
     * @param increment il numero di cambi di renne da aggiungere
     */
    public static void addReindeerSwitch(int increment) {
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

    /**
     * Genera un registro delle attività, riportando il numero di regali consegnati
     * e i cambi di renne effettuati.
     *
     * @return una stringa contenente il resoconto delle attività
     */
    public static String log() {
        return String.format("Numero regali consegnati: %d\nCambi di renne effetuati: %d\nSquadra attiva di renne: %s\nSquadra in riposo di renne: %s", 0, 0, "", "");
    }
}
