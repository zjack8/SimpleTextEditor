package application;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SavepdfController {
	
	@FXML
	private TextField tf;
	@FXML
	private Button save;
	
	// Add a public no-args constructor
    public SavepdfController() {
    }

    @FXML
    private void initialize() {
    }
    
    @FXML
    private void Save() throws IOException, DocumentException {
    	// Save as pdf
    	Document document = new Document();
    	PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/saved/" + tf.getText().toString() + ".pdf"));

    	document.open();
    	Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
    	String[] s = EditorController.text.split("/n");
    	for (int i = 0; i < s.length; i++) {
    		Paragraph p = new Paragraph();
    		p.add(s[i]);
    		p.setFont(font);
        	document.add(p);
    	}
    	document.close();
		
		// Close window
		Stage stageToClose = (Stage) tf.getScene().getWindow();
    	stageToClose.close();
		
    }
}
