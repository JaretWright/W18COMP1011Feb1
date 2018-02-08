/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JWright
 */
public class ProductTest
{
    
    public ProductTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getManufacturer method, of class Product.
     */
    @Test
    public void testGetManufacturer()
    {
        System.out.println("getManufacturer");
        Product instance = null;
        String expResult = "";
        String result = instance.getManufacturer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setManufacturer method, of class Product.
     */
    @Test
    public void testSetManufacturer()
    {
        System.out.println("setManufacturer");
        String manufacturer = "";
        Product instance = null;
        instance.setManufacturer(manufacturer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSku method, of class Product.
     */
    @Test
    public void testGetSku()
    {
        System.out.println("getSku");
        Product instance = null;
        String expResult = "";
        String result = instance.getSku();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSku method, of class Product.
     */
    @Test
    public void testSetSku()
    {
        System.out.println("setSku");
        String sku = "";
        Product instance = null;
        instance.setSku(sku);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductName method, of class Product.
     */
    @Test
    public void testGetProductName()
    {
        System.out.println("getProductName");
        Product instance = null;
        String expResult = "";
        String result = instance.getProductName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductName method, of class Product.
     */
    @Test
    public void testSetProductName()
    {
        System.out.println("setProductName");
        String productName = "";
        Product instance = null;
        instance.setProductName(productName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantityInStock method, of class Product.
     */
    @Test
    public void testGetQuantityInStock()
    {
        System.out.println("getQuantityInStock");
        Product instance = null;
        int expResult = 0;
        int result = instance.getQuantityInStock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantityInStock method, of class Product.
     */
    @Test
    public void testSetQuantityInStock()
    {
        System.out.println("setQuantityInStock");
        int quantityInStock = 0;
        Product instance = null;
        instance.setQuantityInStock(quantityInStock);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Product.
     */
    @Test
    public void testGetPrice()
    {
        System.out.println("getPrice");
        Product instance = null;
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Product.
     */
    @Test
    public void testSetPrice()
    {
        System.out.println("setPrice");
        double price = 0.0;
        Product instance = null;
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
