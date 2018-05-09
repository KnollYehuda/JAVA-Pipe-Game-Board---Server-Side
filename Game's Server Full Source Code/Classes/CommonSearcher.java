package Classes;

import java.util.Comparator;
import java.util.PriorityQueue;

import Interface.Searcher;

public abstract class CommonSearcher<T> implements Searcher<T> {

	protected PriorityQueue<State<T>> openList;
	
	private int evaluatedNodes;

	public CommonSearcher() 
	{
		openList = new PriorityQueue<State<T>>(new Comparator<State<T>>() 
		{  
	            public int compare(State<T> s1, State<T> s2) 
	            {                         
	                return Double.compare(s1.getCost(), s2.getCost());
	            }
		});

		evaluatedNodes = 0;
	}

	protected State<T> popOpenList() {
		evaluatedNodes++;
		return openList.poll();
	}

	public PriorityQueue<State<T>> getOpenList() {
		return openList;
	}

	public void setOpenList(PriorityQueue<State<T>> openList) {
		this.openList = openList;
	}

	public int getEvaluatedNodes() {
		return evaluatedNodes;
	}

	public void setEvaluatedNodes(int evaluatedNodes) {
		this.evaluatedNodes = evaluatedNodes;
	}
	

}
