package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.Contact;

/**
 * FXML Controller class
 *
 * @author JWright
 */
public class SingleContactViewController implements Initializable, PreloadContactInterface
{
    @FXML private Label contactInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
    @Override
    public void preload(Contact contact)
    {
        this.contactInfo.setText(contact.getFirstName() + " " + contact.getLastName());
    }   
}
