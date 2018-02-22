package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author JWright
 */
public class Contact
{
    private int contactID;
    private String firstName, lastName;

    public Contact(int contactID, String firstName, String lastName)
    {
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Contact(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public void insertIntoDB() throws SQLException
    {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try
        {
            //1. Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + "comp1011Assign1?useSSL=false", "student","student");
            
            //2. Create a String to hold the SQL statement.  ? will be our
            //   user inputs
            String sql = "INSERT INTO contacts (firstName, lastName) VALUES"
                    + "(?,?)";
            
            //3. prepare the query
            ps = conn.prepareStatement(sql);
            
            //4. Bind the parameters
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            
            //5. execute the sql statement
            ps.execute();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            if (ps != null)
                ps.close();
            
            if (conn != null)
                conn.close();
        }
    }

    public int getContactID()
    {
        return contactID;
    }

    public void setContactID(int contactID)
    {
        this.contactID = contactID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    
}
