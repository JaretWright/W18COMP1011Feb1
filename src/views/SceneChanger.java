package views;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Contact;

/**
 *
 * @author JWright
 */
public class SceneChanger
{
    /**
     * This method will accept an event, the name of the fxml file and the title
     * for the new scene
     */
    public static void changeScene(ActionEvent event, String viewName, String title) throws IOException
    {
        //load the fxml file
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getResource(viewName));  //new Object is what allows
                                                                              //this to be a static method
        Parent parent = loader.load();
        
        //create the scene
        Scene scene = new Scene(parent);
        
        //get the Stage from the event
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * This method will allow us to change scenes and pass data into the new scene
     */
    public static void changeScene(ActionEvent event, String viewName, String title, Contact contact,
                        PreloadContactInterface controller) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getResource(viewName));
        Parent parent = loader.load();
        
        //access the controller class and preload the Contact
        controller = loader.getController();
        controller.preload(contact);
        
        Scene scene = new Scene(parent);
        
        //get the Stage from the event
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
        
    }        
}
