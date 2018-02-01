
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    @FXML    private Spinner<?> quantitySpinner;
    @FXML    private Spinner<?> yearSpinner;
    @FXML    private ComboBox<?> colourComboBox;
    @FXML    private ComboBox<String> manfacturerComboBox;
    @FXML    private ComboBox<?> cpuComboBox;
    @FXML    private RadioButton iOSRadioButton;
    @FXML    private RadioButton androidRadioButton;
    @FXML    private RadioButton windowsRadioButton;
    @FXML    private Slider frontCamSlider;
    @FXML    private Label frontCamLabel;
    @FXML    private Slider rearCamSlider;
    @FXML    private Label rearCamLabel;
    @FXML    private ImageView phoneImageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //initialize the comboBox with valid manufacturers
        this.manfacturerComboBox.getItems().addAll(Phone.getManufacturers());
        this.manfacturerComboBox.getSelectionModel().selectFirst();
        
    }    
    
}
