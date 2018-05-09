package Interface;

import java.util.Collection;

import Classes.State;

public interface Searchable<T> {

	public State<T> getInitialState();
	
	public Collection<State<T>> getAllPossibleStates(State<T> s);
	
	public boolean IsGoalState(State<T> s);

}