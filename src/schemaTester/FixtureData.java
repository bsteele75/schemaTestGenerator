package schemaTester;

/**
 * Created by briansteele on 10/11/18.
 */
public class FixtureData {

    String QLT_BASE_URL() {
        return "https://quality.globalvetlink.com/gvl2/api/";
    }

    String REG_BASE_URL() {
        return "https://regression.globalvetlink.com/gvl2/api/";
    }

    String ANIMAL_ID() {
        String id = "101418127";
        return id;
    }

    String CONTATCT_ID() {
        String id = "2091345";
        return id;
    }

    String vetCredsJson() {
        return "{\"username\":\"vet1\"," +
                "\"password\":\"pass1234\"," +
                "\"apiKey\": \"GVL\"}";
    }

    String contactFirstName(String firstName) {
        return "{\n    \"firstName\":\"" + firstName + "\"," +
                "\n    \"version\": 100\n}";
    }























//    String animalDataJson() {
//        return "{\"name\": \"newcow\"," +
//                "\"breed\": \"Angus\"," +
//                "\"species\": \"Bovine\"," +
//                "\"label\": \"newcow\"," +
//                "\"gender\": \"male\"," +
//                "\"age\": \"young\"," +
//                "\"color\": \"wat\"," +
//                "\"remarks\": \"wat?\"," +
//                "\"ids\": \"200\"," +
//                "\"idTypes\": \"tags\"," +
//                "\"type\": \"animal\"," +
//                "\"headCount\": 1, " +
//                "\"markings\": " +
//                "{\"otherMarkings\":\"testing1\", " +
//                "\"headMarkings\":\"testing2\"}";
//    }

//    String contactDataJson() {
//        return
//    }
}
