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
            if (productStocks[i] > 0) {
                System.out.printf("| %-3d | %-20s | %6.2f $ | %5d |\n", i, productNames[i], productPrices[i]/100.0, productStocks[i]);
                System.out.println(hr);
            }
        }
    }

    public static boolean verifyStock(int productID) {
        return true;
    }

    public static int checkPrice(int ProductID) {
        return 1;
    }

    public static void dispenseProduct(int productID) throws Exception {
        if (validProductId(productID)) {
            if (productStocks[productID] > 0) {
                try {
                    WalletModule.processPayment(productPrices[productID]);
                    productStocks[productID]--;
                    System.out.printf("Enjoy your %s", productNames[productID]);
                } catch (Exception e) {
                    throw new Exception(e);
                }
            } else {
                throw new Exception("There is not enough stock");
            }
        } else {
            throw new Exception("Invalid product ID");
        }

    }

    private static boolean validProductId (int productID) {
        return !(productID < 0 || productID > productNames.length - 1);
    }
}
