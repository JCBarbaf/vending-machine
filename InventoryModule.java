public class InventoryModule {
    private static String[] productNames;
    private static int[] productStocks;
    private static int[] productPrices;
    private static String hr = "-------------------------------------------------";
    public static void init() {
        productNames = new String[] {"Coke", "Water", "Sparkling water", "Sandwitch", "KitKat", "Potato chips"};
        productStocks = new int[] {3, 5, 5, 2, 1, 5};
        productPrices = new int[] {120, 100, 110, 200, 80, 150};
    }

    public static void showProducts() {
        System.out.println(hr);
        System.out.println("| ID  | Product              | Price    | Stock |");
        System.out.println(hr);
        for (int i = 0; i < productNames.length; i++) {
            System.out.printf("| %-3d | %-20s | %6.2f $ | %5d |\n", i, productNames[i], productPrices[i]/100.0, productStocks[i]);
            System.out.println(hr);
        }
    }

    public static boolean verifyStock(int productID) {
        return true;
    }

    public static int checkPrice(int ProductID) {
        return 1;
    }

    public static void dispenseProduct(int productID) {

    }

    private static boolean validProductId (int productID) {
        return true;
    }
}
