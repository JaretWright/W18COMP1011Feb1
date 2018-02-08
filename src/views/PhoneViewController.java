
package views;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Phone;

/**
 * FXML Controller class
 *
 * @author JWright
 */
public class PhoneViewController implements Initializable
{
    @FXML    private TextField modelTextField;
    @FXML    private TextField skuTextField;
    @FXML    private TextField priceTextField;
    @FXML    private Spinner<Integer> quantitySpinner;
    @FXML    private Spinner<Integer> yearSpinner;
    @FXML    private ComboBox<String> colourComboBox;
    @FXML    private ComboBox<String> manfacturerComboBox;
    @FXML    private ComboBox<String> cpuComboBox;
    @FXML    private RadioButton iOSRadioButton;
    @FXML    private RadioButton androidRadioButton;
    @FXML    private RadioButton windowsRadioButton;
    @FXML    private Slider frontCamSlider;
    @FXML    private Label frontCamLabel;
    @FXML    private Slider rearCamSlider;
    @FXML    private Label rearCamLabel;
    @FXML    private ImageView phoneImageView;
             private String imageLocation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //initialize the comboBox with valid manufacturers
        this.manfacturerComboBox.getItems().addAll(Phone.getManufacturers());
        this.manfacturerComboBox.getSelectionModel().selectFirst();
        
        //example of adding prompt text, can also be performed directly in Scene Builder
        modelTextField.setPromptText("Enter model name");
        
        //Configuring the quantity in stock Spinner
        //Value factories define the range allowed inside the Spinner
        SpinnerValueFactory<Integer> quantityValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000, 10);
        this.quantitySpinner.setValueFactory(quantityValueFactory);
        this.quantitySpinner.setEditable(true);
        
        int currentYear = LocalDate.now().getYear();
        SpinnerValueFactory<Integer> yearValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1973,
                                                                                                currentYear+1, currentYear);
        yearSpinner.setValueFactory(yearValueFactory);
        
        //the ImageView requires an image object
        phoneImageView.setImage(new Image("file:./src/images/defaultPhone.jpg"));
    }    
    
    
    /**
     * This method will use a FileChooser to set the Image in the ImageView
     */
    public void getNewImage(ActionEvent event)
    {
        //get the Stage to open a new window
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        //Instantiate a FileChooser object
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image");
        
        //Create filters for .jpg and .png
        FileChooser.ExtensionFilter jpgFilter = 
                   new FileChooser.ExtensionFilter("Image File (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter pngFilter = 
                   new FileChooser.ExtensionFilter("Image File (*.png)", "*.png");
        fileChooser.getExtensionFilters().addAll(jpgFilter, pngFilter);
        
        //Set to the user's picture directory or user directory if not available
        String userDirectoryString = System.getProperty("user.home")+"\\Pictures";
        File userDirectory = new File(userDirectoryString);
        
        //check if the userDirectory exists
        if (!userDirectory.canRead())
            userDirectory = new File(System.getProperty("user.home"));
        
        //configure the fileChooser to use the starting directory
        fileChooser.setInitialDirectory(userDirectory);
                
        //Open the file dialog window
        File tmpImageFile = fileChooser.showOpenDialog(stage);
        
        if (tmpImageFile != null)
        {
            //update the ImageView with the new image
            if (tmpImageFile.isFile())
            {
                phoneImageView.setImage(new Image("file:"+tmpImageFile.getPath()));
                
                imageLocation = tmpImageFile.getPath();
            }
        }
    }
}
