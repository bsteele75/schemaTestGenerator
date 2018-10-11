package schemaTester;

import org.json.simple.*;



public class main {

    public static void main(String[] args) throws Exception {

        FixtureData data = new FixtureData();
        Helpers example = new Helpers();

        String credsJson = data.vetCredsJson(); // credsJson = {"username": "vet1", "password": "pass1234", "apiKey": "GVL"}

        String token = example.getTokenRequest("https://regression.globalvetlink.com/gvl2/api/gettoken", credsJson); // token = {tokenCreateByTheCall}
        System.out.println("here is the token: " + token + "\n");

        // declare variable and store data to be updated in it
        String contactEditData = data.contactFirstName("Poem");
        System.out.println("here is the data I plan to update: \n" + contactEditData + "\n");

        String url = data.REG_BASE_URL() + "origin/2091345";
        System.out.println("here is the url: " + url + "\n");

        String thing = example.doGetRequest(url, token);
        System.out.println("here is the damn contact data: \n" + thing + "\n");

        // declare variable and store updated response data in it

        String editContactResponse = example.doPostRequest(data.REG_BASE_URL() + "origin/2091345", contactEditData, token);
        System.out.println("here is the response: " + editContactResponse);
    }
}



// THIS IS ALL THE ORIGINAL CODE FOR GETTING THE FILES AND WRITING THE RULES/TESTS TO A FILE.
//        String directoryFilePath = "src/schemas";
//        String token = Helpers.getToken("gettoken");
//        JSONObject allSchemaTests = SchemaTestGenerator.createSchemaTestsFromSchemaFiles(directoryFilePath);
//        JsonFileWriter.writeJson(allSchemaTests);
//        Helpers.getToken("gettoken");
//        Helpers.editFixture("origin", token);
//        CallType.animalCreate("gettoken");





