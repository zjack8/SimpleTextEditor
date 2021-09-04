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
	private TextArea TA;
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
    }
    
    @FXML
    private void New() throws IOException {
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

        Stage stageToClose = (Stage) TA.getScene().getWindow();
        stageToClose.close();
    }
	
    @FXML
    private void Open() {
    	//TODO feature-2
    }
    
    @FXML
    private void Exit() {
    	Stage stageToClose = (Stage) TA.getScene().getWindow();
    	stageToClose.close();
    }
    
    @FXML
    private void TD() throws IOException {
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
    private void About() {
    	//TODO feature-5
    }
    
    @FXML
    private void SelectAll() {
    	TA.selectAll();
    }
    
    
    @FXML
    private void Cut() {
        textToCopy = TA.getSelectedText();
        TA.setText(TA.getText().replace(TA.getSelectedText(),""));
    }
    
    @FXML
    private void Copy() {
        textToCopy = TA.getSelectedText();
    }
    
    @FXML
    private void Paste() {
        int caretPosition = TA.getCaretPosition();
        TA.insertText(caretPosition, textToCopy);
    }
    
    @FXML
    private void Save() {
    	//TODO feature-10
    }
    
    @FXML
    private void Search() {
    	//TODO feature-11
    }
    
    
    @FXML
    private void Print() {
    	//TODO feature-12
    }
    
}
