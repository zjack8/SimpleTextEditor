package application;

import java.io.File;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrintController {
	
	public ArrayList<String> files = new ArrayList();
	@FXML
	private Button print;
	@FXML
	private TextField tf;
	@FXML
	private ComboBox<Object> cb;

	// Add a public no-args constructor
    public PrintController() {
    }
     
    @FXML
    private void initialize() {
    	// Sets the items in the combo box by looking for all pdf files
    	File folder = new File("src/main/resources/saved");
    	File[] listOfFiles = folder.listFiles();
    	for (int i = 0; i < listOfFiles.length; i++) {
    		if (listOfFiles[i].isFile()) {
    			String name = listOfFiles[i].getName();
    			String type = name.substring(name.length()-3);
    			if (type.equals("pdf")) {
    				files.add(name);
    			}
    		  }
    	}
    	cb.setItems(FXCollections.observableArrayList(files.toArray()));
    }
    
    @FXML
    private void Print() {
    	// Ensure User has given input
    	if (tf.getText().toString().equals("")) {
    		
    	} else if (cb.getValue().toString() == null) {
    		
    	} else {
    		try {
				DirectPrint.print(cb.getValue().toString(), tf.getText().toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	// Close window
        Stage stageToClose = (Stage) cb.getScene().getWindow();
        stageToClose.close();
    }
	
}
