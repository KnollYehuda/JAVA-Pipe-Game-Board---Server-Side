package Classes;

import java.io.Serializable;

public class State<T> implements Comparable<State<T>>, Serializable{
		
	private static final long serialVersionUID = 1L;
	private T state; //the state represented by T
	private double cost; //cost to reach this state
	private State<T> cameFrom; // the state we came from to this state
	
	
	public State() {
		super();
	}
	
	public State(T state)
	{
		super();
		this.state = state;
	}
	
	public State(T state, double cost, State<T> cameFrom)
	{
		super();
		this.state = state;
		this.cost = cost;
		this.cameFrom = cameFrom;
	}
	
	@Override
	public int compareTo(State<T> stateToCompare) {
		if(this.state.equals(stateToCompare.getState()) 
				&& this.cameFrom == stateToCompare.cameFrom)
		{
			return 1;
		}
		
		return 0;
	}
	
	public T getState() {
		return state;
	}
	
	public void setState(T state) {
		this.state = state;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public State<T> getCameFrom() {
		return cameFrom;
	}
	
	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
	}
	
	@Override
	public String toString()
	{
		return this.state.toString();
	}

	public boolean equals(State<T> comparedState) {
//		return this.state.toString().equals(comparedState.getState().toString());
		if(this.getState().equals(comparedState.getState()))
			return true;
		return false;
	}
 
}
