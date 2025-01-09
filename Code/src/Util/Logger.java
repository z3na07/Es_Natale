package Util;

public class Logger {
    private static final String DELIVERY_PREFIX = "Sono stati consegnati ";
    private static final String REINDEER_PREFIX = "Sono stati consegnati ";

    private static String deliveryMessage;
    private static String reindeerMessage;

    public static void logDelivery(int numberOfDelivery) {
        deliveryMessage = DELIVERY_PREFIX + numberOfDelivery;
    }

    public static void logReindeerMessage(int numberOfSwitch) {
        reindeerMessage = REINDEER_PREFIX + numberOfSwitch;
    }

    public static String getDeliveryMessage() {
        return deliveryMessage;
    }

    public static String getReindeerMessage() {
        return reindeerMessage;
    }
}