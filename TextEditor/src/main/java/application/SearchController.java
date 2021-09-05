package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchController {
	
	public static int indexStart;
	public static int indexEnd;
	
	@FXML
	private Button search;
	@FXML
	private TextField tf;
	@FXML
	private Label errMsg;
	
	// Add a public no-args constructor
	public SearchController() {
	}

	@FXML
	private void initialize() {
	}
	
	@FXML
	private void Search() throws IOException {
		String text = EditorController.text;
		String searchword = tf.getText().toString();
		indexStart = text.indexOf(searchword);
		if (indexStart == -1) {
			errMsg.setText("Word Not Found");
			indexEnd = -1;
			// Opens new main window that initialises
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
		} else {
			indexEnd = indexStart + searchword.length();
			// Opens new main window that initialises
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
	        
			//Removes old window
			Stage stageToClose = (Stage) tf.getScene().getWindow();
			stageToClose.close();
		}
	}
	
}
