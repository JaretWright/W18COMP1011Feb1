
package models;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JWright
 */
public class TestJDBC
{
    public static void main(String[] args)
    {
        Contact contact = new Contact("Fred","Flintstone");
        try
        {
            contact.insertIntoDB();
        } catch (SQLException ex)
        {
            Logger.getLogger(TestJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
