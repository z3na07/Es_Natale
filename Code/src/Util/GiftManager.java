package Util;

public class GiftManager {
    public static long giftsToDeliver;
    public static final long maxGift = 250_000_000;

    public static void clear() {
        giftsToDeliver = 0;
    }
}
