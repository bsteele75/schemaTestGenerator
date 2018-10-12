package schemaTester.practice;

import okhttp3.*;
import org.json.JSONObject;

/**
 * Created by briansteele on 10/10/18.
 */
public class Animals {


//    public static Object getFixture(String endpoint) throws Exception {
//
//        String newToken = CallType.get("gettoken").toString();
//        String fixture = Helpers.findFixture(endpoint);
//        String url = "http://regression.globalvetlink.com/gvl2/api/" + endpoint + "/" +  fixture;
//
//
//        OkHttpClient client = new OkHttpClient();
//
////        MediaType mediaType = MediaType.parse("application/json; charset=UTF-8");
////        RequestBody body = RequestBody.create(mediaType, "{\"name\": \"newcow\",}");
//
//        Request request = new Request.Builder()
//                // TODO: Need to generisize this url() instead of hardcoding it
//                .url("http://regression.globalvetlink.com/gvl2/api/" + endpoint + "/" +  fixture)
//                .addHeader("X-Auth-Token", newToken)
//                .addHeader("Accept", "application/json")
//                .addHeader("Content-Type", "application/json; charset=UTF-8")
//                .addHeader("Cache-Control", "no-cache")
//                .get()
//                .build();
//
//        Response responses = client.newCall(request).execute();
//        String responseBody = responses.body().string();
//        System.out.println(url);
//        System.out.println(responseBody);
//        return responses;
//    }
}


