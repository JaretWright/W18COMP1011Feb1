/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
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
public class PhoneTest
{
    Phone phone;
    
    public PhoneTest()
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
        phone = new Phone(2018, "Space Grey", "A35", "Android", 12.2, 18, "blah", 
                            "S9", "Samsung", 1000, 1200.32);
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getYear method, of class Phone.
     */
    @Test
    public void testGetYear()
    {
        int expResult = 2018;
        int result = phone.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of setYear method, of class Phone.
     */
    @Test
    public void testSetYearValid()
    {
        int year = 2018;
        phone.setYear(year);
        assertEquals(year, phone.getYear());
    }
    
    /**
     * Test of setYear method, of class Phone, test invalid year low.
     * This should throw an exception
     */
    @Test
    public void testSetYearInvalidLow()
    {
        int year = 1972;
        try{
            phone.setYear(year);
            fail("1972 is too old and should have thrown an exception");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
        
    }

    /**
     * Test of getColour method, of class Phone.
     */
    @Test
    public void testGetColour()
    {
        System.out.println("getColour");
        Phone instance = null;
        String expResult = "";
        String result = instance.getColour();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColour method, of class Phone.
     */
    @Test
    public void testSetColour()
    {
        System.out.println("setColour");
        String colour = "";
        Phone instance = null;
        instance.setColour(colour);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCpu method, of class Phone.
     */
    @Test
    public void testGetCpu()
    {
        System.out.println("getCpu");
        Phone instance = null;
        String expResult = "";
        String result = instance.getCpu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCpu method, of class Phone.
     */
    @Test
    public void testSetCpu()
    {
        System.out.println("setCpu");
        String cpu = "";
        Phone instance = null;
        instance.setCpu(cpu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOS method, of class Phone.
     */
    @Test
    public void testGetOS()
    {
        System.out.println("getOS");
        Phone instance = null;
        String expResult = "";
        String result = instance.getOS();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOS method, of class Phone.
     */
    @Test
    public void testSetOS()
    {
        System.out.println("setOS");
        String OS = "";
        Phone instance = null;
        instance.setOS(OS);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFrontCameraRes method, of class Phone.
     */
    @Test
    public void testGetFrontCameraRes()
    {
        System.out.println("getFrontCameraRes");
        Phone instance = null;
        double expResult = 0.0;
        double result = instance.getFrontCameraRes();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFrontCameraRes method, of class Phone.
     */
    @Test
    public void testSetFrontCameraRes()
    {
        System.out.println("setFrontCameraRes");
        double frontCameraRes = 0.0;
        Phone instance = null;
        instance.setFrontCameraRes(frontCameraRes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRearCameraRes method, of class Phone.
     */
    @Test
    public void testGetRearCameraRes()
    {
        System.out.println("getRearCameraRes");
        Phone instance = null;
        double expResult = 0.0;
        double result = instance.getRearCameraRes();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRearCameraRes method, of class Phone.
     */
    @Test
    public void testSetRearCameraRes()
    {
        System.out.println("setRearCameraRes");
        double rearCameraRes = 0.0;
        Phone instance = null;
        instance.setRearCameraRes(rearCameraRes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getManufacturers method, of class Phone.
     */
    @Test
    public void testGetManufacturers()
    {
        System.out.println("getManufacturers");
        List<String> expResult = null;
        List<String> result = Phone.getManufacturers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setManufacturer method, of class Phone.
     */
    @Test
    public void testSetManufacturer()
    {
        System.out.println("setManufacturer");
        String manufacturer = "";
        Phone instance = null;
        instance.setManufacturer(manufacturer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
