public class WalletModule {
    private static int money;

    public static void init() {
        money = 0;

    }

    public static void insertMoney(int quantity) {
        money += quantity;
    }

    public static int consultMoney() {
        return money;
    }

    public static void processPayment(int price) throws Exception{
        if (money >= price) {
            money -= price;
        } else {
            throw new Exception("Not enough money");
        }
    }

    public static int returnChange() {
        int change = money;
        money = 0;
        return change;
    }
}
