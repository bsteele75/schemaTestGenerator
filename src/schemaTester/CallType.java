package schemaTester;

import okhttp3.*;
import org.json.JSONObject;

/**
 * Created by briansteele on 10/9/18.
 */

public class CallType {

    public static String get(String endpoint){

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"username\":\"vet1\",\"password\":\"pass1234\", \"apiKey\": \"GVL\"}");

        Request request = new Request.Builder()
                // TODO: Need to generisize this url() instead of hardcoding it
                .url("https://regression.globalvetlink.com/gvl2/api/" + endpoint)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .post(body)
                .build();

        try (Response responses = client.newCall(request).execute()) {
            String responseBody = responses.body().string();
            JSONObject jsonResponse = new JSONObject(responseBody);
            String token = jsonResponse.getString("access_token");
//            System.out.println(token);
            return token;

        } catch(Exception e) {
            e.printStackTrace();
        } return null;
    }

    public static Object animalCreate(String endpoint) throws Exception {

        String newToken = get(endpoint).toString();

        OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json; charset=UTF-8");
		RequestBody body = RequestBody.create(mediaType, "{\n  \"name\": \"newcow\",\n  \"breed\": \"Angus\",\n  \"species\": \"Bovine\",\n  \"label\": \"newcow\",\n  \"gender\": \"male\",\n  \"age\": \"young\",\n  \"color\": \"wat\",\n  \"remarks\": \"wat?\",\n  \"ids\": \"200\",\n  \"idTypes\": \"tags\",\n  \"version\": 1,\n  \"type\": \"animal\",\n  \"origin_id\": 1,\n  \"headCount\": 1,\n  \"left_id\":1,\n  \"front_id\":2,\n  \"right_id\":3,\n  \"otherImages\": [4,5],\n  \"markings\": {\n\t\"otherMarkings\":\"testing1\",\n\"headMarkings\":\"testing2\"\n}\n}");

		Request request = new Request.Builder()
                // TODO: Need to generisize this url() instead of hardcoding it
				.url("http://regression.globalvetlink.com/gvl2/api/animal")
				.addHeader("X-Auth-Token", newToken)
				.addHeader("Accept", "application/json")
				.addHeader("Content-Type", "application/json; charset=UTF-8")
				.addHeader("Cache-Control", "no-cache")
                .post(body)
				.build();

        Response responses = client.newCall(request).execute();
        String responseBody = responses.body().string();
        System.out.println(responseBody);
        return responses;
        }
    }


