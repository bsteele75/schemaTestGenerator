package schemaTester;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SchemaTestGenerator {
	
	public static JSONObject createSchemaTestsFromSchemaFiles(String pathToDirectory) {
		JSONArray allRawSchemas = JsonFileReader.fetchAllSchemas(pathToDirectory);

		JSONObject allSchemaTests = new JSONObject();
		
        for(Iterator iterator = allRawSchemas.iterator(); iterator.hasNext();) {
        	JSONObject schema = (JSONObject) iterator.next();
			
			String schemaName = (String) schema.get("schemaName");
			JSONObject schemaTests = (JSONObject) createTestsForEachRule(schema);
			
			allSchemaTests.put(schemaName, schemaTests);
        }
		return allSchemaTests;
	}
	
	public static JSONObject createTestsForEachRule(JSONObject rawSchema) {
		JSONObject schemaRules = (JSONObject) rawSchema.get("properties");
        JSONObject schemaTests = new JSONObject();
        
        //loop through all rules
        for(Iterator iterator = schemaRules.keySet().iterator(); iterator.hasNext();) {
            String ruleName = (String) iterator.next();
            JSONObject rules = (JSONObject) schemaRules.get(ruleName);
                
        	schemaTests.put(ruleName, createTestsForEachRuleType(rules));
        }
        return schemaTests;
	}
	
	
	public static JSONObject createTestsForEachRuleType(JSONObject rules) {
		JSONObject newSchemaTest = new JSONObject();
		Object ruleType = (Object) rules.get("type");
		
		//sometimes the schema type is an array of objects and not a single string, so we need to check and evaluate
		if(ruleType instanceof JSONArray) {
			//The object array will need to be converted to a string array if we want to pass a string value to our testController()
			String[] ruleTypeArray = copyJsonArrayToStringArray((JSONArray) ruleType);
			
		    //create tests for each type in String Array
			for(int i = 0; i < ruleTypeArray.length; i++) {
				newSchemaTest.put(ruleTypeArray[i], SchemaRuleTypeTestGenerator.createTestByRuleType(ruleTypeArray[i], rules));
			}
			
		}else {
			String ruleTypeString = (String) ruleType;
			newSchemaTest.put(ruleTypeString, SchemaRuleTypeTestGenerator.createTestByRuleType(ruleTypeString, rules));
		}
		
		return newSchemaTest;
	}
	
	public static String[] copyJsonArrayToStringArray(JSONArray jsonArray) {
		String[] ruleTypeArray = new String[jsonArray.size()]; //Create a new string array the same size as the JSONArray
		
		//convert and copy JSONArray elements to the new String Array
	    for(int i=0; i<ruleTypeArray.length; i++) {
	    	ruleTypeArray[i] = jsonArray.get(i).toString();
	    }
	    return ruleTypeArray;
	}
	
	

}
