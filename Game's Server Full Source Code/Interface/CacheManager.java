package Interface;

import java.io.FileNotFoundException;

public interface CacheManager<T> {

	//public String checkIfExistingSolution(String currentBoard);
	
	public void save(String levelID, String board);
	
	public String load(String levelID);

	public String getStringFromSolutionFile(String solutionFilePath) throws FileNotFoundException;
	
	public boolean getExist();
	
	public void updateSolutionsMap(String solutionsDirectoryPath);
}