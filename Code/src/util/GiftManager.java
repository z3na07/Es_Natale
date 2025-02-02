package util;

public class GiftManager {
    private static long giftsToDeliver;
    private static long giftsUntilStop = 250_000_000;
    private static final long maxGift = 250_000_000;

    /**
     * Resetta il numero di regali rimanenti fino allo stop al valore massimo.
     */
    public static void resetGiftUntilStop() {
        giftsUntilStop = maxGift;
    }

    /* =========================================
                  GIFT UNTIL STOP
    * ==========================================*/

    /**
     * Restituisce il numero di regali rimanenti fino allo stop.
     *
     * @return il numero di regali rimanenti fino allo stop
     */
    public static long getGiftsUntilStop() {
        return giftsUntilStop;
    }

    /**
     * Imposta il numero di regali rimanenti fino allo stop.
     *
     * @param giftsUntilStop il nuovo valore di regali rimanenti fino allo stop
     */
    public static void setGiftsUntilStop(long giftsUntilStop) {
        GiftManager.giftsUntilStop = giftsUntilStop;
    }

    /**
     * Incrementa il numero di regali da consegnare di una quantità specificata.
     *
     * @param n il numero di regali da aggiungere
     */
    public static void incrementGiftUntilStop(long n) {
        giftsToDeliver += n;
    }

    /**
     * Decrementa il numero di regali da consegnare di una quantità specificata.
     *
     * @param n il numero di regali da sottrarre
     */
    public static void decrementGiftUntilStop(long n) {
        giftsToDeliver -= n;
    }

    /* =========================================
                    GIFT TO DELIVER
    * ==========================================*/

    /**
     * Imposta il numero di regali da consegnare.
     *
     * @param n il nuovo valore del numero di regali da consegnare
     */
    public static void setGiftsToDeliver(long n) {
        giftsToDeliver = n;
    }

    /**
     * Incrementa il numero di regali da consegnare di una quantità specificata.
     *
     * @param n il numero di regali da aggiungere
     */
    public static void incrementGiftToDeliver(long n) {
        giftsToDeliver += n;
    }

    /**
     * Decrementa il numero di regali da consegnare di una quantità specificata.
     *
     * @param n il numero di regali da sottrarre
     */
    public static void decrementGiftToDeliver(long n) {
        giftsToDeliver -= n;
    }

    /**
     * Restituisce il numero di regali da consegnare.
     *
     * @return il numero di regali da consegnare
     */
    public static long getGiftsToDeliver() {
        return giftsToDeliver;
    }

    /* =========================================
                      MAX GIFT
    * ==========================================*/

    /**
     * Restituisce il numero massimo di regali che possono essere consegnati.
     *
     * @return il numero massimo di regali
     */
    public static long getMaxGift() {
        return maxGift;
    }
}
