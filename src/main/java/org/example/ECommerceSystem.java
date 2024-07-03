package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ECommerceSystem {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Asus Dt505fx", 999.99));
        products.add(new Product(2, "iphone15", 499.99));
        products.add(new Product(3, "ipad 3", 299.99));

        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the E-Commerce System");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Product Listings:");
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID to add to cart: ");
                    int productId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    Product productToAdd = null;
                    for (Product product : products) {
                        if (product.getId() == productId) {
                            productToAdd = product;
                            break;
                        }
                    }
                    if (productToAdd != null) {
                        cart.addProduct(productToAdd, quantity);
                        System.out.println("Product added to cart.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.println("Shopping Cart:");
                    System.out.println(cart);
                    break;
                case 4:
                    System.out.println("Checkout");
                    System.out.println(cart);
                    System.out.println("Thank you for your purchase!");
                    cart = new ShoppingCart(); // Reset the cart after checkout
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
