package schemaTester;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;

public class JsonFileWriter {
	public static void writeJson(JSONObject allSchemaTests) {
		String outputFile = "src/schemaTests/schemaTests.json";

		try (FileWriter file = new FileWriter(outputFile)) {
			file.write(new GsonBuilder().setPrettyPrinting().create().toJson(new JsonParser().parse(allSchemaTests.toJSONString())));
//			file.write(allSchemaTests.toJSONString());
			file.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
