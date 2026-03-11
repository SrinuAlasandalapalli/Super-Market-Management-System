import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;
    int quantity;

    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        System.out.println(id + "  " + name + "  " + price + "  " + quantity);
    }
}

public class SupermarketManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[5];

        products[0] = new Product(1, "Rice", 50, 10);
        products[1] = new Product(2, "Sugar", 40, 15);
        products[2] = new Product(3, "Milk", 30, 20);
        products[3] = new Product(4, "Oil", 120, 8);
        products[4] = new Product(5, "Bread", 25, 25);

        int choice;
        double totalBill = 0;

        do {

            System.out.println("\n===== SUPERMARKET MENU =====");
            System.out.println("1. Display Products");
            System.out.println("2. Buy Product");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.println("\nID  Name   Price   Quantity");
                    for(Product p : products) {
                        p.display();
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    for(Product p : products) {
                        if(p.id == id) {
                            if(qty <= p.quantity) {
                                double cost = qty * p.price;
                                totalBill += cost;
                                p.quantity -= qty;
                                System.out.println("Product added. Cost = " + cost);
                            } else {
                                System.out.println("Not enough stock.");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("Total Bill = " + totalBill);
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while(choice != 3);

        sc.close();
    }
}