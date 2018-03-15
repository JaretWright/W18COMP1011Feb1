package models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author JWright
 */
public class Product {
    private String sku, productName, manufacturer;
    private int quantityInStock;
    private double price;
    private String imageLocation;
    

    public Product(String sku, String productName, String manufacturer, int quantityInStock, double price) {
        setSku(sku);
        setProductName(productName);
        setManufacturer(manufacturer);
        setQuantityInStock(quantityInStock);
        setPrice(price);
        imageLocation = "./src/images/defaultPhone.jpg";
    }

    
    public String getImageLocation()
    {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation)
    {
        this.imageLocation = imageLocation;
    }

    
    
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if (!manufacturer.isEmpty())
            this.manufacturer = manufacturer;
        else
            throw new IllegalArgumentException("Manufacturer can not be empty");
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) 
    {
        if (!productName.isEmpty())
            this.productName = productName;
        else
            throw new IllegalArgumentException("Product name cannot be empty");
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        if (quantityInStock >= 0)
            this.quantityInStock = quantityInStock;
        else
            throw new IllegalArgumentException("Stock values must be positive");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0)
            this.price = price;
        else
            throw new IllegalArgumentException("Price must be greater than or equal to 0");
    }
    
    
}
