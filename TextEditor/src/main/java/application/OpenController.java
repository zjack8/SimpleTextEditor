package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OpenController {
	
	public ArrayList<String> files = new ArrayList();
	
	@FXML
	private Button open;
	@FXML
	private ComboBox<Object> cb;
	
    // Add a public no-args constructor
    public OpenController() {
    }
     
    @FXML
    private void initialize() {
    	// Sets the items in the combo box by looking for all txt files
    	File folder = new File("src/main/resources/saved");
    	File[] listOfFiles = folder.listFiles();
    	for (int i = 0; i < listOfFiles.length; i++) {
    		if (listOfFiles[i].isFile()) {
    			String name = listOfFiles[i].getName();
    			String type = name.substring(name.length()-3);
    			if (type.equals("txt")) {
    				files.add(name);
    			} else if (type.equals("odt")) {
    				// Not to be implemented
    			}
    		  }
    	}
    	cb.setItems(FXCollections.observableArrayList(files.toArray()));
    }
    
    @FXML
    private void Open() throws IOException {
    	String name = cb.getValue().toString();
    	String type = name.substring(name.length()-3);
    	if (type.equals("txt")) {
    		FileReader reader = new FileReader("src/main/resources/saved/" + name);
            int i;
            String word = "";
            while((i=reader.read())!=-1) {
            	char c = (char) i;
            	word = word + c;
            }
            EditorController.text = word;
            reader.close();
    	} else if (type.equals("odt")) {
			// Not to be implemented
		}
    	
    	// Opens new main window that initialises with open txt
    	// Create the FXMLLoader 
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        String fxmlDocPath = "src/main/resources/fxml/TextEditorLayout.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

        // Create the Pane and all Details
        VBox root = new VBox();
        root = (VBox) loader.load(fxmlStream);

        // Create the Scene
        Scene scene = new Scene(root);
        // Set the Scene to the Stage
        Stage stage = new Stage();
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("Text Editor");
        stage.getIcons().add(new Image("file:src/main/resources/image/t.jpg"));
        // Display the Stage
        stage.show();
        
        // Closes Open Window
        Stage stageToClose = (Stage) cb.getScene().getWindow();
        stageToClose.close();
    }
}
