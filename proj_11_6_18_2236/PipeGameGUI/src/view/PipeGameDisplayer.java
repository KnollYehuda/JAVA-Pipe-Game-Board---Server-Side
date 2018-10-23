package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PipeGameDisplayer extends Canvas {

	public TileDisplayer[][] boardData;
	private StringProperty VerPipe;
	private StringProperty HorPipe;
	private StringProperty LPipe;
	private StringProperty SevenPipe;
	private StringProperty JPipe;
	private StringProperty FPipe;
	private StringProperty StartPipe;
	private StringProperty GoalPipe;
	private StringProperty EmptyPipe;
	public char[][] charBoardLevel;

	GraphicsContext gc;	
	
	public PipeGameDisplayer() {
		VerPipe = new SimpleStringProperty();
		HorPipe = new SimpleStringProperty();
		LPipe = new SimpleStringProperty();
		SevenPipe = new SimpleStringProperty();
		JPipe = new SimpleStringProperty();
		FPipe = new SimpleStringProperty();
		StartPipe = new SimpleStringProperty();
		GoalPipe = new SimpleStringProperty();
		EmptyPipe = new SimpleStringProperty();
		
	}

	
	// get data from controller to create the board
	public void createBoard(char[][] initialBoard) throws FileNotFoundException {
		
		// handle null board exception
		charBoardLevel = initialBoard;
		boardData = new TileDisplayer[initialBoard.length][initialBoard[0].length];
		
		for (int i = 0; i < initialBoard.length; i++) {
			for (int j = 0; j < initialBoard[i].length; j++) {
				boardData[i][j] = new TileDisplayer(initialBoard[i][j], i, j, getImagePath(initialBoard[i][j]));
				
			}
		}
		redraw();
	}
	
	public void redraw() throws FileNotFoundException
	{
		Double Width = getWidth();
		Double Height = getHeight();
		
		Double TileWidth = Width/boardData[0].length;
		Double TileHeight = Height/boardData.length;
		
		gc = getGraphicsContext2D();
		
		gc.clearRect(0, 0, Width, Height);
		
		for (int i = 0; i < boardData.length; i++) 
		{
			for (int j = 0; j < boardData[i].length; j++) 
			{
				gc.drawImage(new Image(new FileInputStream(boardData[i][j].getImagePath())), j*TileWidth, i*TileHeight, TileWidth, TileHeight);
			}
		}
	}
	
	public String getImagePath(char value)
	{
		switch (value) {
		case '-':
			return HorPipe.get();
		case '|':
			return VerPipe.get();
		case 'F':
			return FPipe.get();
		case '7':
			return SevenPipe.get();
		case 'J':
			return JPipe.get();
		case 'L':
			return LPipe.get();
		case 's':
			return StartPipe.get();
		case 'g':
			return GoalPipe.get();
		default:
			return EmptyPipe.get();
		}
	}


	
	public String getVerPipe() {
		return VerPipe.get();
	}


	
	public void setVerPipe(String verPipe) {
		VerPipe.set(verPipe);
	}


	public String getHorPipe() {
		return HorPipe.get();
	}


	public void setHorPipe(String horPipe) {
		HorPipe.set(horPipe);
	}


	public String getLPipe() {
		return LPipe.get();
	}


	public void setLPipe(String lPipe) {
		LPipe.set(lPipe);
	}


	public String getSevenPipe() {
		return SevenPipe.get();
	}


	public void setSevenPipe(String sevenPipe) {
		SevenPipe.set(sevenPipe);
	}


	public String getJPipe() {
		return JPipe.get();
	}


	public void setJPipe(String jPipe) {
		JPipe.set(jPipe);
	}


	public String getFPipe() {
		return FPipe.get();
	}


	public void setFPipe(String fPipe) {
		FPipe.set(fPipe);
	}


	public String getStartPipe() {
		return StartPipe.get();
	}


	public void setStartPipe(String startPipe) {
		StartPipe.set(startPipe);
	}


	public String getGoalPipe() {
		return GoalPipe.get();
	}


	public void setGoalPipe(String goalPipe) {
		GoalPipe.set(goalPipe);
	}


	public String getEmptyPipe() {
		return EmptyPipe.get();
	}


	public void setEmptyPipe(String emptyPipe) {
		EmptyPipe.set(emptyPipe);
	}


	
	
	
	public void click(double x, double y) {
		Double Width = getWidth();
		Double Height = getHeight();
		
		Double TileWidth = Width/boardData[0].length;
		Double TileHeight = Height/boardData.length;
		
		Double chosenRow;
		Double chosenCol;
		
		chosenRow = y/TileHeight;
		chosenCol = x/TileWidth;
		
		System.out.println(chosenRow.intValue() +" "+ chosenCol.intValue());
		
		try {
			rotate(chosenRow.intValue(),chosenCol.intValue());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}


	private void rotate(int row, int col) throws FileNotFoundException {
		switch (boardData[row][col].getValue()) {
		case '-':
			boardData[row][col] = new TileDisplayer('|', row, col, VerPipe.get());
			break;
		case '|':
			boardData[row][col] = new TileDisplayer('-', row, col, HorPipe.get());
			break;
		case 'F':
			boardData[row][col] = new TileDisplayer('7', row, col, SevenPipe.get());
			break;
		case '7':
			boardData[row][col] = new TileDisplayer('J', row, col, JPipe.get());
			break;
		case 'J':
			boardData[row][col] = new TileDisplayer('L', row, col, LPipe.get());
			break;
		case 'L':
			boardData[row][col] = new TileDisplayer('F', row, col, FPipe.get());
			break;
		}
		
		redraw();
		
	}

	@Override
	public double minHeight(double width) {
		return 64;
	}

	@Override
	public double maxHeight(double width) {
		return 1000;
	}

	@Override
	public double prefHeight(double width) {
		return minHeight(width);
	}

	@Override
	public double minWidth(double height) {
		return 0;
	}

	@Override
	public double maxWidth(double height) {
		return 10000;
	}

	@Override
	public boolean isResizable() {
		return true;
	}

	@Override
	public void resize(double width, double height) {
		super.setWidth(width);
		super.setHeight(height);
		try {
			redraw();
		} catch (FileNotFoundException e) {}
	}
	
	// get solution from controller (and rotate accordingly)


	
}
