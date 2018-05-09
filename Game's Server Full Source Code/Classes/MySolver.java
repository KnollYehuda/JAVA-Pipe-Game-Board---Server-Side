package Classes;

import Interface.Searchable;
import Interface.Searcher;
import Interface.Solver;

public class MySolver<T> implements Solver<T> {
	
	Solver<T> solver;
	
	public MySolver(Searcher<T> searcher) {
		this.solver = new SearcherAdapter<T>(searcher);
	}

	@Override
	public Solution<T> solve(Searchable<T> s) {
		return this.solver.solve(s);
	}
//
//	public void changeSearcher(Searcher<T> searcher)
//	{
//		this.solver = new SearcherAdapter<T>(searcher);
//	}

}
