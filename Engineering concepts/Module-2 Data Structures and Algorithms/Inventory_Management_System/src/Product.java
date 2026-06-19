import java.util.*;

public class Product {

    HashMap<Integer, String> inventory = new HashMap<>();

    // Add Product
    public void addProduct(int id, String name) {
        if (inventory.putIfAbsent(id, name) == null) {
            System.out.println("Product added successfully");
        } else {
            System.out.println("Product already exists");
        }
    }

    // Update Product
    public void updateProduct(int id, String newName) {
        if (inventory.containsKey(id)) {
            inventory.put(id, newName);
            System.out.println("Product updated successfully");
        } else {
            System.out.println("Product not found");
        }
    }

    // Delete Produc
    public void deleteProduct(int id) {
        if (inventory.remove(id) != null) {
            System.out.println("Product deleted successfully");
        } else {
            System.out.println("Product not found");
        }
    }

    // Display Inventory
    public void displayProducts() {
        System.out.println(inventory);
    }

    public static void main(String[] args) {
        Product p = new Product();

        p.addProduct(101, "Laptop");
        p.addProduct(102, "Mouse");

        p.displayProducts();

        p.updateProduct(102, "Wireless Mouse");
        p.displayProducts();

        p.deleteProduct(101);
        p.displayProducts();
    }
}