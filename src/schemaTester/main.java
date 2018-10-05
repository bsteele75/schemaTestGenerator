package schemaTester;

import org.json.simple.JSONObject;

public class main {

	public static void main(String[] args) {
		String directoryFilePath = "src/schemas";
   
		JSONObject allSchemaTests = SchemaTestGenerator.createSchemaTestsFromSchemaFiles(directoryFilePath);
		
		System.out.println(allSchemaTests);
		
		JsonFileWriter.writeJson(allSchemaTests);
		
	}
}
