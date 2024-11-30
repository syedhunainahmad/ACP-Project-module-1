import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Store {
    private String name;
    private String id;
    private String price;
    private String status;
    private List<Product> inventory;

    public Store(String name, String id, String price, String status) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.status = status;
        this.inventory = new ArrayList<>();
    }

    Store() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public List<Product> getInventory() {
        return inventory;
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void removeProduct(Product product) {
        inventory.remove(product);
    }

    // Method to save the inventory to the folder
    public void saveInventoryToFile(String filename) {
        String downloadsPath = "C:\\Users\\Syed Hunain Ahmad\\OneDrive\\Desktop\\products.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(downloadsPath + filename))) {
            for (Product product : inventory) {
                writer.write(product.toString());
                writer.newLine();
            }
            System.out.println("Inventory saved successfully to " + downloadsPath + filename);
        } catch (IOException e) {
            System.err.println("Error saving inventory: " + e.getMessage());
        }
    }

    // Method to load the inventory from the folder
    public void loadInventoryFromFile(String filename) {
        String downloadsPath ="C:\\Users\\Syed Hunain Ahmad\\OneDrive\\Desktop\\products.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(downloadsPath + filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productData = line.split(",");
                if (productData.length == 4) {
                    Product product = new Product(productData[0], productData[1], productData[2], productData[3]);
                    addProduct(product);
                }
            }
            System.out.println("Inventory loaded successfully from " + downloadsPath + filename);
        } catch (IOException e) {
            System.err.println("Error loading inventory: " + e.getMessage());
        }
    }

    public void displaySelectedRowData() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }
}
