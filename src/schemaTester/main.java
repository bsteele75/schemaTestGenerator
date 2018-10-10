package schemaTester;

import org.json.simple.*;



public class main {

    public static void main(String[] args) throws Exception {
        String directoryFilePath = "src/schemas";

        JSONObject allSchemaTests = SchemaTestGenerator.createSchemaTestsFromSchemaFiles(directoryFilePath);

        JsonFileWriter.writeJson(allSchemaTests);

        CallAPI.animalCreate();

    }
}





