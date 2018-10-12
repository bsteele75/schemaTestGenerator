package schemaTester;


import org.json.simple.JSONObject;

public class Main {

    public static void main(String[] args) throws Exception {

        Helpers method = new Helpers();
        Variables var = new Variables();

        String directoryFilePath = "src/schemas";

        String token = method.getTokenRequest(var.REG_SERVER + var.EP_GETTOKEN, var.C1_VET1_CREDS);
        System.out.println("here is the token: " + token + "\n");

        JSONObject allSchemaTests = SchemaTestGenerator.createSchemaTestsFromSchemaFiles(directoryFilePath);
        JsonFileWriter.writeJson(allSchemaTests);

        // TODO: This is where the program breaks from read/write files to API calls. They will need to be connected at some point

        // verify the url is being built correctly for my sanity
        String url = var.REG_SERVER + var.EP_ORIGIN + var.C1_CONTACT1__ID;
        System.out.println("here is the url: " + url + "\n");

        // get the object in it's current state just so I know what it looks like initially
        String contact = method.doGetRequest(url, token);
        System.out.println("here is the contact's original data: \n" + contact + "\n");

        // edit the object with endpoint, pram key, new param value & token
        String editedParam = method.editObject(url, "firstName", "Poets", token);
        System.out.println("here is my edited param: " + editedParam);

        // print out the parameter values that has been updated
        String responseBody = method.doGetRequest(url, token);
        org.json.JSONObject jsonResponse = new org.json.JSONObject(responseBody);
        String changedData = jsonResponse.getString("firstName");
        System.out.println("heres the edited params new value: " + changedData);

        // TODO: I REALLY WANT TO BE ABLE TO ASSERT THAT THE VALUE CHANGED. LOOK INTO THIS NEXT!
        String expectedResponse = "Poets";
        System.out.println(changedData);
        System.out.println(expectedResponse);
        if (changedData != expectedResponse) throw new AssertionError("The expected param wasn't changed!");


        //TODO: Need to find a way to set default values for a contact/animal object that will be used if that parameter isn't being tested
    }
}






