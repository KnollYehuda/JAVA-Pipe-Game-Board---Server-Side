package Classes;

public class Tile {
	private Character value;
	private Integer row;
	private Integer col;
	
	public Tile(Integer row,Integer col,Character value)
	{
		this.row=row;
		
		this.col=col;

		this.value=value;
	}

	public void rotateTile()
	{
		switch (this.getValue())
		{
			case 'L':
			{
				this.setValue('F');
				break;
			}
			case 'F':
			{
				this.setValue('7');
				break;
			}
			case '7':
			{
				this.setValue('J');
				break;
			}
			case 'J':
			{
				this.setValue('L');
				break;
			}
			case '-':
			{
				this.setValue('|');
				break;
			}
			case '|':
			{
				this.setValue('-');
				break;
			}
			default:
				break;
		}
	}
	
	public void rotateTile(Tile t)
	{
		switch (t.getValue())
		{
			case 'L':
			{
				t.setValue('F');
				break;
			}
			case 'F':
			{
				t.setValue('7');
				break;
			}
			case '7':
			{
				t.setValue('J');
				break;
			}
			case 'J':
			{
				t.setValue('L');
				break;
			}
			case '-':
			{
				t.setValue('|');
				break;
			}
			case '|':
			{
				t.setValue('-');
				break;
			}
			default:
				break;
		}
	}
	
	public void rotateTile(int timesToRotate)
	{
		for(int i=0; i<timesToRotate; i++)
		{
			this.rotateTile();
		}
	}
	
	public Character getValue() 
	{
		return value;
	}

	public void setValue(Character value) 
	{
		this.value = value;
	}

	public Integer getRow() 
	{
		return row;
	}

	public void setRow(Integer row) 
	{
		this.row = row;
	}

	public Integer getCol() 
	{
		return col;
	}

	public void setCol(Integer col) 
	{
		this.col = col;
	}
	
	public boolean equals(Tile comparedTile)
	{
		
		if(this.col==comparedTile.getCol() && this.row==comparedTile.getRow())
			return true;
		return false;
	}
	
	public String toString()
	{
		return new String("{"+this.row+","+this.col+"}");
	}
}
