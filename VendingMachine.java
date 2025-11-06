import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Vending Machine ---");
        System.out.println(
            "1- See avaliable products \n" +
            "2- Insert money \n" +
            "3- Buy product \n" +
            "4- Return change \n" +
            "5- EXIT"
        );
        System.out.print("What do you want to do? ");
        String userResponse = scanner.nextLine();
        System.out.println("\n");
        switch (userResponse) {
            case "1":
                InventoryModule.init();
                InventoryModule.showProducts();       
                break;
            case "2":
                System.out.print("How much money will you insert? ");
                try {
                    int quantity = Integer.parseInt(scanner.nextLine());
                    if (quantity >= 0) {
                        WalletModule.insertMoney(quantity);
                        System.out.printf("%d cents inserted \n", quantity);
                    } else {
                        System.out.println("Error: negative quantity inserted");
                    }
                } catch (Exception e) {
                    System.out.println("Error: invalid quantity inserted");
                }
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                System.out.println("Thanks for using the vending machine");
                System.out.println("Here is your change:");
                System.out.println("Have a nice day ^_^");
                scanner.close();
                break;
            default:
                System.out.println("ERROR: please select a valid option");
                break;
        }
    }
}
