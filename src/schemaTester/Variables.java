package schemaTester;

import org.json.JSONObject;

/**
 * Created by briansteele on 10/12/18.
 */
public class Variables {

    /**
     * SERVERS
     */
    public static String QLT_SERVER = "https://quality.globalvetlink.com/gvl2/api/";
    public static String REG_SERVER = "https://regression.globalvetlink.com/gvl2/api/";

    /**
     * ENDPOINTS
     *
     * EP = Endpoint
     *
     */
    public static String EP_GETTOKEN = "gettoken";
    public static String EP_ORIGIN = "origin/";

    /**
     * CLINIC USERS
     *
     * C1   = Clinic 1 (Ames Animal Hospital)
     * VET1 = Joe Sample
     *
     */
    public static String C1_VET1_CREDS = "{\"username\":\"vet1\",\"password\":\"pass1234\",\"apiKey\": \"GVL\"}";

    /**
     * CONTACTS AND ANIMALS
     *
     * CONTACT1 = Poe Dameron
     * ANIMAL1  = Billy Bob Burbon
     *
     */
    public static String C1_CONTACT1__ID = "2091345";
    public static String C1_ANIMAL1_ID = "101418127";

    public static String C1_CONTACT1 = "{\"id\":2091345,\"label\":\"Poe A. Dameron\",\"name\":\"Poe A. Dameron\",\"firstName\":\"Poe\",\"mi\":\"A\",\"lastName\":\"Dameron\",\"suffix\":null,\"ownerEmail\":\"gvltestuser@gmail.com\",\"cellPhone\":\"111 111-1112\",\"version\":36,\"type\":\"Person\",\"mvlConnected\":true,\"consentToStoreInfoInUSA\":false,\"primaryPremises\":{\"id\":1347539,\"label\":\"IA_Address\",\"addressLine1\":\"987 Lor San Tekka\",\"addressLine2\":\"Suite 100\",\"city\":\"Jakku\",\"state\":\"LA\",\"postalCode\":\"50010\",\"plus4\":null,\"county\":\"Story\",\"country\":\"USA\",\"phone\":\"222-222-2222\",\"fax\":\"333-333-3333\",\"latitude\":null,\"longitude\":null,\"nationalId\":\"PIN-1234\",\"locationId\":\"LID-1234\",\"isPrimary\":true,\"premisesName\":\"IA_Address\",\"version\":11,\"housesAnimals\":true},\"premisesList\":{\"1347539\":\"IA_Address\",\"1439842\":\"FL_Address\",\"1439843\":\"ID_Address\",\"1446939\":\"KS_Address\",\"1722603\":\"CA_Address\",\"1805469\":\"CO Address\",\"1814123\":\"OH_Adress\",\"1858173\":\"TX_Address\",\"1877202\":\"ID ADDRESS\"}}";

}
