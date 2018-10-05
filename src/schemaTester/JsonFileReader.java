package schemaTester;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFileReader {
	
	public static JSONArray fetchAllSchemas(String pathToDirectory) {
		JSONArray allRawSchemas = new JSONArray();
		ArrayList<String> jsonFilePaths = findAllFilesInDirectory(pathToDirectory);
		
		for(int i = 0; i < jsonFilePaths.size(); i++) {
			JSONObject rawSchema = readJsonFromFile(jsonFilePaths.get(i));
			allRawSchemas.add(rawSchema);
		}
		return allRawSchemas;
	}
	
	public static ArrayList<String> findAllFilesInDirectory(String pathToDirectory) {
        File folder = new File(pathToDirectory);
        File[] filesInFolder = folder.listFiles();
        ArrayList <String> foundFiles = new ArrayList<String>();

        for (int i = 0; i < filesInFolder.length; i++) {
            if (filesInFolder[i].isFile()) {
            	foundFiles.add(filesInFolder[i].toString());
            } else if (filesInFolder[i].isDirectory()) {
            }
        }
        return foundFiles;
    }
	
	
	public static JSONObject readJsonFromFile(String pathToFile) {
		JSONParser parser = new JSONParser();
		JSONObject rawSchema = new JSONObject();
		 
        try {
            Object obj = parser.parse(new FileReader(pathToFile));
 
            rawSchema = (JSONObject) obj;
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rawSchema;
	}	
}