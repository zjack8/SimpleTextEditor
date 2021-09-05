package application;

import javafx.scene.layout.VBox;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Editor extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws IOException {
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
		stage.setScene(scene);
		// Set the Title to the Stage
		stage.setTitle("Text Editor");
		// Set icon Image
        stage.getIcons().add(new Image("file:src/main/resources/image/t.jpg"));
		// Display the Stage
		stage.show();
	}

}
