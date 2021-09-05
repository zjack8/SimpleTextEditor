package application;

import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SavetxtController {
	
	@FXML
	private TextField tf;
	@FXML
	private Button save;
	
	// Add a public no-args constructor
    public SavetxtController() {
    }

    @FXML
    private void initialize() {
    }
    
    @FXML
    private void Save() throws IOException {
    	// Save
		FileWriter writer = new FileWriter("src/main/resources/saved/" + tf.getText().toString() + ".txt");
		writer.write(EditorController.text);
		writer.close();
		
		// Close window
		Stage stageToClose = (Stage) tf.getScene().getWindow();
    	stageToClose.close();
		
    }
}
