public class WalletModule {
    private static int moneyInserted;
    private static int moneyTotal;

    public static void init() {

    }

    public static void insertMoney(int quantity) {

    }

    public static int consultMoneyInserted() {
        return moneyInserted;
    }

    public static boolean verifyEnoughMoney(int price) {
        return true;
    }

    public static boolean processPayment(int price) {
        return true;
    }

    public static int returnChange() {
        return 1;
    }
}
