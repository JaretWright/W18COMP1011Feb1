package views;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Phone;
import utilities.FileMove;

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
             private ToggleGroup osToggleGroup;

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
        imageLocation = "./src/images/defaultPhone.jpg";
        phoneImageView.setImage(new Image("file:"+imageLocation));
        phoneImageView.setPreserveRatio(true);
        phoneImageView.setSmooth(true);
        
        
        //Configure the front camera slider
        frontCamSlider.setMin(0);
        frontCamSlider.setMax(18);
        frontCamSlider.setValue(12);
        frontCamSlider.setBlockIncrement(2);
//        frontCamSlider.setShowTickMarks(true);
//        frontCamSlider.setShowTickLabels(true);
        frontCamLabel.setText(Double.toString(frontCamSlider.getValue()));   
        
        //Initialize the ToggleGroup, then add the radio buttons to it
        osToggleGroup = new ToggleGroup();
        iOSRadioButton.setToggleGroup(osToggleGroup);
        androidRadioButton.setToggleGroup(osToggleGroup);
        windowsRadioButton.setToggleGroup(osToggleGroup);
        iOSRadioButton.setSelected(true);
        
        this.getOS();
    }    
    
    /**
     * This will update the front camera label when the
     * slider is dragged with the mouse
     */
    public void frontCameraSliderDragged()
    {
        frontCamLabel.setText(String.format("%2.1f",frontCamSlider.getValue()));
    }
    
    
    /**
     * This method will use a FileChooser to set the Image in the ImageView
     */
    public void getNewImage(ActionEvent event) throws IOException
    {
        //get the Stage to open a new window
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        //Instantiate a FileChooser object
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image");
        
        //Create filters for .jpg and .png
        FileChooser.ExtensionFilter jpgFilter = 
                   new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fileChooser.getExtensionFilters().addAll(jpgFilter);
        
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
                imageLocation=tmpImageFile.getPath();
                phoneImageView.setImage(new Image("file:"+tmpImageFile.getPath()));
            };
        }
    }
    
    /**
     * This method will instantiate a phone object when the button is pushed
     */
    public void createButtonPushed() throws IOException
    {
        try
        {
            Phone phone = new Phone(this.yearSpinner.getValue(), 
                                    this.colourComboBox.getValue(), 
                                    "A11 bionic",  //hard coded for now 
                                    this.getOS(), 
                                    this.frontCamSlider.getValue(), 
                                    14,             //hard coded, you build the code 
                                    this.skuTextField.getText(), 
                                    this.modelTextField.getText(), 
                                    this.manfacturerComboBox.getValue(), 
                                    this.quantitySpinner.getValue(), 
                                    Double.parseDouble(this.priceTextField.getText()));
            
            //If the Phone object was created and it is not using the default image, move the image file to the images
            //directory and update the image
            if (!imageLocation.equals("./src/images/defaultPhone.jpg"))
            {
                File newFile = FileMove.copyFileToImagesDirectory(new File(imageLocation));
                phone.setImageLocation(newFile.getPath());
                phoneImageView.setImage(new Image("file:"+phone.getImageLocation()));
                
            }      
        }
        catch (IllegalArgumentException e)
        {
            System.err.println(e);
        }
                
    }
    
    /**
     * This method will return the String representation
     * of the operating system defined in the toggle group
     */
    public String getOS()
    {       
        return ((RadioButton) osToggleGroup.getSelectedToggle()).getText();
    }
    
    
    public void backButtonPushed(ActionEvent event) throws IOException
    {
        SceneChanger.changeScene(event, "ContactView.fxml", "Contacts");
    }
}
