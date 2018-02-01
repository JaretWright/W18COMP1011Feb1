package models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author JWright
 */
public class Phone extends Product{
    private int year;
    private String colour, cpu, OS;
    private double frontCameraRes, rearCameraRes;

    public Phone(int year, String colour, String cpu, String OS, double frontCameraRes, double rearCameraRes, String sku, String productName, String manufacturer, int quantityInStock, double price) {
        super(sku, productName, manufacturer, quantityInStock, price);
        setYear(year);
        setColour(colour);
        setCpu(cpu);
        setOS(OS);
        setFrontCameraRes(frontCameraRes);
        setRearCameraRes(rearCameraRes);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1973 && year < LocalDate.now().getYear()+1)
            this.year = year;
        else
            throw new IllegalArgumentException("Year for the phone must be 1973  to current year + 1");
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public double getFrontCameraRes() {
        return frontCameraRes;
    }

    public void setFrontCameraRes(double frontCameraRes) {
        if (frontCameraRes > 0 )
            this.frontCameraRes = frontCameraRes;
        else
            throw new IllegalArgumentException("Front Camera Resolution must be > 0");
    }

    public double getRearCameraRes() {
        return rearCameraRes;
    }

    public void setRearCameraRes(double rearCameraRes) {
         if (rearCameraRes > 0 )
            this.rearCameraRes = rearCameraRes;
        else
            throw new IllegalArgumentException("Rear Camera Resolution must be > 0");
    }

    /**
     * This method will return a List of valid manufacturers (normally this would come from a DB)
     */
    public static List<String> getManufacturers()
    {
        String [] manufacturerArray = {"Apple","Samsung","Sony","Nokia","LG","HTC","Blackberry"};
        List<String> list = Arrays.asList(manufacturerArray);
        Collections.sort(list);
        return list;
    }
    
   
    @Override
    public void setManufacturer(String manufacturer) {
        if (getManufacturers().contains(manufacturer))
            super.setManufacturer(manufacturer);
        else
            throw new IllegalArgumentException("Manufacturer can not be empty");
    }
    
    
}
