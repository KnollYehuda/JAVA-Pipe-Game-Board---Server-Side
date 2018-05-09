package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Collections;
import java.util.HashSet;
// import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

import Classes.CommonSearcher;
import Classes.Solution;
import Classes.State;
import Interface.Searchable;
import Interface.Searcher;

public class BestFirstSearch<T> extends CommonSearcher<T> implements Searcher<T>{

	Set<State<T>> closedSet = new HashSet<State<T>>();

	@Override
	public Solution<T> Search(Searchable<T> genericSearchable) {
		// System.out.println("Using BestFirstSearch Searcher:  ");
		Solution<T> solution = new Solution<T>();
		
		this.openList.add(genericSearchable.getInitialState());
		this.openList.peek().setCameFrom(null);
		this.openList.peek().setCost(0);
		
		State<T> currentState = new State<T>();
		
		//int counter=1;
		while(!openList.isEmpty())
		{
			Arrays.sort(openList.toArray()); // sort the PQ

			currentState = openList.poll();
			
			closedSet.add(currentState);
			//counter++;
			//System.out.println(currentState.getState().toString());
			//System.out.println("******************************** ==> "+counter);
			
			if(genericSearchable.IsGoalState(currentState))
			{
				do
				{
					solution.add(currentState.getState());
					currentState = currentState.getCameFrom();
				}while(currentState!=null);
				
				openList.clear();
				closedSet.clear();
				return solution;
			}
			
			ArrayList<State<T>> sourceNeighbors = new ArrayList<State<T>>(genericSearchable.getAllPossibleStates(currentState));
			
			for(int i=0; i<sourceNeighbors.size();i++)
			{
				if(!openClosedContainsNeighbor(sourceNeighbors.get(i),openList,closedSet))
				{
					sourceNeighbors.get(i).setCameFrom(currentState);
					openList.add(sourceNeighbors.get(i));
				}
		
			}
		}
		
		solution = updateSolution(currentState,solution);
		openList.clear();
		closedSet.clear();
		return solution;
	}
	
	private boolean openClosedContainsNeighbor(State<T> checkedState, PriorityQueue<State<T>> openList, Set<State<T>> closedSet) 
	{
		boolean flag = false;
		
//		Iterator<State<T>> openListItartor = openList.iterator();

//		while(openListItartor.hasNext())
//		{
//			if(checkedState.equals(openListItartor.next()))
//			{
//				flag = true;
//				return flag;
//			}
//			
//
//		}
		for(State<T> s : openList)
		{
			if(checkedState.equals(s) 
					&& checkedState.getState().toString().equals(s.getState().toString()))
			{
				flag = true;
				return flag;	
			}
		}

		for(State<T> s : closedSet)
		{
			if(checkedState.equals(s) 
					&& checkedState.getState().toString().equals(s.getState().toString()))
			{
				flag = true;
				return flag;	
			}
		}

		
		return flag;
	}

	public int getNumberOfNodesEvaluated() {
		return super.getEvaluatedNodes();
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
