/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Contact;

/**
 * FXML Controller class
 *
 * @author JWright
 */
public class ContactViewController implements Initializable
{
    @FXML    private TableView<Contact> contactTableView;
    @FXML    private TableColumn<Contact, Integer> contactIDColumn;
    @FXML    private TableColumn<Contact, String> firstNameColumn;
    @FXML    private TableColumn<Contact, String> lastNameColumn;
    @FXML    private Button singleContactButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        singleContactButton.setDisable(true);
        
        //configure the columns
        contactIDColumn.setCellValueFactory(new PropertyValueFactory<Contact,Integer>("contactID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Contact,String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Contact,String>("lastName"));
        
        try
        {
            loadData();
        } catch (SQLException ex)
        {
            Logger.getLogger(ContactViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This will enable the "view contact" button when a Contact is selected
     */
    public void contactSelected()
    {
        if (contactTableView.getSelectionModel().getSelectedItem() != null)
            this.singleContactButton.setDisable(false);
    }
    
    /**
     * This method will add data to the TableView object
     */
    public void loadData() throws SQLException
    {
        //create an ObservableList object
        ObservableList<Contact> contactList = FXCollections.observableArrayList();
        
        //add "Contact" objects to the ObservableList
        contactList.add(new Contact(1,"Frank", "Enstein"));
        contactList.add(new Contact(2,"Harry", "Truman"));
        contactList.add(new Contact(3,"Lyndsay", "Vonn"));
        
        //read from the database
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
            
             //5.  Loop over the results and create Contact objects
            while (resultSet.next())
            {
                Contact newContact = new Contact(resultSet.getInt("contactID"),
                                                 resultSet.getString("firstName"),
                                                 resultSet.getString("lastName"));
                contactList.add(newContact);
            }
            
            //get the existing list from the TableView object and use the addAll method to add
            //the new list
            this.contactTableView.getItems().addAll(contactList);
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
        
        
    public void changeToPhoneScene(ActionEvent event) throws IOException
    {
        SceneChanger.changeScene(event, "PhoneView.fxml", "Cool phone view");
    }
    
    public void changeToSingleContactView(ActionEvent event) throws IOException
    {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("SingleContactView.fxml"));
//        Parent root = loader.load();
//        Scene scene = new Scene(root);
        
//        //access the controller class
//        SingleContactViewController controller = loader.getController();
        
        //select a Contact from the TableView object
        Contact contact = contactTableView.getSelectionModel().getSelectedItem();
        
        SceneChanger.changeScene(event, "SingleContactView.fxml", "My buddy", contact, new SingleContactViewController());
        
//        //pass that contact to the SingleContactViewController
//        controller.preloadData(contact);
//        
//        //get the stage and show the contact
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.setTitle("Contact Info");
//        stage.show();
        
    }
    
}
