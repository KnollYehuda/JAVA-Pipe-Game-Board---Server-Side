package view;

import javafx.scene.canvas.Canvas;

public class TileDisplayer extends Canvas{

	char value;
	int row;
	int col;
	String imagePath;
	
	public TileDisplayer(char value,int row,int col, String imagePath) {
		this.value = value;
		this.row = row;
		this.col = col;
		this.imagePath = imagePath;
	}
	
	public char getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
