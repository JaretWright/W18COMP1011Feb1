/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //configure the columns
        contactIDColumn.setCellValueFactory(new PropertyValueFactory<Contact,Integer>("contactID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Contact,String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Contact,String>("lastName"));
        
        loadData();
    }

    /**
     * This method will add data to the TableView object
     */
    public void loadData()
    {
        //create an ObservableList object
        ObservableList<Contact> contactList = FXCollections.observableArrayList();
        
        //add "Contact" objects to the ObservableList
        contactList.add(new Contact(1,"Frank", "Enstein"));
        contactList.add(new Contact(2,"Harry", "Truman"));
        contactList.add(new Contact(3,"Lyndsay", "Vonn"));
        
        //get the existing list from the TableView object and use the addAll method to add
        //the new list
        this.contactTableView.getItems().addAll(contactList);
    }
    
}
