package application;

import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class EditorController {

	private String textToCopy;
	public static String text;

	@FXML
	public TextArea TA;
	@FXML
	private MenuItem Print;
	@FXML
	private MenuItem Save;
	@FXML
	private MenuItem Cut;
	@FXML
	private MenuItem Copy;
	@FXML
	private MenuItem Paste;
	@FXML
	private MenuItem Delete;
	@FXML
	private MenuItem SelectAll;
	@FXML
	private MenuItem UnselectAll;
	@FXML
	private MenuItem Find;
	@FXML
	private MenuItem Replace;
	@FXML
	private MenuItem About;
	@FXML
	private MenuItem Exit;

	// Add a public no-args constructor
	public EditorController() {
	}

	@FXML
	private void initialize() {
		// Sets intial text to "text"
		// This is for the Open function
		TA.setText(text);
		if (SearchController.indexStart != -1) {
			TA.selectRange(SearchController.indexStart, SearchController.indexEnd);
		}
	}

	@FXML
	private void New() throws IOException {
		// Opens New Window
		text = "";
		SearchController.indexStart = -1;
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
		Stage stageToClose = (Stage) TA.getScene().getWindow();
		stageToClose.close();
	}

	@FXML
	private void Open() throws IOException {
		// Opens Open Window
		// Create the FXMLLoader 
		FXMLLoader loader = new FXMLLoader();
		// Path to the FXML File
		String fxmlDocPath = "src/main/resources/fxml/open.fxml";
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
		stage.setTitle("Open file");
		stage.setResizable(false);
		stage.getIcons().add(new Image("file:src/main/resources/image/t.jpg"));
		// Display the Stage
		stage.show();
		//Removes old window
		Stage stageToClose = (Stage) TA.getScene().getWindow();
		stageToClose.close();
	}

	@FXML
	private void Exit() {
		// Closes current window
		Stage stageToClose = (Stage) TA.getScene().getWindow();
		stageToClose.close();
	}

	@FXML
	private void TD() throws IOException {
		// Opens Time & Date Window
		// Create the FXMLLoader 
		FXMLLoader loader = new FXMLLoader();
		// Path to the FXML File
		String fxmlDocPath = "src/main/resources/fxml/TD.fxml";
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
		stage.setTitle("Time and Date");
		stage.setResizable(false);
		stage.getIcons().add(new Image("file:src/main/resources/image/t.jpg"));
		// Display the Stage
		stage.show();
	}

	@FXML
	private void About() throws IOException {
		// Opens About Window
		// Create the FXMLLoader 
		FXMLLoader loader = new FXMLLoader();
		// Path to the FXML File
		String fxmlDocPath = "src/main/resources/fxml/about.fxml";
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
		stage.setTitle("About");
		stage.getIcons().add(new Image("file:src/main/resources/image/t.jpg"));
		// Display the Stage
		stage.show();
	}

	@FXML
	private void SelectAll() {
		// Highlights all text
		TA.selectAll();
	}


	@FXML
	private void Cut() {
		// Copies highlight text and removes it
		textToCopy = TA.getSelectedText();
		TA.setText(TA.getText().replace(TA.getSelectedText(),""));
	}

	@FXML
	private void Copy() {
		// Copies highlighted text
		textToCopy = TA.getSelectedText();
	}

	@FXML
	private void Paste() {
		// Pastes Saved text at Caret Position
		int caretPosition = TA.getCaretPosition();
		TA.insertText(caretPosition, textToCopy);
	}

	@FXML
	private void Savetxt() throws IOException {
		// Opens Print Window
		text = TA.getText().toString();
		// Create the FXMLLoader 
		FXMLLoader loader = new FXMLLoader();
		// Path to the FXML File
		String fxmlDocPath = "src/main/resources/fxml/savetxt.fxml";
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
		stage.setTitle("Save as .txt");
		stage.setResizable(false);
		stage.getIcons().add(new Image("file:src/main/resources/image/t.jpg"));
		// Display the Stage
		stage.show();
	}

	@FXML
	private void Savepdf() throws IOException {
		// Opens Savepdf Window
		text = TA.getText().toString();
		// Create the FXMLLoader 
		FXMLLoader loader = new FXMLLoader();
		// Path to the FXML File
		String fxmlDocPath = "src/main/resources/fxml/savepdf.fxml";
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
		stage.setTitle("Save as .pdf");
		stage.setResizable(false);
		stage.getIcons().add(new Image("file:src/main/resources/image/t.jpg"));
		// Display the Stage
		stage.show();
	}

	@FXML
	private void Search() throws IOException {
		// Opens Search Window
		text = TA.getText().toString();
		// Create the FXMLLoader 
		FXMLLoader loader = new FXMLLoader();
		// Path to the FXML File
		String fxmlDocPath = "src/main/resources/fxml/search.fxml";
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
		stage.setTitle("Search");
		stage.setResizable(false);
		stage.getIcons().add(new Image("file:src/main/resources/image/t.jpg"));
		// Display the Stage
		stage.show();
		//Removes old window
		Stage stageToClose = (Stage) TA.getScene().getWindow();
		stageToClose.close();
	}


	@FXML
	private void Print() throws IOException {
		// Opens Print Window
		// Create the FXMLLoader 
		FXMLLoader loader = new FXMLLoader();
		// Path to the FXML File
		String fxmlDocPath = "src/main/resources/fxml/print.fxml";
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
		stage.setTitle("Print pdf");
		stage.setResizable(false);
		stage.getIcons().add(new Image("file:src/main/resources/image/t.jpg"));
		// Display the Stage
		stage.show();
	}

}
