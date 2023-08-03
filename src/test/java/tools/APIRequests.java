package tools;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.UUID;

public class APIRequests {
    public String FIFA_ID = "85858cf4-2448-44d5-8ba1-f86f27c6eb0f";
    public String SOCCER_ID = "05684792-9662-4e9f-a163-8545e5736c3d";
    public String BASKETBALL_ID = "6240f178-4735-4435-8b86-d7d7ca1b556b";
    public String ICE_HOCKEY_ID = "f6e5590a-4544-4541-b6d0-c5f3be1bd752";
    public String TENNIS_ID = "4cf5fdc6-3b69-454a-8f4b-58bf88e18d51";

    public String champID;
    public String leagueID;
    public String token = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjJDMkMxMjNEODEyRUEwMkUxNjgwMDk3MTdFMTQ2QUI1MTQ5MUY4MzhSUzI1NiIsInR5cCI6IkpXVCIsIng1dCI6IkxDd1NQWUV1b0M0V2dBbHhmaFJxdFJTUi1EZyJ9.eyJuYmYiOjE2OTA5OTI5NTUsImV4cCI6MTY5MTAzNjE1NSwiaXNzIjoiaHR0cHM6Ly9kZXYuZWFzeWNoYW1wLmNvbS9zYy1zZWN1cml0eS1hcGkiLCJhdWQiOlsic2Mtc3RhbmRpbmdzLWFwaSIsInNjLXNlY3VyaXR5LWFwaSJdLCJjbGllbnRfaWQiOiJzYy13ZWItdWkiLCJzdWIiOiIyMDRiY2NjMi0zYjZkLTQ1NzUtODYyMC1kODVlODg1ZmE5ZDgiLCJhdXRoX3RpbWUiOjE2OTA5OTI5NTQsImlkcCI6ImxvY2FsIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvZW1haWxhZGRyZXNzIjoiaXNlcmhpeTg4OEBnbWFpbC5jb20iLCJBc3BOZXQuSWRlbnRpdHkuU2VjdXJpdHlTdGFtcCI6IjdMRjc3QVpKR0gyQ0RHS09ZWFhPWVQ3Qkk0TkJEUTJPIiwicm9sZSI6IlVzZXIiLCJQZXJtaXNzaW9uIjpbIkNoYW1wTGVhZ3VlQ3JlYXRlIiwiUmVmZXJlZU1hbmFnZSIsIk5ld3NNYW5hZ2UiLCJGaXh0dXJlQ3JlYXRlIiwiVGVhbUNyZWF0ZSIsIlZlbnVlTWFuYWdlIl0sInByZWZlcnJlZF91c2VybmFtZSI6ImlzZXJoaXk4ODgiLCJuYW1lIjoiaXNlcmhpeTg4OCIsImVtYWlsIjoiaXNlcmhpeTg4OEBnbWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiZnVsbE5hbWUiOiJTZXJoaWkgSGVtYmVpIiwiZm9yY2VQYXNzd29yZENoYW5nZSI6IkZhbHNlIiwiZXh0ZXJuYWxVc2VyIjoidHJ1ZSIsImdlbmRlciI6IiIsImxvY2FsZSI6ImVuIiwianRpIjoiODg0RkYxNUEwRDE3QUM3QjI0OURCRDQwOEJBM0JGRDEiLCJzaWQiOiI0MThDRTI4NjEyNzMxM0ZBMUI2MEYzOEVCMUY3REFDOSIsImlhdCI6MTY5MDk5Mjk1NSwic2NvcGUiOlsib3BlbmlkIiwicHJvZmlsZSIsImVtYWlsIiwic2Mtc3RhbmRpbmdzLWFwaSIsInNjLXNlY3VyaXR5LWFwaSIsIm9mZmxpbmVfYWNjZXNzIl0sImFtciI6WyJwd2QiXX0.SKw27Ld3Gx67BIx1UVLkw_5mi0ETh4sR61PFmYy0LJui1_c1wEU5-0wOM1OOVAq6Lfwjpo3dGCDkDfpSUKlBD7sEfttInXwCy7kVQ5dB2KGxPnbsZ9rB0jWiP2De-PJRcJafwS2ES7JJgB-0XgZfO-P7C06JLdmUULnu8eAfSuuQ-zVKgdnyUrqdQWRPEOGaJXjSCGZ6IfW56C1i_UGA6PAT6EcemM-N_eHADJ0lW1O_SJN0BI7lw0alIC4Zbmy16Pm2rz5Z_Bm1in_Guh61mAzoDVh5jtORHPS4CdO-xRVhhj3zfUs14XvAcNfzDhOzXekyvVaJMkliPsnEz51ndA";


    /** API request for league creating
     *
     * @param leagueName
     */
    public void requestToLeagueCreateAPI (String leagueName) {
        OkHttpClient client = new OkHttpClient();
        // Create JSON request body
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        try {
            requestBody.put("sport", FIFA_ID);
            requestBody.put("name", leagueName);
            requestBody.put("subDomain", JSONObject.NULL);
            requestBody.put("mainColor", "");
            requestBody.put("accentColor", "");
            requestBody.put("isPublished", true);
            requestBody.put("description", "");
            requestBody.put("colorScheme", "light");
            requestBody.put("language", "en-US");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Build the request
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        Request request = new Request.Builder()
                .url("https://dev.easychamp.com/sc-standings-api/champ-leagues/")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", token)
                .build();
        // Send the request and handle the response
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println("League creation successful");
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    String responseJson = responseBody.string();
                    // Extract the ID from the response JSON
                    JSONObject jsonResponse = new JSONObject(responseJson);
                    leagueID = jsonResponse.getString("id");
                    System.out.println("League ID: " + leagueID);
                }
            } else {
                System.out.println("League creation failed with status code: " + response.code());
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * API request for deleting a league
     */
    public void requestToDeleteLeague () {
        OkHttpClient client = new OkHttpClient();
        // Create JSON request body
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        // Build the request
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        Request request = new Request.Builder()
                .url("https://dev.easychamp.com/sc-standings-api/champ-leagues/" + leagueID)
                .delete(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", token)
                .build();
        // Send the request and handle the response
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println("League deleting successful");
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    String responseJson = responseBody.string();
                }
            } else {
                System.out.println("League deleting failed with status code: " + response.code());
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * API request for Competition creating
     * @param competitionName
     */
    public void requestToChampCreateAPI (String competitionName) {
        OkHttpClient client = new OkHttpClient();
        // Create JSON request body
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject requestBody = new JSONObject();
        try {
            requestBody.put("name", competitionName);
            requestBody.put("description", "Write Description");
            requestBody.put("champLeagueId", leagueID);
            requestBody.put("rankingCriterions", new JSONArray());
            requestBody.put("currency", "eur");

            JSONObject sanctions = new JSONObject();
            sanctions.put("isAccumulatedYellowCard", false);
            sanctions.put("isDoubleYellowCard", false);
            sanctions.put("isDirectRedCard", false);
            sanctions.put("accumulatedYellowCardQuantity", 2);
            sanctions.put("accumulatedYellowCardSanction", 1);
            sanctions.put("accumulatedYellowCardMissNext", 0);
            sanctions.put("doubleYellowCardQuantity", 0);
            sanctions.put("directRedCardQuantity", 0);
            requestBody.put("sanctions", sanctions);

            requestBody.put("alternative", "");
            requestBody.put("champSportSubType", "");
            requestBody.put("url", "");
            requestBody.put("startDate", "2023-07-08T19:11:35.405Z");
            requestBody.put("endDate", "2023-07-09T19:11:35.405Z");
            requestBody.put("teams", new JSONArray());
            requestBody.put("imageUrl", JSONObject.NULL);
            requestBody.put("periodInfos", new JSONArray());
            requestBody.put("isPublished", true);
            requestBody.put("isUserTeamsAllowed", false);
            requestBody.put("isUserPlayersAllowed", false);

            JSONObject standingsRules = new JSONObject();
            standingsRules.put("winPoints", 3);
            standingsRules.put("drawPoints", 1);
            standingsRules.put("lossPoints", 0);
            standingsRules.put("overtimeWinPoints", 2);
            standingsRules.put("overtimeLossPoints", 1);
            requestBody.put("standingsRules", standingsRules);

            requestBody.put("registrationStatus", 0);
            requestBody.put("registrationOption", 1);
            requestBody.put("registrationPlayerStatus", 0);
            requestBody.put("registrationPlayerOption", 1);
            requestBody.put("teamAchievements", new JSONArray());
            requestBody.put("playerAchievements", new JSONArray());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Build the request
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        Request request = new Request.Builder()
                .url("https://dev.easychamp.com/sc-standings-api/champs/")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", token)
                .build();
        // Send the request and handle the response
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println("Championship creation successful");
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    String responseJson = responseBody.string();
                    // Extract the ID from the response JSON
                    JSONObject jsonResponse = new JSONObject(responseJson);
                    String id = jsonResponse.getString("id");
                    champID = id;
                    System.out.println("Championship ID: " + id);
                }
            } else {
                System.out.println("Champ creation failed with status code: " + response.code());
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
