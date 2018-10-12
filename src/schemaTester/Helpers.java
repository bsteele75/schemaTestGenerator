package schemaTester;

import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by briansteele on 10/11/18.
 */
public class Helpers {

    OkHttpClient client = new OkHttpClient();
    Variables var = new Variables();

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    /**
     * EDIT A CONTACTS FIRST NAME FIELD
     * @param firstName
     * @return
     */
    String EDIT_CONTACT_FIRST_NAME(String firstName) {
        return "{\n    \"firstName\":\"" + firstName + "\"," +
                "\n    \"version\": 100\n}";
    }

    /**
     * EDIT A CONTACTS MIDDLE INITIAL FIELD
     * @param mi
     * @return
     */
    String EDIT_CONTACT_MI(String mi) {
        return "{'mi':'" + mi + "','version': 100 }";
    }


    /**
     * FIND THE FIXTURE ID FOR THE SPECIFIED ENDPOINT
     * @param endpoint
     * @return
     */
    String findFixtureIdForEndpoint(String endpoint) {

        if (endpoint == "animal") {
            return var.C1_ANIMAL1_ID;

        } else if (endpoint == "origin") {
            return var.C1_CONTACT1__ID;

        } return null;
    }


    /**
     * DO A GENERIC GET REQUEST
     * @param url
     * @param token
     * @return
     * @throws IOException
     */
    String doGetRequest(String url, String token) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("X-Auth-Token", token)
                .get()
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    /**
     * DO A GET TOKEN REQUEST
     * @param url
     * @param json
     * @return
     * @throws Exception
     */
    String getTokenRequest(String url, String json) throws Exception {

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string().toString();
        JSONObject jsonResponse = new JSONObject(responseBody);
        String token = jsonResponse.getString("access_token");
        return token;
    }

    /**
     * DO A GENERIC PUT REQUEST
     * @param url
     * @param json
     * @param token
     * @return
     * @throws Exception
     */
    Object doPutRequest(String url, String json, String token) throws Exception {

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("X-Auth-Token", token)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json; charset=UTF-8")
                .addHeader("Cache-Control", "no-cache")
                .put(body)
                .build();

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        int statusCode = response.code();
        String message = response.message();
        System.out.println("here is the status code/message: " + statusCode + " : " +  message);

        JSONObject jsonResponse = new JSONObject(responseBody);

        return jsonResponse;
    }

















    //    String vetCredsJson() {
//        return "{\"username\":\"vet1\"," +
//                "\"password\":\"pass1234\"," +
//                "\"apiKey\": \"GVL\"}";
//    }


//    public static String getToken(String endpoint,String json){
//
//        OkHttpClient client = new OkHttpClient();
//
////        MediaType mediaType = MediaType.parse("application/json");
////        RequestBody body = RequestBody.create(mediaType, "{\"username\":\"vet1\",\"password\":\"pass1234\", \"apiKey\": \"GVL\"}");
//
//        RequestBody body = RequestBody.create(JSON, json);
//        Request request = new Request.Builder()
//                // TODO: Need to generisize this url() instead of hardcoding it
//                .url("https://regression.globalvetlink.com/gvl2/api/" + endpoint)
//                .addHeader("Accept", "application/json")
//                .addHeader("Content-Type", "application/json")
//                .addHeader("Cache-Control", "no-cache")
//                .post(body)
//                .build();
//
//        try (Response responses = client.newCall(request).execute()) {
//            String responseBody = responses.body().string();
//            JSONObject jsonResponse = new JSONObject(responseBody);
//            String token = jsonResponse.getString("access_token");
//            System.out.println(token);
//            return token;
//
//        } catch(Exception e) {
//            e.printStackTrace();
//        } return null;
//    }
//
//    public static String findFixtureIdForEndpoint(String endpoint) {
//
//        switch (endpoint) {
//            case "animal":
//                String id = "101418127";
//                return id;
//            case "origin":
//                String originId = "2091345";
//                return originId;
//            default: break;
//        }
//        return null;
//    }
//
//    public static Object getFixture(String endpoint, String token){
//
//        String fixture = findFixtureIdForEndpoint(endpoint);
//
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                // TODO: Generically build this .url() instead of hardcoding it
//                .url("http://regression.globalvetlink.com/gvl2/api/" + endpoint + "/" +  fixture)
//                .addHeader("X-Auth-Token", token)
//                .get()
//                .build();
//
//        try {
//            Response responses = client.newCall(request).execute();
//            String responseBody = responses.body().string();
//            System.out.println(responseBody);
//            return responses;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        } return null;
//    }






//    public static Object editFixture(String endpoint,String token) throws Exception {
//
//        String fixture = findFixtureIdForEndpoint(endpoint);
//
//        OkHttpClient client = new OkHttpClient();
//
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "{\"mi\":\"B\"}");
//
//        Request request = new Request.Builder()
//                // TODO: Generically build this .url() instead of hardcoding it
//                .url("http://regression.globalvetlink.com/gvl2/api/" + endpoint + "/" +  fixture)
//                .addHeader("X-Auth-Token", token)
//                .addHeader("Accept", "application/json")
//                .addHeader("Content-Type", "application/json; charset=UTF-8")
//                .addHeader("Cache-Control", "no-cache")
//                .put(body)
//                .build();
//        System.out.println(body);
//
//        Response responses = client.newCall(request).execute();
//        String responseBody = responses.body().string().toString();
//        int statusCode = responses.code();
//        System.out.println(statusCode);
//        System.out.println(responseBody);
//        return responses;
//    }

}
