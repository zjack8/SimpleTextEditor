package application;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class EditorController{
	
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
    private void New() {
    	//TODO feature-1
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
    private void TD() {
    	//TODO feature-4
    }
    
    @FXML
    private void About() {
    	//TODO feature-5
    }
    
    @FXML
    private void SelectAll() {
    	//TODO feature-6
    }
    
    @FXML
    private void UnselectAll() {
    	//TODO feature-6
    }
    
    @FXML
    private void Cut() {
    	//TODO feature-7
    }
    
    @FXML
    private void Copy() {
    	//TODO feature-8
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
