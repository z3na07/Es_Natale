package util;

public class GiftManager {
    public static long giftsToDeliver;
    public static long giftsUntilStop;
    public static final long maxGift = 250_000_000;

    public static void clear() {
        giftsToDeliver = 0;
    }
}
