package util;

import reindeer.ReindeerTeam;

/**
 * Rappresenta Babbo Natale e gestisce la consegna dei regali, il cambio delle renne e il passaggio dei fusi orari.
 */
public class SantaClaus {
    private long totalGiftsDelivered;
    private int timezonePassed;
    private int reindeerSwitches;
    private ReindeerTeam reindeerTeam;

    /**
     * Costruttore della classe SantaClaus.
     *
     * @param reindeerTeam la squadra di renne iniziale utilizzata per le consegne
     */
    public SantaClaus(ReindeerTeam reindeerTeam) {
        this.totalGiftsDelivered = this.timezonePassed = this.reindeerSwitches = 0;
        this.reindeerTeam = reindeerTeam;
    }

    /**
     * Cambia la squadra di renne attiva con quella di riserva.
     * Incremente anche il numero di cambi effettuati e aggiorna il registro.
     */
    public void switchTeam() {
        reindeerTeam.switchTeams();
        reindeerSwitches++;
        Logger.incrementReindeerSwitch();
    }

    /* =========================================
     *              GIFT DELIVERED
     * ========================================= */

    /**
     * Restituisce il numero totale di regali consegnati.
     *
     * @return il numero di regali consegnati
     */
    public long getTotalGiftsDelivered() {
        return totalGiftsDelivered;
    }

    /**
     * Aggiunge un numero specifico di regali al totale dei regali consegnati.
     * L'aggiornamento viene registrato nel logger.
     *
     * @param giftsToAdd il numero di regali da aggiungere
     */
    public void addTotalGiftsDelivered(long giftsToAdd) {
        this.totalGiftsDelivered += giftsToAdd;
        Logger.incrementGiftDeliverd(giftsToAdd);
    }

    /* =========================================
     *            TIME ZONE PASSED
     * ========================================= */

    /**
     * Restituisce il numero di fusi orari attraversati.
     *
     * @return il numero di fusi orari attraversati
     */
    public int getTimezonePassed() {
        return timezonePassed;
    }

    /**
     * Imposta il numero di fusi orari attraversati.
     *
     * @param timezonePassed il nuovo valore dei fusi orari attraversati
     */
    public void setTimezonePassed(int timezonePassed) {
        this.timezonePassed = timezonePassed;
    }

    /* =========================================
     *             REINDEER SWITCH
     * ========================================= */

    /**
     * Restituisce il numero di cambi di squadra di renne effettuati.
     *
     * @return il numero di cambi di squadra di renne
     */
    public int getReindeerSwitches() {
        return reindeerSwitches;
    }
}
