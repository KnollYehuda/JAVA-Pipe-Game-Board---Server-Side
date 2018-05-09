package Algorithms;

import java.util.ArrayList;
import java.util.Stack;

import Classes.CommonSearcher;
import Classes.Solution;
import Classes.State;
import Interface.Searchable;
import Interface.Searcher;

public class DFS<T> extends CommonSearcher<T> implements Searcher<T> {

	private Stack<State<T>> stack = new Stack<State<T>>();
	private ArrayList<State<T>> neighbors = new ArrayList<State<T>>();
	private ArrayList<State<T>> explored = new ArrayList<State<T>>();

	@Override
	public Solution<T> Search(Searchable<T> genericSearchable) {
		// System.out.println("Using DFS Searcher:  ");
		Solution<T> solution = new Solution<T>();
		State<T> currentState = new State<T>();
		
		currentState = genericSearchable.getInitialState();
		stack.push(currentState);
		explored.add(currentState);
		
		//int counter = 1;
		
		while(!stack.isEmpty())
		{
			currentState = stack.pop();
			
			//System.out.println(currentState.getState().toString());
			//System.out.println("******************************** ==> "+counter);
			//counter++;
			
			if (genericSearchable.IsGoalState(currentState)) {
				do {
					solution.add(currentState.getState());
					currentState = currentState.getCameFrom();
				} while (currentState != null);

				stack.clear();
				explored.clear();
				return solution;
			}
			
			
			neighbors = new ArrayList<State<T>>(genericSearchable.getAllPossibleStates(currentState));

			for(int i=0; i< neighbors.size(); i++)
			{
				if (!openClosedContainsNeighbor(neighbors.get(i), explored)) 
				{
					stack.push(neighbors.get(i));
					explored.add(neighbors.get(i));
				}
			}
			
		}
		
		solution = updateSolution(currentState,solution);
		stack.clear();
		explored.clear();
		return solution;
	}

	private boolean openClosedContainsNeighbor(State<T> checkedState, ArrayList<State<T>> explored) 
	{
		boolean flag = false;

		for (State<T> s : explored) {
			if (checkedState.equals(s) && checkedState.getCameFrom().equals(s.getCameFrom()) 
					&& checkedState.getState().toString().equals(s.getState().toString())) {
				flag = true;
				return flag;
			}
		}

		return flag;
	}
	
	@Override
	public int getNumberOfNodesEvaluated() {
		// TODO Auto-generated method stub
		return 0;
	}

	private Solution<T> updateSolution(State<T> currentSolution, Solution<T> solution) {
		solution.clear();
		do {
			solution.add(currentSolution.getState());
			currentSolution = currentSolution.getCameFrom();
		} while (currentSolution != null);
		return solution;
	}
	
}
