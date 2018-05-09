package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

import Interface.CacheManager;


public class MyCacheManager implements CacheManager<PipeGameBoard> {
	
	String solutionsDirectoryPath;
	HashMap<String, File> solutionsMap = new HashMap<String, File>();
	Boolean exist=false;
	
	// Initialize the file cache manager
public MyCacheManager(String solutionsDirectoryPath) {
		
		this.solutionsMap = new HashMap<>();
		
		new File(solutionsDirectoryPath).mkdirs();
		
//		if(dir.exists())
//		{
			this.solutionsDirectoryPath = solutionsDirectoryPath;
			fillSolutionsMap(solutionsDirectoryPath);
//		}
//		else
//		{
//			dir.mkdir();
//		}

	}
	
	public void updateSolutionsMap(String solutionsDirectoryPath)
	{
		fillSolutionsMap(solutionsDirectoryPath);
	}
	
	// Fill solutionsMap with existing solutions
	private void fillSolutionsMap(String solutionsDirectoryPath) {
		File solutionsDir = new File(solutionsDirectoryPath);
		File[] listOfFiles = solutionsDir.listFiles();
		
		for(int i=0; i<listOfFiles.length;i++)
		{
			// put (LevelID, File pointer)
			solutionsMap.put(listOfFiles[i].getName().substring(0, listOfFiles[i].getName().length()-4), listOfFiles[i]);
		}
		
	}

	// check if solutionsMap contains solution according to the levelID
	@Override
	public String load(String levelID) 
	{
		if(solutionsMap.containsKey(levelID))
		{
			this.exist=true;
			return solutionsMap.get(levelID).getPath();
		}
		else
			this.exist=false;
			return null;
	}

	// send Client Handler the solution file AS A STRING
	public String getStringFromSolutionFile(String solutionFilePath) throws FileNotFoundException {

		BufferedReader reader = new BufferedReader(new FileReader(solutionFilePath));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");
		
	       try {
			while((line = reader.readLine()) != null) {
			        stringBuilder.append(line);
			        stringBuilder.append(ls);
			    }
		} catch (IOException e) {
			//e.printStackTrace();
		}
		
		return stringBuilder.toString();
		

	}
	
	@Override
	public void save(String levelID, String board) {
		try {
			PrintWriter writer = new PrintWriter(solutionsDirectoryPath+"\\"+levelID+".txt", "UTF-8");
			StringTokenizer boardToTokens=new StringTokenizer(board,"\n");
			while(boardToTokens.hasMoreTokens())
				writer.println(boardToTokens.nextToken());
			
			writer.close();
		}
		catch (Exception e){
		}
	}

	public boolean getExist()
	{
		return this.exist;
	}


}

//package Classes;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.StringTokenizer;
//
//import Interface.CacheManager;
//
//public class MyCacheManager implements CacheManager<PipeGameBoard> {
//	
//	String solutionsDirectoryPath;
//	HashMap<String, File> solutionsMap = new HashMap<String, File>();
//	Boolean exist=false;
//	
//	// Initialize the file cache manager
//	public MyCacheManager(String solutionsDirectoryPath) {
//		this.solutionsMap = new HashMap<>();
//		
//		File dir = new File(solutionsDirectoryPath);
//			
//		if(dir.exists())
//		{
//			this.solutionsDirectoryPath = solutionsDirectoryPath;
//			fillSolutionsMap(solutionsDirectoryPath);
//		}
//		else
//		{
//			dir.mkdir();
//		}
//	}
//	
//	public void updateSolutionsMap(String solutionsDirectoryPath)
//	{
//		fillSolutionsMap(solutionsDirectoryPath);
//	}
//	
//	// Fill solutionsMap with existing solutions
//	private void fillSolutionsMap(String solutionsDirectoryPath) {
//		File solutionsDir = new File(solutionsDirectoryPath);
//		File[] listOfFiles = solutionsDir.listFiles();
//		
//		for(int i=0; i<listOfFiles.length;i++)
//		{
//			// put (LevelID, File pointer)
//			solutionsMap.put(listOfFiles[i].getName().substring(0, listOfFiles[i].getName().length()-4), listOfFiles[i]);
//		}
//		
//	}
//
//	// check if solutionsMap contains solution according to the levelID
//	@Override
//	public String load(String levelID) 
//	{
//		if(solutionsMap.containsKey(levelID))
//		{
//			this.exist=true;
//			return solutionsMap.get(levelID).getPath();
//		}
//		else
//			this.exist=false;
//			return null;
//	}
//
//	// send Client Handler the solution file AS A STRING
//	public String getStringFromSolutionFile(String solutionFilePath) throws FileNotFoundException {
//
//		BufferedReader reader = new BufferedReader(new FileReader(solutionFilePath));
//		String line = null;
//		StringBuilder stringBuilder = new StringBuilder();
//		String ls = System.getProperty("line.separator");
//		
//	       try {
//			while((line = reader.readLine()) != null) {
//			        stringBuilder.append(line);
//			        stringBuilder.append(ls);
//			    }
//		} catch (IOException e) {
//			//e.printStackTrace();
//		}
//		
//		return stringBuilder.toString();
//		
//
//	}
//	
//	@Override
//	public void save(String levelID, String board) {
//		try {
//			FileWriter writer = new FileWriter(solutionsDirectoryPath+"\\"+levelID+".txt"/*, "UTF-8"*/);
//			StringTokenizer boardToTokens=new StringTokenizer(board,"\n");
//			while(boardToTokens.hasMoreTokens())
//				writer.write/*.println*/(boardToTokens.nextToken()+'\n');
//			
//			writer.close();
//		}
//		catch (Exception e){
//		}
//	}
//
//	public boolean getExist()
//	{
//		return this.exist;
//	}
//
//
//}

