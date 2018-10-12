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

}
