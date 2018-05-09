package Classes;

import Interface.StateGrader;

public class MyStateGrader implements StateGrader<PipeGameBoard> {
	
	@Override
	public double grade(State<PipeGameBoard> stateToGrade) {
		
		return stateToGrade.getState().calculateGrade(stateToGrade.getState());

	}
	
}