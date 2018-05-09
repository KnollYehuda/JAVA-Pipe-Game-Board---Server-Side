//package Classes;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.StringTokenizer;
//import java.util.concurrent.TimeUnit;
//
//import Interface.Searchable;
//
//public class PipeGameBoard implements Searchable<PipeGameBoard>{
//	
//	private Tile[][] pipeGameBoard;
//	private int rowSize;
//	private int colSize;
//	private Tile source;
//	private Tile goal;
//	private Tile current;
//	
//	public PipeGameBoard(String board)
//	{
//		this.pipeGameBoard = convertStringToBoard(board);
//		this.source = findSource(this.pipeGameBoard);
//		this.goal = findGoal(this.pipeGameBoard);
//		this.current = this.source;
//	}
//	
//	public PipeGameBoard(Tile[][] pipeGameBoard, int rowSize, int colSize, Tile source, Tile goal, Tile current) 
//	{		
//		this.pipeGameBoard=pipeGameBoard;
//		this.rowSize=rowSize;
//		this.colSize=colSize;
//		this.source=source;
//		this.goal=goal;
//		this.current = current;
//	}
//
//	private Tile findGoal(Tile[][] pipeGameBoard) {
//		
//		for(int i=0;i<rowSize;i++)
//			for(int j=0;j<colSize;j++)
//				if(pipeGameBoard[i][j].getValue().equals('g'))
//					return pipeGameBoard[i][j];
//		return null;
//	}
//
//	private Tile findSource(Tile[][] pipeGameBoard) {
//		for(int i=0;i<rowSize;i++)
//			for(int j=0;j<colSize;j++)
//				if(pipeGameBoard[i][j].getValue().equals('s'))
//					return pipeGameBoard[i][j];
//		return null;
//	}
//
//	public Tile getGoal() {
//		return goal;
//	}
//
//	public boolean equals(PipeGameBoard comparedBoard)
//	{
////		if(this.colSize != comparedBoard.getColSize() || this.rowSize != comparedBoard.getRowSize())
////			return false;
//		
//		for(int i=0;i<comparedBoard.getRowSize();i++)
//		{
//			for(int j=0;j<comparedBoard.getColSize();j++)
//				if(this.pipeGameBoard[i][j].getValue()!=comparedBoard.getPipeGameBoard()[i][j].getValue())
//					return false;
//		}
//		return true;
//	}
//	
//	@Override
//	public boolean equals(Object obj)
//	{
//		if(!(obj instanceof PipeGameBoard))
//		{
//			return false;
//		}
//		
//		if(obj==this)
//			return true;
//		
//		return this.equals((PipeGameBoard) obj);
//	}
//	
//	public ArrayList<Tile> getTileNeighbors(Tile currentTile)
//	{
//		ArrayList<Tile> neighborsArray = new ArrayList<Tile>();
//		
//		if(currentTile.getRow()-1 < 0 && currentTile.getCol()-1<0)
//		{
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()+1][currentTile.getCol()]);
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()+1]);
//		}
//		else if(currentTile.getRow()-1 < 0 && currentTile.getCol()+1 > this.getColSize()-1)
//		{
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()-1]);
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()+1][currentTile.getCol()]);
//		}
//		else if(currentTile.getRow()+1 > this.getRowSize()-1 && currentTile.getCol()-1 < 0)
//		{
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()-1][currentTile.getCol()]);
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()+1]);
//		}
//		else if(currentTile.getRow()+1 > this.getRowSize()-1 && currentTile.getCol()+1 > this.getColSize()-1)
//		{
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()-1]);
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()-1][currentTile.getCol()]);
//		}
//		
//		else if(currentTile.getRow()-1 < 0)
//		{
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()+1]);
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()-1]);
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()+1][currentTile.getCol()]);
//		}
//		else if(currentTile.getRow()+1 > this.getRowSize()-1)
//		{
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()+1]);
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()-1]);
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()-1][currentTile.getCol()]);
//		}
//		else if(currentTile.getCol()-1 < 0)
//		{
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()+1][currentTile.getCol()]);
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()-1][currentTile.getCol()]);
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()+1]);
//		}	
//		else if(currentTile.getCol()+1 > this.getColSize()-1)
//		{
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()+1][currentTile.getCol()]);
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()-1][currentTile.getCol()]);
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()-1]);
//		}
//		else
//		{
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()+1][currentTile.getCol()]);
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()-1][currentTile.getCol()]);
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()-1]);
//			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()+1]);
//		}
//		return neighborsArray;
//		
//	}
//	
//	/*public void calculateCost()
//	{
//	
//	}*/
//	
//	public Tile[][] convertStringToBoard(String board)
//	{
//		int i = 0;
//		int internalIndex=0;
//		Tile[][] pipeGameBoard = null;
//		StringTokenizer currentBoardTokenizer = new StringTokenizer(board, "\n");
//		List<String> currentBoardArrayList = new ArrayList<String>();
//		
//		while (currentBoardTokenizer.hasMoreTokens()) {
//			currentBoardArrayList.add(currentBoardTokenizer.nextToken());
//		}
//		
//		pipeGameBoard = new Tile[currentBoardArrayList.size()-1][currentBoardArrayList.get(0).length()];
//		
//		while (!currentBoardArrayList.get(i).equals("done")) {
//			for (internalIndex = 0; internalIndex < currentBoardArrayList.get(i).length(); internalIndex++) {
//				pipeGameBoard[i][internalIndex] = new Tile(i, internalIndex, currentBoardArrayList.get(i).charAt(internalIndex));
//			}
//
//			i++;
//		}
//		
//		this.colSize=currentBoardArrayList.get(0).length();
//		this.rowSize=currentBoardArrayList.size()-1;
//		
//		return pipeGameBoard;
//	}
//	
//	public void printBoard()
//	{
//		int i=0,j=0;
//		
//		for(i=0;i<this.rowSize;i++)
//		{
//			for(j=0;j<this.colSize;j++)
//				System.out.print(pipeGameBoard[i][j].getValue());
//			System.out.println();
//		}
//		
//		System.out.println("*******");
//	}
//	
//	protected boolean isSolved()
//	{
//		boolean flag=false;
//		
//		ArrayList<Tile> sourceNeighbors = new ArrayList<Tile>(this.getTileNeighbors(this.source));
//		
//		for(int i=0; i<sourceNeighbors.size(); i++)
//		{
//			flag = checkPath(sourceNeighbors.get(i), this.source);
//		}
//
//		return flag;
//	}
//	
//	protected boolean checkPath(Tile currentTile,Tile cameFrom)
//	{
//		if(checkLegalConnection(currentTile, cameFrom))
//		{
//			ArrayList<Tile> tileNeighbors = new ArrayList<Tile>(this.getTileNeighbors(currentTile));
//			
//			for(int i=0; i<tileNeighbors.size(); i++)
//			{
//				if(tileNeighbors.get(i) == cameFrom)
//					tileNeighbors.remove(i);
//			}
//	
//			
//			for(int i=0; i<tileNeighbors.size(); i++)
//			{
//				if(checkLegalConnection(currentTile,tileNeighbors.get(i)))
//					if(tileNeighbors.get(i).getValue() == this.goal.getValue())
//						 return true;
//					else
//						return checkPath(currentTile, tileNeighbors.get(i));
//			}
//			
//		}
//		
//		return false;
//	}
//
//	private boolean checkLegalConnection(Tile currentTile, Tile neighbor) {
//		if(currentTile.getValue()=='s' || currentTile.getValue()=='g')
//		{
//			// neighbor from right?
//			if(neighbor.getCol()>currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
//			{
//				if(neighbor.getValue()=='-' || neighbor.getValue()=='7' ||neighbor.getValue()=='J')
//					return true;
//			}	
//			// neighbor from left?
//			else if(neighbor.getCol()<currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
//			{
//				if(neighbor.getValue()=='-' || neighbor.getValue()=='L' ||neighbor.getValue()=='F')
//					return true;
//			}
//			
//			// neighbor from down?
//			else if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()>currentTile.getRow())
//			{
//				if(neighbor.getValue()=='|' || neighbor.getValue()=='L' ||neighbor.getValue()=='J')
//					return true;
//			}
//			
//			// neighbor from up?
//			else if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()<currentTile.getRow())
//			{
//				if(neighbor.getValue()=='|' || neighbor.getValue()=='7' ||neighbor.getValue()=='F')
//					return true;
//			}
//		}
//		else if(currentTile.getValue()=='|')
//		{
//			// neighbor from down?
//			if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()>currentTile.getRow())
//			{
//				if(neighbor.getValue()=='|' || neighbor.getValue()=='L' || neighbor.getValue()=='J'|| neighbor.getValue()=='s')
//					return true;
//			}
//			
//			// neighbor from up?
//			else if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()<currentTile.getRow())
//			{
//				if(neighbor.getValue()=='|' || neighbor.getValue()=='7' ||neighbor.getValue()=='F'|| neighbor.getValue()=='s')
//					return true;
//			}
//		}
//		
//		else if(currentTile.getValue()=='-')
//		{
//			// neighbor from right?
//			if(neighbor.getCol()>currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
//			{
//				if(neighbor.getValue()=='-' || neighbor.getValue()=='7' ||neighbor.getValue()=='J'|| neighbor.getValue()=='s')
//					return true;
//			}	
//			// neighbor from left?
//			else if(neighbor.getCol()<currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
//			{
//				if(neighbor.getValue()=='-' || neighbor.getValue()=='L' ||neighbor.getValue()=='F'|| neighbor.getValue()=='s')
//					return true;
//			}
//		}
//		else if(currentTile.getValue()=='F')
//		{
//			// neighbor from right?
//			if(neighbor.getCol()>currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
//			{
//				if(neighbor.getValue()=='-' || neighbor.getValue()=='7' ||neighbor.getValue()=='J'|| neighbor.getValue()=='s')
//					return true;
//			}
//			
//			// neighbor from down?
//			else if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()>currentTile.getRow())
//			{
//				if(neighbor.getValue()=='|' || neighbor.getValue()=='L' ||neighbor.getValue()=='J'|| neighbor.getValue()=='s')
//					return true;
//			}
//		}
//		
//		else if(currentTile.getValue()=='L')
//		{
//			// neighbor from right?
//			if(neighbor.getCol()>currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
//			{
//				if(neighbor.getValue()=='-' || neighbor.getValue()=='7' ||neighbor.getValue()=='J'|| neighbor.getValue()=='s')
//					return true;
//			}
//			
//			// neigbor from up?
//			else if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()<currentTile.getRow())
//			{
//				if(neighbor.getValue()=='|' || neighbor.getValue()=='7' ||neighbor.getValue()=='F'|| neighbor.getValue()=='s')
//					return true;
//			}
//		}
//		
//		else if(currentTile.getValue()=='7')
//		{
//			// neigbor from left?
//			if(neighbor.getCol()<currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
//			{
//				if(neighbor.getValue()=='-' || neighbor.getValue()=='L' ||neighbor.getValue()=='F'|| neighbor.getValue()=='s')
//					return true;
//			}
//			// neigbor from down?
//			else if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()>currentTile.getRow())
//			{
//				if(neighbor.getValue()=='|' || neighbor.getValue()=='L' || neighbor.getValue()=='J'|| neighbor.getValue()=='s')
//					return true;
//			}
//		}
//		
//		else if(currentTile.getValue()=='J')
//		{
//			// neigbor from left?
//			if(neighbor.getCol()<currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
//			{
//				if(neighbor.getValue()=='-' || neighbor.getValue()=='L' ||neighbor.getValue()=='F'|| neighbor.getValue()=='s')
//					return true;
//			}
//			//neigbor from up?
//			else if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()<currentTile.getRow())
//			{
//				if(neighbor.getValue()=='|' || neighbor.getValue()=='7' ||neighbor.getValue()=='F'|| neighbor.getValue()=='s')
//					return true;
//			}
//			
//		}
//		return false;
//	}
//
////	public void setSource(Tile source) {
////		this.source = source;
////	}
//
//	public int getRowSize() {
//		return rowSize;
//	}
//
//	public void setRowSize(int rowSize) {
//		this.rowSize = rowSize;
//	}
//
//	public int getColSize() {
//		return colSize;
//	}
//
//	public void setColSize(int colSize) {
//		this.colSize = colSize;
//	}
//
//	public Tile[][] getPipeGameBoard() {
//		return pipeGameBoard;
//	}
//
//	@Override
//	public State<PipeGameBoard> getInitialState() 
//	{
//		return new State<PipeGameBoard>(this);
//	}
//
//	/*@Override
//	public Collection<State<PipeGameBoard>> getAllPossibleStates(State<PipeGameBoard> sourceState) 
//	{
//		ArrayList<State<PipeGameBoard>> allPossibleStates = new ArrayList<State<PipeGameBoard>>();
//
//		State<PipeGameBoard> newState = new State<PipeGameBoard>();
//		
//		newState.setState(sourceState.getState());
//		int counter=1;
//		for (int i=0;i<sourceState.getState().getRowSize();i++)
//		{
//			for(int j=0;j<sourceState.getState().getColSize();j++)
//			{
//				      if(sourceState.getState().getPipeGameBoard()[i][j].getValue()!='s'
//						&& sourceState.getState().getPipeGameBoard()[i][j].getValue()!='g'
//						&& sourceState.getState().getPipeGameBoard()[i][j].getValue()!=' ')
//				{
//					newState.setState(copyBoard(sourceState.getState()));
//					newState.getState().pipeGameBoard[i][j].rotateTile();
//					allPossibleStates.add(newState);
//							
//					newState.getState().printBoard();
//					counter++;
//					try {
//						TimeUnit.MILLISECONDS.sleep(30);
//					} catch (InterruptedException e) {
//						//e.printStackTrace();
//					}
//					System.out.flush();
//				}
//			}
//		}		
//		
//		return allPossibleStates;
//	}*/
//
//	@Override
//	public Collection<State<PipeGameBoard>> getAllPossibleStates(State<PipeGameBoard> sourceState) 
//	{
//		ArrayList<State<PipeGameBoard>> allPossibleStates = new ArrayList<State<PipeGameBoard>>();
//		ArrayList<Tile> neighbors = new ArrayList<Tile>(sourceState.getState().getTileNeighbors(sourceState.getState().getCurrent()));
//		
//		State<PipeGameBoard> newState;
//		
//		int timesToRotate;
//		
//		for(int i=0;i<neighbors.size();i++)
//		{
//			  if(neighbors.get(i).getValue()!= ' ' && neighbors.get(i).getValue()!= 's' && neighbors.get(i).getValue()!= 'g')
//			  {
//				  if(neighbors.get(i).getValue()== '-' || neighbors.get(i).getValue()== '|')
//				  {
//					 timesToRotate = 2;
//					 for(int j=1; j<= timesToRotate; j++)
//					 {
//						newState = new State<PipeGameBoard>();
//						newState.setState(copyBoard(sourceState.getState()));
//						newState.getState().getPipeGameBoard()[neighbors.get(i).getRow()][neighbors.get(i).getCol()].rotateTile(j);
//						newState.setCameFrom(sourceState);
//						newState.getState().setCurrent(newState.getState().getPipeGameBoard()[neighbors.get(i).getRow()][neighbors.get(i).getCol()]);
//								
//						if(checkLegalConnection(newState.getState().getPipeGameBoard()[sourceState.getState().getCurrent().getRow()][sourceState.getState().getCurrent().getCol()], newState.getState().getPipeGameBoard()[neighbors.get(i).getRow()][neighbors.get(i).getCol()]) && !checkLoop(newState))
//						{
//							allPossibleStates.add(newState);
//
//						}
//					 }
//				  }
//				  else
//				  {
//					  timesToRotate = 4;
//					  for(int j=1; j<= timesToRotate; j++)
//						 {
//							newState = new State<PipeGameBoard>();
//							newState.setState(copyBoard(sourceState.getState()));
//							newState.getState().getPipeGameBoard()[neighbors.get(i).getRow()][neighbors.get(i).getCol()].rotateTile(j);
//							newState.setCameFrom(sourceState);
//							newState.getState().setCurrent(newState.getState().getPipeGameBoard()[neighbors.get(i).getRow()][neighbors.get(i).getCol()]);
//								
//							if(checkLegalConnection(newState.getState().getPipeGameBoard()[sourceState.getState().getCurrent().getRow()][sourceState.getState().getCurrent().getCol()], newState.getState().getPipeGameBoard()[neighbors.get(i).getRow()][neighbors.get(i).getCol()]) && !checkLoop(newState))
//							{
//								allPossibleStates.add(newState);
//
//							}
//						 }
//				  }
//					
//			  }
//		}
//
//		
//		
//		return allPossibleStates;
//	}
//	
//	private boolean checkLoop(State<PipeGameBoard> newState) {
//		boolean flag = false;
//		
//		State<PipeGameBoard> ancestorState = new State<PipeGameBoard>();
//		
//		if(newState.getCameFrom() == null)
//		{
//			flag = false;
//		}
//		
//		else 
//		{
//			ancestorState = newState.getCameFrom();
//			while(ancestorState.getCameFrom() != null)
//			{
//				if( ancestorState.getState() != null &&  (newState.getState().toString().equals(ancestorState.getState().toString()) && (newState.getState().getCurrent().getValue().equals(ancestorState.getState().getCurrent().getValue()))))
//				{
//					newState = ancestorState;
//					return true;
//				}
//				
//				ancestorState = ancestorState.getCameFrom();
//			}
//		}
//
//		
//		return flag;
//	}
//
//	private PipeGameBoard copyBoard(PipeGameBoard sourceBoard)
//	{
//		Tile[][] copiedBoard=new Tile[sourceBoard.getRowSize()][sourceBoard.getColSize()];
//		int copyRowSize=sourceBoard.getRowSize();
//		int copyColSize=sourceBoard.getColSize();
//		Tile copySource=sourceBoard.findSource(sourceBoard.getPipeGameBoard());
//		Tile copyGoal=sourceBoard.findGoal(sourceBoard.getPipeGameBoard());
//		Tile copyCurrent = sourceBoard.getCurrent();
//		
//		for(int i=0; i<sourceBoard.rowSize; i++)
//		{
//			for(int j=0; j< sourceBoard.colSize; j++)
//			{
//				copiedBoard[i][j]=new Tile(sourceBoard.pipeGameBoard[i][j].getRow(),sourceBoard.pipeGameBoard[i][j].getCol(),sourceBoard.pipeGameBoard[i][j].getValue());
//			}
//		}
//		
//		PipeGameBoard copiedPipeGameBoard=new PipeGameBoard(copiedBoard,copyRowSize,copyColSize,copySource,copyGoal, copyCurrent);
//		
//		return copiedPipeGameBoard;
//		
//	}
//
//	@Override
//	public boolean IsGoalState(State<PipeGameBoard> s) 
//	{
//		return s.getState().isSolved();
//	}
//
//	@Override
//	public String toString()
//	{
//		String solutionBoardString = "";
//		
//		for(int i=0;i<this.getRowSize();i++)
//		{
//			for(int j=0;j<this.getColSize();j++)
//			{
//				solutionBoardString+= this.getPipeGameBoard()[i][j].getValue();
//			}
//			
//			solutionBoardString += '\n';
//		}
//		
//		return solutionBoardString;
//		
//	}
//
//	public Tile getCurrent() {
//		return current;
//	}
//	
//	public void setCurrent(Tile current) {
//		this.current = current;
//	}
//}


package Classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import Interface.Searchable;

public class PipeGameBoard implements Searchable<PipeGameBoard>{
	
	private Tile[][] pipeGameBoard;
	private int rowSize;
	private int colSize;
	private Tile source;
	private Tile goal;
	private Tile current;
	
	public PipeGameBoard(String board)
	{
		this.pipeGameBoard = convertStringToBoard(board);
		this.source = findSource(this.pipeGameBoard);
		this.goal = findGoal(this.pipeGameBoard);
		this.current = this.source;
	}
	
	public PipeGameBoard(Tile[][] pipeGameBoard, int rowSize, int colSize, Tile source, Tile goal, Tile current) 
	{		
		this.pipeGameBoard=pipeGameBoard;
		this.rowSize=rowSize;
		this.colSize=colSize;
		this.source=source;
		this.goal=goal;
		this.current = current;
	}

	private Tile findGoal(Tile[][] pipeGameBoard) {
		
		for(int i=0;i<rowSize;i++)
			for(int j=0;j<colSize;j++)
				if(pipeGameBoard[i][j].getValue().equals('g'))
					return pipeGameBoard[i][j];
		return null;
	}

	private Tile findSource(Tile[][] pipeGameBoard) {
		for(int i=0;i<rowSize;i++)
			for(int j=0;j<colSize;j++)
				if(pipeGameBoard[i][j].getValue().equals('s'))
					return pipeGameBoard[i][j];
		return null;
	}

	public Tile getGoal() {
		return goal;
	}

	public boolean equals(PipeGameBoard comparedBoard)
	{
		if(this.current.equals(comparedBoard.getCurrent())
				&& this.current.getValue().equals(comparedBoard.getCurrent().getValue()))
			return true;
		return false;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof PipeGameBoard))
		{
			return false;
		}
		
		if(obj==this)
			return true;
		
		return this.equals((PipeGameBoard) obj);
	}
	
	private ArrayList<Tile> getTileNeighbors(Tile currentTile)
	{
		ArrayList<Tile> neighborsArray = new ArrayList<Tile>();
		
		if(this.rowSize==1 && this.colSize > 1)
		{
			// left edge
			if(currentTile.getCol() - 1 < 0)
			{
				neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()+1]);
			}
			
			// right edge
			else if(currentTile.getCol() + 1 >= this.colSize)
			{
				neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()-1]);
			}
			
			// center
			else if(currentTile.getCol()>0&& currentTile.getCol()<this.colSize)
			{
				neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()+1]);
				neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()-1]);
			}
		}
		
		
		else if(this.colSize==1 && this.rowSize > 1)
		{
			// up edge
			if(currentTile.getRow() - 1 < 0)
			{
				neighborsArray.add(this.pipeGameBoard[currentTile.getRow()+1][currentTile.getCol()]);
			}
			
			// bottom edge
			else if(currentTile.getRow() + 1 >= this.rowSize)
			{
				neighborsArray.add(this.pipeGameBoard[currentTile.getRow()-1][currentTile.getCol()]);
			}
			
			// center
			else if(currentTile.getRow()>0 && currentTile.getRow() < this.rowSize)
			{
				neighborsArray.add(this.pipeGameBoard[currentTile.getRow()-1][currentTile.getCol()]);
				neighborsArray.add(this.pipeGameBoard[currentTile.getRow()+1][currentTile.getCol()]);
			}
		}
		
		else if(currentTile.getRow()-1 < 0 && currentTile.getCol()-1<0)
		{
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()+1][currentTile.getCol()]);
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()+1]);
		}
		else if(currentTile.getRow()-1 < 0 && currentTile.getCol()+1 > this.getColSize()-1)
		{
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()-1]);
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()+1][currentTile.getCol()]);
		}
		else if(currentTile.getRow()+1 > this.getRowSize()-1 && currentTile.getCol()-1 < 0)
		{
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()-1][currentTile.getCol()]);
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()+1]);
		}
		else if(currentTile.getRow()+1 > this.getRowSize()-1 && currentTile.getCol()+1 > this.getColSize()-1)
		{
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()-1]);
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()-1][currentTile.getCol()]);
		}
		
		else if(currentTile.getRow()-1 < 0)
		{
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()+1]);
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()-1]);
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()+1][currentTile.getCol()]);
		}
		else if(currentTile.getRow()+1 > this.getRowSize()-1)
		{
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()+1]);
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()-1]);
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()-1][currentTile.getCol()]);
		}
		else if(currentTile.getCol()-1 < 0)
		{
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()+1][currentTile.getCol()]);
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()-1][currentTile.getCol()]);
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()+1]);
		}	
		else if(currentTile.getCol()+1 > this.getColSize()-1)
		{
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()+1][currentTile.getCol()]);
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()-1][currentTile.getCol()]);
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()-1]);
		}
		else
		{
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()+1][currentTile.getCol()]);
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()-1][currentTile.getCol()]);
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()-1]);
			neighborsArray.add(this.pipeGameBoard[currentTile.getRow()][currentTile.getCol()+1]);
		}
		return neighborsArray;
		
	}
	
	public Tile[][] convertStringToBoard(String board)
	{
		int i = 0;
		int internalIndex=0;
		Tile[][] pipeGameBoard = null;
		StringTokenizer currentBoardTokenizer = new StringTokenizer(board, "\n");
		List<String> currentBoardArrayList = new ArrayList<String>();
		
		while (currentBoardTokenizer.hasMoreTokens()) {
			currentBoardArrayList.add(currentBoardTokenizer.nextToken());
		}
		
		pipeGameBoard = new Tile[currentBoardArrayList.size()-1][currentBoardArrayList.get(0).length()];
		
		while (!currentBoardArrayList.get(i).equals("done")) {
			for (internalIndex = 0; internalIndex < currentBoardArrayList.get(i).length(); internalIndex++) {
				pipeGameBoard[i][internalIndex] = new Tile(i, internalIndex, currentBoardArrayList.get(i).charAt(internalIndex));
			}

			i++;
		}
		
		this.colSize=currentBoardArrayList.get(0).length();
		this.rowSize=currentBoardArrayList.size()-1;
		
		return pipeGameBoard;
	}
	
	public void printBoard()
	{
		int i=0,j=0;
		
		for(i=0;i<this.rowSize;i++)
		{
			for(j=0;j<this.colSize;j++)
			{
				//System.out.print(pipeGameBoard[i][j].getValue());
			}
			//System.out.println();
		}
		
		//System.out.println("*******");
	}
	
	protected boolean isSolved()
	{
		boolean flag=false;
		
		ArrayList<Tile> sourceNeighbors = new ArrayList<Tile>(this.getTileNeighbors(this.source));
		
		for(int i=0; i<sourceNeighbors.size(); i++)
		{
			flag = checkPath(sourceNeighbors.get(i),this.source);
			
			if(flag)
			{
				return flag;
			}
		}

		return flag;
	}
	
	protected boolean checkPath(Tile currentTile,Tile cameFrom)
	{
		if(checkLegalConnection(cameFrom,currentTile ))
		{
			ArrayList<Tile> tileNeighbors = new ArrayList<Tile>(this.getTileNeighbors(currentTile));
			
			for(int i=0; i<tileNeighbors.size(); i++)
			{
				if(tileNeighbors.get(i).equals(cameFrom))
					tileNeighbors.remove(i);
			}
	
			
			for(int i=0; i<tileNeighbors.size(); i++)
			{
				if(checkLegalConnection(tileNeighbors.get(i),currentTile))
					if(tileNeighbors.get(i).getValue() == this.goal.getValue())
						 return true;
					else
						return checkPath(tileNeighbors.get(i),currentTile);
			}
			
		}
		
		return false;
	}

	private boolean checkLegalConnection(Tile currentTile, Tile neighbor) {
		if(currentTile.getValue()=='s' || currentTile.getValue()=='g')
		{
			// neighbor from right?
			if(neighbor.getCol()>currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
			{
				if(neighbor.getValue()=='-' || neighbor.getValue()=='7' ||neighbor.getValue()=='J')
					return true;
			}	
			// neighbor from left?
			else if(neighbor.getCol()<currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
			{
				if(neighbor.getValue()=='-' || neighbor.getValue()=='L' ||neighbor.getValue()=='F')
					return true;
			}
			
			// neighbor from down?
			else if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()>currentTile.getRow())
			{
				if(neighbor.getValue()=='|' || neighbor.getValue()=='L' ||neighbor.getValue()=='J')
					return true;
			}
			
			// neighbor from up?
			else if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()<currentTile.getRow())
			{
				if(neighbor.getValue()=='|' || neighbor.getValue()=='7' ||neighbor.getValue()=='F')
					return true;
			}
		}
		else if(currentTile.getValue()=='|')
		{
			// neighbor from down?
			if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()>currentTile.getRow())
			{
				if(neighbor.getValue()=='|' || neighbor.getValue()=='L' || neighbor.getValue()=='J'|| neighbor.getValue()=='g')
					return true;
			}
			
			// neighbor from up?
			else if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()<currentTile.getRow())
			{
				if(neighbor.getValue()=='|' || neighbor.getValue()=='7' ||neighbor.getValue()=='F'|| neighbor.getValue()=='g')
					return true;
			}
		}
		
		else if(currentTile.getValue()=='-')
		{
			// neigbor from right?
			if(neighbor.getCol()>currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
			{
				if(neighbor.getValue()=='-' || neighbor.getValue()=='7' ||neighbor.getValue()=='J'|| neighbor.getValue()=='s')
					return true;
			}	
			// neighbor from left?
			else if(neighbor.getCol()<currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
			{
				if(neighbor.getValue()=='-' || neighbor.getValue()=='L' ||neighbor.getValue()=='F'|| neighbor.getValue()=='s')
					return true;
			}
		}
		else if(currentTile.getValue()=='F')
		{
			// neigbor from right?
			if(neighbor.getCol()>currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
			{
				if(neighbor.getValue()=='-' || neighbor.getValue()=='7' ||neighbor.getValue()=='J'|| neighbor.getValue()=='g')
					return true;
			}
			
			// neigbor from down?
			else if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()>currentTile.getRow())
			{
				if(neighbor.getValue()=='|' || neighbor.getValue()=='L' ||neighbor.getValue()=='J'|| neighbor.getValue()=='g')
					return true;
			}
		}
		
		else if(currentTile.getValue()=='L')
		{
			// neigbor from right?
			if(neighbor.getCol()>currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
			{
				if(neighbor.getValue()=='-' || neighbor.getValue()=='7' ||neighbor.getValue()=='J'|| neighbor.getValue()=='g')
					return true;
			}
			
			// neigbor from up?
			else if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()<currentTile.getRow())
			{
				if(neighbor.getValue()=='|' || neighbor.getValue()=='7' ||neighbor.getValue()=='F'|| neighbor.getValue()=='g')
					return true;
			}
		}
		
		else if(currentTile.getValue()=='7')
		{
			// neigbor from left?
			if(neighbor.getCol()<currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
			{
				if(neighbor.getValue()=='-' || neighbor.getValue()=='L' ||neighbor.getValue()=='F'|| neighbor.getValue()=='g')
					return true;
			}
			// neigbor from down?
			else if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()>currentTile.getRow())
			{
				if(neighbor.getValue()=='|' || neighbor.getValue()=='L' || neighbor.getValue()=='J'|| neighbor.getValue()=='g')
					return true;
			}
		}
		
		else if(currentTile.getValue()=='J')
		{
			// neigbor from left?
			if(neighbor.getCol()<currentTile.getCol() && neighbor.getRow()==currentTile.getRow())
			{
				if(neighbor.getValue()=='-' || neighbor.getValue()=='L' ||neighbor.getValue()=='F'|| neighbor.getValue()=='g')
					return true;
			}
			//neigbor from up?
			else if(neighbor.getCol()==currentTile.getCol() && neighbor.getRow()<currentTile.getRow())
			{
				if(neighbor.getValue()=='|' || neighbor.getValue()=='7' ||neighbor.getValue()=='F'|| neighbor.getValue()=='g')
					return true;
			}
			
		}
		return false;
	}

	public void setSource(Tile source) {
		this.source = source;
	}

	public Tile getSource() {
		return source;
	}

	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public int getColSize() {
		return colSize;
	}

	public void setColSize(int colSize) {
		this.colSize = colSize;
	}

	public Tile[][] getPipeGameBoard() {
		return pipeGameBoard;
	}

	@Override
	public State<PipeGameBoard> getInitialState() 
	{
		State<PipeGameBoard> initialState = new State<PipeGameBoard>(this);
		initialState.setCost(calculateCost(this));
		return initialState;
	}

	@Override
	public Collection<State<PipeGameBoard>> getAllPossibleStates(State<PipeGameBoard> sourceState) 
	{
		ArrayList<State<PipeGameBoard>> allPossibleStates = new ArrayList<State<PipeGameBoard>>();
		ArrayList<Tile> neighbors = new ArrayList<Tile>(sourceState.getState().getTileNeighbors(sourceState.getState().getCurrent()));
		
		State<PipeGameBoard> newState=new State<PipeGameBoard>();
		
		for(int i=0;i<neighbors.size();i++)
		{
			  if(neighbors.get(i).getValue()!= ' ' && neighbors.get(i).getValue()!= 's' && neighbors.get(i).getValue()!= 'g')
			  {
				  if(neighbors.get(i).getValue()== '-' || neighbors.get(i).getValue()== '|')
				  {
					  neighborsTimesToRotate(allPossibleStates,newState,sourceState,neighbors,2,i);
				  }
				  else
				  {
					  neighborsTimesToRotate(allPossibleStates,newState,sourceState,neighbors,4,i);
				  }
					
			  }
		}

		return allPossibleStates;
	} 
	
	private boolean checkLoop(State<PipeGameBoard> newState) {
		boolean flag = false;
		
		State<PipeGameBoard> ancestorState = new State<PipeGameBoard>();
		
		if(newState.getCameFrom() == null)
		{
			flag = false;
		}
		
		else 
		{
			ancestorState = newState.getCameFrom();
			while(ancestorState.getCameFrom() != null)
			{
				if(ancestorState.getState() != null 
						&& newState.getState().getCurrent().equals(ancestorState.getState().getCurrent())
						/*&&  (newState.getState().toString().equals(ancestorState.getState().toString())*/ 
						&& (newState.getState().getCurrent().toString().equals(ancestorState.getState().getCurrent().toString())))
				{
					newState = ancestorState;
					//ancestorState = newState;
					return true;
				}
				
				ancestorState = ancestorState.getCameFrom();
			}
		}

		
		return flag;
	}

	private PipeGameBoard copyBoard(PipeGameBoard sourceBoard)
	{
		Tile[][] copiedBoard=new Tile[sourceBoard.getRowSize()][sourceBoard.getColSize()];
		int copyRowSize=sourceBoard.getRowSize();
		int copyColSize=sourceBoard.getColSize();
		Tile copySource=sourceBoard.findSource(sourceBoard.getPipeGameBoard());
		Tile copyGoal=sourceBoard.findGoal(sourceBoard.getPipeGameBoard());
		Tile copyCurrent = sourceBoard.getCurrent();
		for(int i=0; i<sourceBoard.rowSize; i++)
		{
			for(int j=0; j< sourceBoard.colSize; j++)
			{
				copiedBoard[i][j]=new Tile(sourceBoard.pipeGameBoard[i][j].getRow(),sourceBoard.pipeGameBoard[i][j].getCol(),sourceBoard.pipeGameBoard[i][j].getValue());
			}
		}
		
		PipeGameBoard copiedPipeGameBoard=new PipeGameBoard(copiedBoard,copyRowSize,copyColSize,copySource,copyGoal, copyCurrent);
		
		return copiedPipeGameBoard;
		
	}

	@Override
	public boolean IsGoalState(State<PipeGameBoard> s) 
	{
		return s.getState().isSolved();
	}

	@Override
	public String toString()
	{
		String solutionBoardString = "";
		
		for(int i=0;i<this.getRowSize();i++)
		{
			for(int j=0;j<this.getColSize();j++)
			{
				solutionBoardString+= this.getPipeGameBoard()[i][j].getValue();
			}
			
			solutionBoardString += '\n';
		}
		
		return solutionBoardString;
		
	}

	public Tile getCurrent() {
		return current;
	}

	public void setCurrent(Tile current) {
		this.current = current;
	}

	private void neighborsTimesToRotate(ArrayList<State<PipeGameBoard>> allPossibleStates,State<PipeGameBoard> newState,State<PipeGameBoard> sourceState,ArrayList<Tile> neighbors,int timesToRotate,int i)
	{	
		for(int j=1; j<= timesToRotate; j++)
		 {
			newState = new State<PipeGameBoard>();
			newState.setState(copyBoard(sourceState.getState()));
			newState.getState().getPipeGameBoard()[neighbors.get(i).getRow()][neighbors.get(i).getCol()].rotateTile(j);
			newState.setCameFrom(sourceState);
			newState.getState().setCurrent(newState.getState().getPipeGameBoard()[neighbors.get(i).getRow()][neighbors.get(i).getCol()]);
			newState.setCost(calculateCost(newState.getState()));
			
			if(checkLegalConnection(newState.getState().getPipeGameBoard()[sourceState.getState().getCurrent().getRow()][sourceState.getState().getCurrent().getCol()], newState.getState().getPipeGameBoard()[neighbors.get(i).getRow()][neighbors.get(i).getCol()]) && !checkLoop(newState))
			{
				allPossibleStates.add(newState);
			}
		 }
	}
	
	public double calculateCost(PipeGameBoard pipeGameBoard)
	{
		return Math.abs(pipeGameBoard.getCurrent().getCol() - pipeGameBoard.getSource().getCol()) + Math.abs(pipeGameBoard.getCurrent().getRow() - pipeGameBoard.getSource().getRow()) ;
		// return Math.abs(pipeGameBoard.getCurrent().getCol() - pipeGameBoard.getGoal().getCol()) + Math.abs(pipeGameBoard.getCurrent().getRow() - pipeGameBoard.getGoal().getRow()) ;

	}

	public double calculateGrade(PipeGameBoard pipeGameBoard)
	{
		return Math.abs(pipeGameBoard.getCurrent().getCol() - pipeGameBoard.getGoal().getCol()) + Math.abs(pipeGameBoard.getCurrent().getRow() - pipeGameBoard.getGoal().getRow()) ;
	}
}

