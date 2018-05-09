package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Classes.CommonSearcher;
import Classes.Solution;
import Classes.State;
import Interface.Searchable;
import Interface.Searcher;

public class BFS<T> extends CommonSearcher<T> implements Searcher<T> {

	private Queue<State<T>> queue = new LinkedList<State<T>>();
	private ArrayList<State<T>> explored = new ArrayList<State<T>>();

	@Override
	public Solution<T> Search(Searchable<T> genericSearchable) {
		
		// System.out.println("Using BFS Searcher: ");
		
		Solution<T> solution = new Solution<T>();

		queue.add(genericSearchable.getInitialState());
		this.queue.peek().setCameFrom(null);
		this.queue.peek().setCost(0);

		State<T> currentState = new State<T>();

		//int counter=1;
		
		while (!queue.isEmpty()) 
		{
			currentState = queue.poll();
			
			//System.out.println(currentState.getState().toString());
			//System.out.println("******************************** ==> "+counter);
			//counter++;
			
			if (genericSearchable.IsGoalState(currentState)) {
				do {
					solution.add(currentState.getState());
					currentState = currentState.getCameFrom();
				} while (currentState != null);

				queue.clear();
				explored.clear();
				return solution;
			}

			else 
			{
				int i = 0;
				ArrayList<State<T>> sourceNeighbors = new ArrayList<State<T>>(genericSearchable.getAllPossibleStates(currentState));

				while (!sourceNeighbors.isEmpty()) {
					if (!openClosedContainsNeighbor(sourceNeighbors.get(i), queue, explored)) {
						queue.add(sourceNeighbors.get(i));
						
					}
					sourceNeighbors.remove(i);
				}
			}

			explored.add(currentState);
		}

		solution = updateSolution(currentState,solution);
		queue.clear();
		explored.clear();
		return solution;
	}

	private boolean openClosedContainsNeighbor(State<T> checkedState, Queue<State<T>> queue, ArrayList<State<T>> explored) 
	{
		boolean flag = false;

//		Iterator<State<T>> openListItartor = queue.iterator();
//
//		while (openListItartor.hasNext()) 
//		{
//			State<T> queueState = openListItartor.next();
//			if (checkedState.equals(queueState)) {
//				flag = true;
//				return flag;
//			}
//
//		}
		
		for (State<T> s : queue)
		{
			if (checkedState.equals(s) 
					&& checkedState.getState().toString().equals(s.getState().toString())) {
				flag = true;
				return flag;
			}
		}

		for (State<T> s : explored) {
			if (checkedState.equals(s)
					&& checkedState.getState().toString().equals(s.getState().toString())) {
				flag = true;
				return flag;
			}
		}

		return flag;
	}

	@Override
	public int getNumberOfNodesEvaluated() {

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
