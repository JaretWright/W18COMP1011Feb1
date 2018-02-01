
package views;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
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
        this.yearSpinner.setValueFactory(yearValueFactory);
        
    }    
    
}
