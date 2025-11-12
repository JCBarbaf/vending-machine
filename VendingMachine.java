import java.util.Scanner;

//ToDo: Format error messages on buy product
//ToDo: Add product display to buying option
//ToDo: Format machine outputs and linebreaks
//ToDo: CSV database
//ToDo: restock option
public class VendingMachine {
    public static void main(String[] args) {
        InventoryModule.init();
        WalletModule.init();
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
        int change = 0;
        while (repeat) {        
            System.out.println("\n--- Vending Machine ---");
            System.out.println(
                "1- See avaliable products \n" +
                "2- Insert money \n" +
                "3- Consult money \n" +
                "4- Buy product \n" +
                "5- Return change \n" +
                "6- EXIT"
            );
            System.out.print("What do you want to do? ");
            String userResponse = scanner.nextLine();
            System.out.println("\n");
            switch (userResponse) {
                case "1":
                    InventoryModule.showProducts();       
                    break;
                case "2":
                    System.out.print("How much money (cents) will you insert? ");
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
                    int money = WalletModule.consultMoney();
                    System.out.printf("You have %.2f $ \n", money/100.0);
                    break;
                case "4":
                    System.out.print("Insert the ID of the product you want to buy: ");
                    try {
                        int productID = Integer.parseInt(scanner.nextLine());
                        InventoryModule.dispenseProduct(productID);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case "5":
                    change = WalletModule.returnChange();
                    System.out.printf("Here is your change: %.2f $", change/100.0);
                    break;
                case "6":
                    System.out.println("Thanks for using the vending machine");
                    change = WalletModule.returnChange();
                    System.out.printf("Here is your change: %.2f $ \n", change/100.0);
                    System.out.println("Have a nice day ^_^");
                    repeat = false;
                    break;
                    default:
                    System.out.println("ERROR: please select a valid option");
                    break;
                }
            }
            scanner.close();
    }
}
