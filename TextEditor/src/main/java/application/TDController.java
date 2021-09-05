package application;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TDController {
	
	@FXML
	private Label TD;
	
	// Add a public no-args constructor
    public TDController() {
    }

    @FXML
    private void initialize() {
    	// Finds current time and date and sets label text on intialisation
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
		TD.setText(formatter.format(date));
    }
}
