package Interface;

import Classes.State;

public interface StateGrader<T> {
	
	public double grade(State<T> stateToGrade);

}
