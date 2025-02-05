package util;

public class GiftManager {
    private long giftsToDeliver;
    private long giftsUntilStop;
    private final long maxGift;

    public GiftManager(long maxGift) {
        this.maxGift = this.giftsUntilStop = maxGift;
    }

    /**
     * Resetta il numero di regali rimanenti fino allo stop al valore massimo.
     */
    public void resetGiftUntilStop() {
        this.giftsUntilStop = this.maxGift;
    }

    /* =========================================
                  GIFT UNTIL STOP
    * ==========================================*/

    /**
     * Restituisce il numero di regali rimanenti fino allo stop.
     *
     * @return il numero di regali rimanenti fino allo stop
     */
    public long getGiftsUntilStop() {
        return this.giftsUntilStop;
    }

    /**
     * Imposta il numero di regali rimanenti fino allo stop.
     *
     * @param n il nuovo valore di regali rimanenti fino allo stop
     */
    public void setGiftsUntilStop(long n) {
        this.giftsUntilStop = n;
    }

    /**
     * Incrementa il numero di regali da consegnare di una quantità specificata.
     *
     * @param n il numero di regali da aggiungere
     */
    public void incrementGiftUntilStop(long n) {
        this.giftsUntilStop += n;
    }

    /**
     * Decrementa il numero di regali da consegnare di una quantità specificata.
     *
     * @param n il numero di regali da sottrarre
     */
    public void decrementGiftUntilStop(long n) {
        this.giftsUntilStop -= n;
    }

    /* =========================================
                    GIFT TO DELIVER
    * ==========================================*/

    /**
     * Imposta il numero di regali da consegnare.
     *
     * @param n il nuovo valore del numero di regali da consegnare
     */
    public void setGiftsToDeliver(long n) {
        this.giftsToDeliver = n;
    }

    /**
     * Incrementa il numero di regali da consegnare di una quantità specificata.
     *
     * @param n il numero di regali da aggiungere
     */
    public void incrementGiftToDeliver(long n) {
        this.giftsToDeliver += n;
    }

    /**
     * Decrementa il numero di regali da consegnare di una quantità specificata.
     *
     * @param n il numero di regali da sottrarre
     */
    public void decrementGiftToDeliver(long n) {
        this.giftsToDeliver -= n;
    }

    /**
     * Restituisce il numero di regali da consegnare.
     *
     * @return il numero di regali da consegnare
     */
    public long getGiftsToDeliver() {
        return this.giftsToDeliver;
    }

    /* =========================================
                      MAX GIFT
    * ==========================================*/

    /**
     * Restituisce il numero massimo di regali che possono essere consegnati.
     *
     * @return il numero massimo di regali
     */
    public long getMaxGift() {
        return this.maxGift;
    }
}
