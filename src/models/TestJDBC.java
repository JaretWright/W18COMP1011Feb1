
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JWright
 */
public class TestJDBC
{
    public static void main(String[] args) throws SQLException
    {
        //display the contents of the table to the console
        //1. create the connection, resultSet and statement objects
        Connection conn=null;
        Statement statement=null;
        ResultSet resultSet=null;   //this holds the results from the DB
        
        try{
            //2. connect to the database
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306"
                    + "/comp1011Assign1?useSSL=false", "student","student");
            
            //3. create a statement object
            statement = conn.createStatement();
            
            //4.  create the SQL query
            resultSet = statement.executeQuery("SELECT * FROM contacts");
            
            //5. Get the header information
            ResultSetMetaData rsMetaData = resultSet.getMetaData();
            
            for (int col=1; col<=rsMetaData.getColumnCount(); col++)
                System.out.printf("%-15s", rsMetaData.getColumnName(col));
            
            System.out.println();
            //6.  display the rows of data
            while (resultSet.next())
            {
                System.out.printf("%-15d%-15s%-15s%n", resultSet.getInt("contactID"),
                                                    resultSet.getString("firstName"),
                                                    resultSet.getString("lastName"));
            }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        finally
        {
            if (conn!=null) conn.close();
            if (statement!=null) statement.close();
            if (resultSet!=null) resultSet.close();
        }
    }
}
