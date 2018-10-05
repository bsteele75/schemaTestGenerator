package schemaTester;
import org.json.simple.JSONObject;

public class SchemaRuleTypeTestGenerator {
	public static JSONObject createTestByRuleType(String ruleType, JSONObject rules) {
		JSONObject test = new JSONObject();
		
		if(ruleType.equals("string")) {
			test = createStringTests(rules);
			
		}else if(ruleType.equals("number")) {
			test = createNumberTests(rules);
			
		}else if(ruleType.equals("object")) {
			test = createObjectTests(rules);
			
		}else if(ruleType.equals("null")) {
			test = createNullTests(rules);
			
		}
		return test;
	}
	
	public static JSONObject createStringTests(JSONObject rules) {
		JSONObject test = new JSONObject();
		
		long minLength = 0;
		long maxLength = 0;
		
		//add a low boundary test
		if(rules.containsKey("minLength")) {
			minLength = (long) rules.get("minLength");
			test.put("belowBoundary", (minLength - 1));
		}
		//add a high boundary test
		if(rules.containsKey("maxLength")) {
			maxLength = (long) rules.get("maxLength");
			test.put("aboveBoundary", (maxLength + 1));
		}
		//add a passing boundary test
		long passing = minLength + (long) (Math.random() * (maxLength - minLength));
		test.put("passing", passing);
		
		return test;
	}
	
	public static JSONObject createNumberTests(JSONObject rules) {
		JSONObject test = new JSONObject();
		
		long maximum = 0;
		long minimum = 0;
		
		//add a low boundary test
		if(rules.containsKey("minimum")) {
			minimum = (long) rules.get("minimum");
			test.put("belowBoundary", (minimum - 1));
		}
		//add a high boundary test
		if(rules.containsKey("maximum")) {
			maximum = (long) rules.get("maximum");
			test.put("aboveBoundary", (maximum + 1));
		}
		//add a passing boundary test
		long passing = minimum + (long) (Math.random() * (maximum - minimum));
		test.put("passing", passing);
		
		return test;
	}
	
	public static JSONObject createObjectTests(JSONObject rules) {
		JSONObject test = new JSONObject();
		
		long minLength = 0;
		long maxLength = 0;
		
		//add a low boundary test
		if(rules.containsKey("minLength")) {
			minLength = (long) rules.get("minLength");
			test.put("belowBoundary", (minLength - 1));
		}
		//add a high boundary test
		if(rules.containsKey("maxLength")) {
			maxLength = (long) rules.get("maxLength");
			test.put("aboveBoundary", (maxLength + 1));
		}
		//add a passing boundary test
		long passing = minLength + (long) (Math.random() * (maxLength - minLength));
		test.put("passing", passing);
		
		return test;
	}
	
	public static JSONObject createNullTests(JSONObject rules) {
		JSONObject test = new JSONObject();
		
		test.put("nullTest", null);
		
		return test;
	}

}
