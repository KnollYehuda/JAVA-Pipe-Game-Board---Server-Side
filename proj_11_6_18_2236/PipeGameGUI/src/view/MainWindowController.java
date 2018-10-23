package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class MainWindowController implements Initializable{
	
	public PipeGameDisplayer pipeGameDisplayer;
	
	char[][] exampleBoard = { { 's', '-', '-', '-', '-', '-', '-', 'L' },
							  { 'L', '-', '|', '-', '-', '|', '-', 'L' },
							  { 'L', '-', '-', '-', '-', '-', '-', 'L' },
							  { 'L', '-', '-', '|', '-', '-', '-', 'g' } };
	// get the data aka Open File
	@FXML
	public void openFile() throws IOException
	{
		ArrayList<String> newLevelArrayList = new ArrayList<String>();
		
		char[][] newLevel;
		String line = null;
		File f;
		FileChooser chooser = new FileChooser();
	    chooser.setTitle("Open File");
	    f = chooser.showOpenDialog(null);
	    BufferedReader reader = new BufferedReader(new FileReader(f));
	    
	    while((line = reader.readLine()) != null)
				newLevelArrayList.add(line);
	    
	    newLevel = new char[newLevelArrayList.size()][];
	    
	    for(int i=0; i<newLevelArrayList.size();i++)
	    {
	    	newLevel[i] = newLevelArrayList.get(i).toCharArray();
	    }
	    
	    pipeGameDisplayer.createBoard(newLevel);
	}

	// call to solve
	
	
	// mouse listener
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			pipeGameDisplayer.createBoard(exampleBoard);
		} catch (FileNotFoundException e) {}
		
		pipeGameDisplayer.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				pipeGameDisplayer.click(event.getX(),event.getY());
			}
		});
	}
}
