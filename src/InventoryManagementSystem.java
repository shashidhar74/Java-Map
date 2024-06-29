import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map <String,Integer> inventory=new HashMap<>();

        while(true){
            displayInventoryMenu();
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==5){
                System.out.println("Exiting.....");
                sc.close();
                System.exit(0);
            }
            handleUserChoice(choice,sc,inventory);
        }
    }

    public static void displayInventoryMenu(){
       System.out.println("\nWELCOME TO INVENTORY MANAGEMENT SYSTEM");
       System.out.println("1.Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. Update Item Quantity");
        System.out.println("4. Display Inventory");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    public static void handleUserChoice(int choice,Scanner scanner , Map<String,Integer> inventory) {
        switch (choice) {
            case 1:
                System.out.print("Enter Item name : ");
                String addItemName = scanner.nextLine();

                System.out.print("Enter Item Quantity : ");
                int addItemQuantity = scanner.nextInt();
                scanner.nextLine();

                inventory.put(addItemName, inventory.getOrDefault(addItemName, 0) + addItemQuantity);
                System.out.println("Item added successfully.");

                System.out.println("\nCurrent Inventory:");
                for(Map.Entry<String,Integer> entry :inventory.entrySet()){
                    System.out.println("Item: "+entry.getKey() + ", Quantity: "+entry.getValue());
                }
                break;

            case 2:
                System.out.print("Enter item name: ");
                String removeItemName = scanner.nextLine();
                if(inventory.containsKey(removeItemName)){
                    inventory.remove(removeItemName);
                    System.out.println("Item removed successfully.");
                    System.out.println("\nCurrent Inventory:");
                    for(Map.Entry<String,Integer> entry :inventory.entrySet()){
                        System.out.println("Item: "+entry.getKey() + ", Quantity: "+entry.getValue());
                    }
                }else{
                    System.out.println("Item not found in inventory.");
                }
                break;

            case 3:
                System.out.print("Enter item name: ");
                String updateItemName = scanner.nextLine();
                if(inventory.containsKey(updateItemName)){
                    System.out.print("Enter new quantity: ");
                    int updateItemQuantity = scanner.nextInt();
                    scanner.nextLine();
                    inventory.put(updateItemName,updateItemQuantity);
                    System.out.println("Item quantity updated successfully.");
                    System.out.println("\nCurrent Inventory:");
                    for(Map.Entry<String,Integer> entry :inventory.entrySet()){
                        System.out.println("Item: "+entry.getKey() + ", Quantity: "+entry.getValue());
                    }
                }else{
                    System.out.println("Item not found in inventory.");
                }
                break;
            case 4:
                System.out.println("\nCurrent Inventory:");
                for(Map.Entry<String,Integer> entry :inventory.entrySet()){
                    System.out.println("Item: "+entry.getKey() + ", Quantity: "+entry.getValue());
                }
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
