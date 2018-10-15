package schemaTester;

import okhttp3.*;
import org.json.JSONObject;
//import org.json.simple.JSONObject;

import java.io.IOException;

/**
 * Created by briansteele on 10/11/18.
 */
public class Helpers {

    OkHttpClient client = new OkHttpClient();
    Variables var = new Variables();

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    String buildURLWithEndpoint (JSONObject jsonSchema) throws Exception {
        if(jsonSchema.getString("id").contains(Variables.REG_SERVER + "animal")) {
            return Variables.REG_SERVER + Variables.EP_ANIMAL;
        } else if(jsonSchema.getString("id").contains(Variables.QLT_SERVER + "animal")) {
            return Variables.QLT_SERVER + Variables.EP_ANIMAL;
        } return null;
    }

     /**
     * TAKES IN THE URL, KEY TO BE CHANGED, VALUE TO CHANGE KEY TO, TOKEN AND MAKE A PUT CALL
     * @param url
     * @param key
     * @param value
     * @param token
     * @return
     * @throws Exception
     */
    String editObject(String url, String key, String value, String token) throws Exception {

            String requestBody = "{\""
                    + key
                    + "\":\""
                    + value
                    + "\","
                    +"\"version\": 100\n}";

            doPutRequest(url, requestBody, token);
            return requestBody;
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
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json; charset=UTF-8")
                .addHeader("Cache-Control", "no-cache")
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
     * @return JSONObject
     * @throws Exception
     */
    JSONObject doPutRequest(String url, String json, String token) throws Exception {

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
        System.out.println("here is the status code/message: " + statusCode + " : " +  message + "\n");

        JSONObject jsonResponse = new JSONObject(responseBody);

        return jsonResponse;

    }

}
