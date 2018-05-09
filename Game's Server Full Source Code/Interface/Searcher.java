package Interface;

import Classes.Solution;

public interface Searcher<T> {

		public Solution<T> Search(Searchable<T> s);
		
		public int getNumberOfNodesEvaluated();

}
