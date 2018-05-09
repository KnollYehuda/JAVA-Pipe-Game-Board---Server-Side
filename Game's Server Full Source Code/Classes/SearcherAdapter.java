package Classes;

import Interface.*;

public class SearcherAdapter<T> implements Solver<T> {

	// convert Searcher to Solver
	
	Searcher<T> searcher;
	
	public SearcherAdapter(Searcher<T> searcher) {
		this.searcher = searcher;
	}

	@Override
	public Solution<T> solve(Searchable<T> s) {
		return searcher.Search(s);
	}

//	@Override
//	public void changeSearcher(Searcher<T> searcher) {
//		this.searcher = searcher;
//	}
//	
}
